package com.nazarov.radioPlayer.audio;

import java.io.IOException;
import java.net.URL;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.*;

public class UrlPlayer {

    public UrlPlayer(URL url) {

        try {

            AdvancedPlayer advancedPlayer = new AdvancedPlayer(url.openStream());
            advancedPlayer.play();

        } catch (JavaLayerException j) {
            j.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}