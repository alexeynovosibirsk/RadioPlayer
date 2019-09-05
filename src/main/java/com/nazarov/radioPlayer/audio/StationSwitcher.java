package com.nazarov.radioPlayer.audio;

import com.nazarov.radioPlayer.playlist.FilePlayList;
import com.nazarov.radioPlayer.playlist.UrlMaker;

import java.util.concurrent.TimeUnit;

public class StationSwitcher  extends Thread {

    UrlPlayer urlPlayer = new UrlPlayer();
    FilePlayer filePlayer = new FilePlayer();

    private Thread musicThread = new Thread();
    private static int urlNumber = 0;
    private int numIndex;
    private String s;
    private volatile boolean  stopMusic;

    public void setS(String s) {
        this.s = s;
    }

    public void setNumIndex(int numIndex) {
        this.numIndex = numIndex;
    }

    public void logoHello() {

        filePlayer.play(FilePlayList.logoList(5));
    }

    public void playRadio(int urlNumber) {

        stopRadio();

        filePlayer.play(FilePlayList.logoList(numIndex));  // playing logo file "genre"

        UrlMaker.setFile(s);                               // set playlist

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

        filePlayer.play(FilePlayList.logoList(6));   // playing logo "Next station"

        playRadio(urlNumber);
    }

    public void stopRadio() {

         musicThread.stop();
    }
}
