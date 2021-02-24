Feature: DOCINTACT MyFiles Page Features

Scenario Outline: Create a Folder
	Given user_enter <id> and <password> 
	Then Create a folder 
	Then signout
		
	Examples: 
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 
#		|"Ogranization_id_user01"|"Ogranization_password_user01"|


Scenario Outline: Upload a file through right click
	Given user_enter <id> and <password> 
	Then Right click on the folder for upload 
	Then signout
		
	Examples: 
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 
#		|"Ogranization_id_user01"|"Ogranization_password_user01"|

Scenario Outline: Move a folder to another folder through right click
	Given user_enter <id> and <password> 
	Then Right click on the folder and Move to folder
	Then signout
		
	Examples: 
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 

#		|"Ogranization_id_user01"|"Ogranization_password_user01"|


Scenario Outline: Open a file inside the folder through right click
	Given user_enter <id> and <password> 
	Then  Right click on the folder and open the file
	Then signout
		
	Examples: 
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 
#		|"Ogranization_id_user01"|"Ogranization_password_user01"|

Scenario Outline: Rename a folder through right click
	Given user_enter <id> and <password> 
	Then Right click on the folder and rename 
	Then signout
		
	Examples: 
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 

#		|"Ogranization_id_user01"|"Ogranization_password_user01"|


Scenario Outline: Add to favourite through right click
	Given user_enter <id> and <password> 
	Then Favourites_file
	Then signout

		Examples: 
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 
		#|"Ogranization_id_user01"|"Ogranization_password_user01"|
	#	|"Employe_id_user01"     |"Employe_password_user01"     |
	
	
Scenario Outline: Remove from favourite through right click
	Given user_enter <id> and <password> 
	Then Remove_favourite_file
	Then signout

		Examples: 
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 
		#|"Ogranization_id_user01"|"Ogranization_password_user01"|
	#	|"Employe_id_user01"     |"Employe_password_user01"     |
			

Scenario Outline: Share a folder through right click
	Given user_enter <id> and <password> 
	Then Right click on the folder for upload 
	Then signout
	Given user_enter <id> and <password> 
	Then Right click on the folder and click on share
	Then signout
		
	Examples: 
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 
#		|"Ogranization_id_user01"|"Ogranization_password_user01"|


Scenario Outline: Delete a folder through right click
	Given user_enter <id> and <password> 
	Then Right click on the folder and delete
	Then signout
		
	Examples: 
		|      id         |       password      | 
		| "Individual_id_user01" | "Individual_password_user01" | 
#		|"Ogranization_id_user01"|"Ogranization_password_user01"|






		

		
		
