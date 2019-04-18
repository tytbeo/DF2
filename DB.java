/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc
 */
public class DB {

    static boolean stop = false;
    static Statement state;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choosed;
        Scanner sc = new Scanner(System.in);
        System.out.println("app start!");

        while (!stop) {
            try {
                // dang ki driver
                Class.forName("com.mysql.jdbc.Driver");
                // kết nối DB
                String URL = "jdbc:mysql://localhost:3306/testdb";
                Connection connec = DriverManager.getConnection(URL, "phuc", "tyt123456");
                // truy van du lieu
                String sql = "SELECT * FROM student";
                state = connec.createStatement();
                ResultSet rs = state.executeQuery(sql);
                System.out.println("list student : ");
                while (rs.next()) {
                    System.out.println("id: " + rs.getInt("id") + "  name: " + rs.getString("name") + "   age: " + rs.getInt("age") + "   mark: " + rs.getInt("mark"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("\nenter 1 to edit student by id");
            System.out.println("enter 2 to delete student by id");
            System.out.println("enter 3 to add student");
            System.out.println("enter 4 to exit \n");
            choosed = sc.nextInt();
            sc.nextLine();
            int id;
            String name;
            int age;
            int mark;
            switch (choosed) {
                case 1:
                    System.out.println("enter id : ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("enter name : ");
                    name = sc.nextLine();
                    System.out.println("enter age : ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("enter mark : ");
                    mark = sc.nextInt();
                    sc.nextLine();
                    String update = "UPDATE student SET name = '" + name + "', age = " + age + ",mark=" + mark + "  WHERE id=" + id;
                     {
                        try {
                            state.executeUpdate(update);
                        } catch (SQLException ex) {
                            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("enter id : ");
                    id = sc.nextInt();
                    sc.nextLine();
                    String delete = "DELETE FROM student WHERE id=" + id;
                    try {
                        state.executeUpdate(delete);
                    } catch (SQLException ex) {
                        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                        break;
                    }
                    break;
                case 3:
                    System.out.println("enter name : ");
                    name = sc.nextLine();
                    System.out.println("enter age : ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("enter mark : ");
                    mark = sc.nextInt();
                    sc.nextLine();
                    String insert = "INSERT INTO student (name,age,mark)  VALUES( '"+ name + "', " + age + "," + mark + ")";
                    try {
                        state.executeUpdate(insert);
                    } catch (SQLException ex) {
                        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                        break;
                    }
                    break;
                case 4:
                    stop = true;
                    System.out.println("good bye!");
                    break;
            }

        }
    }

}
