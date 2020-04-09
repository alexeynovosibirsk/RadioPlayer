package com.nazarov.radioPlayer.audio;

import com.nazarov.radioPlayer.playlist.UrlMaker;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.IOException;
import java.net.URL;

public class StationPlayer extends Thread {

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
        musicThread.stop();   // I know it's bad/deprecated but no other methods wont work with jplayer...
    }
    public void urlPlayer(URL url) {
        try {
            AdvancedPlayer advancedPlayer = new AdvancedPlayer(url.openStream());
            advancedPlayer.play();
        } catch (JavaLayerException j) {
            j.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



