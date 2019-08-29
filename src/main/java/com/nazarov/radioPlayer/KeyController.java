package com.nazarov.radioPlayer;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyController implements NativeKeyListener {

    GenreLister genreLister = new GenreLister();

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
        if (e.getKeyCode() == NativeKeyEvent.VC_9) {
            System.out.println("Shutdown");
            System.exit(0);
        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) { }

    public void nativeKeyPressed(NativeKeyEvent e) { }
}