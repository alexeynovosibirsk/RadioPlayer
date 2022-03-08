package com.nazarov.radioPlayer.controller;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class KeyController implements NativeKeyListener {

    private WebController webController = new WebController();

    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        boolean isAltPressed = (e.getModifiers() & NativeKeyEvent.ALT_MASK) != 0;

        if (e.getKeyCode() == NativeKeyEvent.VC_1 && isAltPressed) {
            webController.buttons("Mute");
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_2 && isAltPressed) {
            webController.buttons("Next_Station");
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_3 && isAltPressed) {
            webController.buttons("Previous_Station");
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
//        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
//        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

//    public static void main(String[] args) {
//        try {
//            GlobalScreen.registerNativeHook();
//        }
//        catch (NativeHookException ex) {
//            System.err.println("There was a problem registering the native hook.");
//            System.err.println(ex.getMessage());
//            System.exit(1);
//        }
//        GlobalScreen.addNativeKeyListener(new KeyController());
//    }
}
