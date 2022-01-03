package com.nilmani.jpqlprojectexample.entity

import com.nilmani.jpqlprojectexample.enum.University
import javax.persistence.*

@Entity
@Table(name = "coursedetails")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long=-1,
    val studentId:Long=-1,
    val stream:String="",
    val honors:String="",
    val university:Int=University.OTHER.type
)
