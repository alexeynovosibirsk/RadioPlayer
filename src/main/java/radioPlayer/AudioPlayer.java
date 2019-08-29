package com.nazarov.webradioplayer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.*;

public class AudioPlayer {


    Thread playerThread = null;
    AdvancedPlayer advancedPlayer = null;
    public void playR(URL url) {

        try {
            playerThread = new Thread();
            playerThread.start();
            AdvancedPlayer advancedPlayer = new AdvancedPlayer(url.openStream());
            advancedPlayer.play();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JavaLayerException j) {
            j.printStackTrace();
        }
    }
    public synchronized void stopR() {

        //playerThread.stop();
        advancedPlayer.close();
        advancedPlayer = null;
        playerThread = null;

    }




    public static void main(String[] args) throws Exception {

        URL url = new URL("http://uk3.internet-radio.com:8021/stream");
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.playR(url);

        audioPlayer.stopR();
    }
}