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

In this subject, UniqueIdFactory is implemented as a singleton design pattern.
We don't need multiple instances to create Aircraft, to provide weather.
And if you want to count how many Aircrafts you've made in AircraftFactory, singleton design pattern will take advantage, because `AircraftFactory.count` only exist one.

![Singleton design pattern](https://media.geeksforgeeks.org/wp-content/uploads/20260407143547088317/client_1.webp)

#### 3. Factory design pattern
Factory design pattern is a creation design pattern that defines an interface for creating object but lets subclasses decide which object to instantiate.

In this subject, relation between AircraftFactory, Flyable and all these subclasses(Balloon, Helicopter, JetPlane) is implemented as a Factory design pattern.
Advantage of this design pattern is that in the main, we don't need to think about which Class to instantiate but just call Factory Class.
This structure allows for easy addition to new Flyable Class by simply add switch case, without needing to alter existing Main code.

----

### WeatherProvider logic
It's a logic that will try to reproduce natural behavior of aircraft, which avoid these cases,
- never land
- endlessly fly up

```:java
if (coordinates.getLongitude() > 180 || coordinates.getLatitude() > 90) {
    return Weather.SNOW.toString();
}
int sum = (coordinates.getLongitude() % 2 + coordinates.getLatitude() % 3) * (coordinates.getHeight() % 3);
return weather[Math.abs(sum) % weather.length];
```

(x + y) * z

x = 0 | 1,
y = 0 | 1 | 2,
z = 0 | 1 | 2

possible cases:

x = 2,
y = 3,
z = 3

2 * 3 * 3 = 18 cases

Let's take all example and calculate:
```
0, 0, 0 = 0      % 4 = 0
0, 0, 1 = 0      % 4 = 0
0, 0, 2 = 0      % 4 = 0
0, 1, 0 = 0      % 4 = 0
0, 1, 1 = 1      % 4 = 1
0, 1, 2 = 2      % 4 = 2
0, 2, 0 = 0      % 4 = 0
0, 2, 1 = 2      % 4 = 2
0, 2, 2 = 4      % 4 = 0
1, 0, 0 = 0      % 4 = 0
1, 0, 1 = 1      % 4 = 1
1, 0, 2 = 2      % 4 = 2
1, 1, 0 = 0      % 4 = 0
1, 1, 1 = 2      % 4 = 2
1, 1, 2 = 4      % 4 = 0
1, 2, 0 = 0      % 4 = 0
1, 2, 1 = 3      % 4 = 3
1, 2, 2 = 6      % 4 = 2

0 = 10 patterns
1 = 2 patterns
2 = 5 patterns
3 = 1 pattern
```
Since SUN always increases height and SNOW always decreases it, we want SNOW to be the most frequent and SUN to be the least frequent. So the weather array is defined as:

```java
private static final String[] weather = {"SNOW", "RAIN", "FOG", "SUN"};
// index 0 → SNOW (10 patterns = most frequent)
// index 1 → RAIN  (2 patterns)
// index 2 → FOG   (5 patterns)
// index 3 → SUN   (1 pattern  = least frequent)
```

However, a problem remains: if an aircraft gets stuck cycling between RAIN and FOG, its height never changes and it loops forever. Since RAIN and FOG only move longitude/latitude, the coordinates can enter a cycle where the weather never becomes SNOW.

To break out of this cycle, I impose geographic boundaries. In the real world:
```
-180 < longitude < 180
-90  < latitude  < 90
```
The subject requires coordinates to be positive with no upper limit, so aircraft can drift beyond real-world bounds indefinitely. By forcing SNOW when those bounds are exceeded, any aircraft that drifts too far is pulled back down:

```java
if (coordinates.getLongitude() > 180 || coordinates.getLatitude() > 90) {
    return Weather.SNOW.toString();
}
```