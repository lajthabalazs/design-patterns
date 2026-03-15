# Abstract Factory

The abstract factory pattern provides an interface for creating families of related objects, without specifying their concrete classes.
This guarantees that the created objects are compatible with each other.

Typical use cases:
- UI toolkits: a factory produces buttons, checkboxes, and dialogs all in the same theme (e.g. Windows vs macOS)
- Database access: a factory produces connections, commands, and transactions all for the same database vendor

## Class Diagram

```mermaid
classDiagram
    class AbstractFactory {
        <<interface>>
        +createProductA() AbstractProductA
        +createProductB() AbstractProductB
    }
    class ConcreteFactory1 {
        +createProductA() AbstractProductA
        +createProductB() AbstractProductB
    }
    class ConcreteFactory2 {
        +createProductA() AbstractProductA
        +createProductB() AbstractProductB
    }
    class AbstractProductA {
        <<interface>>
    }
    class AbstractProductB {
        <<interface>>
    }
    class ProductA1
    class ProductA2
    class ProductB1
    class ProductB2

    AbstractFactory <|.. ConcreteFactory1
    AbstractFactory <|.. ConcreteFactory2
    AbstractProductA <|.. ProductA1
    AbstractProductA <|.. ProductA2
    AbstractProductB <|.. ProductB1
    AbstractProductB <|.. ProductB2
    ConcreteFactory1 ..> ProductA1 : creates
    ConcreteFactory1 ..> ProductB1 : creates
    ConcreteFactory2 ..> ProductA2 : creates
    ConcreteFactory2 ..> ProductB2 : creates
```

## This Implementation

In this example, `ArmyFactory` produces a family of three unit types — `Warrior`, `Mage`, and `Rogue` — for each faction.
`OrkFactory`, `ElfFactory`, and `HumanFactory` each create a consistent set of faction-specific units.

```mermaid
classDiagram
    class ArmyFactory {
        <<interface>>
        +creatWarrior() Warrior
        +createMage() Mage
        +createRogue() Rogue
    }
    class OrkFactory {
        +creatWarrior() Warrior
        +createMage() Mage
        +createRogue() Rogue
    }
    class ElfFactory {
        +creatWarrior() Warrior
        +createMage() Mage
        +createRogue() Rogue
    }
    class HumanFactory {
        +creatWarrior() Warrior
        +createMage() Mage
        +createRogue() Rogue
    }
    class Unit {
        <<interface>>
    }
    class Warrior {
        <<interface>>
    }
    class Mage {
        <<interface>>
    }
    class Rogue {
        <<interface>>
    }
    class Barbarian
    class Warlock
    class Assasin
    class EldritchKnight
    class HighElf
    class Drow
    class Champion
    class Sorcerer
    class ArcaneTrickster

    ArmyFactory <|.. OrkFactory
    ArmyFactory <|.. ElfFactory
    ArmyFactory <|.. HumanFactory
    Unit <|-- Warrior
    Unit <|-- Mage
    Unit <|-- Rogue
    Warrior <|.. Barbarian
    Mage <|.. Warlock
    Rogue <|.. Assasin
    Warrior <|.. EldritchKnight
    Mage <|.. HighElf
    Rogue <|.. Drow
    Warrior <|.. Champion
    Mage <|.. Sorcerer
    Rogue <|.. ArcaneTrickster
    OrkFactory ..> Barbarian : creates
    OrkFactory ..> Warlock : creates
    OrkFactory ..> Assasin : creates
    ElfFactory ..> EldritchKnight : creates
    ElfFactory ..> HighElf : creates
    ElfFactory ..> Drow : creates
    HumanFactory ..> Champion : creates
    HumanFactory ..> Sorcerer : creates
    HumanFactory ..> ArcaneTrickster : creates
```
