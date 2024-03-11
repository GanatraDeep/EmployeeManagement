package com.example.employeemanagement

import android.util.Log
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Calendar
import java.util.Date
import kotlin.time.Duration.Companion.milliseconds

data class Employee(val code : Int, val name : String, val designation : String, val dob : String, val doj : String, val basicSalary : Int, val dept : String)
{
    override fun toString(): String
    {
        var hra: Double? = null;
        var da : Double? = null;

        if(basicSalary < 30000)
        {
            da = basicSalary * 0.6;
            hra = basicSalary * 0.2;
        }
        else if(basicSalary > 30000 && basicSalary < 45000)
        {
            da = basicSalary * 0.7;
            hra = basicSalary * 0.3;
        }
        else
        {
            da = basicSalary * 0.85;

            hra = basicSalary * 0.4;
        }

        val doj = SimpleDateFormat("dd-MM-yyyy").parse(doj);
        val currentDate = Calendar.getInstance().apply { time = Date() }
        val localDate = Calendar.getInstance().apply { time = doj }
        val exp = calculateExperienceInYears(localDate, currentDate);

        return "Employee(code='$code', name='$name', designation='$designation', dob=$dob, doj=$doj, basicSalary=$basicSalary, dept='$dept', hra=$hra, da=$da, exp=$exp)"
    }

    fun calculateExperienceInYears(startDate: Calendar, endDate: Calendar): Float {
        val yearsInDifference = endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR)
        val monthsInDifference = endDate.get(Calendar.MONTH) - startDate.get(Calendar.MONTH)
        val daysInDifference = endDate.get(Calendar.DAY_OF_MONTH) - startDate.get(Calendar.DAY_OF_MONTH)

        var experienceInYears = yearsInDifference

        if (monthsInDifference < 0 || (monthsInDifference == 0 && daysInDifference < 0)) {
            experienceInYears--
        }

        return experienceInYears.toFloat()
    }
}