/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonstudents;

import java.io.*;
import java.util.*;

/**
 *
 * @author harini-geek
 */

class Student {
    String firstName;
    String lastName;
    int age;
    
    Student(String fName, String lName, int n){
        firstName = fName;
        lastName = lName;
        age = n;
    }
}

public class CommonStudents2 {
    
    static int CommonStudents(Student courseA[], Student courseB[]){
        int common = 0;
        for(Student studentA : courseA){
            for(Student studentB : courseB){
                if (studentA.firstName.equals(studentB.firstName) && studentA.lastName.equals(studentB.lastName) && studentA.age == studentB.age)
                    common++;
            }
        }
        return common;
    }
    
    public static void main(String[] args) throws IOException {
        
        Student courseA[];
        Student courseB[]; 
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter the total number of Students in Course A");
        int total_A = Integer.parseInt(br.readLine());
        courseA = new Student[total_A];
        
        for(int i=0;i<total_A;i++) {
            System.out.println("Enter: FirstName LastName Age");
            String data = br.readLine();
            StringTokenizer st = new StringTokenizer(data," ");
            while(st.hasMoreTokens()){
                courseA[i] = new Student(st.nextToken().trim(), st.nextToken().trim(), Integer.parseInt(st.nextToken().trim()));
            }            
        }
        
        System.out.println("Enter the total number of Students in Course B");
        int total_B = Integer.parseInt(br.readLine());
        courseB = new Student[total_B];
        
        for(int i=0;i<total_B;i++) {
            System.out.println("Enter: FirstName LastName Age");
            String data = br.readLine();
            StringTokenizer st = new StringTokenizer(data," ");
            while(st.hasMoreTokens()){
                courseB[i] = new Student(st.nextToken().trim(), st.nextToken().trim(), Integer.parseInt(st.nextToken().trim()));
            }            
        }
                
        int common = CommonStudents(courseA, courseB);
        System.out.println("Common number of students "+common);
    }    
}
