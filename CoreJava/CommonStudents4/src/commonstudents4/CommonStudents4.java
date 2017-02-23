/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonstudents4;

import java.util.*;

/**
 *
 * @author harini-geek
 */
class Student {
    String firstName;
    String lastName;
    int age;
    
    Student(String fName, String lName, int a){
        firstName = fName;
        lastName = lName;
        age = a;
    }
}

public class CommonStudents4 {

    /**
     * @param args the command line arguments
     */
    static HashSet<Student> totalStudents = new HashSet<Student>();
    static HashSet<Student> courseA = new HashSet<Student>();
    static HashSet<Student> courseB = new HashSet<Student>();
    
    public static void main(String[] args) {
        
        int common = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of students");
        try {
            int total = sc.nextInt();
            for(int i=0;i<total;i++){
                System.out.print("Enter First Name: ");
                String firstName = sc.next();
                System.out.print("Enter Last Name: ");
                String lastName = sc.next();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                
                try {
                    if(firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+") && age>=0){
                        Student newStudent = new Student(firstName, lastName, age);
                        if(!totalStudents.contains(newStudent)){
                            totalStudents.add(newStudent);
                            
                            char enroll;
                            System.out.println("Is the student enrolled in Course A?");
                            enroll = sc.next().charAt(0);
                            if(enroll == 'Y')
                                courseA.add(newStudent);
                            
                            System.out.println("Is the student enrolled in Course B?");
                            enroll = sc.next().charAt(0);
                            if(enroll == 'Y')
                                courseB.add(newStudent);
                        } else {
                            System.out.println("Enter unique First name, Last name, Age combination");
                        }
                    }
                } catch(Exception 
                        e){
                    System.out.println("Enter alphabetical First name, Last name and positive integer for Age");
                }
            }
        } catch(Exception e){
            System.out.println(e.toString());
        }
        
        for(Student s : courseA){
            if(!courseB.contains(s))
                common++;
        }
        System.out.println("Common number of students in Course A and Course B: "+common);
    }
    
}
