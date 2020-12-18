package com.nazarov.radioPlayer.audio;

import org.slf4j.Logger;
import com.nazarov.radioPlayer.playlist.UrlMaker;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;

public class StationPlayer extends Thread {

    final static Logger logger = LoggerFactory.getLogger(StationPlayer.class);

    private Thread musicThread = new Thread();
    private int urlNumber;
    private String playlist;

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }
    @Override
    public void run() {
        urlPlayer(UrlMaker.getUrl());
    }

    public void playRadio() {

        stopRadio();
        urlNumber = 0;
        new LogoPlayer(2);                       // playing logo file NewStationList
        UrlMaker.setFilelist(playlist);                    // set playlist
        UrlMaker.setNumber(urlNumber);                     // set number of row in playlist
        musicThread = new StationPlayer();
        musicThread.start();
    }

    public void nextStation() {

        stopRadio();
        urlNumber++;
        int maxUrlNumber = UrlMaker.getPlaylistSize();
        if (urlNumber > maxUrlNumber) {
            urlNumber = 0;
        }
        new LogoPlayer(1);                      // playing logo "Next station"
        UrlMaker.setNumber(urlNumber);                   // set number of row in playlist
        musicThread = new StationPlayer();
        musicThread.start();
    }

    public void stopRadio() {
        musicThread.stop();   // I know it's bad/deprecated but it's webstream
    }

    public void urlPlayer(URL url) {
        try {
            AdvancedPlayer advancedPlayer = new AdvancedPlayer(url.openStream());
            advancedPlayer.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (ConnectException e) {

            new LogoPlayer(5);
            logger.info("Url not valid!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}