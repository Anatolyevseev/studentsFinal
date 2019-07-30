package controllers;

import database.DBManager;
import entity.Account;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController",urlPatterns = "/login")

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/JSP/logn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("pass");


        Account account = DBManager.getAccountBy(username,password);
        if (account == null){

            req.getRequestDispatcher("WEB-INF/JSP/logn.jsp").forward(req, resp);
        }else {
            req.getSession().setAttribute("isLogin",1);
            req.getSession().setAttribute("role",account.getRole());
            resp.sendRedirect("/");
        }


    }
}
