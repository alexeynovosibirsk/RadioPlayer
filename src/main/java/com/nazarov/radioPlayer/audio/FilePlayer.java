package com.nazarov.radioPlayer.audio;

import com.nazarov.radioPlayer.playlist.FilePlayList;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.*;

public class FilePlayer {

    private void play(InputStream is) {

        try {

            AdvancedPlayer advancedPlayer = new AdvancedPlayer(is);
            advancedPlayer.play();

        } catch (JavaLayerException j) {
            j.printStackTrace();
        }
    }

    public void logoPlayer(int numIndex) {

        play(FilePlayList.logoList(numIndex));
    }



}