package com.nazarov.radioPlayer;

import com.nazarov.radioPlayer.controller.KeyController;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nazarov.radioPlayer.audio.LogoPlayer;
import com.nazarov.radioPlayer.playlist.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            String s = f.getName();
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

       GitCloner gs = new GitCloner();
       gs.go();

       if (gs.getPlaylistsCloned() == true) {
           readConfigs();

           new UrlMaker(playlistDirPath + getGenreOne() + playlistExtension, 0); // For jsp ${url}

           logger.info("WebRadio is ready!");
           new LogoPlayer(0);

       } else {
           File fakeFile = null;
           try {
               fakeFile = new File("/tmp/configs/easy.txt");
               FileWriter fw = new FileWriter(fakeFile);
               fw.write("http://error_no_connection_to_github/ error no connection to github");
               fw.close();
               fw.flush();
           } catch (IOException e) {
               logger.error("Unable to write to fake file");
           }
           new UrlMaker(fakeFile.toString(), 0);
       }
        SpringApplication.run(RadioApplication.class, args);

       //JnativeHook:
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new KeyController());
    }
}