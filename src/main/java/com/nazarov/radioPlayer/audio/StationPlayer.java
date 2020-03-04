package com.nazarov.radioPlayer.audio;

import com.nazarov.radioPlayer.playlist.UrlMaker;

public class StationPlayer extends Thread {

    private static Thread musicThread = new Thread();
    private static int urlNumber = 0;
    private int numIndex;
    private String playlist;

    public void setPlaylist(String playlist) {

        this.playlist = playlist;
    }

    public void setNumIndex(int numIndex) {

        this.numIndex = numIndex;
    }
    
    @Override
    public void run() {

        new UrlPlayer(UrlMaker.getUrl());
    }

    public void playRadio(int urlNumber) {

        stopRadio();

        new LogoPlayer(numIndex);                          // playing logo file from sounds/

        UrlMaker.setFilelist(playlist);                    // set playlist

        UrlMaker.setNumber(urlNumber);                     // set number of row in playlist

        musicThread = new StationPlayer();

        musicThread.start();
        System.out.println(musicThread.getName());
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



