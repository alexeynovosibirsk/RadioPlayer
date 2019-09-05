package com.nazarov.radioPlayer.playlist;

import org.eclipse.jgit.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;


public class DeleteTemp {

    public void del(String fileName) {

        Path rootPath = Paths.get(fileName);
try {
    Files.walk(rootPath)
            .sorted(Comparator.reverseOrder())
            .map(Path::toFile)
            .peek(System.out::println)
            .forEach(File::delete);
} catch (IOException e) {
    e.printStackTrace();
}

    }

    public static void main(String[] args) {
        DeleteTemp d = new DeleteTemp();
        d.del("playlists");
    }
}
