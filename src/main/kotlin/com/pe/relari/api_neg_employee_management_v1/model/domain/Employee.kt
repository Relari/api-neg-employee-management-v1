package com.pe.relari.api_neg_employee_management_v1.model.domain

import com.pe.relari.api_neg_employee_management_v1.model.entity.EmployeeEntity
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

    constructor(employeeEntity: EmployeeEntity): this(
        employeeEntity.id,
        employeeEntity.fatherLastName,
        employeeEntity.motherLastName,
        employeeEntity.firstName,
        employeeEntity.jobTitle,
        employeeEntity.gender,
        employeeEntity.salary,
        employeeEntity.isActive,
        employeeEntity.birthdate
    )

    fun mutateEmployee(employee: Employee) = this.copy(
        fatherLastName = employee.fatherLastName.ifBlank { fatherLastName },
        motherLastName = employee.motherLastName.ifBlank { motherLastName },
        firstName = employee.firstName.ifBlank { firstName },
        jobTitle = if (employee.jobTitle == jobTitle) jobTitle else employee.jobTitle,
        gender = if (employee.gender == gender) gender else employee.gender,
        salary = if (employee.salary == salary) salary else employee.salary,
        isActive = if (isActive == employee.isActive) isActive else employee.isActive,
        birthdate = if (birthdate == employee.birthdate) birthdate else employee.birthdate,
    )

}