package com.nazarov.radioPlayer.audio;

import com.nazarov.radioPlayer.playlist.UrlMaker;

public class StationPlayer extends Thread {

    private Thread musicThread = new Thread();
    private static int urlNumber = 0;
    private int numIndex;
    private String playlist;

    public void setPlaylist(String playlist) {

        this.playlist = playlist;
    }

    public void setNumIndex(int numIndex) {

        this.numIndex = numIndex;
    }

    public void playRadio(int urlNumber) {

        stopRadio();

        musicThread = new Thread(() -> {

        new LogoPlayer(numIndex);                          // playing logo file from sounds/

        UrlMaker.setFilelist(playlist);                    // set playlist

        UrlMaker.setNumber(urlNumber);                     // set number of row in playlist

            new UrlPlayer(UrlMaker.getUrl());
        });

        musicThread.start();
    }

    public void nextStation() {

        stopRadio();

        urlNumber++;

        int maxUrlNumber = UrlMaker.getPlaylistSize();

        if (urlNumber > maxUrlNumber) {

            urlNumber = 0;
        }

        new LogoPlayer(6);   // playing logo "Next station"

        playRadio(urlNumber);
    }

    public void stopRadio() {

        musicThread.stop();
    }
}



