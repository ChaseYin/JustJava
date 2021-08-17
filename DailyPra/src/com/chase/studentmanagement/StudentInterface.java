package com.chase.studentmanagement;

import java.util.List;

public interface StudentInterface {
    /**
     * 遍历所有学生信息
     */
    void showAll();

    boolean addStudent();

    Student findStudentBySid(int sid);

    List<Student> findStudentByName(String name);

    boolean removeStudentBySid(int sid);

    boolean modifyStuBySid(int sid);

}
