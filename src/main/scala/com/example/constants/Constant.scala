package com.example.constants

object Constant {

  val KEYSPACE_TABLE = "CREATE KEYSPACE IF NOT EXISTS udt WITH REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor' : 1 };"
  val ADDRESS_TABLE = "CREATE TYPE IF NOT EXISTS udt.address (employee_id int, residence_address text, office_address text,city text);"
  val EMPLOYEE_TABLE = "CREATE TABLE IF NOT EXISTS udt.employee (employee_id int PRIMARY KEY,name text,address frozen<address>,salary text);"
}
