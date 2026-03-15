# Visitor

Visitors are used to execute functionality on every item of a data structure.
The benefit of the visitor pattern compared to just iterating over the data structure is that there's no instanceof logic in the visitor deciding what to execute based on the item type. This logic is in the items. This is also the downside: the items have to be aware of the visitor pattern.

Typical use cases:
- Exporting the data structure to a file.
- Bulk-editing all elements of a selection, ex highlighting units in a video game

## Class Diagram

```mermaid
classDiagram
    class Visitor {
        <<interface>>
        +visitConcreteElementA(ConcreteElementA)
        +visitConcreteElementB(ConcreteElementB)
    }
    class ConcreteVisitor {
        +visitConcreteElementA(ConcreteElementA)
        +visitConcreteElementB(ConcreteElementB)
    }
    class Element {
        <<interface>>
        +accept(Visitor)
    }
    class ConcreteElementA {
        +accept(Visitor)
    }
    class ConcreteElementB {
        +accept(Visitor)
    }

    Visitor <|.. ConcreteVisitor
    Element <|.. ConcreteElementA
    Element <|.. ConcreteElementB
    ConcreteElementA ..> Visitor : calls visitConcreteElementA
    ConcreteElementB ..> Visitor : calls visitConcreteElementB
```

## This Implementation

```mermaid
classDiagram
    class Spell {
        <<interface>>
        +applyToMage(Mage)
        +applyToWarrior(Warrior)
    }
    class Weaken {
        -level: int
        +applyToMage(Mage)
        +applyToWarrior(Warrior)
    }
    class Unit {
        <<interface>>
        +accept(Spell)
    }
    class Mage {
        -manna: int
        +accept(Spell)
        +drainManna(int)
    }
    class Warrior {
        -health: int
        +accept(Spell)
        +damange(int)
    }

    Spell <|.. Weaken
    Unit <|.. Mage
    Unit <|.. Warrior
    Mage ..> Spell : calls applyToMage
    Warrior ..> Spell : calls applyToWarrior
```
