package com.pe.relari.api_neg_employee_management_v1.dao.repository

import com.pe.relari.api_neg_employee_management_v1.model.entity.EmployeeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<EmployeeEntity, Int>