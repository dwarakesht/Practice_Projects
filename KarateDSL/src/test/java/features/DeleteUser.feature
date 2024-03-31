@DeleteUser
Feature: Practice API Testing in GoRest website.

  Background:
    * def URL = baseURl
    * def UserResource = 'public/v2/users/'
    * def queryParam = {"access-token":'20298c6944fb2b8a2a7db37ca7a59ac27b5c50018c0d411c1ef7420ee90a1940'}
    * def UserCreationResponse = call read("CreateUser.feature")
    * def UserId = UserCreationResponse.response.id
    * print UserId

  Scenario: Delete user by ID
    Given url URL
    And path UserResource + UserId
    And params queryParam
    When method DELETE
    Then status 204

