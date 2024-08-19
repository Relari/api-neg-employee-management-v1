package com.pe.relari.api_neg_employee_management_v1.dao.impl

import com.pe.relari.api_neg_employee_management_v1.dao.EmployeeDao
import com.pe.relari.api_neg_employee_management_v1.dao.repository.EmployeeRepository
import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee
import com.pe.relari.api_neg_employee_management_v1.model.entity.EmployeeEntity
import org.springframework.stereotype.Component
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Component
class EmployeeDaoImpl(private val employeeRepository: EmployeeRepository) : EmployeeDao {

    val log: Logger = LoggerFactory.getLogger(EmployeeDaoImpl::class.java.name)

    override fun findAll(): List<Employee> = employeeRepository.findAll()
            .map { Employee(it) }

    override fun findByEmployeeId(employeeId: Int): Employee = employeeRepository.findById(employeeId)
        .map { Employee(it) }
        .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found") }

    override fun save(employee: Employee) {
        val employeeEntity = EmployeeEntity(employee)
        employeeRepository.save(employeeEntity)
    }

}