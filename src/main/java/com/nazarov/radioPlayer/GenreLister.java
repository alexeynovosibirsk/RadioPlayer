package com.nazarov.radioPlayer;

import com.nazarov.radioPlayer.playlist.UrlMaker;
import java.net.URL;

public class GenreLister {

    AudioPlayer audioPlayer = new AudioPlayer();

    static int ambientUrlNumber = 0;
    static int jazzUrlNumber = 0;
    static int tranceUrlNumber = 0;
    static int rockUrlNumber = 0;
    static int otherUrlNumber = 0;
    private Thread ambientThread = new Thread();
    private Thread jazzThread = new Thread();
    private Thread tranceThread = new Thread();
    private Thread rockThread = new Thread();
    private Thread otherThread = new Thread();
    private Thread logoambientThread;
    private Thread logojazzThread;
    private Thread logotranceThread;
    private Thread logorockThread;
    private Thread logootherThread;
    private String ambient = "playlists/ambient.txt";
    private String jazz = "playlists/jazz.txt";
    private String trance = "playlists/trance.txt";
    private String retro = "playlists/retro.txt";
    private String other = "playlists/other.txt";

    public void logoHello() {

        logoambientThread = new Thread(() -> {
            audioPlayer.playR(UrlMaker.logoURL(5));
        });
        logoambientThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        logoambientThread.stop();
    }

    public void ambient(int urlNumber) {
        logoambientThread = new Thread(() -> {
            audioPlayer.playR(UrlMaker.logoURL(0));
        });
        logoambientThread.start();

        ambientThread = new Thread(() -> {
            UrlMaker.setFile(ambient);
            audioPlayer.playR(UrlMaker.getUrl(urlNumber));
        });
        ambientThread.start();
    }

    public void jazz(int urlNumber) {
        logojazzThread = new Thread(() -> {
            audioPlayer.playR(UrlMaker.logoURL(1));
        });
        logojazzThread.start();

        jazzThread = new Thread(() -> {
            UrlMaker.setFile(jazz);
            audioPlayer.playR(UrlMaker.getUrl(urlNumber));
        });
        jazzThread.start();
    }

    public void trance(int urlNumber) {
        logotranceThread = new Thread(() -> {
            audioPlayer.playR(UrlMaker.logoURL(2));
        });
        logotranceThread.start();

        tranceThread = new Thread(() -> {
            UrlMaker.setFile(trance);
            audioPlayer.playR(UrlMaker.getUrl(urlNumber));
        });
        tranceThread.start();
    }

    public void rock(int urlNumber) {
        logorockThread = new Thread(() -> {
            audioPlayer.playR(UrlMaker.logoURL(3));
        });
        logorockThread.start();

        rockThread = new Thread(() -> {
            UrlMaker.setFile(retro);
            audioPlayer.playR(UrlMaker.getUrl(urlNumber));
        });
        rockThread.start();
    }

    public void other(int urlNumber) {
        logootherThread = new Thread(() -> {
            audioPlayer.playR(UrlMaker.logoURL(4));
        });
        logootherThread.start();

        otherThread = new Thread(() -> {
            UrlMaker.setFile(other);
            audioPlayer.playR(UrlMaker.getUrl(urlNumber));
        });
        otherThread.start();
    }

     public void nextStation() {

         if (ambientThread.isAlive()) {
            ambientThread.stop();
            ambientUrlNumber++;
            int maxUrlNumber = UrlMaker.getPlaylistSize();
            if (ambientUrlNumber > maxUrlNumber) {
                ambientUrlNumber = 0;
            }
            ambient(ambientUrlNumber);
            System.out.println("AMBI " + ambientUrlNumber);
        }
        if(jazzThread.isAlive()) {
            jazzThread.stop();
            jazzUrlNumber++;
            int maxUrlNumber = UrlMaker.getPlaylistSize();
            if (jazzUrlNumber > maxUrlNumber) {
                jazzUrlNumber = 0;
            }
            jazz(jazzUrlNumber);
            System.out.println("JAZZ " + jazzUrlNumber);
        }
        if (tranceThread.isAlive()) {
            tranceThread.stop();
            tranceUrlNumber++;
            int maxUrlNumber = UrlMaker.getPlaylistSize();
            if (tranceUrlNumber > maxUrlNumber) {
                tranceUrlNumber = 0;
            }
            trance(tranceUrlNumber);
            System.out.println("TRANCE " + tranceUrlNumber);
        }
        if (rockThread.isAlive()) {
            rockThread.stop();
            rockUrlNumber++;
            int maxUrlNumber = UrlMaker.getPlaylistSize();
            if (rockUrlNumber > maxUrlNumber) {
                rockUrlNumber = 0;
            }
            rock(rockUrlNumber);
           System.out.println("RETRO " + rockUrlNumber);
        }
        if (otherThread.isAlive()) {
            otherThread.stop();
            otherUrlNumber++;
            int maxUrlNumber = UrlMaker.getPlaylistSize();
            if (otherUrlNumber > maxUrlNumber) {
                otherUrlNumber = 0;
            }
            other(otherUrlNumber);
            System.out.println("OTHER " + otherUrlNumber);
         }
    }

    public void killR() {

        ambientUrlNumber = 0;
        jazzUrlNumber = 0;
        tranceUrlNumber = 0;
        rockUrlNumber = 0;
        otherUrlNumber = 0;

        if (ambientThread != null) {
            ambientThread.stop();
          }
        if (jazzThread != null) {
            jazzThread.stop();
          }
        if (tranceThread != null) {
            tranceThread.stop();
          }
        if (rockThread != null) {
            rockThread.stop();
          }
        if (otherThread != null) {
            otherThread.stop();
           }
    }

}
