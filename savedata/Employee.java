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
public class Employee extends  human{
    double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(double salary, int id, String Name) {
        super(id, Name);
        this.salary = salary;
    }

    @Override
    public void toStringg() {
        System.out.println("công nhân id: "+id+" ,tên: "+Name+" ,lương: "+salary);
    }
    
}
