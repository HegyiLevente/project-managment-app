-- INSERT INTO EMPLOYEE
INSERT INTO employee(employee_id, first_name, last_name, email_address) VALUES(1, 'Mike', 'Tyson', 'ironmyke@gmail.com');
INSERT INTO employee(employee_id, first_name, last_name, email_address) VALUES(2, 'John', 'Wick', 'johny@gmail.com');
INSERT INTO employee(employee_id, first_name, last_name, email_address) VALUES(3, 'Keanu', 'Reeves', 'goodman@gmail.com');
INSERT INTO employee(employee_id, first_name, last_name, email_address) VALUES(4, 'Bruce', 'Wayne', 'battsy@gmail.com');
INSERT INTO employee(employee_id, first_name, last_name, email_address) VALUES(5, 'Jo', 'Ker', 'joker@gmail.com');
INSERT INTO employee(employee_id, first_name, last_name, email_address) VALUES(6, 'Bruce', 'Willis', 'willare@gmail.com');
INSERT INTO employee(employee_id, first_name, last_name, email_address) VALUES(7, 'Margot', 'Robbie', 'marg@gmail.com');
INSERT INTO employee(employee_id, first_name, last_name, email_address) VALUES(8, 'Will', 'Smith', 'willnot@gmail.com');


-- INSERT INTO PROJECT
INSERT INTO project(project_id, name, stage, description) VALUES(1000, 'Rescue Johns dog', 'INPROGRESS', 'Some foolish dude did something to that poor animal, he is fucked');
INSERT INTO project(project_id, name, stage, description) VALUES(1001, 'Win the heavy weight title', 'COMPLETED', 'Aint nothin but peanut');
INSERT INTO project(project_id, name, stage, description) VALUES(1002, 'Steal some shit', 'NOTSTARTED', 'Do a big fucking plan');
INSERT INTO project(project_id, name, stage, description) VALUES(1003, 'Fight for the sin city', 'INPROGRESS', 'Lets see who is the bigger dog');


-- INSERT INTO THE JOIN TABLE
INSERT INTO project_employee VALUES(1000, 2);
INSERT INTO project_employee VALUES(1000, 3);
INSERT INTO project_employee VALUES(1000, 6);
INSERT INTO project_employee VALUES(1001, 1);
INSERT INTO project_employee VALUES(1002, 7);
INSERT INTO project_employee VALUES(1002, 8);
INSERT INTO project_employee VALUES(1003, 4);
INSERT INTO project_employee VALUES(1003, 2);
INSERT INTO project_employee VALUES(1002, 2);
INSERT INTO project_employee VALUES(1000, 8);
INSERT INTO project_employee VALUES(1002, 5);
INSERT INTO project_employee VALUES(1000, 5);










