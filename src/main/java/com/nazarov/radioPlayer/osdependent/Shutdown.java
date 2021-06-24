package com.nazarov.radioPlayer.osdependent;

import com.nazarov.radioPlayer.audio.LogoPlayer;

public class Shutdown {

    public static void go() {
        new LogoPlayer(4);
        System.exit(1);
    }
}
