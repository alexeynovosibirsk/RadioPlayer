package com.nazarov.radioPlayer.audio;

import com.nazarov.radioPlayer.playlist.UrlMaker;

public class StationPlayer extends Thread {

    private Thread musicThread = new Thread();
    private static int urlNumber = 0;
    private int numIndex;
    private String playlist;

    UrlPlayer urlPlayer = new UrlPlayer();
    FilePlayer filePlayer = new FilePlayer();

    public void setPlaylist(String playlist) {

        this.playlist = playlist;
    }

    public void setNumIndex(int numIndex) {

        this.numIndex = numIndex;
    }

    public void playRadio(int urlNumber) {

        stopRadio();

        filePlayer.logoPlayer(numIndex);                          // playing logo file from sounds/

        UrlMaker.setFilelist(playlist);                           // set playlist

        UrlMaker.setNumber(urlNumber);                            // set number of row in playlist

            musicThread = new Thread(() -> {

                    urlPlayer.playR(UrlMaker.getUrl());
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

        filePlayer.logoPlayer(6);   // playing logo "Next station"

        playRadio(urlNumber);
    }

    public void stopRadio() {

         musicThread.stop();
    }
}
