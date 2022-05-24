package com.nazarov.radioPlayer.audio;

import com.nazarov.radioPlayer.RadioApplication;
import com.nazarov.radioPlayer.playlist.GitCloner;
import com.nazarov.radioPlayer.playlist.UrlMaker;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import lombok.extern.slf4j.Slf4j;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;

@Slf4j
public class StationPlayer extends Thread {

    private Thread musicThread = new Thread();
    private int urlNumber;
    private static String playlist;
    private boolean isMuted;

    private static StationPlayer _instance = null;

    private StationPlayer(){}

    public static StationPlayer getInstance() {
        if (_instance == null) {
            _instance = new StationPlayer();
        }
        return _instance;
    }

    public void setIsMuted(boolean state) {
        isMuted = state;
    }

    public boolean getIsMuted() {
    return isMuted;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }
    public String getPlaylist() { return playlist; }

    @Override
    public void run() {
        urlPlayer(UrlMaker.getUrl());
    }

    public void playRadio() {

        stopRadio();
        setIsMuted(false);
        urlNumber = 0;
        UrlMaker.setFilelist(playlist);                    // set playlist
        UrlMaker.setNumber(urlNumber);                     // set number of row in playlist
        musicThread = new StationPlayer();
        musicThread.start();
        new LogoPlayer(2);                       // playing logo file NewStationList
    }

    public void nextStation() {

        stopRadio();
        setIsMuted(false);
        urlNumber++;
        int maxUrlNumber = UrlMaker.getPlaylistSize();
        if (urlNumber > maxUrlNumber) {
            urlNumber = 0;
        }
        new LogoPlayer(6);                      // playing logo "switch station"
        UrlMaker.setNumber(urlNumber);                   // set number of row in playlist
        musicThread = new StationPlayer();
        musicThread.start();
    }

    public void previousStation() {

        stopRadio();
        setIsMuted(false);
        urlNumber--;
        int maxUrlNumber = UrlMaker.getPlaylistSize();
        if (urlNumber < 0) {
            urlNumber = maxUrlNumber;
        }
        new LogoPlayer(6);                      // playing logo "switch station"
        UrlMaker.setNumber(urlNumber);                   // set number of row in playlist
        musicThread = new StationPlayer();
        musicThread.start();
    }

    public void stopRadio() {

            musicThread.stop();   // I know it's bad/deprecated but it's the webstream
    }

    public void mute() {
        System.out.println("muteActivate");

        if (!getIsMuted()) {
            stopRadio();
            setIsMuted(true);
            new LogoPlayer(6);
            getIsMuted();

        } else {
            System.out.println("UnMute");

            if (getIsMuted()) {
                new LogoPlayer(6);
                UrlMaker.setNumber(urlNumber);
                musicThread = new StationPlayer();
                musicThread.start();
                setIsMuted(false);
                getIsMuted();
            }
        }
    }

    public void urlPlayer(URL url) {
        log.info("Playing: " + url);

        try {
            AACPlayer.decodeAAC(url.openStream());
        } catch (Exception e) {
            log.info("Not AAC - switching to MP3");
            try {
                AdvancedPlayer advancedPlayer = new AdvancedPlayer(url.openStream());
                advancedPlayer.play();

            } catch (JavaLayerException | ConnectException | FileNotFoundException ex) {
                ex.printStackTrace();

                new LogoPlayer(5);
                log.info("BAD URL: " + getPlaylist().split("/")[3] + " " + url);
                e.printStackTrace();

            } catch (IOException ex) {

                new LogoPlayer(5);
                log.info("BAD URL: " + getPlaylist().split("/")[3] + " " + url);
                e.printStackTrace();
            }
        }
    }
}