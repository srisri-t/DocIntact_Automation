Feature: DOCINTACT Department Feature



Scenario Outline: Successful login and Fill the details of department and submit
Given user_enter <id> and <password>
Then Add_Department
Then signout
Examples:
				|      id         |       password      |
				|"Ogranization_id_user01"|"Ogranization_password_user01"|







		

		
		
