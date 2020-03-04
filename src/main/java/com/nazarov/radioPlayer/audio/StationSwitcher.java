package com.nazarov.radioPlayer.audio;

import org.springframework.stereotype.Service;

@Service
public class StationSwitcher {

    StationPlayer stationPlayer = new StationPlayer();

    public void ambient() {
        System.out.println("Ambient");
        stationPlayer.setPlaylist("playlists/ambient.txt");
        stationPlayer.setNumIndex(0);                       // Number of LogoList string for LogoPlayer
        stationPlayer.playRadio(0);              // Number of urlList string  for urlPlayer
    }

    public void jazz() {
        System.out.println("Jazz");
        stationPlayer.setPlaylist("playlists/jazz.txt");
        stationPlayer.setNumIndex(1);
        stationPlayer.playRadio(0);
    }

    public void trance() {
        System.out.println("Trance");
        stationPlayer.setPlaylist("playlists/trance.txt");
        stationPlayer.setNumIndex(2);
        stationPlayer.playRadio(0);
    }

    public void retro() {
        System.out.println("Retro");
        stationPlayer.setPlaylist("playlists/retro.txt");
        stationPlayer.setNumIndex(3);
        stationPlayer.playRadio(0);
    }

    public void variable() {
        System.out.println("Variable");
        stationPlayer.setPlaylist("playlists/variable.txt");
        stationPlayer.setNumIndex(4);
        stationPlayer.playRadio(0);
    }

    public void dance() {
        System.out.println("Dance");
        stationPlayer.setPlaylist("playlists/dance.txt");
        stationPlayer.setNumIndex(9);
        stationPlayer.playRadio(0);
    }

    public void nextStation() {
        stationPlayer.nextStation();
    }

    public void stopRadio() {
        stationPlayer.stopRadio();
    }



}

