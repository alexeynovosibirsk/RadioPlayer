package com.nazarov.radioPlayer.playlist;

import com.nazarov.radioPlayer.RadioApplication;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class GitCloner {
    final static Logger logger = LoggerFactory.getLogger(GitCloner.class);

    public GitCloner() {

        // remove directory with configs if it is
        Path rootPath = Paths.get(RadioApplication.playlistDirectory);
        logger.info("Delete temporary directory:");

        try {
             Files.walk(rootPath)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .peek(System.out::println)
                        .forEach(File::delete);

            } catch (IOException e) {
                logger.info("No temp directory for deleting...");
            }

        // then creating new directory and cloning from github
        File file = new File(RadioApplication.getPlaylistDirectory());
        try {
            Git git = Git.cloneRepository()
                    .setURI(RadioApplication.getGithubUrl())
                    .setDirectory(file)
                    .call();

        } catch (GitAPIException ge) {
            ge.printStackTrace();
        }
    }
}