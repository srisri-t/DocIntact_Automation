Feature: DOCINTACT Landing Page Links Feature


Scenario: Header links validation
Then Validation Header links in home page
#
#Scenario: Headerlinks page validation
#Then Validation Header links Button in home page
#
#Scenario: Footer links validation
#Then Validation Footer links in home page


Scenario Outline: Verify the document after submission
	Given user_enter <id> and <password>
#	Then Upload New File From Url
	Then open file and add sign and share to all users2
#	Then signout
#	Given user_enter <id2> and <password2>
#	Then open shared file and add sign and submit
#	Then signout
#	Given user_enter <id> and <password>
#	Then open file and download
#	Then signout
#
#
			Examples:
		|      id         |       password      | id2 | password2|
		| "Individual_id_user01" | "Individual_password_user01" |  "Individual_id_user02" | "Individual_password_user02" |
#
##Scenario: Verify the document
##Then open file and Verify
