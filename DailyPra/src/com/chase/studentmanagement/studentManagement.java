package com.chase.studentmanagement;

import java.util.Scanner;


public class studentManagement {
    public static void main(String[] args){
        StudentSystem system = new StudentSystem();
        system.welcome();
        Scanner scanner = new Scanner(System.in);
        while(true){
            system.showMenu();
            int input = MyUtil.getInputNumber("请选择您的操作：",scanner);
            switch (input){
                case 1:
                    system.showAll();
                    break;
                case 2:
                    system.addStudent();
                    break;
                case 3:
                    system.findStudentBySid();
                    break;
                case 4:
                    system.findStudentByName();
                    break;
                case 5:
                    system.removeStudentBySid();
                    break;
                case 6:
                    system.modifyStuBySid();
                    break;
                case 7:
                    system.exit();
                    return;

            }
        }
    }
}
