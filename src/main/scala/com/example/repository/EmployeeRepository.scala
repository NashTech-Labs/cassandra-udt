package com.example.repository

import com.datastax.driver.core.{Cluster, ResultSet}
import com.example.models.Employee
import play.api.libs.json.Json
import com.example.constants.Constant._

class EmployeeRepository {

  val cluster = Cluster.builder.addContactPoint("127.0.0.1").build()
  val session = cluster.connect()

  session.execute(KEYSPACE_TABLE)
  session.execute(ADDRESS_TABLE)
  session.execute(EMPLOYEE_TABLE)

  def insertEmployeeDetails(employee: Employee): ResultSet = {
    val employeeJsonString = Json.toJson(employee).toString()
    session.execute(s"INSERT INTO udt.employee JSON '$employeeJsonString';")
  }

  def getEmployeeDetails(employeeId: Int): ResultSet = {
    session.execute("SELECT JSON * FROM udt.employee WHERE employee_id=" + employeeId)
  }

  def deleteEmployeeDetails(employeeId: Int): ResultSet = {
    session.execute("DELETE * from udt.employee WHERE employee_id =" + employeeId)
  }
}

