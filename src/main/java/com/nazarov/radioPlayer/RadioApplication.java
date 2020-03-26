package com.nazarov.radioPlayer;

import com.nazarov.radioPlayer.config.ConfigReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nazarov.radioPlayer.audio.LogoPlayer;
import com.nazarov.radioPlayer.playlist.*;

@SpringBootApplication
public class RadioApplication  {

   public static String playlistDirectory = "configs";
   public static String githubUrl = "https://github.com/nixoved/RadioPlayerPlaylists";
   public static String playlistDirPath = playlistDirectory + "/";
   public static String playlistExtension = ".txt";

   public static String getPlaylistDirectory() {
       return playlistDirectory;
   }
   public static String getPlaylistDirPath() { return playlistDirPath; }
   public static String getPlaylistExtension() { return playlistExtension; }
   public static String getGithubUrl() { return githubUrl; }

    public static void main(String[] args)  {
        new GitCloner();
        new ConfigReader();
        new UrlMaker(playlistDirPath + ConfigReader.getGenreOne() + playlistExtension, 0); // For jsp ${url}
        SpringApplication.run(RadioApplication.class, args);

        System.out.println("----- webRadio is ready! -----");

       new LogoPlayer(0);
    }
}