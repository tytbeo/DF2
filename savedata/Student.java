/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savedata;

/**
 *
 * @author Phuc
 */
public class Student extends human{
    int age;
    

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int age, int id, String Name) {
        super(id, Name);
        this.age = age;
    }
    
    
    @Override
    public void toStringg() {
        System.out.println("học sinh id: "+id+" ,tên: "+Name+" ,tuổi: "+age);
    }
    
    
    
}
