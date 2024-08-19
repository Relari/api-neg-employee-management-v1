package com.pe.relari.api_neg_employee_management_v1.dao.impl

import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee
import com.pe.relari.api_neg_employee_management_v1.model.entity.EmployeeEntity
import java.time.LocalDateTime

object EmployeeMapper {

        fun mapEmployeeEntity(employee: Employee): EmployeeEntity = EmployeeEntity(
                employee.idEmployee,
                employee.fatherLastName,
                employee.motherLastName,
                employee.firstName,
                employee.jobTitle,
                employee.gender,
                employee.salary,
                employee.isActive,
                employee.birthdate,
                LocalDateTime.now()
        )

        fun mapEmployee(employeeEntity: EmployeeEntity): Employee = Employee(
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

}