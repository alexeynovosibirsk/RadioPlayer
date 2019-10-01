package com.nazarov.radioPlayer;

import java.net.MalformedURLException;
import java.net.URL;

public class TestParse  {



    public void parseFileExtension() throws MalformedURLException {
        URL url = new URL("http://us2.internet-radio.com:8443/stream");
        String filename = url.toString();
        if (filename.endsWith(".mp3")) {
            System.out.println("aaa");
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        TestParse t = new TestParse();
        t.parseFileExtension();
    }
}
