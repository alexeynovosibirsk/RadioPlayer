package com.nazarov.radioPlayer.audio;

import java.io.IOException;

public class VolumeControl {

    public void volUp() {
        Runtime run = Runtime.getRuntime();
        Process p = null;
        String cmd = "amixer -D pulse set Master 10%+";
        try {
            p = run.exec(cmd);
            p.getErrorStream();
            p.waitFor();


        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR.RUNNING.CMD");

        } finally {
            p.destroy();
        }
    }
    public void volDown() {
        Runtime run = Runtime.getRuntime();
        Process p = null;
        String cmd = "amixer -D pulse set Master 10%-";
        try {
            p = run.exec(cmd);
            p.getErrorStream();
            p.waitFor();


        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR.RUNNING.CMD");

        } finally {
            p.destroy();
        }
    }
}
