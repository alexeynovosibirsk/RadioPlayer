package com.nazarov.radioPlayer.playlist;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.*;
import java.util.ArrayList;

public class FilePlayList {

    private static InputStream is;

    public static InputStream logoList(int numIndex)  {

        String s = "sounds/";

        ArrayList<String> arrLogo = new ArrayList<>();

        arrLogo.add(s + "ambient.mp3");
        arrLogo.add(s + "jazz.mp3");
        arrLogo.add(s + "trance.mp3");
        arrLogo.add(s + "retro.mp3");
        arrLogo.add(s + "variable.mp3");
        arrLogo.add(s + "hello.mp3");
        arrLogo.add(s + "next.mp3");
        arrLogo.add(s + "sleepMode.mp3");
        arrLogo.add(s + "shutdown.mp3");
        arrLogo.add(s + "dance.mp3");

        Resource resource = new ClassPathResource(arrLogo.get(numIndex));

        try {

            is = resource.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return is;
    }
}