FoodCourt Microservices

## Architecture

Hexagonal Architecture

## Dependencies

- Spring Boot
- Lombok
- MapStruct
- Spring Security
- JWT

## Current Functionalities

- Create Owner
- Create Restaurant
- Create Plate
- Update Plate
- JWT Authorization and Authentication
- Create Employee
- Enable/Unable Plate
- Create Client
- List Restaurant
- List Plate
- Create Order
- List Order

## Changelog

v1.0.2

- Modified mail existence validation.
- Added Qualifier for client use case.

v1.0.3

- Modified restaurant controller for adding listing restaurants route.
- Added Qualifier for list restaurant use case.

v1.0.4

- Modified plate controller for adding listing plates route.
- Added Qualifier for list plate use case.

v1.0.5

- Added Order management (model,DTO, entity, handler, repository, service, controller, adapter, UseCase).
- Added Qualifier for creating order.

v1.0.6

- Added order listing, filtering by status and number of records to show
- Added Qualifier for listing order
- Modified employee creation for saving employee's id on restaurant data.

v1.0.7

- Added order assignment to an employee from the restaurant which took the order.
- Added Qualifier for assign order