package com.nazarov.radioPlayer.newFeatures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseDir {

    public void go() {
        Set<String> genreSet = new HashSet<>();

        File folder = new File("configs");
        List<String> res = new ArrayList<>();
        for (File f : folder.listFiles()) {

            String s = f.toString().split("/")[1];
            if (s.endsWith("txt")) {
                String genre = s.replace(".txt", "");
                res.add(genre);

            }
        }
            Collections.sort(res);
            for (String a : res) {
                System.out.println(a);
            }
        }






    public static void main(String[] args) {
        ParseDir p = new ParseDir();
        p.go();

    }
}
