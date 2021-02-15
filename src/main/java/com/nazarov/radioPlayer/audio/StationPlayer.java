package com.nazarov.radioPlayer.audio;

import org.slf4j.Logger;
import com.nazarov.radioPlayer.playlist.UrlMaker;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;

public class StationPlayer extends Thread {

    final static Logger logger = LoggerFactory.getLogger(StationPlayer.class);

    private Thread musicThread = new Thread();
    private int urlNumber;
    private static String playlist;
    private boolean isMuted;

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
        urlNumber = 0;
        UrlMaker.setFilelist(playlist);                    // set playlist
        UrlMaker.setNumber(urlNumber);                     // set number of row in playlist
        musicThread = new StationPlayer();
        musicThread.start();
        new LogoPlayer(2);                       // playing logo file NewStationList
    }

    public void nextStation() {

        stopRadio();
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
        urlNumber--;
        System.out.println(urlNumber);
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

            musicThread.stop();   // I know it's bad/deprecated but it's webstream
    }

    public void mute() {

        if (!isMuted) {
            stopRadio();
            isMuted = true;

        } else {
            UrlMaker.setNumber(urlNumber);
            musicThread = new StationPlayer();
            musicThread.start();
            isMuted = false;
        }
    }

    public void urlPlayer(URL url) {
        logger.info("Playing: " + url);
        try {
            AdvancedPlayer advancedPlayer = new AdvancedPlayer(url.openStream());
            advancedPlayer.play();

        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (ConnectException | FileNotFoundException e) {

            new LogoPlayer(5);
            logger.info("BAD URL: " + getPlaylist().split("/")[3] + " " + url);
            e.printStackTrace();

        } catch (IOException e) {

            new LogoPlayer(5);
            logger.info("BAD URL: " + getPlaylist().split("/")[3] + " " + url);
            e.printStackTrace();
        }
    }
}