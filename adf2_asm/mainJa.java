/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2_asm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Phuc
 */
public class mainJa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        action PP = new action();
        boolean keepRuning = true;
        Integer choosen ;
        while (keepRuning) {            
            System.out.println("\n1. Add student. \n" +
            "2. Show student. \n" +
            "3. save all record to file txt\n"+
            "4. Exit.");
            while (true) {
                System.out.println("enter : ");
                String test = sc.nextLine();
                try {
                    choosen = Integer.parseInt(test);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("only number(1-4)");
                }
            }

            switch(choosen){
                case 1 :
                    PP.addStudent();
                    break;
                case 2 :
                    PP.ShowList();
                    break;
                case 3:
                    String saveString= PP.saveDataTotxtFile();
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("StudentSaved.txt"));
                        writer.write(saveString);
                        writer.close();
                        System.out.println("save Success!");
                    } catch (Exception e) {
                        System.out.println("fail!");
                        break;
                    }
                    
                    break;
                case 4:
                    System.out.println("do you remebering save data before exit ?yes/no");
                    String exit = "yes";
                    exit = sc.nextLine();
                    if ( "yes".equals(exit)){
                        System.out.println("chương trình kết thúc!");
                        keepRuning = false;
                        break;
                    } else{
                        break;
                    }
                    
                default :
                    System.out.println("chỉ được nhập các số từ 1-4");
                    break;
            }
        }
    }
}
