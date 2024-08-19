package com.pe.relari.api_neg_employee_management_v1.model.entity

import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee
import com.pe.relari.api_neg_employee_management_v1.util.GenderCategory
import com.pe.relari.api_neg_employee_management_v1.util.JobTitleCategory
import java.time.LocalDate
import java.time.LocalDateTime
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Enumerated
import jakarta.persistence.EnumType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "EMPLOYEE")
data class EmployeeEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(length = 50, nullable = false)
    val fatherLastName: String = String(),

    @Column(length = 50, nullable = false)
    val motherLastName: String = String(),

    @Column(length = 50, nullable = false)
    val firstName: String = String(),

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    val jobTitle: JobTitleCategory = JobTitleCategory.DEVELOPER,

    @Enumerated(EnumType.STRING)
    @Column(length = 1, nullable = false)
    val gender: GenderCategory = GenderCategory.M,

    @Column(nullable = false)
    val salary: Double = 0.0,

    @Column(nullable = false)
    val isActive: Boolean = true,

    @Column(nullable = false, columnDefinition = "DATE")
    val birthdate: LocalDate = LocalDate.now(),

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    val creationDate: LocalDateTime = LocalDateTime.now()
) {
    constructor(employee: Employee): this(
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
}