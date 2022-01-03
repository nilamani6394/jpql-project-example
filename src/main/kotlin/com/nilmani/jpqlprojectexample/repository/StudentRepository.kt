package com.nilmani.jpqlprojectexample.repository

import com.nilmani.jpqlprojectexample.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student,Long> {

}