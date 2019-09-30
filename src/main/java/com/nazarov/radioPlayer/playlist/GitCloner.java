package com.nazarov.radioPlayer.playlist;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;

public class GitCloner {

    private File file;
    private String uri;

    public void setFile(String s) {

        File file = new File(s);
        this.file = file;
    }

    public void setUri(String uri) {

        this.uri = uri;
    }

    public void clonePlaylists() {

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
