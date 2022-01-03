package com.nilmani.jpqlprojectexample.model.request

import com.nilmani.jpqlprojectexample.enum.University

data class ReqCourse(
    val studentId:Long=-1,
    val stream:String="",
    val honors:String="",
    val university:Int= University.OTHER.type
)
