package com.nazarov.radioPlayer.osdependent;

import java.io.IOException;

public class VolumeControl {

    public void volumeUp() {
        volLvl("+");
    }
    public void volumeDn() {
        volLvl("-");
    }
    public void mute() {
        for(int i = 0; i < 50; i++) {
           volumeDn();
        }
    }

    private void volLvl(String sign) {

        Runtime run = Runtime.getRuntime();

        Process process = null;

        String raspberry = "amixer -c 0 set PCM 2dB" + sign;
        String debian = "amixer sset Master 5%" + sign;
        String ubuntu = "amixer -D pulse sset Master 5%" + sign;

        try {
            process = run.exec(raspberry);
            process = run.exec(debian);
            process = run.exec(ubuntu);
            process.getErrorStream();
            process.waitFor();

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Bash command ERROR");
        } finally {
            process.destroy();
        }
    }
}