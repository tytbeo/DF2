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
public class SaveData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonModel<Student> StudentList = new PersonModel<>();
        StudentList.add(new Student(123, 19, "phúc"));
        StudentList.add(new Student(111, 12, "quân"));
        StudentList.printOut();
        PersonModel<Employee>  EmployeeList = new PersonModel<>();
        EmployeeList.add(new Employee(1001, 999, "Sang"));
        EmployeeList.add(new Employee(1005, 3100, "Chi"));
        EmployeeList.printOut();
    }
    
}
