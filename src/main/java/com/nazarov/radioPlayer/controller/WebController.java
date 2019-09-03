package com.nazarov.radioPlayer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(path="/logo")
public class WebController implements WebMvcConfigurer {

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

    @RequestMapping("/jazz")
    public void logoJazz(HttpServletRequest request,
                         HttpServletResponse response
    ) throws ServletException, IOException {
        String fileName = "jazz.mp3";
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

    @RequestMapping("/trance")
    public void logoTrance(HttpServletRequest request,
                           HttpServletResponse response
    ) throws ServletException, IOException {
        String fileName = "trance.mp3";
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

    @RequestMapping("/rock")
    public void logoRock(HttpServletRequest request,
                         HttpServletResponse response
    ) throws ServletException, IOException {
        String fileName = "retro.mp3";
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

    @RequestMapping("/other")
    public void logoOther(HttpServletRequest request,
                          HttpServletResponse response
    ) throws ServletException, IOException {
        String fileName = "other.mp3";
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

    @RequestMapping("/hello")
    public void logoHello(HttpServletRequest request,
                          HttpServletResponse response
    ) throws ServletException, IOException {
        String fileName = "hello.mp3";
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
}












