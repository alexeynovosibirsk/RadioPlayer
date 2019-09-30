package com.nazarov.radioPlayer.osdependent;

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

        String debian = "amixer sset Master 5%" + sign;

        String ubuntu = "amixer -D pulse sset Master 5%" + sign;

        try {

            process = run.exec(debian);
            process = run.exec(ubuntu);
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
