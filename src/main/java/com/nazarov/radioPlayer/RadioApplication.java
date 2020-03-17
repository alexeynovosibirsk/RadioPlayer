package com.nazarov.radioPlayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nazarov.radioPlayer.audio.LogoPlayer;
import com.nazarov.radioPlayer.playlist.*;

@SpringBootApplication
public class RadioApplication  {

    public static void main(String[] args)  {

        String playlistDirectory = "playlists";
        String githubUrl = "https://github.com/nixoved/RadioPlayerPlaylists";

        SpringApplication.run(RadioApplication.class, args);

        new DeleteTemp(playlistDirectory);

        new GitCloner(playlistDirectory, githubUrl);

        // Below for jsp ${url}:
        UrlMaker u = new UrlMaker();
        u.setFilelist(playlistDirectory + "/ambient.txt");
        u.setNumber(0);

        System.out.println("----- webRadio is ready! -----");

       new LogoPlayer(5);
    }
}