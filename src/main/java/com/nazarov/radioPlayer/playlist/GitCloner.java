package com.nazarov.radioPlayer.playlist;

import com.nazarov.radioPlayer.RadioApplication;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

@Slf4j
@Getter
public class GitCloner {

    private boolean playlistsCloned = false;

    public boolean go() {
        // remove directory with configs if it is
        Path rootPath = Paths.get(RadioApplication.playlistDirectory);
        log.info("Delete temporary directory");

        try {
             Files.walk(rootPath)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .peek(System.out::println)
                        .forEach(File::delete);

            } catch (IOException e) {
                log.info("No temp directory for deleting...");
            }

        // then creating new directory and cloning from github
        File file = new File(RadioApplication.playlistDirectory);
        try {
            Git.cloneRepository()
                    .setURI(RadioApplication.githubUrl)
                    .setDirectory(file)
                    .call();

            playlistsCloned = true;

        } catch (GitAPIException e) {
            log.error("No connection to github!");
        }

        return playlistsCloned;
    }
}