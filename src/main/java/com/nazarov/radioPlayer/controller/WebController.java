package com.nazarov.radioPlayer.controller;

import com.nazarov.radioPlayer.RadioApplication;
import com.nazarov.radioPlayer.audio.LogoPlayer;
import com.nazarov.radioPlayer.audio.StationPlayer;
import com.nazarov.radioPlayer.osdependent.PowerOff;
import com.nazarov.radioPlayer.osdependent.VolumeControl;
import com.nazarov.radioPlayer.playlist.UrlMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServlet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController extends HttpServlet implements WebMvcConfigurer {
    final static Logger logger = LoggerFactory.getLogger(WebController.class);

//    VolumeControl volumeControl = new VolumeControl();
    StationPlayer stationPlayer = new StationPlayer();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView webRadioPlayer() {

        ModelAndView mav = new ModelAndView("webRadioPlayer");
        mav.addObject("url", UrlMaker.getUrlForJsp());
        mav.addObject("info", UrlMaker.getInfoForJsp());
        mav.addObject("stationName", UrlMaker.getStationNameForJsp());
        mav.addObject("genreOne", RadioApplication.getGenreOne());
        mav.addObject("genreTwo", RadioApplication.getGenreTwo());
        mav.addObject("genreThree", RadioApplication.getGenreThree());
        mav.addObject("genreFour", RadioApplication.getGenreFour());
        mav.addObject("genreFive", RadioApplication.getGenreFive());
        mav.addObject("genreSix", RadioApplication.getGenreSix());

        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView buttons(@RequestParam(value = "action", required = true) String action) {

        if (action.equals("Next_Station")) {
            stationPlayer.nextStation();
//        } else if (action.equals("Volume_up")) {
//            volumeControl.volumeUp();
//        } else if (action.equals("Volume_dn")) {
//            volumeControl.volumeDn();
        } else if (action.equals("Previous_Station")) {
            stationPlayer.previousStation();
        } else if (action.equals("Mute")) {
            stationPlayer.mute();
            logger.info("Player stoped");
//            if (!volumeControl.isMuted()) {
//                volumeControl.muteOn();
//            } else {
//                volumeControl.muteOff();
//            }
        } else {
            stationPlayer.setPlaylist(RadioApplication.getPlaylistDirPath() + action + RadioApplication.getPlaylistExtension());
            stationPlayer.playRadio();
            stationPlayer.setUnmute();
        }
        return webRadioPlayer();
    }

//    @RequestMapping(value = "/operations", method = RequestMethod.GET)
//    public ModelAndView operations() {
//
//        ModelAndView mav = new ModelAndView("operations");
//        return mav;
//    }

//    @RequestMapping(value = "/operations", method = RequestMethod.POST)
//    public ModelAndView shutdownButtons(@RequestParam(value = "action", required = true) String action) {
//
//        if (action.equals("Shutdown")) {
//            new LogoPlayer(4);
//            new PowerOff(0);
//            return bye();
//        }
//        if (action.equals("Sleep_Mode_30")) {
//            new LogoPlayer(3);
//            new PowerOff(30);
//        }
//        if (action.equals("Sleep_Mode_60")) {
//            new LogoPlayer(3);
//            new PowerOff(60);
//        }
//        return webRadioPlayer();
//    }

    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public ModelAndView bye() {

        ModelAndView mav = new ModelAndView("bye");
        return mav;
    }
}