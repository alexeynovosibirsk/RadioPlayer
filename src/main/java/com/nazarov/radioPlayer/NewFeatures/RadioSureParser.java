package com.nazarov.radioPlayer.NewFeatures;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    int mp3Counter = 0;
    int aacCounter = 0;
    int m3uCounter = 0;
    int plsCounter = 0;
    int goodCounter = 0;
    int allLinksStreamCounter = 0;
    int allLinksCounter = 0;

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
        }
        for (String s : list)  {
            getStationStream(s);
              allLinksCounter++;
        }
        System.out.println("All links = " + allLinksCounter);
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
            allLinksStreamCounter++;
        }

        try {
            Path outputDir = Files.createDirectory(Paths.get("NewPlaylists"));


            fw = new FileWriter( outputDir + "/" +queryVar + ".txt");
            for(String s : stationsStreams)

                if (s.endsWith("mp3")) { mp3Counter++;}

                else if (s.endsWith("aac")) { aacCounter++;}
                else if (s.endsWith("m3u")) { m3uCounter++;}
                else if (s.endsWith("pls")) { plsCounter++;}
                else { goodCounter++;

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
        System.out.println("MP3 " + mp3Counter);
        System.out.println("AAC " + aacCounter);
        System.out.println("M3U " + m3uCounter);
        System.out.println("PLS " + plsCounter);
        System.out.println("Write " + goodCounter);
        System.out.println("All stream links = " + allLinksStreamCounter);
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
