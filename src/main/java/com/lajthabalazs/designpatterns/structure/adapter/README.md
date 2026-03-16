# Adapter

The adapter pattern converts the interface of an existing class into another interface that clients expect. It allows classes with incompatible interfaces to work together without modifying their source code.

Typical use cases:
- Integrating a third-party library whose interface doesn't match your application's expectations.
- Reusing legacy code that cannot be changed but needs to fit a new interface.

## Generic Class Diagram

```mermaid
classDiagram
    class Target {
        <<interface>>
        +request()
    }
    class Adapter {
        -adaptee: Adaptee
        +Adapter(adaptee: Adaptee)
        +request()
    }
    class Adaptee {
        +specificRequest()
    }

    Target <|.. Adapter
    Adapter --> Adaptee : wraps
```

## Example Class Diagram

```mermaid
classDiagram
    class Selectable {
        <<interface>>
        +select()
        +deselect()
    }
    class Saddle {
        -horse: Horse
        +Saddle(horse: Horse)
        +select()
        +deselect()
    }
    class Horse {
        -highlighted: boolean
        +setHighlighted(highlighted: boolean)
        +render() String
    }

    Selectable <|.. Saddle
    Saddle --> Horse : wraps
```
