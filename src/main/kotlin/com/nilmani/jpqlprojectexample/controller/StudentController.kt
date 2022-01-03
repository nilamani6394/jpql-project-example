package com.nilmani.jpqlprojectexample.controller

import com.nilmani.jpqlprojectexample.entity.Student
import com.nilmani.jpqlprojectexample.model.request.ReqGetByStudentId
import com.nilmani.jpqlprojectexample.model.request.ReqStudent
import com.nilmani.jpqlprojectexample.model.response.ResStudent
import com.nilmani.jpqlprojectexample.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/test")
class StudentController {
    @Autowired
    private lateinit var studentRepo:StudentRepository

    @PostMapping("/add")
    fun addStudent(@ModelAttribute request: ReqStudent):ResponseEntity<*>{
        val newStudent = Student(
            name = request.name,
            email = request.email,
            phone = request.phone
        )
        val saveStudent = studentRepo.save(newStudent)
        val respStudent = ResStudent(
            saveStudent.name,
            saveStudent.email,
            saveStudent.phone
        )
        return ResponseEntity("student Registration Successfull",HttpStatus.OK)
    }

}