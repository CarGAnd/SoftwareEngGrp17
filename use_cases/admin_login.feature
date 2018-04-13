Feature: Admin login
	Description: The administrator logs into the system and also logs out
	Actor: Administrator
	
Scenario: Administrator can login
	Given that the administrator is not logged in
	When the adminstrator enters the password "adminadmin" and the ID "admin"
	Then the adminstrator is logged in
	
#Scenario: Administrator has the wrong password
#	Given that the administrator is not logged in
#	And the adminstrator enters the password "wrong password" and the ID "admin"
#	Then the administrator is not logged in
