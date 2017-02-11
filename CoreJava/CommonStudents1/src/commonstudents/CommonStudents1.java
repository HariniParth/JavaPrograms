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
    int id;
    
    Student(String fName, String lName, int n){
        firstName = fName;
        lastName = lName;
        age = n;
    }
}

public class CommonStudents1 {
    
    static int CommonStudents(Student courseA[], Student courseB[]){
        int common = 0;
        for(Student student : courseA){
            if(Arrays.asList(courseB).contains(student))
                common++;
        }
        return common;
    }
    
    public static void main(String[] args) throws IOException {
        
        Student student[];
        Student courseA[];
        Student courseB[]; 
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the total number of Students ");
        int total = Integer.parseInt(br.readLine());
        student = new Student[total];
        
        for(int i=0;i<total;i++) {
            System.out.println("Enter: FirstName, LastName, Age");
            String data = br.readLine();
            StringTokenizer st = new StringTokenizer(data,",");
            while(st.hasMoreTokens()){
                student[i] = new Student(st.nextToken().trim(), st.nextToken().trim(), Integer.parseInt(st.nextToken().trim()));
            }            
            student[i].id = i+1;
        }
        
        System.out.println("Enter number of students taking Course A");
        int total_A = Integer.parseInt(br.readLine());
        
        if(total_A < total) {
            courseA = new Student[total_A];
            
            for(int i=0;i<total_A;i++){
                System.out.println("Enter: Student ID");
                int id = Integer.parseInt(br.readLine());
                courseA[i] = student[id-1];
            }
            
            System.out.println("Enter number of students taking Course B");
            int total_B = Integer.parseInt(br.readLine());

            if(total_B < total) {
                courseB = new Student[total_B];

                for(int i=0;i<total_B;i++){
                    System.out.println("Enter: Student ID");
                    int id = Integer.parseInt(br.readLine());
                    courseB[i] = student[id-1];
                }
                
                int common = CommonStudents(courseA, courseB);
                System.out.println("Common Number of Students "+common);
                
            } else {
                System.out.println("Invalid");
            }
        
        } else {
            System.out.println("Invalid");
        }
        
    }
    
}
