Feature: Expert Tunisie Footer

@Footer
Scenario: Verify footer sections and links

    Given user opens chrome browser

    When user opens Expert Tunisie website

    Then footer should be displayed

    And footer should contain all sections

    And footer links should be displayed