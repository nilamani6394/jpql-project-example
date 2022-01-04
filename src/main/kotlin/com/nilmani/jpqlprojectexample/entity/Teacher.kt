package com.nilmani.jpqlprojectexample.entity

import com.nilmani.jpqlprojectexample.enum.Subject
import com.nilmani.jpqlprojectexample.enum.University
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Teacher(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long=-1,
    val nameOfTeacher:String="",
    val price:Long=-1,
    val subject:Int = Subject.MATH.type,//List<Int> = listOf(Subject.MATH.type)
    val university:Int=University.OTHER.type
)
