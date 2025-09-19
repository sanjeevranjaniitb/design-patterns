# Java Design Patterns Summary

This document summarizes the essential design patterns, with diagrams, explanations, and a brief algorithm in pseudocode for each.

---

## Creational Patterns

### 1. Singleton

Ensures a class has only one instance.

```plaintext
+----------------------+
|   SingletonClass     |
|----------------------|
| - instance: static   |
| + getInstance()      |
+----------------------+
         |
         v
 (Only one object exists!)
```

**Pseudocode:**
```java
class Singleton {
  static Singleton instance;
  private Singleton() {}
  static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
```
---

### 2. Factory Method

Defines an interface for creating an object, letting subclasses decide which to instantiate.

```plaintext
+-----------+
| Creator   |
|-----------|
| +factory()|
+-----------+
     ^
     |
+-----------+   +-----------+
|ProductA   |   |ProductB   |
+-----------+   +-----------+
```

**Pseudocode:**
```java
abstract class Product {}
class ProductA extends Product {}
class ProductB extends Product {}

abstract class Creator {
  abstract Product factory();
}
class ConcreteCreatorA extends Creator {
  Product factory() { return new ProductA(); }
}
```
---

### 3. Abstract Factory

Provides an interface for creating families of related objects.

```plaintext
+----------------------+
|AbstractFactory       |
|----------------------|
| +createProductA()    |
| +createProductB()    |
+----------------------+
     ^                          ^
     |                          |
+---------+             +-------------+
|Factory1 |             |Factory2     |
+---------+             +-------------+
```

**Pseudocode:**
```java
interface AbstractFactory {
  ProductA createProductA();
  ProductB createProductB();
}
class Factory1 implements AbstractFactory {
  ProductA createProductA() { return new ProductA1(); }
  ProductB createProductB() { return new ProductB1(); }
}
```
---

### 4. Builder

Separates construction of a complex object from its representation.

```plaintext
+-------------+
| Director    |
+-------------+
      |
      v
+-------------+         +-----------+
|   Builder   |<------->| Product   |
+-------------+         +-----------+
```

**Pseudocode:**
```java
class Product { /* fields */ }
interface Builder {
  void buildPartA();
  void buildPartB();
  Product getResult();
}
class Director {
  Builder builder;
  void construct() {
    builder.buildPartA();
    builder.buildPartB();
  }
}
```
---

### 5. Prototype

Creates objects by copying a prototype.

```plaintext
+-----------------+
|   Prototype     |
+-----------------+
| +clone()        |
+-----------------+
```

**Pseudocode:**
```java
interface Prototype {
  Prototype clone();
}
class ConcretePrototype implements Prototype {
  Prototype clone() {
    return new ConcretePrototype();
  }
}
```
---

## Structural Patterns

### 6. Adapter

Allows incompatible interfaces to work together.

```plaintext
+------------------+      +--------------------+
| Client           |----->| Adapter            |
+------------------+      +--------------------+
                               ^
                               |
                      +--------------------+
                      | Adaptee            |
                      +--------------------+
```

**Pseudocode:**
```java
class Adaptee { void specificRequest(); }
interface Target { void request(); }
class Adapter implements Target {
  Adaptee adaptee;
  void request() { adaptee.specificRequest(); }
}
```
---

### 7. Decorator

Adds responsibilities to objects dynamically.

```plaintext
+-----------+
| Component |
+-----------+
      ^
      |
+-------------+
| Decorator   |
+-------------+
      ^
      |
+-------------+
| ConcreteDecorator |
+-------------+
```

**Pseudocode:**
```java
interface Component { void operation(); }
class ConcreteComponent implements Component {
  void operation() { /* ... */ }
}
class Decorator implements Component {
  Component component;
  void operation() { component.operation(); }
}
```
---

### 8. Facade

Provides a simplified interface to a complex system.

```plaintext
+---------+
| Facade  |
+---------+
   /   |   \
  v    v    v
+--+ +--+ +--+
|A | |B | |C |
+--+ +--+ +--+
```

**Pseudocode:**
```java
class SubsystemA { void opA(); }
class SubsystemB { void opB(); }
class Facade {
  SubsystemA a; SubsystemB b;
  void operation() { a.opA(); b.opB(); }
}
```
---

### 9. Composite

Composes objects into tree structures to represent part-whole hierarchies.

```plaintext
      +------------------+
      |   Component      |
      +------------------+
         ^         ^
         |         |
+-------------+ +-------------+
| Leaf        | | Composite   |
+-------------+ +-------------+
                      |
              +----------------+
              | children[]     |
              +----------------+
```

**Pseudocode:**
```java
interface Component { void operation(); }
class Leaf implements Component {
  void operation() { /* ... */ }
}
class Composite implements Component {
  List<Component> children;
  void operation() {
    for (Component c : children) c.operation();
  }
}
```
---

### 10. Proxy

Provides a surrogate or placeholder for another object.

```plaintext
+--------+      +--------+
| Client |----->| Proxy  |-----> RealSubject
+--------+      +--------+
```

**Pseudocode:**
```java
interface Subject { void request(); }
class RealSubject implements Subject { void request() { /* actual work */ } }
class Proxy implements Subject {
  RealSubject real;
  void request() { real.request(); }
}
```
---

