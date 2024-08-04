package com.pe.relari.api_neg_employee_management_v1.controller

import com.pe.relari.api_neg_employee_management_v1.util.REGEXP_ONLY_NUMBER

import com.pe.relari.api_neg_employee_management_v1.model.api.EmployeeRequest
import com.pe.relari.api_neg_employee_management_v1.model.api.EmployeeResponse
import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee
import com.pe.relari.api_neg_employee_management_v1.service.EmployeeService
import jakarta.validation.Valid
import org.intellij.lang.annotations.Pattern
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${application.api.path}")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun findAll() = employeeService.findAll()
            .map { EmployeeMapper.mapEmployeeResponse(it) }

    @GetMapping("/{id}")
    fun findByEmployeeId(
            @Pattern(value = REGEXP_ONLY_NUMBER)
            @PathVariable("id") id: Int): EmployeeResponse {
        val employee: Employee = employeeService.findByEmployeeId(id)
        return EmployeeMapper.mapEmployeeResponse(employee)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(
            @RequestBody @Valid employeeRequest: EmployeeRequest) {
        val employee: Employee = EmployeeMapper.mapEmployee(employeeRequest)
        employeeService.save(employee)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(
            @Pattern(value = REGEXP_ONLY_NUMBER)
            @PathVariable("id") id: Int,
            @RequestBody @Valid employeeRequest: EmployeeRequest) {
        val employee: Employee = EmployeeMapper.mapEmployee(id, employeeRequest)
        employeeService.update(employee)
    }

}