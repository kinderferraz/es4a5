Feature: Busca Github
  Scenario: Busca por usuario
    Given Eu estou no site "http://github.com"
    When Eu procuro por "kinderferraz"
    And Eu clico no link com descricao "menu-item" e "users"
    Then Eu deveria encontrar um link com descricao "kinderferraz"

  Scenario: Busca por repositorio
    Given Eu estou no site "http://github.com"
    When Eu procuro por "cucumber"
    Then Eu deveria encontrar um link com descricao "cucumber-jvm"
