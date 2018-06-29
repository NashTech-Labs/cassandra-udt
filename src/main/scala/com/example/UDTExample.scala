package com.example

import com.datastax.driver.core.{ResultSet, Row}
import com.example.models.{Address, Employee}
import com.example.repository.EmployeeRepository
import play.api.libs.json.Json


object UDTExample extends App {

  val employeeRepository = new EmployeeRepository
  val address = Address(1234, "65A Block", "75D Block","Goa")
  val employee = Employee(address.employee_id,"Akhil",address,"12000")

  employeeRepository.insertEmployeeDetails(employee)

  val employeeDetails: ResultSet = employeeRepository.getEmployeeDetails(employee.employee_id)

  val row: Row = employeeDetails.one()
  println("Employee Details: " + Json.parse(row.getString(0)).as[Employee])
  employeeRepository.session.close()
  employeeRepository.cluster.close()
}
