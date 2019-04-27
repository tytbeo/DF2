/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2_asm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Phuc
 */
public class action {
    ArrayList<Student> listHs = new ArrayList<>();
    public action() {
        System.out.println("bắt đầu chương trình");
        
    }
    Scanner sc = new Scanner(System.in);
    void addStudent(){
        Student hs = new Student();
        hs.StudentID = "";
        while (hs.StudentID == "") {            
            System.out.println("nhập id học sinh: ");
            hs.StudentID = sc.nextLine();
            if(listHs.size() > 0){
                for(Student hss : listHs){
                    if (hs.StudentID == hss.StudentID){
                        System.out.println("id trùng lặp! xin vui lòng nhập lại");
                        hs.StudentID = "";
                        break;
                    }
              }
            }
        }
        
        System.out.println("nhập tên học sinh: ");
        hs.StudentName = sc.nextLine();
        
        System.out.println("nhập địa chỉ của học sinh: ");
        hs.address = sc.nextLine();
        
        System.out.println("nhập số điện thoại");
        hs.phone = sc.nextLine();
        
        
        this.listHs.add(hs);
        
    }
    
    void ShowList(){
        if(listHs.size() > 0){
            for(Student hss : listHs){
                System.out.println("\nid: " + hss.StudentID + "  ,họ và tên: " + hss.StudentName);
                System.out.println("địa chỉ: " + hss.address +"  ,số điện thoại: "+hss.phone);
            }
            return;
        }
        System.out.println("chưa có học sinh nào, vui lòng nhập học sinh mới");
            
    }
    String  saveDataTotxtFile() {
        String saveString = "";
        if(listHs.size() > 0){
            for(Student hss : listHs){
                saveString +="\\r\\n id: " + hss.StudentID + ", họ và tên: " + hss.StudentName +", địa chỉ: " + hss.address +", số điện thoại: "+hss.phone + "      ";
                System.out.println();
            }
        }else{
            saveString="emty";
        }
        return saveString;
    }

}
