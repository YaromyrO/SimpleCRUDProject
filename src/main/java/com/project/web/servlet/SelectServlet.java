package com.project.web.servlet;

import com.project.web.connection.DBConnection;
import com.project.web.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectServlet")
public class SelectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        DBConnection connection = new DBConnection();
        List<User> users = connection.select();
        //ми передаємо список юзерів в якості атрибуту клієнту
        request.setAttribute("users", users);
        //за допомогою цих методів ми відсилаємо інформацію на відповідну сторінку (адресу) для показу її клієнту
        request.getRequestDispatcher("pages/users.jsp").forward(request, response);

    }
}
