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
import java.util.List;

@WebServlet(name = "SemestrModifyController", urlPatterns = "/semestr_modify")
public class SemestrModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTerm = req.getParameter("idModifyTerm");
        Semestr selectedSemestr = DBManager.getSemestrByid(idTerm);

        List<Discipline> disciplineList = DBManager.getAllActiveDisciplines();
        req.setAttribute("selectedSemestr", selectedSemestr);
        req.setAttribute("disciplineList", disciplineList);
        req.getRequestDispatcher("WEB-INF/JSP/modify_semestr.jsp").forward(req, resp);

    }
}

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String idSemestr = req.getParameter("id");
//        String [] modifiedDisciplinesID = req.getParameterValues("modifiedDurationID");
//        String modifiedDuration = req.getParameter("modifysemetr");
//        Semestr selectedSemestr = DBManager.modifySemestrByid(idSemestr);
//
//      List<Semestr> semestrsList = DBManager.getAllActiveSemestrs();
//        req.setAttribute("selectedSemestr",selectedSemestr);
//
//        resp.sendRedirect("/semestr");
//    }
//}
