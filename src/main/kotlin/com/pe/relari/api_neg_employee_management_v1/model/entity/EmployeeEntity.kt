package com.pe.relari.api_neg_employee_management_v1.model.entity

import com.pe.relari.api_neg_employee_management_v1.util.GenderCategory
import com.pe.relari.api_neg_employee_management_v1.util.JobTitleCategory
import com.pe.relari.api_neg_employee_management_v1.util.EMPTY
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

    @Column(name = "fatherLastName", length = 50, nullable = false)
    val fatherLastName: String = EMPTY,

    @Column(name = "motherLastName", length = 50, nullable = false)
    val motherLastName: String = EMPTY,

    @Column(name = "firstName", length = 50, nullable = false)
    val firstName: String = EMPTY,

    @Enumerated(EnumType.STRING)
    @Column(name = "jobTitle", length = 50, nullable = false)
    val jobTitle: JobTitleCategory = JobTitleCategory.DEVELOPER,

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 1, nullable = false)
    val gender: GenderCategory = GenderCategory.M,

    @Column(name = "salary", nullable = false)
    val salary: Double = 0.0,

    @Column(name = "isActive", nullable = false)
    val isActive: Boolean = true,

    @Column(name = "birthdate", nullable = false, columnDefinition = "DATE")
    val birthdate: LocalDate = LocalDate.now(),

    @Column(name = "creationDate", nullable = false, columnDefinition = "TIMESTAMP")
    val creationDate: LocalDateTime = LocalDateTime.now()
)