package com.chase.studentmanagement;

import java.awt.*;
import java.util.*;
import java.util.List;

public class StudentSystem implements StudentInterface{

    //使用hashmap保存学生信息，容器中的Entry的key是学号，value就是学号对应的学生对象

    private Map<Integer, Student> students = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    //显示系统开头
    public void welcome(){
        System.out.println("**********欢迎来到学生管理系统**********");
    }

    public void exit(){
        System.out.println("**********谢谢使用**********");
    }


    //显示系统菜单
    public void showMenu(){
        System.out.println("\n");
        System.out.println("请选择您的操作：");
        System.out.println("1------>显示所有学生信息");
        System.out.println("2------>添加学生信息");
        System.out.println("3------>根据学号查找学生");
        System.out.println("4------>根据姓名查找学生");
        System.out.println("5------>根据学号删除学生");
        System.out.println("6------>根据学号修改学生");
        System.out.println("7------>退出系统");

    }

    @Override
    public void showAll() {
        Set<Integer> sids = students.keySet();
        Iterator<Integer> iterator = sids.iterator();
        while(iterator.hasNext()){
            Integer sid = iterator.next();
            Student student = students.get(sid);
            System.out.println(student);
        }
    }

    @Override
    public boolean addStudent() {

//        System.out.println("请输入学生的学号，要求整数：");
//        int sid = scanner.nextInt();
//
//        System.out.println("请输入学生的学号，要求整数：");
//        int sid = scanner.nextInt();

        //使用自己的类的方法
        int sid = MyUtil.getInputNumber("请输入学生的学号，要求是整数",scanner);

        String name = MyUtil.getInputString("请输入学生的姓名", scanner);

        int age = MyUtil.getInputNumber("请输入学生的年龄",scanner);

        Gender gender = MyUtil.getInputString("请输入学生的性别：",scanner).equals("男")?Gender.男:Gender.女;

        Student s = new Student(sid, name, age, gender);

        students.put(sid, s);

        System.out.println("添加成功");

        return false;
    }

    @Override
    public Student findStudentBySid(int sid) {
        Student student = students.get(sid);

        if(student != null){
            System.out.println(student);
        }else{
            System.out.println("此学生不存在");
        }
        return student;
    }

    public Student findStudentBySid(){
        int sid = MyUtil.getInputNumber("请输入要查找的学生的学号",scanner);
        return findStudentBySid(sid);
    }

    @Override
    public List<Student> findStudentByName(String name) {

        List<Student> list = new ArrayList<>();
        //遍历所有的学生，然后和name进行比对

        Collection<Student> stus = students.values();
        Iterator<Student> iterator = stus.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.getName().equals(name)){
                list.add(student);
            }

        }

        return list.size() == 0 ? null: list;
    }

    public void findStudentByName() {
        String name = MyUtil.getInputString("请输入要查找的学生的姓名：",scanner);
        List<Student> stus = findStudentByName(name);
        if(stus == null){
            System.out.println("该姓名的学生不存在");
        }else{
            System.out.println("查找到的学生如下：");
            for(int i = 0; i < stus.size(); i++){
                System.out.println(stus.get(i));
            }
        }
    }



    @Override
    public boolean removeStudentBySid(int sid) {
        Student student = students.remove(sid);
        return student == null ? false : true;
    }

    public void removeStudentBySid() {
        int sid = MyUtil.getInputNumber("请输入要删除的学生的学号：",scanner);
        boolean bool = removeStudentBySid(sid);
        if(bool == true){
            System.out.println("删除成功！");
        }else{
            System.out.println("不存在该学生！");

        }
    }

    @Override
    public boolean modifyStuBySid(int sid) {
        Student student = students.get(sid);
        if(student != null){
            sid = MyUtil.getInputNumber("请输入学生的学号，要求是整数",scanner);

            String name = MyUtil.getInputString("请输入学生的姓名", scanner);

            int age = MyUtil.getInputNumber("请输入学生的年龄",scanner);

            Gender gender = MyUtil.getInputString("请输入学生的性别：",scanner).equals("男")?Gender.男:Gender.女;
            student.setAge(age);
            student.setGender(gender);
            student.setAge(age);
            student.setSid(sid);
        }
        return student == null ? false : true;
    }

    public void modifyStuBySid() {
        int sid = MyUtil.getInputNumber("请输入要修改的学生的学号：",scanner);
        boolean bool = modifyStuBySid(sid);
                if(bool){
                    System.out.println("修改成功！");
                }else{
                    System.out.println("学生不存在！");
                }
        //return modifyStuBySid(sid);
    }
}
