package com.dream.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.dream.service.*;

@WebServlet(value="/person_info")
public class ControlPersonInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var personInfo = new ServicePersonInfoImpl();
        var personList = personInfo.process();
        if (personList != null) {
            request.setAttribute("personList", personList);
        }
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
}