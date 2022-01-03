package com.nilmani.jpqlprojectexample.model.request

import com.nilmani.jpqlprojectexample.enum.Subject
import com.nilmani.jpqlprojectexample.enum.University

data class ReqTeacher(
    val nameOfTeacher:String="",
    val price:Long=-1,
    val subject:Int= Subject.MATH.type,
    val university:Int= University.OTHER.type
)
