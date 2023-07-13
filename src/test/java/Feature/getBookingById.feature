Feature: get Token

  Background:
    Given  token is generated

  Scenario:get by id's
    When Creates a new booking "createBooking"
    Then the status code of 'createbooking' Response is 200
    And Verifies booking details displayed properly
    When client retrieve the valid booking id
    Then the status code of 'getbookingById' Response is 200

  Scenario:invalid booking id
    When Creates a new booking "createBooking"
    Then the status code of 'createbooking' Response is 200
    And Verifies booking details displayed properly
    When client retrieve with invalid booking id
    Then the status code of 'getbookingById' Response is 404