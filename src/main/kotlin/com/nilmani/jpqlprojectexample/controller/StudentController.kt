package com.nilmani.jpqlprojectexample.controller

import com.nilmani.jpqlprojectexample.entity.Student
import com.nilmani.jpqlprojectexample.entity.StudentHistoryDetails
import com.nilmani.jpqlprojectexample.model.request.ReqGetByStudentId
import com.nilmani.jpqlprojectexample.model.request.ReqStudent
import com.nilmani.jpqlprojectexample.model.request.ReqStudentHistoryDetails
import com.nilmani.jpqlprojectexample.model.response.ResStudent
import com.nilmani.jpqlprojectexample.repository.StudentHistoryDetailsRepository
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
    @Autowired
    private lateinit var historyRepo:StudentHistoryDetailsRepository

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

    /**API For to Get the Student Details*/
    @PostMapping("/history")
    fun studentHistory(@ModelAttribute request:ReqStudentHistoryDetails):ResponseEntity<*>{
        val existHistory = StudentHistoryDetails(
            studentId = request.studentId,
            teacherId = request.teacherId,
            courseId = request.courseId
        )
        val saveHistory = historyRepo.save(existHistory)
        val resHistory = ReqStudentHistoryDetails(
            saveHistory.studentId,
            saveHistory.courseId,
            saveHistory.teacherId
        )
        return ResponseEntity(resHistory,HttpStatus.OK)
    }
    @GetMapping("/highStudent")
    fun gettingHighestStudent():List<StudentHistoryDetails>{
        val highStudent:MutableList<StudentHistoryDetails> = ArrayList(historyRepo.highestStudent())
        highStudent.forEach{
            e -> println(e)
        }
        return highStudent
    }

}