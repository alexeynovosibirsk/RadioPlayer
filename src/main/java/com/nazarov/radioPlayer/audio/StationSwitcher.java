package com.nazarov.radioPlayer.audio;

import com.nazarov.radioPlayer.playlist.UrlMaker;

public class StationSwitcher  extends Thread {

    AudioPlayer audioPlayer = new AudioPlayer();

    private Thread musicThread = new Thread();
    private static int uniurlNumber = 0;
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

           audioPlayer.playR(UrlMaker.logoURL(5));
    }

    public void playRadio(int uniurlNumber) {

        stopRadio();

        audioPlayer.playR(UrlMaker.logoURL(numIndex));

        UrlMaker.setFile(s);

            musicThread = new Thread(() -> {

                    audioPlayer.playR(UrlMaker.makeUrl(uniurlNumber));
                });

        musicThread.start();
    }


    public void nextStation() {

        stopRadio();

        uniurlNumber++;

        int maxUrlNumber = UrlMaker.getPlaylistSize();

        if (uniurlNumber > maxUrlNumber) {

                uniurlNumber = 0;
        }

        playRadio(uniurlNumber);
    }

    public void stopRadio() {

        musicThread.stop();
    }
}
