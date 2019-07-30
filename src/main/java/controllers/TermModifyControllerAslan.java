package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Semestr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TermModifyControllerAslan", urlPatterns = "/term_modifying")
public class TermModifyControllerAslan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTerm = req.getParameter("idModifyTerm");
        Semestr selectedTerm = DBManager.getSemestrByid(idTerm);
        req.setAttribute("selectedTerm", selectedTerm);
        ArrayList<Discipline> disciplines = DBManager.getAllActiveDisciplines();
        req.setAttribute("allDisciplines", disciplines);

        req.getRequestDispatcher("WEB-INF/JSP/modify_semestr_Aslan.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String modifiedDuration = req.getParameter("modifiedDuration");
        String[] modifiedDisciplinesId = req.getParameterValues("modifiedDisciplinesId");
        String id = req.getParameter("id");
        if (modifiedDuration.equals("")) {
            req.setAttribute("error", "1");
           List<Discipline> disciplines2 = DBManager.getAllActiveDisciplines();
            req.setAttribute("allDisciplines", disciplines2);
            req.getRequestDispatcher("WEB-INF/JSP/modify_semestr_Aslan.jsp").forward(req, resp);
        } else {
            DBManager.modifyTerm(id,modifiedDuration, modifiedDisciplinesId);
            resp.sendRedirect("/semestr");
        }
    }
}