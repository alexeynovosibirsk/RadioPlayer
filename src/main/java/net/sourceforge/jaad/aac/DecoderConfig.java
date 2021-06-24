package net.sourceforge.jaad.aac;

import net.sourceforge.jaad.aac.syntax.BitStream;
import net.sourceforge.jaad.aac.syntax.Constants;
import net.sourceforge.jaad.aac.syntax.PCE;

/**
 * DecoderConfig that must be passed to the
 * <code>Decoder</code> constructor. Typically it is created via one of the
 * static parsing methods.
 *
 * @author in-somnia
 */
public class DecoderConfig implements Constants {

	private net.sourceforge.jaad.aac.Profile profile, extProfile;
	private SampleFrequency sampleFrequency;
	private ChannelConfiguration channelConfiguration;
	private boolean frameLengthFlag;
	private boolean dependsOnCoreCoder;
	private int coreCoderDelay;
	private boolean extensionFlag;
	//extension: SBR
	private boolean sbrPresent, downSampledSBR, sbrEnabled;
	//extension: error resilience
	private boolean sectionDataResilience, scalefactorResilience, spectralDataResilience;

	private DecoderConfig() {
		profile = net.sourceforge.jaad.aac.Profile.AAC_MAIN;
		extProfile = net.sourceforge.jaad.aac.Profile.UNKNOWN;
		sampleFrequency = SampleFrequency.SAMPLE_FREQUENCY_NONE;
		channelConfiguration = ChannelConfiguration.CHANNEL_CONFIG_UNSUPPORTED;
		frameLengthFlag = false;
		sbrPresent = false;
		downSampledSBR = false;
		sbrEnabled = true;
		sectionDataResilience = false;
		scalefactorResilience = false;
		spectralDataResilience = false;
	}

	/* ========== gets/sets ========== */
	public ChannelConfiguration getChannelConfiguration() {
		return channelConfiguration;
	}

	public void setChannelConfiguration(ChannelConfiguration channelConfiguration) {
		this.channelConfiguration = channelConfiguration;
	}

	public int getCoreCoderDelay() {
		return coreCoderDelay;
	}

	public void setCoreCoderDelay(int coreCoderDelay) {
		this.coreCoderDelay = coreCoderDelay;
	}

	public boolean isDependsOnCoreCoder() {
		return dependsOnCoreCoder;
	}

	public void setDependsOnCoreCoder(boolean dependsOnCoreCoder) {
		this.dependsOnCoreCoder = dependsOnCoreCoder;
	}

	public net.sourceforge.jaad.aac.Profile getExtObjectType() {
		return extProfile;
	}

	public void setExtObjectType(net.sourceforge.jaad.aac.Profile extObjectType) {
		this.extProfile = extObjectType;
	}

	public int getFrameLength() {
		return frameLengthFlag ? WINDOW_SMALL_LEN_LONG : WINDOW_LEN_LONG;
	}

	public boolean isSmallFrameUsed() {
		return frameLengthFlag;
	}

	public void setSmallFrameUsed(boolean shortFrame) {
		this.frameLengthFlag = shortFrame;
	}

	public net.sourceforge.jaad.aac.Profile getProfile() {
		return profile;
	}

	public void setProfile(net.sourceforge.jaad.aac.Profile profile) {
		this.profile = profile;
	}

	public SampleFrequency getSampleFrequency() {
		return sampleFrequency;
	}

	public void setSampleFrequency(SampleFrequency sampleFrequency) {
		this.sampleFrequency = sampleFrequency;
	}

	//=========== SBR =============
	public boolean isSBRPresent() {
		return sbrPresent;
	}

	public boolean isSBRDownSampled() {
		return downSampledSBR;
	}

	public boolean isSBREnabled() {
		return sbrEnabled;
	}

	public void setSBREnabled(boolean enabled) {
		sbrEnabled = enabled;
	}

	//=========== ER =============
	public boolean isScalefactorResilienceUsed() {
		return scalefactorResilience;
	}

	public boolean isSectionDataResilienceUsed() {
		return sectionDataResilience;
	}

	public boolean isSpectralDataResilienceUsed() {
		return spectralDataResilience;
	}

