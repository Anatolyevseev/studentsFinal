package controllers;

import database.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "StudentsModifyingController", urlPatterns = "/students_modifying")
public class StudentsModifyingController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("modifyst");
        if (id.equals("")) {
            resp.sendRedirect("/students");
        } else {
            req.setAttribute("modifyst", id);
            ArrayList<Student> students = DBManager.getAllActiveStudents();
            for (Student student : students) {
                if (student.getId() == Integer.parseInt(id)) {
                    req.setAttribute("selectedStudent", student);
                }
            }
            req.getRequestDispatcher("WEB-INF/JSP/students_modifying.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("if");
        String modifiedLastName = req.getParameter("sername");
        String modifiedFirstName = req.getParameter("name");
        String modifiedGroup = req.getParameter("group");
        String modifiedDate = req.getParameter("date");
        String dateFormat = null;
        if (modifiedLastName.equals("") || modifiedFirstName.equals("")|| modifiedGroup.equals("") || modifiedDate.equals("")){
            req.setAttribute("error","1");
            req.getRequestDispatcher("WEB-INF/JSP/students_modifying.jsp").forward(req,resp);
        }else {
            if (!modifiedDate.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d")){
                String pattern = "MM/dd/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date date2 = null;
                try {
                    date2 = simpleDateFormat.parse(modifiedDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String pattern1 = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);
                dateFormat = simpleDateFormat1.format(date2);
                DBManager.modifyStudent(id, modifiedLastName,modifiedFirstName,modifiedGroup,dateFormat);
                resp.sendRedirect("/students");
            }else{
                DBManager.modifyStudent(id, modifiedLastName,modifiedFirstName,modifiedGroup,modifiedDate);
                resp.sendRedirect("/students");
            }
        }
    }
}



//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        if (id.equals("")){
//            resp.sendRedirect("/students");
//        }else {
//            req.setAttribute("id",id);
//            ArrayList<Student> students = DBManager.getAllActiveStudents();
//            for (Student student:students)
//            if (student.getId()==Integer.parseInt(id)){
//                req.setAttribute("selectedStudent",student);
//            }
//        }
//        req.getRequestDispatcher("WEB-INF/JSP/students_modifying.jsp").forward(req,resp);
//    }

//}
//@WebServlet(name = "StudentsModifyingController", urlPatterns = "/students_modifying")
//public class StudentsModifyingController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        if (id.equals("")) {
//            resp.sendRedirect("/students");
//        } else {
//            req.setAttribute("id",id);
//            ArrayList<Student> students = DBManager.getAllActiveStudents();
//            for (Student student : students ) {
//                if (student.getId()==Integer.parseInt(id)){
//                    req.setAttribute("selectedStudent",student);
//                }
//            }
//            req.getRequestDispatcher("WEB-INF/JSP/students_modifying.jsp").forward(req,resp);
//
//        }
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        String id = req.getParameter("id");
//        String modifiedLastName = req.getParameter("modifiedLastName");
//        String modifiedFirstName = req.getParameter("modifiedFirstName");
//        String modifiedGroup = req.getParameter("modifiedGroup");
//        String modifiedDate = req.getParameter("modifiedDate");
//        String dateFormat = null;
//        if (modifiedLastName.equals("") || modifiedFirstName.equals("")|| modifiedGroup.equals("") || modifiedDate.equals("")){
//            req.setAttribute("error","1");
//            req.getRequestDispatcher("WEB-INF/JSP/students_modifying.jsp").forward(req,resp);
//        }else {
//            if (!modifiedDate.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d")){
//                String pattern = "MM/dd/yyyy";
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//                Date date2 = null;
//                try {
//                    date2 = simpleDateFormat.parse(modifiedDate);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                String pattern1 = "yyyy-MM-dd HH:mm:ss";
//                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);
//                dateFormat = simpleDateFormat1.format(date2);
//                DBManager.modifyStudent(id, modifiedLastName,modifiedFirstName,modifiedGroup,dateFormat);
//                resp.sendRedirect("/students");
//            }else{
//                DBManager.modifyStudent(id, modifiedLastName,modifiedFirstName,modifiedGroup,modifiedDate);
//                resp.sendRedirect("/students");
//            }
//        }
//    }
