package com.nazarov.radioPlayer.controller;

import com.nazarov.radioPlayer.audio.StationSwitcher;
import com.nazarov.radioPlayer.audio.VolumeControl;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyController implements NativeKeyListener {

    StationSwitcher stationSwitcher = new StationSwitcher();
    VolumeControl volumeControl = new VolumeControl();



    public void nativeKeyReleased(NativeKeyEvent e) {

        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        if (e.getKeyCode() == NativeKeyEvent.VC_1) {
            System.out.println("Ambient");
            stationSwitcher.setS("playlists/ambient.txt");
            stationSwitcher.setNumIndex(0);
            stationSwitcher.playRadio(0);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_2) {
            System.out.println("Jazz");
            stationSwitcher.setS("playlists/jazz.txt");
            stationSwitcher.setNumIndex(1);
            stationSwitcher.playRadio(0);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_3) {
            System.out.println("Trance");
            stationSwitcher.setS("playlists/trance.txt");
            stationSwitcher.setNumIndex(2);
            stationSwitcher.playRadio(0);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_4) {
            System.out.println("Retro");
            stationSwitcher.setS("playlists/retro.txt");
            stationSwitcher.setNumIndex(3);
            stationSwitcher.playRadio(0);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_5) {
            System.out.println("Other");
            stationSwitcher.setS("playlists/other.txt");
            stationSwitcher.setNumIndex(4);
            stationSwitcher.playRadio(0);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_6) {
            stationSwitcher.nextStation();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_7) {
            stationSwitcher.stopRadio();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_9) {
            System.out.println("Shutdown");
            System.exit(0);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_MINUS) {
            volumeControl.volDown();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_EQUALS) {
            volumeControl.volUp();
        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) { }

    public void nativeKeyPressed(NativeKeyEvent e) { }
}