package com.nilmani.jpqlprojectexample.entity

import javax.persistence.*

@Entity
@Table(name="studentdetails")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long=-1,
    val name:String="",
    val email:String="",
    val phone:Long=-1,
)
