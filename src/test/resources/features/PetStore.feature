@ConsultaMascota
Feature: Servivio de Store de PetStore
  @Scenario1
  Scenario Outline: Crear una orden de una nueva mascota
    Given Estoy en la tienda
    When Hago un post de orden de mascota con id <ID>, petId <PetID>, quantity <Quantity>, shipDate "2024-06-30T00:00:34.940+0000", status "placed", complete "false"
    Then valido el codigo de respuesta sea 200
    And valido el body del response tiene "petId" con valor <PetID>
    Examples:
      | ID | PetID |  Quantity |
      | 10 |   5   |     2   |
      | 50 |   6   |     5   |
      | 120 |  9   |     3   |
      | 135 |  8   |     1   |


  @Scenario2
  Scenario Outline: Consulta una orden de Mascota
    Given Estoy en la tienda
    When consulto la orden de mascota de ID <ID>
    Then valido el codigo de respuesta sea 200
    And valido el body del response de consulta tiene "id" con valor <ID>
    Examples:
      | ID |
      | 10 |
      | 50 |
      | 120 |
      | 135 |
