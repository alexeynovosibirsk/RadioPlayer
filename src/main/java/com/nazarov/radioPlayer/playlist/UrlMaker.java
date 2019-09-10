package com.nazarov.radioPlayer.playlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UrlMaker {

    private static  File filelist;
    private static  URL url;
    private static int playlistsize;
    private static int number;

    public static void setFilelist(String s) {

        filelist = new File(s);
    }

    public static void setNumber(int localnumber) {

         number = localnumber;
    }

    public static int getPlaylistSize() {

        urlMaker();

        return playlistsize;
    }

    public static URL getUrl() {

        urlMaker();

        System.out.println("TotalStations: " + playlistsize + " | Current: " + number + " | url: " + url);

        return url;

    }

    private static void urlMaker() {

        List<String> playlist = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filelist))) {

            String line = "";

            while (line != null) {

                line = br.readLine();

                playlist.add(line);
            }

            playlist.removeAll(Collections.singleton(null));

            playlist.removeAll(Collections.singleton(""));

        } catch (IOException e) {
            e.printStackTrace();
        }

        playlistsize = playlist.size() - 1;

        try {
            url = new URL(playlist.get(number));

        } catch (MalformedURLException em) {
            em.printStackTrace();
        }
    }
}