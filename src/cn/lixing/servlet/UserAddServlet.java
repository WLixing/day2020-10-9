package cn.lixing.servlet;

import cn.lixing.entity.User;
import cn.lixing.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        UserServiceImpl usi = new UserServiceImpl();
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String bornDate = request.getParameter("bornDate");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(bornDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setUsername(username);
        user.setPassword(password);
        user.setSex(sex);
        user.setBornDate(date);
        int i = usi.addUserInfo(user);
        System.out.println(i);
        if (i>0){
            response.sendRedirect("list.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
