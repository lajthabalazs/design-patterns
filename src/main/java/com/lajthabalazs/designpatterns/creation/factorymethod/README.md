# Factory Method

The factory method pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate.
It allows a class to defer instantiation to subclasses.

Typical use cases:
- Frameworks: a base class defines a workflow but lets subclasses plug in the concrete objects it operates on
- Logging: a base logger defines how messages are handled, subclasses decide the transport (file, console, network)

## Class Diagram

```mermaid
classDiagram
    class Creator {
        +operation()
        #factoryMethod() Product
    }
    class ConcreteCreator1 {
        #factoryMethod() Product
    }
    class ConcreteCreator2 {
        #factoryMethod() Product
    }
    class Product {
        <<interface>>
    }
    class ConcreteProduct1
    class ConcreteProduct2

    Creator <|-- ConcreteCreator1
    Creator <|-- ConcreteCreator2
    Product <|.. ConcreteProduct1
    Product <|.. ConcreteProduct2
    ConcreteCreator1 ..> ConcreteProduct1 : creates
    ConcreteCreator2 ..> ConcreteProduct2 : creates
```

## This Implementation

In this example, `MilitaryInstallation` is the abstract creator that defines the `deployUnit()` workflow (setting the rally point on the trained unit).
Subclasses `Barracks` and `ArcheryRange` implement the factory method `trainUnit()` to produce a `SwordsMan` or `Archer` respectively.

```mermaid
classDiagram
    class MilitaryInstallation {
        -rallyPoint int
        +setRallyPoint(int)
        +deployUnit() Unit
        #trainUnit() Unit
    }
    class Barracks {
        #trainUnit() Unit
    }
    class ArcheryRange {
        #trainUnit() Unit
    }
    class Unit {
        -target int
        +setTarget(int)
        +getTarget() int
    }
    class SwordsMan
    class Archer

    MilitaryInstallation <|-- Barracks
    MilitaryInstallation <|-- ArcheryRange
    Unit <|-- SwordsMan
    Unit <|-- Archer
    Barracks ..> SwordsMan : creates
    ArcheryRange ..> Archer : creates
```
