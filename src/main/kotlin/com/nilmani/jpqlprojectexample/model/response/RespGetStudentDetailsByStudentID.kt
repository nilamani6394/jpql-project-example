package com.nilmani.jpqlprojectexample.model.response

import com.nilmani.jpqlprojectexample.enum.University

data class RespGetStudentDetailsByStudentID(
    val studentId:Long=-1,
    val stream:String="",
    val honors:String="",
    val university:Int= University.OTHER.type
)
