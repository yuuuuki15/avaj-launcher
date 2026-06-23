## How to start
```
make run
```

## Mandatory part

#### how to read UML
A class diagram is a diagram used in designing and modeling software to describe classes and their relationships.
source: https://www.geeksforgeeks.org/system-design/unified-modeling-language-uml-class-diagrams/

| Visibility Notation ||
| ------ | ------ |
| + | public|
| # | protected|
| ~ | default|
| - | private|

![Class Diagram Relationships](https://media.geeksforgeeks.org/wp-content/uploads/20260512095736466305/class_diagram_relationships.webp)


------

I'm going to use design patterns which are explicitly written in the subject.
Design patterns are well-established design techniques that help developers create efficient, flexible, and maintainable software applications.

#### 1. Observer design pattern
Observer design pattern is a behavioral pattern that creates a one-to-many relationship between
a subject and its observers.
When the subject's state changes, all dependent observers are notified and updated automatically.

In this subject, Tower is the subject and Flyable instances(Balloon, Helicopter, JetPlane) are the observers.
When main(Client) change the state of Tower, Tower will notify all the observers that had been registered to the Tower.

![Observer design pattern](https://media.geeksforgeeks.org/wp-content/uploads/20250911164921062949/observer-design-Pattern.webp)

#### 2. Singleton design pattern
Singleton design pattern is a class design patter that ensure the class will create only one instance.
It it used when we want centralized control of resources.

In this subject, WeatherProvider and AircraftFactory are implemented as a singleton design pattern.
We don't need multiple instances to create Aircraft, to provide weather.
And if you want to count how many Aircrafts you've made in AircraftFactory, singleton design pattern will take advantage, because `AircraftFactory.count` only exist one.

![Singleton design pattern](https://media.geeksforgeeks.org/wp-content/uploads/20260407143547088317/client_1.webp)

#### 3. Factory design pattern
Factory design pattern is a creation design pattern that defines an interface for creating object but lets subclasses decide which object to instantiate.

In this subject, relation between AircraftFactory, Flyable and all these subclasses(Balloon, Helicopter, JetPlane) is implemented as a Factory design pattern.
Advantage of this design pattern is that in the main, we don't need to think about which Class to instantiate but just call Factory Class.
This structure allows for easy addition to new Flyable Class by simply add switch case, without needing to alter existing Main code.

