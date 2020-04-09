package com.nazarov.radioPlayer.newFeatures;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class ThreadTest implements Runnable {

    URL url;
    boolean isActive;
    void disable() {
        isActive = false;
    }

    ThreadTest() {
        isActive = true;
    }

    @Override
    public void run() {
        while (isActive) {
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
       new Thread(tt).start();

        Scanner scanner = new Scanner(System.in);
        int i  = scanner.nextInt();
        if (i == 1) {

            tt.disable();

            System.out.println("AAA");
        }
    }
}
