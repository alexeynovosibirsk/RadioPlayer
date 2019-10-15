package com.nazarov.radioPlayer.controller;

import com.nazarov.radioPlayer.audio.StationSwitcher;
import com.nazarov.radioPlayer.osdependent.PowerOff;
import com.nazarov.radioPlayer.osdependent.VolumeControl;
import com.nazarov.radioPlayer.playlist.GitCloner;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServlet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController extends HttpServlet implements WebMvcConfigurer {

    StationSwitcher stationSwitcher = new StationSwitcher();
    VolumeControl volumeControl = new VolumeControl();
    PowerOff powerOff = new PowerOff();
    GitCloner gitCloner = new GitCloner();

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
            stationSwitcher.other();
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
        if (action.equals("Shutdown")) {
            powerOff.powerOff(0);
        }
        if (action.equals("Sleep_Mode_15")) {
            powerOff.powerOff(15);
        }

        return webRadioPlayer();
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public ModelAndView help() {
        ModelAndView mav = new ModelAndView("help");
        return mav;
    }

    @RequestMapping(value = "/help", method = RequestMethod.POST)
    public ModelAndView buttonsHelp(@RequestParam(value = "action", required = true) String action) {

        String confDirectory = "configfile";
        String githubUrl = "https://github.com/nixoved/RadioPlayerConfig";

        if (action.equals("Get_config")) {
            try {
                gitCloner.clonePlaylists(confDirectory, githubUrl);
            } catch (JGitInternalException j) {
                System.out.println("File already pulled");
                }
                    return err();
        }
        return help();
    }

    @RequestMapping(value = "/err", method = RequestMethod.GET)
    public ModelAndView err() {
        ModelAndView mav = new ModelAndView("err");
        return mav;
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public ModelAndView configFile() {
        ModelAndView mav = new ModelAndView("config");
        return mav;
    }


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getDownloadData() throws Exception {

        String regData = "string";
        byte[] output = regData.getBytes();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charset", "utf-8");
        responseHeaders.setContentType(MediaType.valueOf("text/html"));
        responseHeaders.setContentLength(output.length);
        responseHeaders.set("Content-disposition", "attachment; filename=filename.txt");

        return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
    }
}
