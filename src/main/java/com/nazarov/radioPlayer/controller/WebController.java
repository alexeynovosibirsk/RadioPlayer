package com.nazarov.radioPlayer.controller;

import com.nazarov.radioPlayer.RadioApplication;
import com.nazarov.radioPlayer.audio.LogoPlayer;
import com.nazarov.radioPlayer.audio.StationPlayer;
import com.nazarov.radioPlayer.config.ConfigReader;
import com.nazarov.radioPlayer.osdependent.PowerOff;
import com.nazarov.radioPlayer.osdependent.VolumeControl;
import com.nazarov.radioPlayer.playlist.UrlMaker;
import com.nazarov.radioPlayer.updates.QueryParserInput;
import com.nazarov.radioPlayer.updates.RadioSureParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServlet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Scanner;

@Controller
public class WebController extends HttpServlet implements WebMvcConfigurer {

    VolumeControl volumeControl = new VolumeControl();
    StationPlayer stationPlayer = new StationPlayer();
    QueryParserInput queryParserInput = new QueryParserInput();

    ConfigReader configReader = new ConfigReader();
    String genreOne = configReader.getGenreOne();
    String genreTwo = configReader.getGenreTwo();
    String genreThree = configReader.getGenreThree();
    String genreFour = configReader.getGenreFour();
    String genreFive = configReader.getGenreFive();
    String genreSix = configReader.getGenreSix();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView webRadioPlayer() {

        UrlMaker u = new UrlMaker();
        String url = u.getUrlForJsp();
        String info = u.getInfoForJsp();

        ModelAndView mav = new ModelAndView("webRadioPlayer");
        mav.addObject("url", url);
        mav.addObject("info", info);
        mav.addObject("genreOne", genreOne);
        mav.addObject("genreTwo", genreTwo);
        mav.addObject("genreThree", genreThree);
        mav.addObject("genreFour", genreFour);
        mav.addObject("genreFive", genreFive);
        mav.addObject("genreSix", genreSix);

        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView buttons(@RequestParam(value = "action", required = true) String action) {

        if (action.equals(genreOne)) {
                stationPlayer.setPlaylist(RadioApplication.getPlaylistDirPath() + action + RadioApplication.getPlaylistExtension());
                stationPlayer.playRadio();
       }
        if (action.equals(genreTwo)) {
            stationPlayer.setPlaylist(RadioApplication.getPlaylistDirPath() + action + RadioApplication.getPlaylistExtension());
            stationPlayer.playRadio();
        }
        if (action.equals(genreThree)) {
            stationPlayer.setPlaylist(RadioApplication.getPlaylistDirPath() + action + RadioApplication.getPlaylistExtension());
            stationPlayer.playRadio();
        }
        if (action.equals(genreFour)) {
            stationPlayer.setPlaylist(RadioApplication.getPlaylistDirPath() + action + RadioApplication.getPlaylistExtension());
            stationPlayer.playRadio();
        }
        if (action.equals(genreFive)) {
            stationPlayer.setPlaylist(RadioApplication.getPlaylistDirPath() + action + RadioApplication.getPlaylistExtension());
            stationPlayer.playRadio();
        }
        if (action.equals(genreSix)) {
            stationPlayer.setPlaylist(RadioApplication.getPlaylistDirPath() + action + RadioApplication.getPlaylistExtension());
            stationPlayer.playRadio();
        }
        if (action.equals("Next_Station")) {
            stationPlayer.nextStation();
        }
        if (action.equals("Volume_up")) {
            volumeControl.volumeUp();
        }
        if (action.equals("Volume_dn")) {
            volumeControl.volumeDn();
        }
        if (action.equals("Mute")) {
            stationPlayer.stopRadio();
        }
        return webRadioPlayer();
    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public ModelAndView operations() {

        ModelAndView mav = new ModelAndView("operations");

//        RadioSureParser radioSureParser = new RadioSureParser();
//        String queryVar = radioSureParser.getQueryVar();
//        mav.addObject(queryVar);
        return mav;
    }

    @RequestMapping(value = "/operations", method = RequestMethod.POST)
    public ModelAndView shutdownButtons(@RequestParam(value = "action", required = true) String action) {
        if (action.equals("RadioSure")) {
            QueryParserInput queryParserInput = new QueryParserInput();
           // queryParserInput.inputQuery(queryVar);
            queryParserInput.radiosureParsing();
            //queryParserInput.getQueryVar();



        }
        if (action.equals("Shutdown")) {
            new LogoPlayer(4);
            new PowerOff(0);
        }
        if (action.equals("Sleep_Mode_30")) {
            new LogoPlayer(3);
            new PowerOff(30);
        }
        if (action.equals("Sleep_Mode_60")) {
            new LogoPlayer(3);
            new PowerOff(60);
        }
        return webRadioPlayer();
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET)  // now using now but I have the plan)))
    public ModelAndView configFile() {
        ModelAndView mav = new ModelAndView("config");
        return mav;
    }

//    @RequestMapping(value = "/err", method = RequestMethod.GET)
//    public ModelAndView getdata() {
//
//        UrlMaker u = new UrlMaker();
//        URL url = u.getUrl();
//        ModelAndView mav = new ModelAndView("err");
//
//        mav.addObject("url", url);
//
//        return mav;
//    }
}