package com.pe.relari.api_neg_employee_management_v1.model.domain

import com.pe.relari.api_neg_employee_management_v1.util.GenderCategory
import com.pe.relari.api_neg_employee_management_v1.util.JobTitleCategory
import java.time.LocalDate

data class Employee (
    var idEmployee: Int,
    var fatherLastName: String,
    var motherLastName: String,
    var firstName: String,
    var jobTitle: JobTitleCategory,
    var gender: GenderCategory,
    var salary: Double,
    var isActive: Boolean,
    val birthdate: LocalDate
) {

    fun mutateEmployee(employee: Employee) = Employee(
            this.idEmployee,
            if(employee.fatherLastName.isNullOrBlank()) this.fatherLastName else employee.fatherLastName,
            if(employee.motherLastName.isNullOrBlank()) this.motherLastName else employee.motherLastName,
            if(employee.firstName.isNullOrBlank()) this.firstName else employee.firstName,
            if(employee.jobTitle == null) this.jobTitle else employee.jobTitle,
            if(employee.gender == null) this.gender else employee.gender,
            if(employee.salary == null) this.salary else employee.salary,
            this.isActive,
            if(employee.birthdate == null) this.birthdate else employee.birthdate
    )

}