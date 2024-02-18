package com.nxtwave;

import java.util.List;

import com.nxtwave.dao.StudentDao;
import com.nxtwave.dao.StudentDaoImpl;
import com.nxtwave.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        
        StudentDao studentDao = new StudentDaoImpl();
        
        Student student = new Student("Ummed Singh", "18EBKCS110");
        studentDao.creatStudent(student);
        
        student.setName("Ummed");
        studentDao.updateStudent(student);
        
        Student student2 = studentDao.getStudentById(student.getId());
        
        List<Student> students = studentDao.getStudents();
        
        students.forEach(stu -> System.out.println(stu.getId()));
        
        studentDao.deleteStudent(student.getId());
    }
}
