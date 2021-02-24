Feature: DOCINTACT Login Feature


Scenario Outline: Successful login and navigate to all pages and signout
Given user_enter <id> and <password>
Then Verify all pages of navigation
Then signout
Examples:
				|      id         |       password      |
				| "Individual_id_user01" | "Individual_password_user01" |
#    			|"Ogranization_id_user01"|"Ogranization_password_user01"|
# 				|"Employe_id_user01"     |"Employe_password_user01"     |


Scenario: Forget and ResetPassword
Then forget_password

Scenario Outline: Successful login  and changepassword and signout
Given user_enter <id1> and <password1>
Then change_password
Then signout
Examples:
			 |      id1         |       password1     |
			 | "Individual_id_user01" | "Individual_password_user01" |

Scenario Outline: Successful login  and re_changepassword and signout
Given user_enter <id> and <password>
Then re_change_password
Then signout
Examples:
			 |      id         |       password     |
			 | "Individual_id_user01" | "change_password" |


#Scenario: social icons login
#Then twitter_login
#Then signout
#Then facebook_login
#Then signout
#Then google_login
#Then signout