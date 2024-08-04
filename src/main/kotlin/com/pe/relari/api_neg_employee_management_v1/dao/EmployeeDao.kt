package com.pe.relari.api_neg_employee_management_v1.dao

import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee

interface EmployeeDao {

    fun findAll() : List<Employee>

    fun findByEmployeeId(employeeId: Int): Employee

    fun save(employee: Employee)

}