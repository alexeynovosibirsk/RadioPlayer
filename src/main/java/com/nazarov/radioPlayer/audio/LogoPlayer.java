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

        arrLogo.add("sounds/0-hello.mp3");
        arrLogo.add("sounds/1-next.mp3");
        arrLogo.add("sounds/2-newStationList.mp3");
        arrLogo.add("sounds/3-sleepMode.mp3");
        arrLogo.add("sounds/4-shutdown.mp3");
        arrLogo.add("sounds/5-urlIsNotValid.mp3");
        arrLogo.add("sounds/6-switch.mp3");
        arrLogo.add("sounds/7-falling.mp3");
        arrLogo.add("sounds/8-updatesCompleted.mp3");

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