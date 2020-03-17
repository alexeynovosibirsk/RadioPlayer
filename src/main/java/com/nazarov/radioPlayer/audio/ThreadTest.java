package com.nazarov.radioPlayer.audio;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ThreadTest implements Runnable {

    URL url;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                url = new URL("http://stream.syntheticfm.com:8040/stream");

                AdvancedPlayer advancedPlayer = new AdvancedPlayer(url.openStream());
                advancedPlayer.play();

            } catch (JavaLayerException e) {
                e.printStackTrace();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }
    }
    AdvancedPlayer advancedPlayer;

    public void justPlay() {
        try {
            url = new URL("http://stream.syntheticfm.com:8040/stream");

            AdvancedPlayer  advancedPlayer = new AdvancedPlayer(url.openStream());

            advancedPlayer.play();

        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
    public  void stopPlayer() {

        advancedPlayer.stop();
    }
    }

class Demo {

    public static void main(String[] args) {

//        Thread t = new Thread(new ThreadTest());
//        t.start();
//        t.setDaemon(true);
        ThreadTest tt = new ThreadTest();
        tt.justPlay();

        Scanner scanner = new Scanner(System.in);
        int i  = scanner.nextInt();
        if (i == 1) {

          //  t.interrupt();

            System.out.println("AAA");
        }
    }
}
