# Java Design Patterns Summary

This document summarizes essential design patterns, especially useful in interviews. Each pattern includes a simple ASCII diagram and a short explanation.

---

## Creational Patterns

### 1. Singleton
Ensures a class has only one instance and provides a global point of access.

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

---

### 2. Factory Method
Defines an interface for creating an object, but lets subclasses decide which class to instantiate.

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

---

### 3. Abstract Factory
Provides an interface for creating families of related or dependent objects.

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

---

### 4. Builder
Separates the construction of a complex object from its representation.

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

---

### 5. Prototype
Creates new objects by copying an existing object.

```plaintext
+-----------------+
|   Prototype     |
+-----------------+
| +clone()        |
+-----------------+
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

---

### 10. Proxy
Provides a surrogate or placeholder for another object.

```plaintext
+--------+      +--------+
| Client |----->| Proxy  |-----> RealSubject
+--------+      +--------+
```

---

## Behavioral Patterns

### 11. Observer
Defines a dependency so that when one object changes state, all dependents are notified.

```plaintext
+-----------+      +------------+
| Subject   |<---->| Observer 1 |
|-----------|      +------------+
| +notify() |      +------------+
+-----------+      | Observer 2 |
                   +------------+
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

---

### 15. State
Allows an object to alter its behavior when its internal state changes.

```plaintext
+--------+        +--------------+
|Context |<-----> | StateA/B/... |
+--------+        +--------------+
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

---

### 20. Visitor
Adds further operations to objects without modifying them.

```plaintext
+---------+    +---------+
|Visitor  |--->|Element  |
+---------+    +---------+
```

---

## Interview Tips
- For each pattern, understand the problem it solves, the structure, and the consequences.
- Be ready to sketch diagrams and explain them.
- Relate patterns to real-world Java examples.
- Mention trade-offs, pros/cons, and when to use each pattern.

---

If you’d like summaries for individual source files or more detail on any pattern, let me know!
