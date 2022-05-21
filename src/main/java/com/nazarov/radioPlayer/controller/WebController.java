package com.nazarov.radioPlayer.controller;

import com.nazarov.radioPlayer.RadioApplication;
import com.nazarov.radioPlayer.audio.LogoPlayer;
import com.nazarov.radioPlayer.audio.StationPlayer;
import com.nazarov.radioPlayer.osdependent.PowerOff;
import com.nazarov.radioPlayer.osdependent.Shutdown;
import com.nazarov.radioPlayer.playlist.GitCloner;
import com.nazarov.radioPlayer.playlist.UrlMaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component; // do not delete!
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServlet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class WebController extends HttpServlet implements WebMvcConfigurer {

    StationPlayer stationPlayer = StationPlayer.getInstance();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView webRadioPlayer() {

        ModelAndView mav = new ModelAndView("webRadioPlayer");
        mav.addObject("version", "v 1.9");
        mav.addObject("url", UrlMaker.getUrlForJsp());
        mav.addObject("info", UrlMaker.getInfoForJsp());
        mav.addObject("stationName", UrlMaker.getStationNameForJsp());
        mav.addObject("genreOne", RadioApplication.genreOne);
        mav.addObject("genreTwo", RadioApplication.genreTwo);
        mav.addObject("genreThree", RadioApplication.genreThree);
        mav.addObject("genreFour", RadioApplication.genreFour);
        mav.addObject("genreFive", RadioApplication.genreFive);
        mav.addObject("genreSix", RadioApplication.genreSix);

        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView buttons(@RequestParam(value = "action", required = true) String action) {

        if (action.equals("Next_Station")) {
            stationPlayer.nextStation();

        } else if (action.equals("Previous_Station")) {
            stationPlayer.previousStation();

        } else if (action.equals("Mute")) {
            stationPlayer.mute();
            log.info("Player stoped");

        } else if (action.equals("Update_lists")) {
            GitCloner.getInstance().updatePlaylists();
            RadioApplication.readConfigs();
            new LogoPlayer(8);

        } else if (action.equals("Shutdown")) {
            stationPlayer.mute();
            new Shutdown();
            return bye();

        } else if (action.equals("Poweroff")) {
            new PowerOff(0);

        } else {
            stationPlayer.setPlaylist(RadioApplication.playlistDirPath + action + RadioApplication.playlistExtension);
            stationPlayer.playRadio();
            stationPlayer.setIsMuted(false);
        }

        return webRadioPlayer();
    }

    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public ModelAndView bye() {
        ModelAndView mav = new ModelAndView("bye");
        return mav;
    }
}