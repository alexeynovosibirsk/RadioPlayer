package com.nazarov.radioPlayer.audio;

public class StationSwitcher {

    StationPlayer stationPlayer = new StationPlayer();

    public void ambient() {
        System.out.println("Ambient");
        stationPlayer.setPlaylist("playlists/ambient.txt");
        stationPlayer.setNumIndex(0);
        stationPlayer.playRadio(0);
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

    public void other() {
        System.out.println("Other");
        stationPlayer.setPlaylist("playlists/other.txt");
        stationPlayer.setNumIndex(4);
        stationPlayer.playRadio(0);
    }

    public void nextStation() {
        stationPlayer.nextStation();
    }

    public void stopRadio() {
        stationPlayer.stopRadio();
    }



}

