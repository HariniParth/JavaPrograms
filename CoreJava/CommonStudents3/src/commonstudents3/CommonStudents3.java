/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonstudents3;

import java.io.*;
import java.util.*;

/**
 *
 * @author harini-geek
 */
class Student{
    String firstName;
    String lastName;
    int age;
    
    Student(String fName, String lName, int a){
        firstName = fName;
        lastName = lName;
        age = a;
    }
}

public class CommonStudents3 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    static List<Student> students = new ArrayList<>();
    static List<Student> courseA = new ArrayList<>();
    static List<Student> courseB = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        
        int common = 0;
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the total number of students");
        int total = Integer.parseInt(br.readLine());
        
        for(int i=0;i<total;i++){
            System.out.println("Enter FirstName LastName Age: ");
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input," ");
            
            while(st.hasMoreTokens()){
                
                try{
                    String firstName = st.nextToken().trim();
                    String lastName = st.nextToken().trim();
                    int age = Integer.parseInt(st.nextToken().trim());
                    Student newStudent = null;
                
                    if(firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+") && age>=0){
                        newStudent = new Student(firstName, lastName, age);
                        
                        if(students.size() > 0){
                            for(Student student : students){
                                if(!(student.firstName.equals(newStudent.firstName) && student.lastName.equals(newStudent.lastName) && student.age == newStudent.age)){
                                    students.add(newStudent);
                                    enrollStudent(newStudent);
                                }
                                else
                                    System.out.println("Enter unique FirstName, LastName, Age combination");
                            }
                        } else {
                            students.add(newStudent);
                            enrollStudent(newStudent);
                        }
                        
                        
                    } else {
                        
                    }
                } catch(NumberFormatException e){
                    System.out.println("Enter alphabetical FirstName, LastName and a positive integer Age");
                }              
            }
        }
        
        for(Student student : courseA){
            if(courseB.contains(student)){
                common++;
            }
        }
        
        System.out.println("Common number of students in courses A and B: "+common);
    }
    
    static void enrollStudent(Student student) throws IOException{
        
        char enroll;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enroll student in Course A? [Y/N]");
        enroll = (char) br.read();
        if(enroll == 'Y')
            courseA.add(student);
        
        BufferedReader cr = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enroll student in Course B? [Y/N]");
        enroll = (char) cr.read();
        if(enroll == 'Y')
            courseB.add(student);
    }
    
}
