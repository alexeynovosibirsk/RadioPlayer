package com.nazarov.radioPlayer.playlist;

import java.io.File;
import java.util.ArrayList;

public class FilePlayList {

    private static  File file;

    public static File logoList(int numIndex) {
        String s = "classes/sounds/";

        ArrayList<String> arrLogo = new ArrayList<>();
        arrLogo.add(s + "ambient.mp3");
        arrLogo.add(s + "jazz.mp3");
        arrLogo.add(s + "trance.mp3");
        arrLogo.add(s + "retro.mp3");
        arrLogo.add(s + "other.mp3");
        arrLogo.add(s + "hello.mp3");
        arrLogo.add(s + "next.mp3");

        file = new File(arrLogo.get(numIndex));

        return file;
    }
}