package com.nazarov.radioPlayer.playlist;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import java.io.File;
import java.io.IOException;

public class DeleteTemp {

    public void del(String fileName) {

        File file = new File(fileName);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
