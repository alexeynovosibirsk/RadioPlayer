package com.nazarov.radioPlayer.playlist;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;

public class GitCloner {

    public void clonePlaylists() {

        File file = new File("playlists/");
        try {
            Git git = Git.cloneRepository()
                    .setURI("https://github.com/nixoved/webRadioPlayerPlaylists")
                    .setDirectory(file)
                    .call();
        } catch (GitAPIException ge) {
            ge.printStackTrace();
        }
    }
}
