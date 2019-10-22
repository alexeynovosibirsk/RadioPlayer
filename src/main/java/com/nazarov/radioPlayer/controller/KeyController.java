package com.nazarov.radioPlayer.controller;

import com.nazarov.radioPlayer.audio.StationSwitcher;
import com.nazarov.radioPlayer.config.FileConfigReader;
import com.nazarov.radioPlayer.osdependent.VolumeControl;
import com.nazarov.radioPlayer.osdependent.PowerOff;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyController implements NativeKeyListener {

    StationSwitcher stationSwitcher = new StationSwitcher();
    VolumeControl volumeControl = new VolumeControl();
    PowerOff powerOff = new PowerOff();
    FileConfigReader fileConfigReader = new FileConfigReader();

    public void nativeKeyReleased(NativeKeyEvent e) {

        fileConfigReader.mapperKeys();

        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == fileConfigReader.getKeyCode(0)) {
           stationSwitcher.ambient();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(1)) {
            stationSwitcher.jazz();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(2)) {
            stationSwitcher.trance();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(3)) {
            stationSwitcher.retro();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(4)) {
            stationSwitcher.variable();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(5)) {
            stationSwitcher.dance();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(6)) {
            stationSwitcher.nextStation();
        }
         if (e.getKeyCode() == fileConfigReader.getKeyCode(7)) {
            volumeControl.volumeUp();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(8)) {
            volumeControl.volumeDn();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(9)) {
            stationSwitcher.stopRadio();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(10)) {
            powerOff.powerOff(0);
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(11)) {
            powerOff.powerOff(15);
        }

//        if (e.getKeyCode() == NativeKeyEvent.VC_0) {
//            powerControl.powerOff();
//            System.exit(0);
//        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) { }

    public void nativeKeyPressed(NativeKeyEvent e) { }
}