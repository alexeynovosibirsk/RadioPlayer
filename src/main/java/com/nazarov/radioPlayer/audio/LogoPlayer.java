package com.nazarov.radioPlayer.audio;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LogoPlayer {

    private static InputStream is = null;

    public LogoPlayer(int numIndex) {
        play(logoList(numIndex));
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void play(InputStream is) {

        try {
            AdvancedPlayer advancedPlayer = new AdvancedPlayer(is);
            advancedPlayer.play();

        } catch (JavaLayerException j) {
            j.printStackTrace();
        }
    }
    private static InputStream logoList(int numIndex)  {

        List<String> arrLogo = new ArrayList<>();
        arrLogo.add("sounds/hello.mp3");
        arrLogo.add("sounds/next.mp3");
        arrLogo.add("sounds/newStationList.mp3");
        arrLogo.add("sounds/sleepMode.mp3");
        arrLogo.add("sounds/shutdown.mp3");

        Resource resource = new ClassPathResource(arrLogo.get(numIndex));

        try {
            is = resource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }
}