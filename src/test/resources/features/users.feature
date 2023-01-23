Feature: The CRUD process is required for APIS

  Scenario: User creation required
    Given User requires to create new users
    When User information is sent
    Then Successful creation response is given

  Scenario: user query
    Given since you need to search for a user
    When User information is sent for the query
    Then User query is successful

  Scenario: update user

    Given since you need to update  a user
    When User information is sent for the update
    Then User update is successful
