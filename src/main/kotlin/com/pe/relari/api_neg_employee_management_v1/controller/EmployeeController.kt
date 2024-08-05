package com.pe.relari.api_neg_employee_management_v1.controller

import com.pe.relari.api_neg_employee_management_v1.model.api.EmployeeRequest
import com.pe.relari.api_neg_employee_management_v1.model.api.EmployeeResponse
import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee
import com.pe.relari.api_neg_employee_management_v1.service.EmployeeService
import com.pe.relari.api_neg_employee_management_v1.util.REGEXP_ONLY_NUMBER
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.intellij.lang.annotations.Pattern
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@Tag(name = "Employee", description = "Employee Controller")
@OpenAPIDefinition(
    info = Info(
        title = "Employee API",
        version = "\${application.info.version}",
        description = "\${application.info.description}"
    )
)
@RestController
@RequestMapping("\${application.api.path}")
class EmployeeController(private val employeeService: EmployeeService) {

    @Operation(
        summary = "Listado de Empleados",
        method = "GET",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Retorna todos los Empleados",
                content = [
                    Content(
                        array = ArraySchema(
                            schema = Schema(
                                implementation = EmployeeResponse::class
                            )
                        ),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                ]
            )
        ]
    )
    @GetMapping
    fun findAll(): List<EmployeeResponse> = employeeService.findAll()
            .map { EmployeeMapper.mapEmployeeResponse(it) }

    @Operation(
        summary = "Obtiene la informacion de un empleado.",
        method = "GET",
        parameters = [
            Parameter(
                description = "Id del Empleado",
                name = "id",
                `in` = ParameterIn.PATH,
                example = "1",
                required = true
            )
        ],
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Muestra al empleado por su ID.",
                content = [
                    Content(
                        schema = Schema(implementation = EmployeeResponse::class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
                ]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Error producido porque no encuentra al empleado.",
                content = [Content()]
            )
        ]
    )
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