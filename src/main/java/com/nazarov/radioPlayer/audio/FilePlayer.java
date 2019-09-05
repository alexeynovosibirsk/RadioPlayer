package com.nazarov.radioPlayer.audio;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.*;
import java.net.URL;

public class FilePlayer {

    public void play(File file) {


        try {
            InputStream is = new FileInputStream(file);


            AdvancedPlayer advancedPlayer = new AdvancedPlayer(is);
            advancedPlayer.play();

        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (JavaLayerException j) {
            j.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}