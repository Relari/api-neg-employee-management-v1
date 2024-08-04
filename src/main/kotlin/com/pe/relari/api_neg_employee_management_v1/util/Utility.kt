package com.pe.relari.api_neg_employee_management_v1.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

const val EMPTY: String = ""

const val REGEXP_ONLY_NUMBER: String = "[0-9]*"
const val REGEXP_SEX: String = "M|F"
const val REGEXP_DATE: String = "[0-9]{2}-[0-9]{2}-[0-9]{4}"
const val REGEXP_JOBS: String = "SCRUM_MASTER|TEAM_LEAD|DEVELOPER|MANAGER|ARCHITECT"

const val DATE_FORMAT: String = "dd-MM-yyyy"
const val DATETIME_FORMAT: String = "dd-MM-yyyy HH:mm"

val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT)
val DATETIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);

class Utility {

    companion object {
        fun formatDate(date: LocalDate): String = date.format(DATE_FORMATTER)

        fun mapLocalDate(date: String): LocalDate = LocalDate.parse(date, DATE_FORMATTER)

        fun formatDatetime(datetime: LocalDateTime): String = datetime.format(DATETIME_FORMATTER)

    }
}
