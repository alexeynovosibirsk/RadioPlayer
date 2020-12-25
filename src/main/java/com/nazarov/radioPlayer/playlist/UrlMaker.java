package com.nazarov.radioPlayer.playlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UrlMaker {
    final static Logger logger = LoggerFactory.getLogger(UrlMaker.class);

    private static File filelist;
    private static URL url;
    private static String stationName;
    private static int playlistsize;
    private static int number;


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
        String urlForJsp = null;
        urlMaker();
        String fullUrl = url.toString();
        String urlWithoutProtocol = fullUrl.replace("http://", "");
        if (urlWithoutProtocol.length() > 33) {
            urlForJsp = urlWithoutProtocol.substring(0, 32).split("/")[0];
        } else {
            urlForJsp = urlWithoutProtocol.split("/")[0];
        }
        return urlForJsp;
    }

    public static String getInfoForJsp() {
        String filelistToString = filelist.toString();
        String genre = filelistToString.split("/")[3].replace(".txt", "");
        return  playlistsize + " - " + genre + " - " + number;
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