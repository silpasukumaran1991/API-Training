Feature: Feature to test the Delete User functionality

#Scenario 1
Scenario: Check if the admin user is able to delete user details successfully
Given The user details that need to be deleted
When The admin user submits the user details to delete
Then The user details should get deleted successfully
