package org.example.repo.impl;

import org.example.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepMySqlimpl extends JpaRepository<Student , Long> {
//    public UserRepMySqlimpl(){
//
//    }
//    public Student save (Student studentreq){
//        Student s1 = new Student();
//        s1.setName("muskan");
//        s1.setAge(22);
//        s1.setEmail("muskan@gmail.com");
//        s1.setSubject("corporate java");
//        s1.setRollNo(1078);
//        return s1;
//    }
}
