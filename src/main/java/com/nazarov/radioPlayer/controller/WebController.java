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


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("user");




        return mav;
    }


//    @PostMapping("/user")
//    public String saveJob(@RequestParam(value = "accept") Boolean accept) {
//        StationSwitcher stationSwitcher = new StationSwitcher();
//
//        if (accept) {
//            //   myClass.method1();
//            stationSwitcher.jazz();
//        }
//        return "haha";
//    }

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public String handlePost(@RequestParam String action) {
//        StationSwitcher stationSwitcher = new StationSwitcher();
//        if (action.equals("save")) {
//           stationSwitcher.jazz();
//
//        }
//        return "user";
//    }





//    @Override
//    @RequestMapping(value = "/user")
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        StationSwitcher stationSwitcher = new StationSwitcher();
//
//        if (request.getParameter("button1") != null) {
//         //   myClass.method1();
//            stationSwitcher.jazz();
//        } else if (request.getParameter("button2") != null) {
//        //    myClass.method2();
//        } else if (request.getParameter("button3") != null) {
//        //    myClass.method3();
//        } else {
//            // ???
//        }
//
//        request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
//    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView showEmployeeForm() {

        // Add the command object to the modelview
        ModelAndView mv = new ModelAndView("employee");
       // mv.addObject("employee");

//        // Add the payments modes to model for <form:radiotbuttons>
//        mv.addObject("paymentModes", paymentModes);

        return mv;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String submitForm(Model model) {

  //      model.addAttribute("employee");
        return "success";

    }

}











