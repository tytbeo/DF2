/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import db.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc
 */
public class app {

    static boolean stop = false;
    static Statement state;
    static int id;
    static String username;
    static String email;
    static String password;
    static Scanner sc = new Scanner(System.in);

    static void add() {
        System.out.println("enter username : ");
        username = sc.nextLine();
        System.out.println("enter email : ");
        email = sc.nextLine();
        System.out.println("enter password : ");
        password = sc.nextLine();
    }

    public static void main(String[] args) {
        Integer choosed;
        System.out.println("app start!");
        try {
            // dang ki driver
            Class.forName("com.mysql.jdbc.Driver");
            // kết nối DB
            String URL = "jdbc:mysql://localhost:3306/testdb";
            Connection connec = DriverManager.getConnection(URL, "phuc", "tyt123456");
            // truy van du lieu

            state = connec.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!stop) {
            System.out.println("\nenter 1 to login");
            System.out.println("enter 2 to sign in");
            System.out.println("enter 3 to display list user");
            System.out.println("enter 4 to delete user or change to disable");
            System.out.println("enter 5 to exit \n");
            while (true) {
                System.out.println("enter : ");
                String test = sc.nextLine();
                try {
                    choosed = Integer.parseInt(test);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("only number(1-5)");
                }
            }

            switch (choosed) {
                case 1:
                    System.out.println("enter username : ");
                    username = sc.nextLine();
                    System.out.println("enter password : ");
                    password = sc.nextLine();

                    try {
                        String takeInfo = "SELECT * FROM user";
                        ResultSet account = state.executeQuery(takeInfo);
                        int wrongPass = 0;
                        int rowNumber = 0;
                        int exist = 0;
                        boolean shutDown = false;
                        while (account.next()) {
                            if ( username.equals(account.getString("username").trim()) && password.equals(account.getString("password").trim()) ) {
                                System.out.println("login success!");
                                break;
                            } else if ( password !=account.getString("password").trim())  {
                                wrongPass++;
                                System.out.println("wrongPass "+wrongPass);
                            }
                            if(username.equals(account.getString("username").trim()) ){
                                exist++;
                                System.out.println("exist "+exist);
                            }
                            rowNumber++;
                            System.out.println("rowNumber "+rowNumber);
                        }
                        if (shutDown) {
                            break;
                        }
                        if (rowNumber == wrongPass && exist == 1) {
                            System.out.println("wrong password");
                            break;
                        }
                        System.out.println("this user doesnot exits");
                    } catch (SQLException ex) {
                        break;
                    }
                    break;
                case 2:
                    add();
                    String takeInfo = "SELECT * FROM user";
                    String insert = "INSERT INTO user(username,email,password)  VALUES( '" + username + "', '" + email + "','" + password + "')";
                    try {
                        ResultSet account = state.executeQuery(takeInfo);
                        boolean shutDown = false;
                        while (account.next()) {
                            if (username.equals(account.getString("username"))) {
                                System.out.println("duplicate username");
                                shutDown=true;
                                break ;
                            } else if (email.equals(account.getString("email"))) {
                                System.out.println("duplicate email");
                                shutDown=true;
                                break;
                            }
                        }
                        if (shutDown) {
                            break;
                        }
                        state.executeUpdate(insert);
                        System.out.println("sign in success!");
                    } catch (SQLException ex) {
                        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                        break;
                    }
                    break;
                case 4:
                    System.out.println("enter id : ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("enter 1 to detele in database, enter 2 to change status to disable : ");
                    OUTER:
                    while (true) {
                        int de = sc.nextInt();
                        sc.nextLine();
                        try {
                            switch (de) {
                                case 1:
                                    String delete = "DELETE FROM user WHERE id =" + id;
                                    state.executeUpdate(delete);
                                    System.out.println("update success!");
                                    break OUTER;
                                case 2:
                                    String update = "UPDATE  user SET status = " + 0 + "  WHERE id =" + id;
                                    state.executeUpdate(update);
                                    System.out.println("update success!");
                                    break OUTER;
                                case 3:
                                    break OUTER;
                                default:
                                    System.out.println("u only can  enter 1 or 2. if u dont want, enter 3 to exit!");
                                    break;
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
                            break;
                        }
                    }
                    break;
                case 3:
                    String sql = "SELECT * FROM user";
                    ResultSet rs;
                    try {
                        rs = state.executeQuery(sql);
                        System.out.println("list student : ");
                        while (rs.next()) {
                            String status1 = "";
                            if (rs.getInt("status") == 1) {
                                status1 = "enable";
                            } else {
                                status1 = "disable";
                            }

                            System.out.println("id: " + rs.getInt("id") + "  username: " + rs.getString("username")
                                    + "   email: " + rs.getString("email") + "   password: " + rs.getString("password") + "   status: " + status1);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 5:
                    stop = true;
                    System.out.println("good bye!");
                    break;
                default:
                    System.out.println("unacepted input! try again.");
                    break;
            }

        }
    }
}
