package com.nazarov.radioPlayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nazarov.radioPlayer.audio.LogoPlayer;
import com.nazarov.radioPlayer.playlist.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class RadioApplication  {

   public static String playlistDirectory = "configs";
   public static String githubUrl = "https://github.com/nixoved/RadioPlayerPlaylists";
   public static String playlistDirPath = playlistDirectory + "/";
   public static String playlistExtension = ".txt";
   public static String genreOne;
   public static String genreTwo;
   public static String genreThree;
   public static String genreFour;
   public static String genreFive;
   public static String genreSix;

   public static String getPlaylistDirectory() {
       return playlistDirectory;
   }
   public static String getPlaylistDirPath() { return playlistDirPath; }
   public static String getPlaylistExtension() { return playlistExtension; }
   public static String getGithubUrl() { return githubUrl; }
   public static String getGenreOne() {
        return genreOne;
    }
   public static String getGenreTwo() {
        return genreTwo;
    }
   public static String getGenreThree() {
        return genreThree;
    }
   public static String getGenreFour() {
        return genreFour;
    }
   public static String getGenreFive() {
        return genreFive;
    }
   public static String getGenreSix() {
        return genreSix;
    }

    public void readConfigs() {

        File folder = new File(playlistDirectory);
        List<String> listGenres = new ArrayList<>(5);
        for (File f : folder.listFiles()) {

            String s = f.toString().split("/")[1];
            if (s.endsWith("txt")) {
                String genre = s.replace(playlistExtension, "");
                listGenres.add(genre);
            }
         }
        Collections.sort(listGenres);
    genreOne = listGenres.get(0).intern();
    genreTwo = listGenres.get(1).intern();
    genreThree = listGenres.get(2).intern();
    genreFour = listGenres.get(3).intern();
    genreFive = listGenres.get(4).intern();
    genreSix = listGenres.get(5).intern();
}
    public static void main(String[] args)  {

        new GitCloner();
        RadioApplication r = new RadioApplication();
        r.readConfigs();

        new UrlMaker(playlistDirPath + getGenreOne() + playlistExtension, 0); // For jsp ${url}
        SpringApplication.run(RadioApplication.class, args);

        System.out.println("----- webRadio is ready! -----");

       new LogoPlayer(0);
    }
}
