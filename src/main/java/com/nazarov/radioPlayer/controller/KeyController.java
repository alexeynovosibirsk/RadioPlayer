package com.nazarov.radioPlayer.controller;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyController implements NativeKeyListener {

    private final WebController webController = new WebController();

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
//        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

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
        // Genres:
        if (e.getKeyCode() == NativeKeyEvent.VC_4 && isAltPressed) {
            webController.buttons("ambient");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_5 && isAltPressed) {
            webController.buttons("easy");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_6 && isAltPressed) {
            webController.buttons("synth");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_7 && isAltPressed) {
            webController.buttons("dance");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_8 && isAltPressed) {
            webController.buttons("jazz");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_9 && isAltPressed) {
            webController.buttons("trance");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_0 && isAltPressed) {
            webController.buttons("Update_lists");
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
//        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }
    @Override
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
