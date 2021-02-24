Feature: DOCINTACT Upload Document  Feature 

Scenario Outline: Sign and upload a file through URL 
	Given user_enter <id> and <password> 
	Then Upload New File From Url
	Then signout
		
	Examples:
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 
		#|"Ogranization_id_user01"|"Ogranization_password_user01"|
	#	|"Employe_id_user01"     |"Employe_password_user01"     |


Scenario Outline: Sign and upload a file through local system
	Given user_enter <id> and <password> 
	Then Upload New File From local system
	Then signout
		
	Examples: 
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 
		#|"Ogranization_id_user01"|"Ogranization_password_user01"|
	#	|"Employe_id_user01"     |"Employe_password_user01"     |

		
Scenario Outline: Sign and upload a folder
	Given user_enter <id> and <password> 
	Then Upload New folder
	Then signout
		
	Examples: 
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 
		#|"Ogranization_id_user01"|"Ogranization_password_user01"|
	#	|"Employe_id_user01"     |"Employe_password_user01"     |
		