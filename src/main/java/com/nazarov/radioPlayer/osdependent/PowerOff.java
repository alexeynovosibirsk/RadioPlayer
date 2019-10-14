package com.nazarov.radioPlayer.osdependent;

import java.io.IOException;

public class PowerOff {

    public void powerOff(int time) {

        Runtime run = Runtime.getRuntime();
        Process process = null;
        String cmd = "shutdown " + time;

        try {

            process = run.exec(cmd);
            process.getErrorStream();
            process.waitFor();

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Bash command ERROR");

        } finally {
            process.destroy();
        }
    }

}
