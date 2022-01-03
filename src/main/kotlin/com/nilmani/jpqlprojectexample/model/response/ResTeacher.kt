package com.nilmani.jpqlprojectexample.model.response

import com.nilmani.jpqlprojectexample.enum.Subject
import com.nilmani.jpqlprojectexample.enum.University

data class ResTeacher(
    val nameOfTeacher:String="",
    val price:Long=-1,
    val subject:Int= Subject.MATH.type,
    val university:Int= University.OTHER.type
)
