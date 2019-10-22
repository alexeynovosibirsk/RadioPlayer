package com.nazarov.radioPlayer.audio;

import com.nazarov.radioPlayer.playlist.FilePlayList;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.springframework.stereotype.Service;

import java.io.InputStream;

public class FilePlayer {

    public void logoPlayer(int numIndex) {

        play(FilePlayList.logoList(numIndex));
    }

    private void play(InputStream is) {

        try {

            AdvancedPlayer advancedPlayer = new AdvancedPlayer(is);
            advancedPlayer.play();

        } catch (JavaLayerException j) {
            j.printStackTrace();
        }
    }
}