package com.example.models

import play.api.libs.json.Json

case class Employee(employee_id: Int, name: String, address: Address, salary: String)

object Employee {
  implicit val format = Json.format[Employee]
}

