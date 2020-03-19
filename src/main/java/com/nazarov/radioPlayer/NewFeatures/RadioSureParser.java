package com.nazarov.radioPlayer.NewFeatures;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RadioSureParser {

    private Document doc;
    private String prefixUrl = "http://radiosure.com/rsdbms/";
    private String queryBody = "search.php?search=";
    private static String queryVar = "";
    private String queryMid = "&pos=";
    private String queryTail = "&reset_pos=0&status=active#info";
    private List<String> list = new ArrayList<>();
    private List<String> stationsStreams = new ArrayList<>();
    private FileWriter fw;
    int mp3 = 0;
    int aac = 0;
    int m3u = 0;
    int pls = 0;
    int good = 0;
    int allLinksStream = 0;
    int allLinks = 0;

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
        int pageMaximum = pageMaxRaw * 20 - 20;

        System.out.println("pageMax = " + pageMaximum);

        return pageMaximum;
    }

    public void getLinksFromQuery(int pageMaximum) {

        for(int pgNum = 10; pgNum < pageMaximum; pgNum += 10) {

            String url = prefixUrl + queryBody + queryVar + queryMid + pgNum + queryTail;
            try {
                doc = Jsoup.connect(url)
                        .get();

            } catch (IOException e) {
                e.printStackTrace();
            }
            // Get urls from page:
            Elements tbody = doc.select("tbody");
            Elements links = tbody.select("a[href]");

            for (Element a : links) {
                String s = a.attr("href");
                String fullUrl = prefixUrl + s;
                list.add(fullUrl);
            }

//            for (String s : list) {
//                System.out.println(s);
//            }
        }
        for (String s : list)  {
            getStationStream(s);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            allLinks++;
        }
        System.out.println("All links = " + allLinks);
    }

    public void getStationStream(String url) {

        try {
            doc = Jsoup.connect(url)
                    .get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements urlsFromPage = doc.select("a[href]");
        Element stationStream = urlsFromPage.get(1);
        String stationStreamToString = stationStream.text();
        stationsStreams.add(stationStreamToString);

    }

    public void writeToFile() {

        //Just statistic:
        for(String a : stationsStreams) {
            allLinksStream++;
        }


        try {
            fw = new FileWriter(queryVar + ".txt");
            for(String s : stationsStreams)

                if (s.endsWith("mp3")) { mp3++;}

                else if (s.endsWith("aac")) { aac++;}
                else if (s.endsWith("m3u")) { m3u++;}
                else if (s.endsWith("pls")) { pls++;}
                else { good++;

                    fw.write(s + "\n");}

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("MP3 " + mp3);
        System.out.println("AAC " + aac);
        System.out.println("M3U " + m3u);
        System.out.println("PLS " + pls);
        System.out.println("Write " + good);
        System.out.println("All links = " + allLinksStream);
    }

    public static void main(String[] args) {
        RadioSureParser r = new RadioSureParser();

        Scanner input = new Scanner(System.in);

        System.out.println("Add query:");
        queryVar  = input.nextLine();

        r.getLinksFromQuery(r.pageMax());
        r.writeToFile();


    }


}
