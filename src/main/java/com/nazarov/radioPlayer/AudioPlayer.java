package com.nazarov.radioPlayer;

import java.io.IOException;
import java.net.URL;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.*;

public class AudioPlayer {

    public void playR(URL url) {

        try {
            Thread   playerThread = new Thread();
            playerThread.start();
            AdvancedPlayer advancedPlayer = new AdvancedPlayer(url.openStream());
            advancedPlayer.play();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JavaLayerException j) {
            j.printStackTrace();
        }
    }
 }