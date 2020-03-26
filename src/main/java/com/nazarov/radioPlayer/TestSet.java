package com.nazarov.radioPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class TestSet  {

    public static void main(String[] args) {

        File file = new File("config/config.txt");
        Scanner scanner;
        List<String> list = new ArrayList<>();
        String one = list.get(0);
        String two;
        try {
           scanner =new Scanner(file);
            while(scanner.hasNextLine()) {
                String s = scanner.nextLine().split(" ")[0];
                list.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(String s : list) {
            System.out.println(s);
        }



    }


}
