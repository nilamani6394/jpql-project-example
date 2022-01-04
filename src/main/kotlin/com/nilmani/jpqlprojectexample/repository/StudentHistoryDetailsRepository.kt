package com.nilmani.jpqlprojectexample.repository

import com.nilmani.jpqlprojectexample.entity.StudentHistoryDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StudentHistoryDetailsRepository : JpaRepository<StudentHistoryDetails,Long> {
    /**Find the instructor id who has many student*/
    @Query("select sh from StudentHistoryDetails sh  where sh.teacherId > 2")
    fun highestStudent():List<StudentHistoryDetails>
}