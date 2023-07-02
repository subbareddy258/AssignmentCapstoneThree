Feature:Pets
  Background:
    Given Token genrated

  Scenario:Pets
    And Create a "newpet"
    When I update the "updatedpet"
    Then I get pet by status
    And I get pet by Id
    Then update pet form data
    And Delete pet from store

  Scenario:Place an order for pets in Stores
    And Create a store "placeOrderPet"
    When I find pet by orderId
    Then Delete purchase order by Id
    And Return the inventory order


  Scenario:Operations about user
    And Create a new "user"
    Then user login into store
    Then get by userName
    And Update the "updateuser"
    Then delete the user and logout from the system




