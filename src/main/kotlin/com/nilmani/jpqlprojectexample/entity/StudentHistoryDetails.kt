package com.nilmani.jpqlprojectexample.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class StudentHistoryDetails(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long=-1,
    val studentId:Long=-1,
    val courseId:Long=-1,
    val teacherId:Long=-1
)
