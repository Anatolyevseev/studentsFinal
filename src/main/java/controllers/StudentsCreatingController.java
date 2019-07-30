package controllers;
import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "StudentsCreatingController", urlPatterns = "/students_creating")

public class StudentsCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/JSP/students_creating.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sernameST = req.getParameter("sername");
        String nameST = req.getParameter("name");
        String groupST = req.getParameter("group");
        String dateST = req.getParameter("date");

        if (sernameST.equals("") || nameST.equals("") || groupST.equals("") || dateST.equals("")) {
            req.setAttribute("error","1");
            req.getRequestDispatcher("WEB-INF/JSP/students_creating.jsp").forward(req,resp);
        }else{
            String pattern = "MM/dd/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date date = null;

            try {
                date = simpleDateFormat.parse(dateST);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String pattern2 = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);

            String dateFormat = simpleDateFormat2.format(date);
            DBManager.createStudent(sernameST,nameST,groupST,dateFormat);
            resp.sendRedirect("/students");
        }


    }
}
