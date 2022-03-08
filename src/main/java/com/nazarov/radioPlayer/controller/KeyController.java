package com.nazarov.radioPlayer.controller;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import okhttp3.*;

import java.io.IOException;

public class KeyController implements NativeKeyListener {

    private WebController webController = new WebController();

    public void nativeKeyPressed(NativeKeyEvent e) {
//        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        boolean isAltPressed = (e.getModifiers() & NativeKeyEvent.ALT_MASK) != 0;

        if (e.getKeyCode() == NativeKeyEvent.VC_1 && isAltPressed) {
            webController.buttons("Mute");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_2 && isAltPressed) {
            webController.buttons("Next_Station");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_3 && isAltPressed) {
            webController.buttons("Previous_Station");
        }
        // Genres:
        if (e.getKeyCode() == NativeKeyEvent.VC_4 && isAltPressed) {
            postRequest("action=ambient");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_5 && isAltPressed) {
            postRequest("action=easy");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_6 && isAltPressed) {
            postRequest("action=synth");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_7 && isAltPressed) {
            postRequest("action=dance");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_8 && isAltPressed) {
            postRequest("action=jazz");
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_9 && isAltPressed) {
            postRequest("action=trance");
        }
    }

    public void postRequest(String genre) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, genre);
        Request request = new Request.Builder()
                .url("http://localhost:65534/")
                .method("POST", body)
                .addHeader("Connection", "keep-alive")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"98\", \"Google Chrome\";v=\"98\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("Origin", "http://localhost:65534")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-Mode", "navigate")
                .addHeader("Sec-Fetch-User", "?1")
                .addHeader("Sec-Fetch-Dest", "document")
                .addHeader("Referer", "http://localhost:65534/")
                .addHeader("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .addHeader("Cookie", "JSESSIONID=CE984CB434FBC41379105A2D4DBA0AC1; JSESSIONID=6B4665CD82506939A61D34CAF41D412F")
                .build();
        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
//        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
//        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

//    public static void main(String[] args) {
//        try {
//            GlobalScreen.registerNativeHook();
//        }
//        catch (NativeHookException ex) {
//            System.err.println("There was a problem registering the native hook.");
//            System.err.println(ex.getMessage());
//            System.exit(1);
//        }
//        GlobalScreen.addNativeKeyListener(new KeyController());
//    }
}
