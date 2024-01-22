Feature: Feature to test the get functionality
#Scenario 1
Scenario: Verify the user is able to get single user details successfully
Given The system should shows single user details
When Hit the get single user api 
Then The single users details should retrieved successfully


#Scenario 2

Scenario: Check if the admin user is able to get user details successfully
Given The users whose details need to be retrieved
When The admin user submits the users whose details need to be retrieved 
Then The users details should be retrieved successfully


#Scenario 3

Scenario: Check if the admin user is not able to see single user 
Given The resource url which need to be retrieved
When The admin user submits the url
Then The user details should not be shown 