package org.example.controller;

import org.example.entity.Student;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;

    }
    // insert  post
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createstudent = userService.createUser(student);
//        return ResponseEntity.ok(createstudent);
         return ResponseEntity.status(HttpStatus.CREATED).body(createstudent);
    }
    // get select/fatch/read  getbyid
    @GetMapping("/read/{id}")
    public ResponseEntity<Student> readByIdStudent(@PathVariable Long id) {
       Student studentres = userService.readbyidStudent(id);
       if(studentres == null){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(studentres);
    }
    @GetMapping("/readAll")
    public ResponseEntity<List<Student>> readAllStudent() {
        List<Student> studentres = userService.readAllStudent();
        if(studentres.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentres);
    }
    // update  put
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> UpdateStudent(@PathVariable Long id , @RequestBody Student student ){
        Student studentres = userService.updateStudent(id , student);
        if(studentres == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentres);
    }

    //delte  delete
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> deleteStudent(@PathVariable Long id){
         boolean studentRes = userService.deleteStudent(id);
         if(!studentRes){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok("Record deleted ");
    }
}


