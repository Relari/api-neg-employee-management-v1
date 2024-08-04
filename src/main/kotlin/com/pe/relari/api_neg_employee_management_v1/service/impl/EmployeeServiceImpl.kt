package com.pe.relari.api_neg_employee_management_v1.service.impl

import com.pe.relari.api_neg_employee_management_v1.dao.EmployeeDao
import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee
import com.pe.relari.api_neg_employee_management_v1.service.EmployeeService
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(private val employeeDao: EmployeeDao) : EmployeeService {

    override fun findByEmployeeId(employeeId: Int): Employee = employeeDao.findByEmployeeId(employeeId)

    override fun findAll(): List<Employee> = employeeDao.findAll()

    override fun save(employee: Employee) = employeeDao.save(employee)

    override fun update(employee: Employee) {
       val employeeFound: Employee = employeeDao.findByEmployeeId(employee.idEmployee)
           .mutateEmployee(employee)
        employeeDao.save(employeeFound)
    }

}