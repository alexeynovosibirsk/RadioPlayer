package com.nazarov.radioPlayer.controller;

import com.nazarov.radioPlayer.audio.StationSwitcher;
import com.nazarov.radioPlayer.osdependent.PowerOff;
import com.nazarov.radioPlayer.osdependent.VolumeControl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping(path="/")
public class WebController extends HttpServlet implements WebMvcConfigurer {


    @RequestMapping(method = RequestMethod.GET)
    public String viewMain(ModelMap model) {
        //  model.addAttribute("hello", "IHHAA!");
        return "index";
    }

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public ModelAndView appSettings() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }


    @RequestMapping("/banner")
    public void bannerJpg(HttpServletRequest request,
                          HttpServletResponse response
    ) {
        String fileName = "banner.jpg";
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/static/");
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) {
            response.setContentType("image/jpg");
        }
        try {
            Files.copy(file, response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping("/css")
    public void background(HttpServletRequest request,
                          HttpServletResponse response
    ) {
        String fileName = "buttons.css";
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/static/");
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) {
            response.setContentType("text/css");
        }
        try {
            Files.copy(file, response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @RequestMapping("/bgr_blue")
    public void background1(HttpServletRequest request,
                           HttpServletResponse response
    ) {
        String fileName = "bgr_blue.jpg";
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/static/images/");
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) {
            response.setContentType("image/jpg");
        }
        try {
            Files.copy(file, response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @RequestMapping("/bgr_blue1")
    public void background2(HttpServletRequest request,
                            HttpServletResponse response
    ) {
        String fileName = "bgr_blue1.jpg";
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/static/images/");
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) {
            response.setContentType("image/jpg");
        }
        try {
            Files.copy(file, response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @RequestMapping("/bgr_metall.jpg")
    public void background3(HttpServletRequest request,
                            HttpServletResponse response
    ) {
        String fileName = "bgr_metall.jpg";
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/static/images/");
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) {
            response.setContentType("image/jpg");
        }
        try {
            Files.copy(file, response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @RequestMapping("/ambient")
    public void logoAmbient(HttpServletRequest request,
                            HttpServletResponse response
    ) throws ServletException, IOException {
        String fileName = "ambient.mp3";
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/sounds/");
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) {
            response.setContentType("audio/mpeg");
            //  response.addHeader("Content-Disposition", "attachment; filename="+fileName);

            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public ModelAndView handleRequest(HttpServletRequest request,
//                                      HttpServletResponse response) throws Exception {
//        ModelAndView mav = new ModelAndView("user");
//        return mav;
//    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView showEmployeeForm() {

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("index");


        return mv;
    }
    StationSwitcher stationSwitcher = new StationSwitcher();
    VolumeControl volumeControl = new VolumeControl();
    PowerOff powerOff = new PowerOff();

    @RequestMapping(value = "/webRadioPlayer", method = RequestMethod.GET)
    public ModelAndView webRadioPlayer()  {
        ModelAndView mav = new ModelAndView("webRadioPlayer");
        //stationSwitcher.ambient();
        return mav;
    }

    @RequestMapping(value = "/webRadioPlayer", method = RequestMethod.POST)

    public ModelAndView buttons(@RequestParam(value = "action", required = true) String action){

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
           powerOff.powerOff();
        }
        return webRadioPlayer();
    }
}











