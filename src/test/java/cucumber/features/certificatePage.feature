Feature: Check certificate

  Scenario Outline: Certificate isn't exist
    When search certificate number:<certNum>
    Examples:
      | certNum |
      | 11111   |
      | 2222222 |
      | 333333  |
      | 444     |







