package com.pe.relari.api_neg_employee_management_v1.util

import com.pe.relari.api_neg_employee_management_v1.model.domain.Employee
import java.time.LocalDate

object Utils {

    fun buildEmployee(): Employee = Employee(
        1,
        "Perez",
        "Mendoza",
        "Ricardo",
        JobTitleCategory.DEVELOPER,
        GenderCategory.M,
        2500.0,
        true,
        LocalDate.now()
    )

}