package com.pe.relari.api_neg_employee_management_v1.service.impl

import com.pe.relari.api_neg_employee_management_v1.dao.EmployeeDao
import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee
import com.pe.relari.api_neg_employee_management_v1.util.Utils
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class EmployeeServiceImplTest {

    @InjectMocks
    lateinit var employeeService: EmployeeServiceImpl

    @Mock
    lateinit var employeeDao: EmployeeDao

    @BeforeEach
    fun init() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun findByEmployeeId() {

        val employee: Employee = Utils.buildEmployee()

        Mockito.`when`(employeeDao.findByEmployeeId(Mockito.anyInt()))
            .thenReturn(employee)

        val employeeResponse: Employee = employeeService.findByEmployeeId(1)
        assertNotNull(employeeResponse)
    }

    @Test
    fun findAll() {

        val employees = listOf(Utils.buildEmployee())

        Mockito.`when`(employeeDao.findAll())
            .thenReturn(employees)

        val employeeResponses = employeeService.findAll()
        assertNotNull(employeeResponses)
    }

    @Test
    fun save() {
    }
}