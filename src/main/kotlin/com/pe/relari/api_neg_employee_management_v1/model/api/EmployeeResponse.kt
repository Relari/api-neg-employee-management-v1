package com.pe.relari.api_neg_employee_management_v1.model.api

import io.swagger.v3.oas.annotations.media.Schema

data class EmployeeResponse(
     val idEmployee: Int,
     @Schema(
          description = "Representa el apellido paterno del empleado.",
          name = "fatherLastName",
          example = "Perez",
          implementation = String::class
     )
     val fatherLastName: String,

     @Schema(
          description = "Representa el apellido materno del empleado.",
          name = "motherLastName",
          example = "Mendoza",
          implementation = String::class
     )
     val motherLastName: String,

     @Schema(
          description = "Representa el nombre del empleado.",
          name = "firstName",
          example = "Ricardo",
          implementation = String::class
     )
     val firstName: String,

     @Schema(
          description = "Representa el cargo o posición del empleado en la empresa.",
          name = "jobTitle",
          example = "DEVELOPER",
          implementation = String::class
     )
     val jobTitle: String,

     @Schema(
          description = "Representa el género o sexo del empleado.",
          name = "gender",
          example = "M",
          implementation = String::class
     )
     val gender: String,

     @Schema(
          description = "Representa el salario o sueldo del empleado.",
          name = "salary",
          example = "1500",
          implementation = Double::class
     )
     val salary: Double,

     @Schema(
          description = "Representa el estado del empleado.",
          name = "isActive",
          example = "true",
          implementation = Boolean::class
     )
     val isActive: Boolean,

     @Schema(
          description = "Representa la fecha de nacimiento del empleado.",
          name = "birthdate",
          example = "03-05-1995",
          implementation = String::class
     )
     val birthdate: String
)