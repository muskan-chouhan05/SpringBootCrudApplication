package org.example.service;

import org.example.entity.Student;
import org.example.repo.impl.UserRepMySqlimpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepMySqlimpl userRepoMySql;
    public UserService(UserRepMySqlimpl userRepoMySql){
        this.userRepoMySql = userRepoMySql;
    }
    public Student createUser(Student studentreq){
        Student studentResponse = userRepoMySql.save(studentreq);
        return studentResponse;
    }

    public Student readbyidStudent(Long id) {
        Optional<Student> studentRes = userRepoMySql.findById(id);
        if(studentRes.isPresent()){
            return studentRes.get();
        }
        return null;
    }

    public List<Student> readAllStudent() {
        List<Student> studentRes = userRepoMySql.findAll();
        return studentRes;
    }
    public Student updateStudent(Long id, Student student){
        Optional<Student> studentRes = userRepoMySql.findById(id);
        if(studentRes.isEmpty()){
            return null;
        }
        Student studentSave = studentRes.get();
        studentSave.setName(student.getName());
        studentSave.setRollNo(student.getRollNo());
        studentSave.setSubject(student.getSubject());
        studentSave.setEmail(student.getEmail());
        studentSave.setAge(student.getAge());
        Student studenttoSave = userRepoMySql.save(studentSave);
        return studenttoSave;
    }
    public Boolean deleteStudent(Long id  ){
        Boolean studentRes = userRepoMySql.existsById(id);
        if(!studentRes){
            return false;
        }
        userRepoMySql.deleteById(id);
        return true;
    }
}
