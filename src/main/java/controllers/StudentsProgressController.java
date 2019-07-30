package controllers;

import database.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentsProgressController",urlPatterns = "/students_progress")
public class StudentsProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Student> student = DBManager.getOneActiveStudent();
        req.setAttribute("student",student);
        req.getRequestDispatcher("WEB-INF/JSP/students_progress.jsp").forward(req,resp);
    }


}
