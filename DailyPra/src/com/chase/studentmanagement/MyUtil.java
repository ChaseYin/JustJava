package com.chase.studentmanagement;

import java.util.Scanner;

public class MyUtil {
    private  MyUtil(){

    }
    //得到制定区间的随机数
    public static int getRandomNumber(int min, int max){
        return (int)(Math.random()*(max-min)+min);
    }

    //给用户提示信息的同时，请用户输入一个整数
    public static int getInputNumber(String msg, Scanner scanner){
        System.out.println(msg);
        return scanner.nextInt();
    }

    //给用户提示信息的同时，请用户输入一个字符串
    public static String getInputString(String msg, Scanner scanner){
        System.out.println(msg);
        return scanner.next();
    }





}