	/* ======== static builder ========= */
	/**
	 * Parses the input arrays as a DecoderSpecificInfo, as used in MP4
	 * containers.
	 * 
	 * @return a DecoderConfig
	 */
	static DecoderConfig parseMP4DecoderSpecificInfo(byte[] data) throws net.sourceforge.jaad.aac.AACException {
		final BitStream in = new BitStream(data);
		final DecoderConfig config = new DecoderConfig();

		try {
			config.profile = readProfile(in);

			int sf = in.readBits(4);
			if(sf==0xF) config.sampleFrequency = SampleFrequency.forFrequency(in.readBits(24));
			else config.sampleFrequency = SampleFrequency.forInt(sf);
			config.channelConfiguration = ChannelConfiguration.forInt(in.readBits(4));

			switch(config.profile) {
				case AAC_SBR:
					config.extProfile = config.profile;
					config.sbrPresent = true;
					sf = in.readBits(4);
					//TODO: 24 bits already read; read again?
					//if(sf==0xF) config.sampleFrequency = SampleFrequency.forFrequency(in.readBits(24));
					//if sample frequencies are the same: downsample SBR
					config.downSampledSBR = config.sampleFrequency.getIndex()==sf;
					config.sampleFrequency = SampleFrequency.forInt(sf);
					config.profile = readProfile(in);
					break;
				case AAC_MAIN:
				case AAC_LC:
				case AAC_SSR:
				case AAC_LTP:
				case ER_AAC_LC:
				case ER_AAC_LTP:
				case ER_AAC_LD:
					//ga-specific info:
					config.frameLengthFlag = in.readBool();
					if(config.frameLengthFlag) throw new net.sourceforge.jaad.aac.AACException("config uses 960-sample frames, not yet supported"); //TODO: are 960-frames working yet?
					config.dependsOnCoreCoder = in.readBool();
					if(config.dependsOnCoreCoder) config.coreCoderDelay = in.readBits(14);
					else config.coreCoderDelay = 0;
					config.extensionFlag = in.readBool();

					if(config.extensionFlag) {
						if(config.profile.isErrorResilientProfile()) {
							config.sectionDataResilience = in.readBool();
							config.scalefactorResilience = in.readBool();
							config.spectralDataResilience = in.readBool();
						}
						//extensionFlag3
						in.skipBit();
					}

					if(config.channelConfiguration==ChannelConfiguration.CHANNEL_CONFIG_NONE) {
						//TODO: is this working correct? -> ISO 14496-3 part 1: 1.A.4.3
						in.skipBits(3); //PCE
						PCE pce = new PCE();
						pce.decode(in);
						config.profile = pce.getProfile();
						config.sampleFrequency = pce.getSampleFrequency();
						config.channelConfiguration = ChannelConfiguration.forInt(pce.getChannelCount());
					}

					if(in.getBitsLeft()>10) readSyncExtension(in, config);
					break;
				default:
					throw new net.sourceforge.jaad.aac.AACException("profile not supported: "+config.profile.getIndex());
			}
			return config;
		}
		finally {
			in.destroy();
		}
	}

	private static net.sourceforge.jaad.aac.Profile readProfile(BitStream in) throws net.sourceforge.jaad.aac.AACException {
		int i = in.readBits(5);
		if(i==31) i = 32+in.readBits(6);
		return net.sourceforge.jaad.aac.Profile.forInt(i);
	}

	private static void readSyncExtension(BitStream in, DecoderConfig config) throws net.sourceforge.jaad.aac.AACException {
		final int type = in.readBits(11);
		switch(type) {
			case 0x2B7:
				final net.sourceforge.jaad.aac.Profile profile = net.sourceforge.jaad.aac.Profile.forInt(in.readBits(5));

				if(profile.equals(Profile.AAC_SBR)) {
					config.sbrPresent = in.readBool();
					if(config.sbrPresent) {
						config.profile = profile;

						int tmp = in.readBits(4);

						if(tmp==config.sampleFrequency.getIndex()) config.downSampledSBR = true;
						if(tmp==15) {
							throw new AACException("sample rate specified explicitly, not supported yet!");
							//tmp = in.readBits(24);
						}
					}
				}
				break;
		}
	}
}
