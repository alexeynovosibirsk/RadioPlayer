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

        filePlayer.logoPlayer(numIndex);                          // playing logo file "genre"

        UrlMaker.setFile(playlist);                               // set playlist

            musicThread = new Thread(() -> {

                    urlPlayer.playR(UrlMaker.makeUrl(urlNumber));
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

//    public void playRadio(int urlNumber) {
//
//        stopRadio();
//
//        filePlayer.play(FilePlayList.logoList(numIndex));  // playing logo file "genre"
//
//        UrlMaker.setFile(playlist);                               // set playlist
//
//        musicThread = new Thread(() -> {
//
//            urlPlayer.playR(UrlMaker.makeUrl(urlNumber));
//        });
//
//        musicThread.start();
//    }
}
