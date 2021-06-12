Feature: Oi Mundo

  O mundo é gentil?

  Scenario: Minha saudação e "Oi"
    Given Minha saudação e "Oi"
    When eu executo minha aplicação
    Then ela deveria responder com "Oi mundo"