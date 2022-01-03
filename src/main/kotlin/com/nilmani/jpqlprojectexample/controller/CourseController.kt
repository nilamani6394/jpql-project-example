package com.nilmani.jpqlprojectexample.controller

import com.nilmani.jpqlprojectexample.entity.Course
import com.nilmani.jpqlprojectexample.model.request.ReqCourse
import com.nilmani.jpqlprojectexample.model.response.ResCourse
import com.nilmani.jpqlprojectexample.repository.CourseRepository
import com.nilmani.jpqlprojectexample.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/course")
class CourseController {
    @Autowired
    private lateinit var courseRepo: CourseRepository
    @Autowired
    private lateinit var studentRepo:StudentRepository

    @PostMapping("/add")
    fun addCourse(@ModelAttribute request:ReqCourse):ResponseEntity<*>{
        val existingStudent = studentRepo.findById(request.studentId)
        if (existingStudent.isPresent){
            val newCourse = Course(
                studentId = request.studentId,
                stream = request.stream,
                honors = request.honors,
                university = request.university
            )
            val saveCourse = courseRepo.save(newCourse)
            val respCourse = ResCourse(
                saveCourse.studentId,
                saveCourse.stream,
                saveCourse.honors,
                saveCourse.university
            )
            return ResponseEntity(respCourse,HttpStatus.OK)
        }else{
            return ResponseEntity("No such student id exist",HttpStatus.NOT_FOUND)
        }
    }

    /**Get the Student course Details*/
    @GetMapping("/getAll")
    fun getAllCourses():Course{
        val existUsers:MutableList<Course> =ArrayList(courseRepo.getAllCourse())
        existUsers.forEach{e -> println(e)}
        return  Course()
    }
    /**Get the student details between some id  for eg 2 to 5*/
    @GetMapping("/betStudent")
    fun getDetailsOfStudentBetweenTwoId():MutableList<Course>{
        val existingStudent :MutableList<Course> = ArrayList(courseRepo.getStudentsCourseDetail())
        existingStudent.forEach{
            e -> println(e)
        }
        return existingStudent
    }

}

