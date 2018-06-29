package com.example.models

import play.api.libs.json.Json

case class Address(employee_id: Int, residence_address: String, office_address: String, city: String)
object Address {
  implicit val format = Json.format[Address]
}
