package com.project.web.servlet;

import com.project.web.connection.DBConnection;
import com.project.web.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//сервлет це спеціальний клас котрий опрацьовує запити зі сторони клієнта та відправляє йому відповідь, сервлети потрібно описувати в web.xml інакше вони не будуть працювати
@WebServlet(name = "SaveServlet")
public class SaveServlet extends HttpServlet {

    //всього є 7 методів, та використовуюються найчастіше оці два

    //do post  використувоється для відправлення інформаціїї (на сервер?), do get для цього не підходить
    //параматери, відправлені вами в адресні строці не будудть відображатися
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //ми підтягуємо (реєструємо?) драйвер для підключення до нашої БД, для різних БД драйвер буде інший
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        User user = new User();
        //метод getParameter використовується для отримання значення введеного користувачем з форми (form) на сторонці JSP
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setAge(Integer.parseInt(request.getParameter("age")));

        DBConnection connection = new DBConnection();
        connection.save(user);

        //переадресовуємо клвєнта на відповідну сторінку
        response.sendRedirect("pages/index.jsp");

    }
    // do get підходить для отримання інформаціїї, на приклад вибір товару в магазині, адже в адресні стороці будуть відображатися пармаетри котрі ви відправили,
    // такий метод не підходить для відправлення паролю на сервер і т.п., адже тоді його буде видно в адресні строці.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
