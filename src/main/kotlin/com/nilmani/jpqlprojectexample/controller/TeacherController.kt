package com.nilmani.jpqlprojectexample.controller

import com.nilmani.jpqlprojectexample.entity.Teacher
import com.nilmani.jpqlprojectexample.model.request.ReqTeacher
import com.nilmani.jpqlprojectexample.model.response.ResTeacher
import com.nilmani.jpqlprojectexample.repository.TeacherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/teachTest")
class TeacherController {
    @Autowired
    private lateinit var teachRopo:TeacherRepository

    @PostMapping("/add")
    fun addTeacher(@ModelAttribute request:ReqTeacher):ResponseEntity<*>{
//        val newTeacher = teachRopo.findById(request.)
        var newTeacher = Teacher(
            nameOfTeacher = request.nameOfTeacher,
            price = request.price,
            subject = request.subject,
            university = request.university,
        )
        val saveTeacher = teachRopo.save(newTeacher)
        val respTeacher = ResTeacher(
            saveTeacher.nameOfTeacher,
            saveTeacher.price,
            saveTeacher.subject,
            saveTeacher.university
        )
        return ResponseEntity(respTeacher,HttpStatus.OK)
    }
    /**Find the avrage proce of the teacher*/
    @GetMapping("/getAvg")
   fun getAveragePrice():Long{
       val avPrice =  teachRopo.findPriceAvrage()
        return avPrice
   }
    /**Get the Max price of the teacher*/
    @GetMapping("/maxPrice")
    fun getMaxPrice():Long{
        val maxPrice = teachRopo.getMaxPrice()
        return maxPrice
    }
    /**Get all the teacher name who teaches math*/
    @GetMapping("/exisingMath")
    fun getMathTeacher():List<Teacher>{
        val existingMath:MutableList<Teacher> = ArrayList(teachRopo.mathTeacher())
        existingMath.forEach { e -> println(e) }
        return existingMath
    }

    /**Find the teachers name and price  who charges highest price for  teaching */
//    @GetMapping("/gainful")
//    fun getTeacherNameAndPrice():List<Teacher>{
//        val getHighPriceName = teachRopo.getHighestSalary()
//        return getHighPriceName
//    }

}