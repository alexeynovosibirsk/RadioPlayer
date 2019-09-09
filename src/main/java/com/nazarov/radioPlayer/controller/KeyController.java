package com.nazarov.radioPlayer.controller;

import com.nazarov.radioPlayer.audio.StationSwitcher;
import com.nazarov.radioPlayer.audio.VolumeControl;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyController implements NativeKeyListener {

    StationSwitcher stationSwitcher = new StationSwitcher();
    VolumeControl volumeControl = new VolumeControl();
    PowerControl powerControl = new PowerControl();

    public void nativeKeyReleased(NativeKeyEvent e) {

        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        if (e.getKeyCode() == NativeKeyEvent.VC_1) {
           stationSwitcher.ambient();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_2) {
            stationSwitcher.jazz();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_3) {
            stationSwitcher.trance();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_4) {
            stationSwitcher.retro();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_5) {
            stationSwitcher.other();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_6) {
            stationSwitcher.nextStation();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_9) {
            stationSwitcher.stopRadio();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_0) {
         //   powerControl.powerOff();
           // System.exit(0);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_7) {
            volumeControl.volumeUp();
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_8) {
            volumeControl.volumeDn();
        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) { }

    public void nativeKeyPressed(NativeKeyEvent e) { }
}