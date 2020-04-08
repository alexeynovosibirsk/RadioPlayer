package com.nazarov.radioPlayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nazarov.radioPlayer.audio.LogoPlayer;
import com.nazarov.radioPlayer.playlist.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void readConfig() {

    File file = new File(playlistDirPath + "config.txt");
    Scanner scanner;
    List<String> list = new ArrayList<>();

                try {
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().split(" ")[0];
            list.add(s);
        }
    } catch (
    FileNotFoundException e) {
        e.printStackTrace();
    }

    genreOne = list.get(1).intern();
    genreTwo = list.get(2).intern();
    genreThree = list.get(3).intern();
    genreFour = list.get(4).intern();
    genreFive = list.get(5).intern();
    genreSix = list.get(6).intern();
}

    public static void main(String[] args)  {

        new GitCloner();

        RadioApplication r = new RadioApplication();
        r.readConfig();

        new UrlMaker(playlistDirPath + getGenreOne() + playlistExtension, 0); // For jsp ${url}
        SpringApplication.run(RadioApplication.class, args);

        System.out.println("----- webRadio is ready! -----");

       new LogoPlayer(0);
    }
}
