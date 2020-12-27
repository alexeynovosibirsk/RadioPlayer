package com.nazarov.radioPlayer.playlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UrlMaker {

    private static File filelist;
    private static int number;
    private static URL url;
    private static String stationName;
    private static int playlistsize;


    public UrlMaker (String filelist, int number) {

        this.filelist = new File(filelist);
        this.number = number;
    }

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
        return url;
    }

    public static String getUrlForJsp() {

        urlMaker();

        StringBuilder sb = new StringBuilder();
        sb.append(url.toString())
                .delete(0, 7);
        if(sb.length() > 33) {
            sb.substring(32);
        }

        return sb.toString().split("/")[0];
    }

    public static String getInfoForJsp() {

        StringBuilder genre = new StringBuilder();
        genre.append(filelist.toString().split("/")[3])
                .reverse()
                .delete(0, 4)
                .reverse();

        StringBuilder sb = new StringBuilder();
        sb.append(playlistsize + 1)
                .append(" < ")
                .append(genre)
                .append(" > ")
                .append(number + 1);

        return  sb.toString();
    }

    public static String getStationNameForJsp() {
        return stationName;
    }

    private static void urlMaker() {

        List<String> playlist = new ArrayList<>();
        List<String> statname = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(filelist))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String url = line.split(" ")[0];

                String st = line.replaceAll("[\\s|\\u00A0]+", " ");
                String name = st.split(" ")[1];

                playlist.add(url);
                statname.add(name);

            }
         } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        playlistsize = playlist.size() - 1;

        try {
            url = new URL(playlist.get(number));
            stationName = statname.get(number);


        } catch (MalformedURLException em) {
            em.printStackTrace();
        }
    }
}