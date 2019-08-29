package com.nazarov.webradioplayer;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyController implements NativeKeyListener {

    GenreLister genreLister = new GenreLister();

    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) { // DO NOT FORGET TO REMOVE!!!
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {

        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        if (e.getKeyCode() == NativeKeyEvent.VC_1) {
            System.out.println("Ambient");
            genreLister.killR();
            genreLister.ambient(0);
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_2) {
            System.out.println("Jazz");
            genreLister.killR();
            genreLister.jazz(0);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_3) {
            System.out.println("Trance");
            genreLister.killR();
            genreLister.trance(0);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_4) {
            System.out.println("Rock");
            genreLister.killR();
            genreLister.rock(0);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_5) {
            System.out.println("Other");
            genreLister.killR();
            genreLister.other(0);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_6) {
            System.out.println("NextStation");
            //   genreLister.killR();
            genreLister.nextStation();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_7) {
            System.out.println("Check");
          }
        if (e.getKeyCode() == NativeKeyEvent.VC_8) {
            System.out.println("Check");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_9) {
            System.out.println("Shutdown");
            System.exit(0);
        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        // System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public static void main(String[] args) {

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

        GlobalScreen.addNativeKeyListener(new KeyController());
    }
}