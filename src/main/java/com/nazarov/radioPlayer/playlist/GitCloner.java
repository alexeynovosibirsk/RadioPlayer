package com.nazarov.radioPlayer.playlist;

import com.nazarov.radioPlayer.RadioApplication;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.*;


import java.io.File;
import java.io.IOException;

@Slf4j
@Getter
public class GitCloner {

    private boolean playlistsCloned = false;
    private File configDirectory = new File(RadioApplication.playlistDirectory);
    private Git result = null;

    private static GitCloner _instance = null;

    public GitCloner() {}

    public static GitCloner getInstance() {
        if(_instance == null) {
            _instance = new GitCloner();
        }
        return _instance;
    }

    public void updatePlaylists() {

           try (Git git = new Git(result.getRepository())) {

            git.pull()
                    .call();
        } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }

    public boolean go() {
        // cloning the playlists from github
        try {
            if(configDirectory.exists()) {
                FileUtils.deleteDirectory(configDirectory);
            }
            result = Git.cloneRepository()
                    .setURI(RadioApplication.githubUrl)
                    .setDirectory(configDirectory)
                    .call();

            playlistsCloned = true;

        } catch (GitAPIException e) {
            log.error("No connection to github!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playlistsCloned;
    }
}