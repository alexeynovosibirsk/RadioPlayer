package com.nazarov.radioPlayer.controller;

import com.nazarov.radioPlayer.audio.StationSwitcher;
import com.nazarov.radioPlayer.config.FileConfigReader;
import com.nazarov.radioPlayer.osdependent.VolumeControl;
import com.nazarov.radioPlayer.osdependent.PowerOff;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.HashMap;
import java.util.Map;

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
            stationSwitcher.other();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(5)) {

        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(6)) {
            stationSwitcher.nextStation();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(7)) {

        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(8)) {
            volumeControl.volumeUp();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(9)) {
            volumeControl.volumeDn();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(10)) {
            stationSwitcher.stopRadio();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(11)) {
//            powerOff.powerOff();
        }
        /* ------------------- Remote keyboard ----------------- */
        if (e.getKeyCode() == fileConfigReader.getKeyCode(12)) {
            stationSwitcher.ambient();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(13)) {
            stationSwitcher.jazz();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(14)) {
            stationSwitcher.trance();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(15)) {
            stationSwitcher.retro();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(16)) {
            stationSwitcher.other();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(17)) {

        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(18)) {
            stationSwitcher.nextStation();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(19)) {
            volumeControl.volumeUp();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(20)) {
            volumeControl.volumeDn();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(21)) {
            stationSwitcher.stopRadio();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(22)) {
//            powerOff.powerOff();
        }
        if (e.getKeyCode() == fileConfigReader.getKeyCode(23)) {

        }

//        if (e.getKeyCode() == NativeKeyEvent.VC_0) {
//            powerControl.powerOff();
//            System.exit(0);
//        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) { }

    public void nativeKeyPressed(NativeKeyEvent e) { }
}