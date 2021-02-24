Feature: DOCINTACT Employee Feature



Scenario Outline: Successful login and Fill the details of employee and submit
Given user_enter <id> and <password>
Then Add_Employees
Then search_Employee
Then Active_Employee
Then Update_Employee and Status_change_Employee
Then Delete_Employee
Then signout
Examples:
				|      id         |       password      |
				|"Ogranization_id_user01"|"Ogranization_password_user01"|







		

		
		
