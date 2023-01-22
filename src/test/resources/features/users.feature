Feature: The CRUD process is required for APIS

  Scenario: User creation required
    Given User requires to create new users
    When User information is sent
    Then Successful creation response is given
