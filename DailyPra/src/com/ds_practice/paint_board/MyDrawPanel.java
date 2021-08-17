package com.ds_practice.paint_board;


import javax.swing.*;

public class MyDrawPanel extends JFrame{



    public static void main(String[] args){

        new MyDrawPanel().init();

    }

    public void init(){

        this.setTitle("DS Board");


        this.setSize(1200,1000);

        //把窗体显示在屏幕中间
        this.setLocationRelativeTo(null);

        //设置窗体的关闭按钮
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //设置窗体的可见性
        this.setVisible(true);


    }


}
