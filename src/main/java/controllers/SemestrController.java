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

@WebServlet(name = "SemestrController", urlPatterns = "/semestr")
public class SemestrController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Semestr> semestrs = DBManager.getAllActiveSemestrs();
        req.setAttribute("semestrs",semestrs);
        req.setAttribute("selectedSemestr",semestrs.get(0));
        ArrayList<Discipline> disciplines = DBManager.getAllActiveDisciplinesBySemestrs(semestrs.get(0).getId());
        req.setAttribute("alldisciplines",disciplines);
        req.getRequestDispatcher("WEB-INF/JSP/Semestr.jsp").forward(req,resp);
    }



}
