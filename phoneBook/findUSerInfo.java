/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneBook;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Phuc
 */
public class findUSerInfo {

    static int id;
    static String username;
    static String email;
    static String password;

    static boolean stop = false;
    static Scanner sc = new Scanner(System.in);
    static DaoUser method = new DaoUser();
    static connector conn = connector.getInstance();

    public static String add() {
        System.out.println("enter username : ");
        username = sc.nextLine();
        return username;
    }

    public static String add2() {
        System.out.println("enter email : ");
        email = sc.nextLine();
        return email;
    }

    public static int add3() {
        System.out.println("enter id : ");
        id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public static void main(String[] args) throws SQLException {
        Integer choosed;
        while (!stop) {
            System.out.println("\nenter 1 to display list user");
            System.out.println("enter 2 to find phone-Number");
            System.out.println("enter 3 to exit \n");
            while (true) {
                System.out.println("enter : ");
                String test = sc.nextLine();
                try {
                    choosed = Integer.parseInt(test);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("only number(1-3)");
                }
            }
            switch (choosed) {
                case 1:
                    method.printUser();
                    break;
                case 2:
                    method.getPhoneNumber(add());
                    break;
                case 3:
                    try {
                        conn.close();
                    } catch (Exception ex) {

                    }
                    stop = true;
                    break;
                default:
                    System.out.println("only number(1-3)");
                    break;
            }

        }

    }
}
