package com.nilmani.jpqlprojectexample.repository

import com.nilmani.jpqlprojectexample.entity.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CourseRepository : JpaRepository<Course,Long> {
    @Query(" select c from Course  c")
    fun getAllCourse():List<Course>
    /**Get the student details between  student id 2 and 5*/
    @Query("select  distinct  c from Course c where c.studentId between 4 and 5")
    fun getStudentsCourseDetail():List<Course>
}