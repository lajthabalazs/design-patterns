# Decorator

Decorators enhance the functionality of an object in runtime. They use composition to wrap the core object, and provide the same external interface, but enhanced behavior. But can work together too.

Typical use cases:
- Extending a class with logging.
- Adding checks to input parameters, validation of output ex in a chat bot.

## Generic Class Diagram

```mermaid
classDiagram
    class Component {
        <<interface>>
        +operation()
    }
    class ConcreteComponent {
        +operation()
    }
    class Decorator {
        <<abstract>>
        -component: Component
        +operation()
    }
    class ConcreteDecoratorA {
        +operation()
    }
    class ConcreteDecoratorB {
        +operation()
    }

    Component <|.. ConcreteComponent
    Component <|.. Decorator
    Decorator <|-- ConcreteDecoratorA
    Decorator <|-- ConcreteDecoratorB
    Decorator o--> Component : wraps
```

## Example Class Diagram

```mermaid
classDiagram
    class Shop {
        <<interface>>
        +sellItem() List~String~
    }
    class SimpleShop {
        +sellItem() List~String~
    }
    class ShopDecorator {
        <<abstract>>
        -coreShop: Shop
        +getCoreShop() Shop
    }
    class LoyaltyPointsDecorator {
        +sellItem() List~String~
    }
    class SubscribeToMailingListDecorator {
        +sellItem() List~String~
    }

    Shop <|.. SimpleShop
    Shop <|.. ShopDecorator
    ShopDecorator <|-- LoyaltyPointsDecorator
    ShopDecorator <|-- SubscribeToMailingListDecorator
    ShopDecorator o--> Shop : wraps
```