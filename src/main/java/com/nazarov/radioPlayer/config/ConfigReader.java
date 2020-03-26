package com.nazarov.radioPlayer.config;

import com.nazarov.radioPlayer.RadioApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConfigReader {

    private static String email;
    private static String user;
    private static String genreOne;
    private static String genreTwo;
    private static String genreThree;
    private static String genreFour;
    private static String genreFive;
    private static String genreSix;

    RadioApplication radioApplication = new RadioApplication();

    public static String getEmail() { return  email; }
    public static String getUser() {
        String user = email.split("@")[0];
        return user;
    }
    public static String getGenreOne() {
        return genreOne;
    }
    public static String getGenreTwo() {
        return genreTwo;
    }
    public static String getGenreThree() {
        return genreThree;
    }
    public static String getGenreFour() {
        return genreFour;
    }
    public static String getGenreFive() {
        return genreFive;
    }
    public static String getGenreSix() {
        return genreSix;
    }

    public ConfigReader () {

        File file = new File(radioApplication.getPlaylistDirPath() + "config.txt");
        Scanner scanner;
        List<String> list = new ArrayList<>();

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().split(" ")[0];
                list.add(s);
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        email = list.get(0);
        genreOne = list.get(1);
        genreTwo = list.get(2);
        genreThree = list.get(3);
        genreFour = list.get(4);
        genreFive = list.get(5);
        genreSix = list.get(6);
    }
}
