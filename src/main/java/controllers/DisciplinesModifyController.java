package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "DisciplinesModifyController",urlPatterns = "/discipline_modify")
public class DisciplinesModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idDisc = req.getParameter("modifydisc");
        req.setAttribute("idDisc", idDisc);
        ArrayList<Discipline> disciplines = DBManager.getAllActiveDisciplines();
        for (Discipline id : disciplines) {
            if (id.getId() == Integer.parseInt(idDisc)) {
                req.setAttribute("selectedDiscipline", id);
            }
        }
        req.getRequestDispatcher("WEB-INF/JSP/Discipline_modifying.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String modifiedDiscipline = req.getParameter("modifiedDiscipline");
        if (modifiedDiscipline.equals("")) {
            req.setAttribute("error", "2");
            req.getRequestDispatcher("WEB-INF/JSP/Discipline_modifying.jsp").forward(req, resp);
        } else {
            DBManager.modifyDiscipline(id, modifiedDiscipline);
            resp.sendRedirect("/disciplines");
        }
    }
}
