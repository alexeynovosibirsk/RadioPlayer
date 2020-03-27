package com.nazarov.radioPlayer.updates;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

public class QueryParserInput extends HttpServlet {

    String queryVar;

    public String getQueryVar() {
        return queryVar;
    }

    public void inputQuery(HttpServletRequest request) {
       // Scanner input = new Scanner(System.in);
       // System.out.println("Add query:");
        String queryVar = request.getParameter("queryVar");
       // String queryVar  = input.nextLine();
        this.queryVar = queryVar;
        System.out.println(queryVar);
    }
    public void radiosureParsing() {
        RadioSureParser radioSureParser = new RadioSureParser();
        radioSureParser.setQueryVar(queryVar);
        radioSureParser.startRadioSureParser();
    }



//    public static void main(String[] args) {
//        QueryParserInput i = new QueryParserInput();
//        i.input();
//        System.out.println(i.getQueryVar());
//        RadioSureParser r = new RadioSureParser(i.getQueryVar());
//    }
}
