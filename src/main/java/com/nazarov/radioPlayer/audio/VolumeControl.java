package com.nazarov.radioPlayer.audio;

import java.io.IOException;

public class VolumeControl {

    public void volumeUp() {

        volLvl("+");
    }

    public void volumeDn() {

        volLvl("-");

    }

    private void volLvl(String sign) {

        Runtime run = Runtime.getRuntime();
        Process process = null;
        String cmd = "amixer -D pulse set Master 10%" + sign;

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
