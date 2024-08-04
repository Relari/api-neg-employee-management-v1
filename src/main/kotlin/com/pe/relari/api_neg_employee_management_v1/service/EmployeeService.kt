package com.pe.relari.api_neg_employee_management_v1.service

import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee

interface EmployeeService {

    fun findAll() : List<Employee>

    fun findByEmployeeId(employeeId: Int): Employee

    fun save(employee: Employee)

    fun update(employee: Employee)

}