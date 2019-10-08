package com.nazarov.radioPlayer;

import org.jnativehook.GlobalScreen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.NativeHookException;
import com.nazarov.radioPlayer.audio.FilePlayer;
import com.nazarov.radioPlayer.controller.KeyController;
import com.nazarov.radioPlayer.playlist.*;

@SpringBootApplication
public class RadioApplication  {

    public static void main(String[] args)  {

        String playlistDirectory = "playlists";
        String githubUrl = "https://github.com/nixoved/webRadioPlayerPlaylists";

        SpringApplication.run(RadioApplication.class, args);

        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);

        DeleteTemp deleteTemp = new DeleteTemp();
        deleteTemp.del(playlistDirectory);

        GitCloner g = new GitCloner();
        g.clonePlaylists(playlistDirectory, githubUrl);

        System.out.println("----- webRadio is ready! -----");

        FilePlayer filePlayer = new FilePlayer();
        filePlayer.logoPlayer(5);

        GlobalScreen.addNativeKeyListener(new KeyController());
    }
}