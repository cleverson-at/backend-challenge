Feature: Check the song suggestions based on the local temperature

  Scenario: Get Rock songs suggested
    Given the temperature is bellow 15 degrees Celsius
    When I check the song suggestions
    Then I get songs of the Rock category suggested
    
  Scenario: Get Classic songs suggested
    Given the temperature is greater than or equal to 15 degrees Celsius and lower than or equal to 20
    When I check the song suggestions
    Then I get songs of the Classic category suggested
    
  Scenario: Get Hip Hop songs suggested
    Given the temperature is greater than or equal to 21 degrees Celsius and lower than or equal to 30
    When I check the song suggestions
    Then I get songs of the Hip Hop category suggested
    
  Scenario: Get Party songs suggested
    Given the temperature is greater than 30 degrees Celsius
    When I check the song suggestions
    Then I get songs of the Party category suggested
