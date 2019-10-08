package com.nazarov.radioPlayer.playlist;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;

public class GitCloner {

    public void clonePlaylists(String s, String uri) {

        File file = new File(s);

        try {

            Git git = Git.cloneRepository()
                    .setURI(uri)
                    .setDirectory(file)
                    .call();

        } catch (GitAPIException ge) {
            ge.printStackTrace();
        }
    }
}
