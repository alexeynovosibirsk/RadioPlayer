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

    public LogoPlayer(int numIndex) {
        play(logoList(numIndex));
    }

    private static InputStream logoList(int numIndex)  {

        List<String> arrLogo = new ArrayList<>();

        arrLogo.add("sounds/hello.mp3");
        arrLogo.add("sounds/next.mp3");
        arrLogo.add("sounds/newStationList.mp3");
        arrLogo.add("sounds/sleepMode.mp3");
        arrLogo.add("sounds/shutdown.mp3");
        arrLogo.add("sounds/urlIsNotValid.mp3");
        arrLogo.add("sounds/switch.mp3");

        Resource resource = new ClassPathResource(arrLogo.get(numIndex));
        InputStream is = null;

        try {
            is = resource.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }

    private void play(InputStream inputStream) {

        try {
            AdvancedPlayer advancedPlayer = new AdvancedPlayer(inputStream);
            advancedPlayer.play();

        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}