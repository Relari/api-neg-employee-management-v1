package com.pe.relari.api_neg_employee_management_v1.controller

import com.pe.relari.api_neg_employee_management_v1.model.api.EmployeeRequest
import com.pe.relari.api_neg_employee_management_v1.model.api.EmployeeResponse
import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee
import com.pe.relari.api_neg_employee_management_v1.util.Utility
import com.pe.relari.api_neg_employee_management_v1.util.GenderCategory
import com.pe.relari.api_neg_employee_management_v1.util.JobTitleCategory

object EmployeeMapper {

        fun mapEmployeeResponse(employee: Employee): EmployeeResponse = EmployeeResponse(
                employee.idEmployee,
                employee.fatherLastName,
                employee.motherLastName,
                employee.firstName,
                employee.jobTitle.name,
                employee.gender.name,
                employee.salary,
                employee.isActive,
                Utility.formatDate(employee.birthdate)
        )

        fun mapEmployee(employeeRequest: EmployeeRequest): Employee = Employee(
                0,
                employeeRequest.fatherLastName,
                employeeRequest.motherLastName,
                employeeRequest.firstName,
                JobTitleCategory.valueOf(employeeRequest.jobTitle),
                GenderCategory.valueOf(employeeRequest.gender),
                employeeRequest.salary,
                true,
                Utility.mapLocalDate(employeeRequest.birthdate)
        )

        fun mapEmployee(employeeId: Int, employeeRequest: EmployeeRequest): Employee = Employee(
                employeeId,
                employeeRequest.fatherLastName,
                employeeRequest.motherLastName,
                employeeRequest.firstName,
                JobTitleCategory.valueOf(employeeRequest.jobTitle),
                GenderCategory.valueOf(employeeRequest.gender),
                employeeRequest.salary,
                true,
                Utility.mapLocalDate(employeeRequest.birthdate)
        )

}