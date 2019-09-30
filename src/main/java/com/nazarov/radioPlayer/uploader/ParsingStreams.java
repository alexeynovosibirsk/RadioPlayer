package com.nazarov.radioPlayer.uploader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.*;
import java.util.logging.SimpleFormatter;

public class ParsingStreams {

    public String httpRequest() {

            RestTemplate restTemplate = new RestTemplate();

            String randomuserUrl = "http://cosmicwaves.ru/radio-stations/";

            ResponseEntity<String> response = restTemplate.getForEntity(randomuserUrl, String.class);

          //  String resp = response.getBody().replaceAll("[\\[\\]\\{\\}\"]", "");
        String resp = response.getBody();

        try (
            Scanner scanner = new Scanner(resp)) {
                scanner.useDelimiter("");
                if (scanner.hasNext()) {
                String name = scanner.next();
                String value = scanner.next();
                    System.out.println("NAME: " + name + " VAL: " + value);
            }
        }



   //     System.out.println(resp);

            return resp;
    }

    public void jsoup() {

        Document doc;
        Elements list = null;

        try {
            doc = Jsoup.connect("http://cosmicwaves.ru/radio-stations/").get();
            list = doc.select("<i class=\\fa fa-play mi\\>");
            //title = doc.title();
        } catch (IOException e) {
            e.printStackTrace();
        }

   //     System.out.println(list);

    }

    public static void main(String[] args) {

        ParsingStreams p = new ParsingStreams();
        p.httpRequest();
      //  p.jsoup();
    }


}
