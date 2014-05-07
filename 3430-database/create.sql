CREATE TABLE department
	(department_name VARCHAR(20),
	department_number INT,
	manager_ssn INT,
	manager_start_date DATE
)


CREATE TABLE dependent
	(employee_ssn INT,
	dependent_name VARCHAR(20),
	sex ENUM('M','F'),
	dependent_name VARCHAR(20),
	birthdate DATE,
	relationship VARCHAR(20)
)

CREATE TABLE employee
	(first_name VARCHAR(20), 
	middle_name  VARCHAR(20), 
	last_name  VARCHAR(20), 
	employee_ssn  INT,
	birthdate DATE,
	address  VARCHAR(20), 
	sex  ENUM('M','F'),
	salary  decimal(8, 2),
	supervisor_ssn  INT,
	department_number VARCHAR(20)
)

CREATE TABLE project
	(project_name VARCHAR(20), 
	project_number INT,
	project_location VARCHAR(20), 
	department_number INT
)

CREATE TABLE employee
	(employee_ssn INT, 
	project_number INT,
	hours INT
)