@CreateUser
Feature: Practice API Testing in GoRest website.
  Background:
    * def URL = 'https://gorest.co.in'
    * def UserResource = 'public/v2/users/'
    * def queryParam = {"access-token":'20298c6944fb2b8a2a7db37ca7a59ac27b5c50018c0d411c1ef7420ee90a1940'}
  @Post
  Scenario: Create a new user
    Given url URL
    And path UserResource
    And params queryParam
    * def requestBody = read("../resources/payload.json")
    And request requestBody
    When method POST
    Then status 201
    And print response

