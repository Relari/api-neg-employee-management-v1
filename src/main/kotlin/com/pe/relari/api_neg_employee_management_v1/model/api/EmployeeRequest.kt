package com.pe.relari.api_neg_employee_management_v1.model.api

import com.pe.relari.api_neg_employee_management_v1.util.EMPTY
import com.pe.relari.api_neg_employee_management_v1.util.REGEXP_DATE
import com.pe.relari.api_neg_employee_management_v1.util.REGEXP_SEX
import com.pe.relari.api_neg_employee_management_v1.util.REGEXP_JOBS
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern

data class EmployeeRequest(
    @NotBlank
    @NotNull
    val fatherLastName: String,
    @NotBlank
    @NotNull
    val motherLastName: String,
    @NotBlank
    @NotNull
    val firstName: String,
    @Pattern(regexp = REGEXP_JOBS)
    val jobTitle: String,
    @Pattern(regexp = REGEXP_SEX)
    val gender: String,
    @NotNull
    val salary: Double,
    @Pattern(regexp = REGEXP_DATE)
    val birthdate: String
)