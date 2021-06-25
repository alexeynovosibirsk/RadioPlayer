package com.nazarov.radioPlayer.osdependent;

import com.nazarov.radioPlayer.audio.LogoPlayer;

public class Shutdown {

    public static void go() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        new LogoPlayer(4);
        new LogoPlayer(7);
        System.exit(1);
    }
}
