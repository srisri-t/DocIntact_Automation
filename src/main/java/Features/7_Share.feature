Feature: DOCINTACT Shared Features  

Scenario Outline: Add Signature field and share to user 2
#	Given user_enter <id> and <password> 
#	Then Upload New File From Url 
#	Then open file and add sign and share to all users2 
#	Then signout
	Given user_enter <id2> and <password2> 
	Then open shared file and add sign and submit
	Then signout	
		
			Examples: 
		|      id         |       password      | id2 | password2| 
		| "Individual_id_user01" | "Individual_password_user01" |  "Individual_id_user02" | "Individual_password_user02" |
		
#Scenario Outline: Add Template with Signature field and share to user 2
#	Given user_enter <id> and <password> 
#	Then Upload New File From Url 
#	Then open file and add template 
#	Then signout
#	Given user_enter <id2> and <password2> 
#	Then open shared file and add sign and submit
#	Then signout
#	
#		Examples: 
#		|      id         |       password      | id2 | password2| 
#		| "Individual_id_user01" | "Individual_password_user01" |  "Individual_id_user02" | "Individual_password_user02" |
#	
#	
#Scenario Outline: Individual user01 share file to user02 for review 
#	Given user_enter <id> and <password> 
#	Then Upload New File From Url
#	Then open file and share for review 
#	Then signout
#	Given user_enter <id2> and <password2> 
#	Then open shared file and review the file 
#	Then signout
#	
#	
#		Examples: 
#		|      id         |       password      | id2 | password2| 
#		| "Individual_id_user01" | "Individual_password_user01" |  "Individual_id_user02" | "Individual_password_user02" |
#		
#Scenario Outline: Add Signature field and share to user 2
#	Given user_enter <id> and <password> 
#	Then Upload New File From Url 
#	Then open file and add sign and share_organization 
#	Then signout
#	Given user_enter <id2> and <password2> 
#	Then open shared file and add sign and submit
#	Then signout	
#		
#			Examples: 
#		|      id         |       password      | id2 | password2| 
#		|"Ogranization_id_user01"|"Ogranization_password_user01"|"Employe_id_user01"|"Employe_password_user01"|
#
#
##Upload a file through local system
#
#Scenario Outline: Add Signature field and share to user 2
#	Given user_enter <id> and <password> 
#	Then Upload New File From local system
#	Then open file and add sign and share to all users2 
#	Then signout
#	Given user_enter <id2> and <password2> 
#	Then open shared file and add sign and submit
#	Then signout	
#		
#			Examples: 
#		|      id         |       password      | id2 | password2| 
#		| "Individual_id_user01" | "Individual_password_user01" |  "Individual_id_user02" | "Individual_password_user02" |
#		
#Scenario Outline: Add Template with Signature field and share to user 2
#	Given user_enter <id> and <password> 
#	Then Upload New File From local system 
#	Then open file and add template 
#	Then signout
#	Given user_enter <id2> and <password2> 
#	Then open shared file and add sign and submit
#	Then signout
#	
#		Examples: 
#		|      id         |       password      | id2 | password2| 
#		| "Individual_id_user01" | "Individual_password_user01" |  "Individual_id_user02" | "Individual_password_user02" |
#	
#	
#Scenario Outline: Individual user01 share file to user02 for review 
#	Given user_enter <id> and <password> 
#	Then Upload New File From local system
#	Then open file and share for review 
#	Then signout
#	Given user_enter <id2> and <password2> 
#	Then open shared file and review the file 
#	Then signout
#	
#	
#		Examples: 
#		|      id         |       password      | id2 | password2| 
#		| "Individual_id_user01" | "Individual_password_user01" |  "Individual_id_user02" | "Individual_password_user02" |
#	