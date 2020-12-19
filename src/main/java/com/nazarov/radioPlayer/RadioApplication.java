package com.nazarov.radioPlayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nazarov.radioPlayer.audio.LogoPlayer;
import com.nazarov.radioPlayer.playlist.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class RadioApplication  {
    final static Logger logger = LoggerFactory.getLogger(RadioApplication.class);

   public static String playlistDirectory = "/tmp/configs";
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

    public static void readConfigs() {

        File folder = new File(playlistDirectory);
        List<String> listGenres = new ArrayList<>(5);

        for (File f : folder.listFiles()) {
            String s = f.toString().split("/")[3];
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

        readConfigs();

        new UrlMaker(playlistDirPath + getGenreOne() + playlistExtension, 0); // For jsp ${url}
        SpringApplication.run(RadioApplication.class, args);

        logger.info("WebRadio is ready!");

       new LogoPlayer(0);
    }
}