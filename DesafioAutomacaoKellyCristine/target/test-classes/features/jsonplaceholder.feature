Feature: JSONPlaceholder Automation
  Scenario: Validar os dados do objeto com id = 6
    Given que eu acesse a pagina inicial do JSONPlaceholder
    When eu acessar o menu Guide
    And eu navegar ate a pagina de albuns
    Then eu capturo os dados exibidos e salvo num array JSON
    And eu valido os dados do objeto com id = 6
