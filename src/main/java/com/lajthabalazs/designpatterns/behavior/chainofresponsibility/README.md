# Chain of Responsibility

The chain of responsibility design pattern allows multiple respondents to handle a command or event, without a central controller
having to manage the flow. Handlers are added to a chain, and either handle the event, or pass the responsibility to the next item.

While the name implies a linked list, the chain doesn't have to be a list. It can be a tree or forest, with every item that can
handle the event linking to a parent item. In that case the chain is the path from each leave or node to the root of the tree.

Typical use cases:
- Event handling in a UI: a component receives the event, and it bubbles up from child to parent, until it gets handled
- Authorization: The authorization request goes through a chain of rules, until one of them allows or rejects it

## Class Diagram

```mermaid
classDiagram
    class Handler {
        <<interface>>
        +setNext(Handler next)
        +handle(Request request) Optional~Response~
    }

    class BaseHandler {
        -Handler next
        +setNext(Handler next)
        +handle(Request request) Optional~Response~
    }

    class ConcreteHandler1 {
        +handle(Request request) Optional~Response~
    }

    class ConcreteHandler2 {
        +handle(Request request) Optional~Response~
    }

    class ConcreteHandlerN {
        +handle(Request request) Optional~Response~
    }

    class Request {
        +type
        +severity
    }

    Handler <|.. BaseHandler : implements
    BaseHandler <|-- ConcreteHandler1 : extends
    BaseHandler <|-- ConcreteHandler2 : extends
    BaseHandler <|-- ConcreteHandlerN : extends
    BaseHandler o-- Handler : next
    ConcreteHandler1 ..> Request : uses
    ConcreteHandler2 ..> Request : uses
    ConcreteHandlerN ..> Request : uses
```

## This Implementation

In this example, emergency services (`Hospital`, `FireStation`, `PoliceStation`) form a chain that handles `Incident` requests.
Each handler decides whether it can respond to the incident based on its type and severity, and delegates to the next handler if not.

```mermaid
classDiagram
    class IncidentHandler {
        <<interface>>
        +setNext(IncidentHandler next)
        +handleIncident(Incident incident) Optional~String~
    }

    class IncidentChainElement {
        -IncidentHandler next
        +setNext(IncidentHandler next)
        +handleIncident(Incident incident) Optional~String~
    }

    class Hospital {
        -String id
        +handleIncident(Incident incident) Optional~String~
    }

    class FireStation {
        -String id
        +handleIncident(Incident incident) Optional~String~
    }

    class PoliceStation {
        -String id
        +handleIncident(Incident incident) Optional~String~
    }

    class Incident {
        <<record>>
        +String id
        +IncidentType type
        +IncidentSeverity severity
    }

    IncidentHandler <|.. IncidentChainElement : implements
    IncidentChainElement <|-- Hospital : extends
    IncidentChainElement <|-- FireStation : extends
    IncidentChainElement <|-- PoliceStation : extends
    IncidentChainElement o-- IncidentHandler : next
    Hospital ..> Incident : handles
    FireStation ..> Incident : handles
    PoliceStation ..> Incident : handles
```
