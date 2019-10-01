package com.nazarov.radioPlayer.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileConfigReader {

    private static File configFile = new File("configfile/config.txt");
    private List<String> listString = new ArrayList<>();
    private List<Integer> keyCode = new ArrayList<>();
    private Map<String, Integer> mapKey = new HashMap<>();

    public Integer getKeyCode(int i) {

        System.out.println(keyCode.get(i));

        return keyCode.get(i);
    }

    public void mapperKeys() {

        settingFiller();
        fillKeyCode();

        for (String s : listString) {

            for (Map.Entry<String, Integer> entry : mapKey.entrySet()) {

                String s1 = entry.getKey();

                if (s.equals(s1)) {

                    keyCode.add(entry.getValue());
                }
            }
        }
    }

    public void settingFiller() {

        try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
            String line = "";
            String prefix = "VCC_";

            while ((line = br.readLine()) != null) {

                String next = line.split(" ")[0];

                if(next.equals("#")) continue;

              //  if (next.isEmpty()) break;

                listString.add(prefix + next);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillKeyCode() {

        mapKey.put("VCC_ESCAPE", 1);
        mapKey.put("VCC_F1", 59);
        mapKey.put("VCC_F2", 60);
        mapKey.put("VCC_F3", 61);
        mapKey.put("VCC_F4", 62);
        mapKey.put("VCC_F5", 63);
        mapKey.put("VCC_F6", 64);
        mapKey.put("VCC_F7", 65);
        mapKey.put("VCC_F8", 66);
        mapKey.put("VCC_F9", 67);
        mapKey.put("VCC_F10", 68);
        mapKey.put("VCC_F11", 87);
        mapKey.put("VCC_F12", 88);
        mapKey.put("VCC_F13", 91);
        mapKey.put("VCC_F14", 92);
        mapKey.put("VCC_F15", 93);
        mapKey.put("VCC_F16", 99);
        mapKey.put("VCC_F17", 100);
        mapKey.put("VCC_F18", 101);
        mapKey.put("VCC_F19", 102);
        mapKey.put("VCC_F20", 103);
        mapKey.put("VCC_F21", 104);
        mapKey.put("VCC_F22", 105);
        mapKey.put("VCC_F23", 106);
        mapKey.put("VCC_F24", 107);
        mapKey.put("VCC_BACKQUOTE", 41);
        mapKey.put("VCC_1", 2);
        mapKey.put("VCC_2", 3);
        mapKey.put("VCC_3", 4);
        mapKey.put("VCC_4", 5);
        mapKey.put("VCC_5", 6);
        mapKey.put("VCC_6", 7);
        mapKey.put("VCC_7", 8);
        mapKey.put("VCC_8", 9);
        mapKey.put("VCC_9", 10);
        mapKey.put("VCC_0", 11);
        mapKey.put("VCC_MINUS", 12);
        mapKey.put("VCC_EQUALS", 13);
        mapKey.put("VCC_BACKSPACE", 14);
        mapKey.put("VCC_TAB", 15);
        mapKey.put("VCC_CAPS_LOCK", 58);
        mapKey.put("VCC_A", 30);
        mapKey.put("VCC_B", 48);
        mapKey.put("VCC_C", 46);
        mapKey.put("VCC_D", 32);
        mapKey.put("VCC_E", 18);
        mapKey.put("VCC_F", 33);
        mapKey.put("VCC_G", 34);
        mapKey.put("VCC_H", 35);
        mapKey.put("VCC_I", 23);
        mapKey.put("VCC_J", 36);
        mapKey.put("VCC_K", 37);
        mapKey.put("VCC_L", 38);
        mapKey.put("VCC_M", 50);
        mapKey.put("VCC_N", 49);
        mapKey.put("VCC_O", 24);
        mapKey.put("VCC_P", 25);
        mapKey.put("VCC_Q", 16);
        mapKey.put("VCC_R", 19);
        mapKey.put("VCC_S", 31);
        mapKey.put("VCC_T", 20);
        mapKey.put("VCC_U", 22);
        mapKey.put("VCC_V", 47);
        mapKey.put("VCC_W", 17);
        mapKey.put("VCC_X", 45);
        mapKey.put("VCC_Y", 21);
        mapKey.put("VCC_Z", 44);
        mapKey.put("VCC_OPEN_BRACKET", 26);
        mapKey.put("VCC_CLOSE_BRACKET", 27);
        mapKey.put("VCC_BACK_SLASH", 43);
        mapKey.put("VCC_SEMICOLON", 39);
        mapKey.put("VCC_QUOTE", 40);
        mapKey.put("VCC_ENTER", 28);
        mapKey.put("VCC_COMMA", 51);
        mapKey.put("VCC_PERIOD", 52);
        mapKey.put("VCC_SLASH", 53);
        mapKey.put("VCC_SPACE", 57);
        mapKey.put("VCC_PRINTSCREEN", 3639);
        mapKey.put("VCC_SCROLL_LOCK", 70);
        mapKey.put("VCC_PAUSE", 3653);
        mapKey.put("VCC_INSERT", 3666);
        mapKey.put("VCC_DELETE", 3667);
        mapKey.put("VCC_HOME", 3655);
        mapKey.put("VCC_END", 3663);
        mapKey.put("VCC_PAGE_UP", 3657);
        mapKey.put("VCC_PAGE_DOWN", 3665);
        mapKey.put("VCC_UP", 57416);
        mapKey.put("VCC_LEFT", 57419);
        mapKey.put("VCC_CLEAR", 57420);
        mapKey.put("VCC_RIGHT", 57421);
        mapKey.put("VCC_DOWN", 57424);
        mapKey.put("VCC_NUM_LOCK", 69);
        mapKey.put("VCC_SEPARATOR", 83);
        mapKey.put("VCC_SHIFT", 42);
        mapKey.put("VCC_CONTROL", 29);
        mapKey.put("VCC_ALT", 56);
        mapKey.put("VCC_META", 3675);
        mapKey.put("VCC_CONTEXT_MENU", 3677);
        mapKey.put("VCC_POWER", 57438);
        mapKey.put("VCC_SLEEP", 57439);
        mapKey.put("VCC_WAKE", 57443);
        mapKey.put("VCC_MEDIA_PLAY", 57378);
        mapKey.put("VCC_MEDIA_STOP", 57380);
        mapKey.put("VCC_MEDIA_PREVIOUS", 57360);
        mapKey.put("VCC_MEDIA_NEXT", 57369);
        mapKey.put("VCC_MEDIA_SELECT", 57453);
        mapKey.put("VCC_MEDIA_EJECT", 57388);
        mapKey.put("VCC_VOLUME_MUTE", 57376);
        mapKey.put("VCC_VOLUME_UP", 57392);
        mapKey.put("VCC_VOLUME_DOWN", 57390);
        mapKey.put("VCC_APP_MAIL", 57452);
        mapKey.put("VCC_APP_CALCULATOR", 57377);
        mapKey.put("VCC_APP_MUSIC", 57404);
        mapKey.put("VCC_APP_PICTURES", 57444);
        mapKey.put("VCC_BROWSER_SEARCH", 57445);
        mapKey.put("VCC_BROWSER_HOME", 57394);
        mapKey.put("VCC_BROWSER_BACK", 57450);
        mapKey.put("VCC_BROWSER_FORWARD", 57449);
        mapKey.put("VCC_BROWSER_STOP", 57448);
        mapKey.put("VCC_BROWSER_REFRESH", 57447);
        mapKey.put("VCC_BROWSER_FAVORITES", 57446);
        mapKey.put("VCC_KATAKANA", 112);
        mapKey.put("VCC_UNDERSCORE", 115);
        mapKey.put("VCC_FURIGANA", 119);
        mapKey.put("VCC_KANJI", 121);
        mapKey.put("VCC_HIRAGANA", 123);
        mapKey.put("VCC_YEN", 125);
        mapKey.put("VCC_SUN_HELP", 65397);
        mapKey.put("VCC_SUN_STOP", 65400);
        mapKey.put("VCC_SUN_PROPS", 65398);
        mapKey.put("VCC_SUN_FRONT", 65399);
        mapKey.put("VCC_SUN_OPEN", 65396);
        mapKey.put("VCC_SUN_FIND", 65406);
        mapKey.put("VCC_SUN_AGAIN", 65401);
        mapKey.put("VCC_SUN_UNDO", 65402);
        mapKey.put("VCC_SUN_COPY", 65404);
        mapKey.put("VCC_SUN_INSERT", 65405);
        mapKey.put("VCC_SUN_CUT", 65403);
        mapKey.put("VCC_UNDEFINED", 0);
    }
}

