package com.nazarov.radioPlayer.playlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UrlMaker {
    private static final Logger logger = LoggerFactory.getLogger(UrlMaker.class);

    private static File filelist;
    private static int number;
    private static URL url;
    private static String urlForJsp;
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

                playlist.add(url);

                String st = line.replaceAll("[\\s|\\u00A0]+", " ");
                String nameArray[] = st.split(" ");
                String name;

                if (nameArray.length != 1) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < nameArray.length; i++) {
                        sb.append(nameArray[i] + " ");
                    }
                    name = sb.toString();

                } else {
                    name = "uknown station";
                }
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