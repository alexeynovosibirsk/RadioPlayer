package com.nazarov.radioPlayer.controller;

import java.io.IOException;

public class PowerControl {

    public void powerOff() {
        Runtime run = Runtime.getRuntime();
        Process p = null;
        String cmd = "shutdown -h now";
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
