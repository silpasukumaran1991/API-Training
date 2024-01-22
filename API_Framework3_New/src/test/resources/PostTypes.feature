Feature: Feature to test the post functionality
#Scenario 1
Scenario: Check if the admin user is able to create a user successfully
Given The user details which needs to be created
When The admin user submits the user details which will be created
Then The user should be created successfully


#Scenario 2
Scenario: Verify the register unsuccessfull
Given Verify the register unsuccessfull without using password 
When The admin user submits the user login details using missing password 
Then The verification should be unsuccessfull


#Scenario 3
Scenario: Check if the admin user is able to create a user using another method
Given Enter the user details which needs to be created
When The admin user submit the request to create a user 
Then The new user should be created successfully