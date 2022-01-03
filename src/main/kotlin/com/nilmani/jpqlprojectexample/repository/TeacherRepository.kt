package com.nilmani.jpqlprojectexample.repository

import com.nilmani.jpqlprojectexample.entity.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TeacherRepository : JpaRepository<Teacher,Long> {
    /**Find the avrage of the price */
    @Query("select  AVG (t.price) from Teacher t")
    fun findPriceAvrage():Long
    /**Find the max price */
    @Query("select max (t.price) from  Teacher t ")
    fun getMaxPrice():Long
    /**Find the teachers name and price  who charges highest price for  teaching */
//    @Query("select MAX (t.price) from Teacher t where t.nameOfTeacher= :nameOfTeacher")
//    fun getHighestSalary(@Param("nameOfTeacher")nameOfTeacher:String):List<Teacher>
    /**Write Jpql query to find the teachers name who teach Math*/
    @Query("select t.nameOfTeacher from Teacher t where t.subject=1")
    fun mathTeacher():List<Teacher>
//    fun mathTeacher():List<Teacher>
    /**Find the Price and Teacher Name*/
}