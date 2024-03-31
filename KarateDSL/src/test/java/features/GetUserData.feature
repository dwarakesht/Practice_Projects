@GetUserData
Feature: Practice API Testing in GoRest website.

  Background:
    * def URL = 'https://gorest.co.in'
    * def UserResource = 'public/v2/users/'
    * def queryParam = {"access-token":'20298c6944fb2b8a2a7db37ca7a59ac27b5c50018c0d411c1ef7420ee90a1940'}
    * def UserCreationResponse = call read("CreateUser.feature")
    * def UserId = UserCreationResponse.response.id
  @Get @Ignore
  Scenario: Get All Users
    Given url URL
    And path UserResource
    When method GET
    Then status 200
    And print response
    And match response.id == UserId
  @Get
  Scenario: Get user by ID
    Given url URL
    And path UserResource + UserId
    When method GET
    Then status 200
    And print response
    And match response.id == UserId

