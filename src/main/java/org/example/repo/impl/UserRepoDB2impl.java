package org.example.repo.impl;

import org.example.entity.Student;
import org.example.repo.UserRepo;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoDB2impl implements UserRepo {
    public UserRepoDB2impl(){

    }
    @Override
    public Student save(Student studentreq) {
        System.out.println("DB2 save ");
        return null;
    }
}
