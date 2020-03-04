package com.nazarov.radioPlayer.playlist;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class DeleteTemp {

    public DeleteTemp(String fileName) {

        Path rootPath = Paths.get(fileName);
        System.out.println("Delete temporary directory:");

        try {
            Files.walk(rootPath)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .peek(System.out::println)
                    .forEach(File::delete);

        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("No temp directory for deleting...");
        }
    }
}