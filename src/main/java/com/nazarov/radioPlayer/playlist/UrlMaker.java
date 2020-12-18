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
    private static URL url;
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
        urlMaker();
        String fullUrl = "" + url;
        String urlWithoutProtocol = fullUrl.replace("http://", "");
        String urlForJsp = "";
        if (urlWithoutProtocol.length() > 33) {
            urlForJsp = urlWithoutProtocol.substring(0, 32);
        } else {
            urlForJsp = urlWithoutProtocol;
        }
        return urlForJsp;
    }

    public static String getInfoForJsp() {

        String filelistToString = filelist.toString();
        String genre = filelistToString.split("/")[1].replace(".txt", "");
        return  playlistsize + " - " + genre + " - " + number;
    }

    private static void urlMaker() {

        List<String> playlist = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(filelist))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String url = line.split(" ")[0];
                playlist.add(url);
            }
         } catch (FileNotFoundException e) {
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