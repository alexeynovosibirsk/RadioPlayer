package com.nazarov.radioPlayer.controller;

import com.nazarov.radioPlayer.audio.LogoPlayer;
import com.nazarov.radioPlayer.audio.StationSwitcher;
import com.nazarov.radioPlayer.osdependent.PowerOff;
import com.nazarov.radioPlayer.osdependent.VolumeControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServlet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController extends HttpServlet implements WebMvcConfigurer {

    VolumeControl volumeControl = new VolumeControl();


    @Autowired
    private StationSwitcher stationSwitcher;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView webRadioPlayer() {
        ModelAndView mav = new ModelAndView("webRadioPlayer");
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView buttons(@RequestParam(value = "action", required = true) String action) {

        if (action.equals("Ambient")) {
            stationSwitcher.ambient();
        }
        if (action.equals("Jazz")) {
            stationSwitcher.jazz();
        }
        if (action.equals("Trance")) {
            stationSwitcher.trance();
        }
        if (action.equals("Retro")) {
            stationSwitcher.retro();
        }
        if (action.equals("Variable")) {
            stationSwitcher.variable();
        }
        if (action.equals("Dance")) {
            stationSwitcher.dance();
        }
        if (action.equals("Next_Station")) {
            stationSwitcher.nextStation();
        }
        if (action.equals("Volume_up")) {
            volumeControl.volumeUp();
        }
        if (action.equals("Volume_dn")) {
            volumeControl.volumeDn();
        }
        if (action.equals("Mute")) {
            stationSwitcher.stopRadio();
        }
        return webRadioPlayer();
    }

    @RequestMapping(value = "/shutdown", method = RequestMethod.GET)
    public ModelAndView shutdown() {
        ModelAndView mav = new ModelAndView("shutdown");
        return mav;
    }

    @RequestMapping(value = "/shutdown", method = RequestMethod.POST)
    public ModelAndView shutdownButtons(@RequestParam(value = "action", required = true) String action) {
        if (action.equals("Shutdown")) {
            new LogoPlayer(8);
            new PowerOff(0);
        }
        if (action.equals("Sleep_Mode_30")) {
            new LogoPlayer(7);
            new PowerOff(30);
        }
        if (action.equals("Sleep_Mode_60")) {
            new LogoPlayer(7);
            new PowerOff(60);
        }
        return webRadioPlayer();
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public ModelAndView configFile() {
        ModelAndView mav = new ModelAndView("config");
        return mav;
    }
}