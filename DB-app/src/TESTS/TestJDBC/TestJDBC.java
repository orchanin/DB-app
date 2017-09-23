package TESTS.TestJDBC;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.*;

/**
 * Created by dyachkov1997 on 17.02.17.
 */
public class TestJDBC {
    public static void main(String args[]){


        try {
            System.setOut(new PrintStream("JDBCout.txt"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return;
        }
        
        System.out.println("Copyright 2017, Evgeny Dyachkov");

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try { //Желательно орабатывать каждый момент
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/students";
            con = DriverManager.getConnection(url, "root", "yyJtHTH73X");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                String str = rs.getString(1) + ":" + rs.getString(2);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закрываем все открытые ресурсы
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }
}


