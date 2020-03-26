package com.nazarov.radioPlayer.playlist;

import com.nazarov.radioPlayer.RadioApplication;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class GitCloner {

    public GitCloner() {
        RadioApplication radioApplication = new RadioApplication();

        // remove directory with configs if it is
        Path rootPath = Paths.get(radioApplication.playlistDirectory);
        System.out.println("Delete temporary directory:");
        try {
             Files.walk(rootPath)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .peek(System.out::println)
                        .forEach(File::delete);

            } catch (IOException e) {
                System.out.println("No temp directory for deleting...");
            }

        // then creating new directory and cloning from github
        File file = new File(radioApplication.getPlaylistDirectory());
        try {
            Git git = Git.cloneRepository()
                    .setURI(radioApplication.getGithubUrl())
                    .setDirectory(file)
                    .call();

        } catch (GitAPIException ge) {
            ge.printStackTrace();
        }
    }
}