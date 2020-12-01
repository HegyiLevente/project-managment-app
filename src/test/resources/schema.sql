CREATE SEQUENCE IF NOT EXISTS project_seq;

CREATE TABLE IF NOT EXISTS project(
	project_id BIGINT NOT NULL DEFAULT NEXTVAL('project_seq'),
	name VARCHAR(50) NOT NULL,
	stage VARCHAR(50) NOT NULL,
	description VARCHAR(200) NOT NULL,
	
	CONSTRAINT PK_project PRIMARY KEY(project_id)
);

CREATE SEQUENCE IF NOT EXISTS employee_seq;

CREATE TABLE IF NOT EXISTS employee(
	employee_id BIGINT NOT NULL DEFAULT NEXTVAL('employee_seq'),
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email_address VARCHAR(50) NOT NULL,
	
	CONSTRAINT PK_employee PRIMARY KEY(employee_id)
);

CREATE TABLE IF NOT EXISTS project_employee(
	project_id BIGINT NOT NULL,
	employee_id BIGINT NOT NULL,
	
	CONSTRAINT FK_ProjectEmployee FOREIGN KEY(project_id) REFERENCES project(project_id),
	CONSTRAINT FK_EmployeeProject FOREIGN KEY(employee_id) REFERENCES employee(employee_id)
);