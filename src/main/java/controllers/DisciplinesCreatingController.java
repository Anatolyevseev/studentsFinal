package controllers;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="DisciplinesCreatingController", urlPatterns = "/disciplines_creating")
public class DisciplinesCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/JSP/Disciplines_creating.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameDI = req.getParameter("name");
        if (nameDI.equals("")) {
            req.setAttribute("error","3");
            req.getRequestDispatcher("WEB-INF/JSP/Disciplines_creating.jsp").forward(req,resp);
        }

        DBManager.createDiscipline(nameDI);
        resp.sendRedirect("/disciplines");
    }
}
