package com.nazarov.radioPlayer.newFeatures;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class PausablePlayer  {

    private final static int NOTSTARTED = 0;
    private final static int PLAYING = 1;
    private final static int PAUSED = 2;
    private final static int FINISHED = 3;

    // the player actually doing all the work
    private Player player;
    URL url;

    // locking object used to communicate with player thread
    private final Object playerLock = new Object();

    // status variable what player thread is doing/supposed to do
    private int playerStatus = NOTSTARTED;

    public PausablePlayer(URL url) {
        try {
            player = new Player(url.openStream());
        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
    /**
     * Starts playback (resumes if paused)
     */
    public void play() throws JavaLayerException {
        synchronized (playerLock) {
            switch (playerStatus) {
                case NOTSTARTED:
                    final Runnable r = new Runnable() {
                        public void run() {
                            playInternal();
                        }
                    };
                    final Thread t = new Thread(r);

                    playerStatus = PLAYING;
                    t.start();
                    System.out.println(t.getName());
                    break;

                default:
                    break;
            }
        }
    }

    public void stop() {
        synchronized (playerLock) {
            playerStatus = FINISHED;
            playerLock.notifyAll();
        }
    }

    private void playInternal() {
        while (playerStatus != FINISHED) {
            try {
                if (!player.play(1)) {
                    break;
                }
            } catch (final JavaLayerException e) {
                break;
            }
            // check if paused or terminated
            synchronized (playerLock) {
                while (playerStatus == PAUSED) {
                    try {
                        playerLock.wait();
                    } catch (final InterruptedException e) {
                        // terminate player
                        break;
                    }
                }
            }
        }
        close();
    }

    /**
     * Closes the player, regardless of current state.
     */
    public void close() {
        synchronized (playerLock) {
            playerStatus = FINISHED;
        }
        try {
            player.close();
        } catch (final Exception e) {
            // ignore, we are terminating anyway
        }
    }

    // demo how to use
    public static void main(String[] argv) {
        try {
           URL url = new URL("http://stream.syntheticfm.com:8040/stream");

            PausablePlayer player = new PausablePlayer(url);
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextInt()) {
                int i = scanner.nextInt();
                if (i == 1) {


                    // start playing
                    player.play();
                    System.out.println("play");
                    Thread.sleep(1000);
                    player.stop();

                }
                if (i == 2) {

                    player.stop();
                    System.out.println("pause");
                }
            }

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

}