## Behavioral Patterns

### 11. Observer

Defines a dependency so that when one object changes, all dependents are notified.

```plaintext
+-----------+      +------------+
| Subject   |<---->| Observer 1 |
|-----------|      +------------+
| +notify() |      +------------+
+-----------+      | Observer 2 |
                   +------------+
```

**Pseudocode:**
```java
interface Observer { void update(); }
class Subject {
  List<Observer> observers;
  void notifyObservers() {
    for (Observer o : observers) o.update();
  }
}
```
---

### 12. Strategy

Defines a family of algorithms, encapsulates each, and makes them interchangeable.

```plaintext
+-----------------+
|   Context       |
+-----------------+
| - strategy      |
| + setStrategy() |
| + execute()     |
+-----------------+
       |
       v
+------------------+
| StrategyA/B/...  |
+------------------+
```

**Pseudocode:**
```java
interface Strategy { void algorithm(); }
class Context {
  Strategy strategy;
  void setStrategy(Strategy s) { strategy = s; }
  void execute() { strategy.algorithm(); }
}
```
---

### 13. Command

Encapsulates a request as an object.

```plaintext
+---------+    +-------------+
|Invoker  |--->|Command      |
+---------+    +-------------+
                   |
                   v
            +---------------+
            | Receiver      |
            +---------------+
```

**Pseudocode:**
```java
interface Command { void execute(); }
class Receiver { void action(); }
class ConcreteCommand implements Command {
  Receiver receiver;
  void execute() { receiver.action(); }
}
class Invoker {
  Command command;
  void run() { command.execute(); }
}
```
---

### 14. Template Method

Defines the skeleton of an algorithm, deferring some steps to subclasses.

```plaintext
+---------------------+
| AbstractClass       |
+---------------------+
| + templateMethod()  |
+---------------------+
       ^
       |
+---------------------+
| ConcreteClass       |
+---------------------+
```

**Pseudocode:**
```java
abstract class AbstractClass {
  void templateMethod() {
    step1();
    step2();
  }
  abstract void step1();
  abstract void step2();
}
class ConcreteClass extends AbstractClass {
  void step1() { /* ... */ }
  void step2() { /* ... */ }
}
```
---

### 15. State

Allows an object to alter its behavior when its internal state changes.

```plaintext
+--------+        +--------------+
|Context |<-----> | StateA/B/... |
+--------+        +--------------+
```

**Pseudocode:**
```java
interface State { void handle(); }
class Context {
  State state;
  void setState(State s) { state = s; }
  void request() { state.handle(); }
}
```
---

### 16. Iterator

Provides a way to access elements of a collection sequentially.

```plaintext
+--------+      +----------+
|Client  |<---->|Iterator  |
+--------+      +----------+
                      ^
                      |
                +-----------+
                |Collection |
                +-----------+
```

**Pseudocode:**
```java
interface Iterator { boolean hasNext(); Object next(); }
class ConcreteIterator implements Iterator {
  List<Object> items; int index;
  boolean hasNext() { return index < items.size(); }
  Object next() { return items.get(index++); }
}
```
---

### 17. Chain of Responsibility

Passes requests along a chain of handlers.

```plaintext
Client
  |
  v
+---------+    +---------+    +---------+
|Handler1 |--->|Handler2 |--->|Handler3 |
+---------+    +---------+    +---------+
```

**Pseudocode:**
```java
abstract class Handler {
  Handler next;
  void handle(Request req) {
    if (canHandle(req)) { /* process */ }
    else if (next != null) next.handle(req);
  }
}
```
---

### 18. Mediator

Defines an object that encapsulates how a set of objects interact.

```plaintext
+---------+
|Mediator |
+---------+
  ^   ^   ^
  |   |   |
+---+ +---+ +---+
|A  | |B  | |C  |
+---+ +---+ +---+
```

**Pseudocode:**
```java
interface Mediator { void notify(Component sender, String event); }
class Component { Mediator mediator; }
class ConcreteComponent extends Component {
  void doSomething() { mediator.notify(this, "event"); }
}
```
---

### 19. Memento

Captures and restores an object's internal state.

```plaintext
+---------+      +-----------+
|Originator|<--->| Memento   |
+---------+      +-----------+
      ^
      |
+-------------+
| Caretaker   |
+-------------+
```

**Pseudocode:**
```java
class Memento { Object state; }
class Originator {
  Object state;
  Memento save() { return new Memento(state); }
  void restore(Memento m) { state = m.state; }
}
```
---

### 20. Visitor

Adds further operations to objects without modifying them.

```plaintext
+---------+    +---------+
|Visitor  |--->|Element  |
+---------+    +---------+
```

**Pseudocode:**
```java
interface Visitor { void visit(Element e); }
interface Element { void accept(Visitor v); }
class ConcreteElement implements Element {
  void accept(Visitor v) { v.visit(this); }
}
```
---

## Interview Tips

- For each pattern, know the problem it solves, its structure, pseudocode, and when to use it.
- Use diagrams in explanations.
- Relate to Java real-world examples.
- Mention pros/cons and trade-offs.

---

If you need more details or want code from a specific source file, let me know!
