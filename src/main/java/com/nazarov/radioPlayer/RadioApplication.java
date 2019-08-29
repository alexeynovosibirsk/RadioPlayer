package com.nazarov.radioPlayer;

import com.nazarov.radioPlayer.playlist.*;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class RadioApplication {

    public static void main(String[] args) throws IOException {

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
        deleteTemp.del("playlists");

        GitCloner g = new GitCloner();
        g.clonePlaylists();

        GenreLister genreLister = new GenreLister();
        genreLister.logoHello();

        GlobalScreen.addNativeKeyListener(new KeyController());
    }
}