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

    private static  File file;
    private static  URL url;

    public static List<String> getPlaylist() {

        List<String>  playlist = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";

            while (line != null) {

                line = br.readLine();

                playlist.add(line);
            }

            br.close();
            playlist.removeAll(Collections.singleton(null));
            playlist.removeAll(Collections.singleton(""));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return playlist;
    }

    public static URL getUrl(int number) {

        List<String>  playlist = getPlaylist();

        int playlistSize = playlist.size();

        if (number > (playlistSize -1 )) {
            number = 0;
        }

        try {
            url = new URL(playlist.get(number));
        } catch (MalformedURLException em) {
            em.printStackTrace();
        }

        System.out.println("TotalStations: " + playlistSize + " | Current: " + number + " | url: " + url);

        return url;
    }

    public static void setFile(String s) {

        file = new File(s);
    }

    public static int getPlaylistSize() {
        List<String> playlist = getPlaylist();

        int playlistSize = playlist.size() - 1;

        return playlistSize;
    }

    public static URL logoURL(int numIndex) {

        ArrayList<String> arrLogo = new ArrayList<>();
        arrLogo.add("http://localhost:8080/logo/ambient");
        arrLogo.add("http://localhost:8080/logo/jazz");
        arrLogo.add("http://localhost:8080/logo/trance");
        arrLogo.add("http://localhost:8080/logo/rock");
        arrLogo.add("http://localhost:8080/logo/other");
        arrLogo.add("http://localhost:8080/logo/hello");

        try {

           url = new URL(arrLogo.get(numIndex));
        } catch (MalformedURLException em2) {
            em2.printStackTrace();
        }
        return url;
    }
}