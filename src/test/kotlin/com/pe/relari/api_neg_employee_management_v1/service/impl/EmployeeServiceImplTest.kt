package com.pe.relari.api_neg_employee_management_v1.service.impl

import com.pe.relari.api_neg_employee_management_v1.dao.EmployeeDao
import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee
import com.pe.relari.api_neg_employee_management_v1.util.GenderCategory
import com.pe.relari.api_neg_employee_management_v1.util.JobTitleCategory
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.time.LocalDate

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

        val employee = Employee(
            1, "Perez","Mendoza","Ricardo",JobTitleCategory.DEVELOPER,GenderCategory.M,2500.0,true, LocalDate.now()
        )

        Mockito.`when`(employeeDao.findByEmployeeId(Mockito.anyInt()))
            .thenReturn(employee)

        val employeeResponse: Employee = employeeService.findByEmployeeId(1)
        assertNotNull(employeeResponse)
    }

    @Test
    fun findAll() {

        val employees = listOf(Employee(
                1, "Perez","Mendoza","Ricardo",JobTitleCategory.DEVELOPER,GenderCategory.M,2500.0,true, LocalDate.now()
        ))

        Mockito.`when`(employeeDao.findAll())
            .thenReturn(employees)

        val employeeResponses = employeeService.findAll()
        assertNotNull(employeeResponses)
    }

    @Test
    fun save() {
    }
}