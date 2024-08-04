package com.pe.relari.api_neg_employee_management_v1.model.api

data class EmployeeResponse(
     val idEmployee: Int,
     val fatherLastName: String,
     val motherLastName: String,
     val firstName: String,
     val position: String,
     val sex: String,
     val salary: Double,
     val isActive: Boolean,
     val birthdate: String
)