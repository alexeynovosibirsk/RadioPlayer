package com.nazarov.radioPlayer.updates;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadioSureParser {

    private Document doc;
    private String source = "_RadioSure";
    private String prefixUrl = "http://radiosure.com/rsdbms/";
    private String queryBody = "search.php?search=";
    private static String queryVar = "";
    private String queryMid = "&pos=";
    private String queryTail = "&reset_pos=0&status=active#info";
    private File outputDir = new File("NewPlaylist");
    private List<String> list = new ArrayList<>();
    private List<String> stationsStreams = new ArrayList<>();
    private FileWriter fw;
    private int countPage = 0;
    private int mp3Counter = 0;
    private int aacCounter = 0;
    private int m3uCounter = 0;
    private int m3u8Counter = 0;
    private int plsCounter = 0;
    private int asxCounter = 0;
    private int phpCounter = 0;
    private int goodCounter = 0;
    private int allLinksStreamCounter = 0;
    private int allLinksCounter = 0;

    public void setQueryVar(String queryVar) {

    }

    public String getQueryVar() {
        return queryVar;
    }

    public void startRadioSureParser() {

        getLinksFromQuery(pageMax());
        writeToFile();
    }

    public int pageMax() {

        String urlInitial = prefixUrl + queryBody + queryVar + queryMid + 0 + queryTail;
        try {
            doc = Jsoup.connect(urlInitial).get();
        } catch (IOException e) {
            System.out.println("Initial exception: ");
            e.printStackTrace();
        }
        // Get number of pages:
        Elements pageNumbers = doc.select("p.style3");
        String pageNumber = pageNumbers.text().split(" ")[3];
        int pageMaxRaw = Integer.parseInt(pageNumber);
        int pageMaximum;
        if(pageMaxRaw > 2) {
            pageMaximum = pageMaxRaw * 20 - 20;
        } else {
            pageMaximum = pageMaxRaw * 10;
        }
        return pageMaximum;
    }
    public void getLinksFromQuery(int pageMaximum) {

            for (int pgNum = 0; pgNum <= pageMaximum; pgNum += 20) {

                String url = prefixUrl + queryBody + queryVar + queryMid + pgNum + queryTail;
                try {
                    doc = Jsoup.connect(url).get();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Get urls from page:
                Elements tbody = doc.select("tbody");
                Elements links = tbody.select("a[href]");

                countPage++;
                System.out.println("Processing page number: " + countPage);

                for (Element a : links) {
                    String s = a.attr("href");
                    String fullUrl = prefixUrl + s;
                    list.add(fullUrl);
                }
            }
        for (String s : list)  {
            getStationStream(s);
              allLinksCounter++;
        }
        System.out.println("-----------------");
        System.out.println("All links4processing: " + allLinksCounter);
    }
    public void getStationStream(String url) {
        try {
            doc = Jsoup.connect(url).get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements urlsFromPage = doc.select("a[href]");
        Element stationStream = urlsFromPage.get(1);
        String stationStreamToString = stationStream.text();
        stationsStreams.add(stationStreamToString);

    }


    public void writeToFile() {
        String fullFileName = queryVar + source + ".txt";
        //Just statistic:
        for(String a : stationsStreams) {
            allLinksStreamCounter++;
        }
        try {
            if(!outputDir.exists()) {
                outputDir.mkdir();
            } else {
                fw = new FileWriter(outputDir + "/" + fullFileName);
                for (String s : stationsStreams)

                    if (s.endsWith("mp3")) {
                        mp3Counter++;
                    } else if (s.endsWith("aac")) {
                        aacCounter++;
                    } else if (s.endsWith("m3u")) {
                        m3uCounter++;
                    } else if (s.endsWith("m3u8")) {
                        m3u8Counter++;
                    } else if (s.endsWith("pls")) {
                        plsCounter++;
                    } else if (s.endsWith("asx")) {
                        asxCounter++;
                    } else if (s.contains(".php")) {
                        phpCounter++;
                    } else {
                        goodCounter++;

                        fw.write(s + "\n");
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total processed links: " + allLinksStreamCounter);
        System.out.println("MP3 " + mp3Counter);
        System.out.println("AAC " + aacCounter);
        System.out.println("M3U " + m3uCounter);
        System.out.println("PLS " + plsCounter);
        System.out.println("M38U " + m3u8Counter);
        System.out.println("ASX " + asxCounter);
        System.out.println("PHP " + phpCounter);
        System.out.println("---------------------");
        System.out.println("Write to file = " + goodCounter);
    }
//    public static void main(String[] args) {
//        RadioSureParser r = new RadioSureParser();
//        Scanner input = new Scanner(System.in);
//        System.out.println("Add query:");
//        queryVar  = input.nextLine();
//        r.getLinksFromQuery(r.pageMax());
//        r.writeToFile();
//
//
//        MailSender mailSender = new MailSender();
//        mailSender.sendEmail("RadioSurePlaylist", r.outputDir + "/" + queryVar + r.source + ".txt");
//
//    }
}
