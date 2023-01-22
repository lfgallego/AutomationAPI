Feature: The CRUD process is required for APIS

  Scenario Outline: User creation required
    Given User requires to create new users
    When User information is sent "<name>" "<job>"
    Then Successful creation response is given
    Examples:
    |name|job|
    |Felipe |Automatizador   |