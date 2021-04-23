package database;

import entity.Account;
import entity.Discipline;
import entity.Semestr;
import entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBManager {

    public static ArrayList<Student> getAllActiveStudents() {
        ArrayList<Student> allStudents = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student where status='1';");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSername(rs.getString("sername"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                student.setStatus(1);
                allStudents.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allStudents;
    }

    public static ArrayList<Student> getOneActiveStudent() {
        ArrayList<Student> oneStudent = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "Aa309182769975");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student where sername='Петров';");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSername(rs.getString("sername"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                student.setStatus(1);
                oneStudent.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return oneStudent;
    }

    public static ArrayList<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> allDisciplines = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM discipline where status='1';");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                discipline.setStatus(1);
                allDisciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allDisciplines;
    }


    public static ArrayList<Semestr> getAllActiveSemestrs() {
        ArrayList<Semestr> allActiveSmestrs = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM term where status = '1'");

            while (rs.next()) {
                Semestr semestr = new Semestr();
                semestr.setId(rs.getInt("id"));
                semestr.setTerm(rs.getString("term"));
                semestr.setDuration(rs.getString("duration"));
                semestr.setStatus(1);
                allActiveSmestrs.add(semestr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allActiveSmestrs;
    }

    public static ArrayList<Discipline> getAllActiveDisciplinesBySemestrs(int idSemestr) {
        ArrayList<Discipline> allDisciplines = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM term_discipline\n" +
                    "left join discipline on term_discipline.id_discipline = discipline.id\n" +
                    "where term_discipline.id_term = " + idSemestr + " and discipline.status = '1'");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id_discipline"));
                discipline.setDiscipline(rs.getString("discipline"));
                discipline.setStatus(1);
                allDisciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allDisciplines;
    }


    public static void createStudent(String name, String sername, String group, String date) {

        try {
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `student` (`sername`, `name`, `group`, `date`) VALUES ('" + sername + "', '" + name + "', '" + group + "', '" + date + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public static void createDiscipline(String name) {

        try {
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `discipline` (`discipline`) VALUES ('" + name + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteDiscipline(String id) {
        try {
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` = '"+id+"');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteStudent(String id) {
        try {
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = '"+id+"');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static Semestr getSemestrByid(String idTerm) {
        try {
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM term where id = " + idTerm);

           while(rs.next()){
               Semestr semestr = new Semestr();
               semestr.setId(rs.getInt("id"));
               semestr.setDuration(rs.getString("duration"));
               semestr.setTerm(rs.getString("term"));
               semestr.setStatus(1);
               return semestr;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void modifySemestrByid(String idTerm2,String modifiedTerm,String modifiedDuration) {
//        try {
//            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(url, "root", "password");
//            Statement stmt = con.createStatement();
//            stmt.execute("UPDATE `term` SET `term` = '"+modifiedTerm+"', `duration` = '"+modifiedDuration+"' where (`id` = '" +idTerm2+"');");
//
//            } catch (ClassNotFoundException e1) {
//            e1.printStackTrace();
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//        }
//    } catch (Exception e) {
//            e.printStackTrace();
//        }



    public static void modifyStudent(String id,String modifiedFirstName, String modifiedLastName, String modifiedGroup, String modifiedDate) {

        try {
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement statement = con.createStatement();
            statement.execute("UPDATE `student` SET `sername` = '"+modifiedLastName+"', `name` = '"+modifiedFirstName+"', `group` = '"+modifiedGroup+"', `date` = '"+modifiedDate+"' WHERE (`id` = '"+id+"');");

        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void modifyDiscipline(String id, String modifiedDiscipline){

        try{
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root", "password");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `discipline` SET `discipline` = '"+modifiedDiscipline+"' WHERE (`id` = '"+id+"')");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Account getAccountBy(String login,String password) {
        try {
            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account where login = '" + login+"' and password = '" + password + "'");

            while(rs.next()){
                Account account = new Account();
                account.setLogin( rs.getString("login"));
                account.setPassword( rs.getString("password"));
                account.setRole( rs.getInt("role"));
                return account;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void modifyTerm(String id, String modifiedDuration, String[] modifiedDisciplinesId) {
        int duration1 = 0;
        try {
            duration1 = Integer.parseInt(modifiedDuration.trim());

        } catch (NumberFormatException e) {
            Pattern pattern = Pattern.compile("\\D");
            Matcher matcher = pattern.matcher(modifiedDuration);
            int i = 0;
            if (matcher.find()){
                i = matcher.start();
            }
            duration1 = Integer.parseInt(modifiedDuration.substring(0,i));
        }
        String wordWeek= null;
        String durationString = String.valueOf(duration1);
        if ((duration1-1)%10==0 && duration1!=11){
            wordWeek= " неделя";
        }else if ((durationString.substring(durationString.length()-1).equals("2") ||
                durationString.substring(durationString.length()-1).equals("3") ||
                durationString.substring(durationString.length()-1).equals("4"))&&
                duration1!=12 && duration1!=13 && duration1!=14){
            wordWeek=" недели";
        }else{
            wordWeek = " недель";
        }
        String durationResult = duration1+wordWeek;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/students_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "password");
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM `term_discipline` WHERE (`id_term` = '" + id + "')");
            if (modifiedDisciplinesId != null) {
                for (String newDisciplineId : modifiedDisciplinesId) {
                    statement.execute("INSERT INTO `term_discipline` (`id_term`, `id_discipline`) VALUES ('" + id + "', '" + newDisciplineId + "')");
                }
            }

            statement.execute("UPDATE `term` SET `duration` = '" + durationResult + "' WHERE (`id` = '" + id + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//    public static Semestr modifySemestrByid(String idSemestr) {
//    }
}
//    public static Discipline getDisciplineByid(String iddisc2) {
//        try {
//            String url = "jdbc:mysql://localhost/student_control?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(url, "root", "password");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM term where id = " + iddisc2+"");
//
//            while(rs.next()){
//                Discipline discipline = new Discipline();
//                discipline.setId(rs.getInt("id"));
//                discipline.setDiscipline("discipline");
//                discipline.setStatus(1);
//                return discipline;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}


