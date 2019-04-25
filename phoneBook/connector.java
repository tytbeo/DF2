/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneBook;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author Phuc
 */
public class connector {

    public  Connection conn;

    public static connector instance;

    private connector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/testdb";
            this.conn = DriverManager.getConnection(URL, "phuc", "tyt123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static connector getInstance() {
        if (instance == null) {
            instance = new connector();
        }
        return instance;
    }

    public ResultSet getQuery(String sql) throws Exception {
        Statement statement = this.conn.createStatement();
        return statement.executeQuery(sql);
    }

    public int updateQuery(String sql) throws Exception {
        Statement statement = this.conn.createStatement();
        return statement.executeUpdate(sql);
    }

    public void close() throws Exception {
        this.conn.close();
    }

}
