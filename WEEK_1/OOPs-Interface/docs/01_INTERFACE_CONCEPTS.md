# Java Interfaces

## Table of Contents

1. [What is an Interface?](#1-what-is-an-interface)
2. [Why Interfaces? The Design Problem](#2-why-interfaces-the-design-problem)
3. [Interface Syntax](#3-interface-syntax)
4. [Implementing an Interface](#4-implementing-an-interface)
5. [Interface vs Abstract Class](#5-interface-vs-abstract-class)
6. [Multiple Interface Implementation](#6-multiple-interface-implementation)
7. [Interface as a Type (Polymorphism)](#7-interface-as-a-type-polymorphism)
8. [Default & Static Methods (Java 8+)](#8-default--static-methods-java-8)
9. [Functional Interfaces & Lambda (Java 8+)](#9-functional-interfaces--lambda-java-8)
10. [Marker Interfaces](#10-marker-interfaces)
11. [Interface Inheritance](#11-interface-inheritance)
12. [SOLID Principles & Interfaces](#12-solid-principles--interfaces)
13. [Real-World Design Patterns Using Interfaces](#13-real-world-design-patterns-using-interfaces)
14. [Common Placement Interview Questions](#14-common-placement-interview-questions)
15. [Quick Cheat Sheet](#15-quick-cheat-sheet)

---

## 1. What is an Interface?

An **interface** in Java is a **blueprint of behaviour** — it declares _what_ methods a class must have, without specifying _how_ they work.

Think of an interface as a **contract** or **agreement**:

> "Any class that signs this contract (implements this interface) MUST provide implementations for all the methods listed."

```java
// Declaring an interface
public interface Drawable {
    void draw();       // implicitly public and abstract
    double area();     // no body — just a signature
}
```

**Key rules:**

- All methods in an interface are **`public` and `abstract`** by default (before Java 8).
- All variables are **`public static final`** (constants) by default.
- An interface **cannot be instantiated** directly.
- A class uses the `implements` keyword to adopt an interface.

---

## 2. Why Interfaces? The Design Problem

### Without Interface (Bad Design)

Imagine you're building a payment system:

```java
class CreditCardPayment {
    public void pay(double amount) { /* credit card logic */ }
}

class UPIPayment {
    public void pay(double amount) { /* UPI logic */ }
}

class OrderProcessor {
    // Tightly coupled — has to change every time a new payment type is added!
    public void process(CreditCardPayment p, double amt) { p.pay(amt); }
    public void process(UPIPayment p, double amt)        { p.pay(amt); }
}
```

**Problems:**

- Adding a new payment method (e.g., NetBanking) means editing `OrderProcessor`.
- Code is not reusable or extensible.

### With Interface (Good Design)

```java
public interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) { System.out.println("Paid via Credit Card: " + amount); }
}

class UPIPayment implements Payment {
    public void pay(double amount) { System.out.println("Paid via UPI: " + amount); }
}

class OrderProcessor {
    // Works with ANY Payment type — past, present, future!
    public void process(Payment p, double amt) { p.pay(amt); }
}
```

**Benefits:**

- Open for extension, closed for modification (**Open/Closed Principle**).
- `OrderProcessor` doesn't need to change when new payment types are added.

---

## 3. Interface Syntax

```java
[access_modifier] interface InterfaceName [extends OtherInterface] {

    // Constants (public static final by default)
    int MAX_BOOKS = 10;  // same as: public static final int MAX_BOOKS = 10;

    // Abstract methods (public abstract by default)
    void methodOne();
    int methodTwo(String input);

    // Default method (Java 8+) — has a body
    default void greet() {
        System.out.println("Hello from interface!");
    }

    // Static method (Java 8+)
    static void info() {
        System.out.println("This is a static interface method.");
    }

    // Private method (Java 9+) — used internally by default methods
    private void helper() {
        System.out.println("Internal helper");
    }
}
```

### Breakdown of modifiers

| Member            | Default Modifier      | Can you change it?    |
| ----------------- | --------------------- | --------------------- |
| Method (abstract) | `public abstract`     | No (must stay public) |
| Variable          | `public static final` | No                    |
| Default method    | `public`              | No                    |
| Static method     | `public`              | No                    |

---

## 4. Implementing an Interface

```java
public class Circle implements Drawable {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // MUST implement ALL abstract methods from the interface
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
```

**Rules for implementation:**

1. Use `implements` keyword.
2. Override **all** abstract methods (or declare the class `abstract`).
3. The access modifier of overridden methods must be `public` (can't reduce visibility).
4. Use `@Override` annotation — it's a good practice (compiler checks the signature).

---

## 5. Interface vs Abstract Class

This is the **most common interview question** on interfaces.

| Feature              | Interface                                            | Abstract Class                                |
| -------------------- | ---------------------------------------------------- | --------------------------------------------- |
| Keyword              | `implements`                                         | `extends`                                     |
| Multiple inheritance | ✅ A class can implement many interfaces             | ❌ A class can extend only ONE abstract class |
| Constructor          | ❌ Not allowed                                       | ✅ Allowed                                    |
| Instance variables   | ❌ Only constants (`public static final`)            | ✅ Any type of variables                      |
| Method body          | Only `default`/`static` methods (Java 8+)            | Both abstract and concrete methods            |
| Access modifiers     | All methods are `public`                             | Can be `protected`, `private`, `public`       |
| When to use          | Define a **contract/capability** (can fly, can swim) | Share **common code** among related classes   |

### Golden Rule:

> Use an **interface** when unrelated classes need to share a capability.  
> Use an **abstract class** when related classes share common code/state.

```java
// Interface: unrelated things can both be "Flyable"
interface Flyable { void fly(); }

class Bird implements Flyable   { public void fly() { ... } }
class Airplane implements Flyable { public void fly() { ... } }

// Abstract class: related animals share common state
abstract class Animal {
    String name;  // shared state
    abstract void speak();
    void breathe() { System.out.println("Breathing..."); }  // shared behaviour
}
```

---

## 6. Multiple Interface Implementation

Java does **not** support multiple class inheritance, but a class **can implement multiple interfaces**.

```java
interface Swimmable {
    void swim();
}

interface Flyable {
    void fly();
}

// Duck can both swim AND fly
class Duck implements Swimmable, Flyable {

    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }

    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }
}
```

**Diamond Problem in Interfaces (Java 8+):**  
If two interfaces have the same default method, the implementing class must override it:

```java
interface A { default void hello() { System.out.println("A"); } }
interface B { default void hello() { System.out.println("B"); } }

class C implements A, B {
    @Override
    public void hello() {
        A.super.hello();  // explicitly choose which one
    }
}
```

---

## 7. Interface as a Type (Polymorphism)

An interface acts as a **reference type**. This is the heart of polymorphism with interfaces:

```java
LibraryUser user1 = new KidUser();    // KidUser IS-A LibraryUser
LibraryUser user2 = new AdultUser();  // AdultUser IS-A LibraryUser

user1.registerAccount();  // calls KidUser's version
user2.registerAccount();  // calls AdultUser's version

// Store in a list — same type, different behaviours
List<LibraryUser> users = new ArrayList<>();
users.add(new KidUser());
users.add(new AdultUser());

for (LibraryUser u : users) {
    u.registerAccount();  // dynamic dispatch — correct version called at runtime
}
```

This is **runtime polymorphism (dynamic dispatch)** — the JVM decides at runtime which class's method to call.

---

## 8. Default & Static Methods (Java 8+)

### Default Methods

Allow adding new methods to an interface **without breaking existing implementations**:

```java
interface Vehicle {
    void start();

    // Default method — existing classes don't need to override this
    default void stop() {
        System.out.println("Vehicle stopped.");
    }
}

class Car implements Vehicle {
    @Override
    public void start() { System.out.println("Car started"); }
    // stop() is inherited from interface — no need to override
}
```

### Static Methods

Utility methods tied to the interface — not inherited by implementing classes:

```java
interface MathOps {
    static int square(int n) { return n * n; }
}

// Call via interface name only:
int result = MathOps.square(5);  // ✅
// Car.square(5);                // ❌ — not accessible via implementing class
```

---

## 9. Functional Interfaces & Lambda (Java 8+)

A **functional interface** has exactly one abstract method. It can be used with **lambda expressions**.

```java
@FunctionalInterface
interface Greeting {
    void greet(String name);
}

// Traditional way
Greeting g1 = new Greeting() {
    public void greet(String name) { System.out.println("Hello, " + name); }
};

// Lambda shorthand
Greeting g2 = name -> System.out.println("Hello, " + name);

g2.greet("Ravi");  // Output: Hello, Ravi
```

**Built-in functional interfaces (java.util.function):**

| Interface       | Signature            | Use case         |
| --------------- | -------------------- | ---------------- |
| `Runnable`      | `void run()`         | Thread tasks     |
| `Comparable<T>` | `int compareTo(T o)` | Sorting          |
| `Predicate<T>`  | `boolean test(T t)`  | Filtering        |
| `Function<T,R>` | `R apply(T t)`       | Transformations  |
| `Consumer<T>`   | `void accept(T t)`   | Processing       |
| `Supplier<T>`   | `T get()`            | Providing values |

---

## 10. Marker Interfaces

A **marker interface** has no methods — it just "marks" a class to indicate special behaviour to the JVM or frameworks.

```java
// Built-in marker interfaces in Java
Serializable  // marks class as serializable
Cloneable     // marks class as cloneable
Remote        // marks class for RMI
```

```java
import java.io.Serializable;

class Student implements Serializable {
    String name;
    int roll;
    // JVM now knows this class can be serialized to a byte stream
}
```

---

## 11. Interface Inheritance

Interfaces can extend other interfaces (even multiple):

```java
interface Animal {
    void eat();
}

interface Pet extends Animal {
    void play();
}

interface ServicePet extends Pet {
    void work();
}

class GuideDog implements ServicePet {
    public void eat()  { System.out.println("Eating"); }
    public void play() { System.out.println("Playing"); }
    public void work() { System.out.println("Guiding the visually impaired"); }
    // Must implement ALL methods from the entire hierarchy
}
```

---

## 12. SOLID Principles & Interfaces

Interfaces are central to good OOP design (SOLID):

### S — Single Responsibility

Each interface should represent one responsibility:

```java
interface Printable  { void print(); }
interface Saveable   { void save(); }
// Don't merge unrelated behaviours into one fat interface
```

### O — Open/Closed Principle

Classes should be open for extension but closed for modification.  
→ Program to an interface, not a concrete class.

### L — Liskov Substitution

Any implementing class should be substitutable for the interface type:

```java
LibraryUser u = new KidUser();   // ✅ always safe
```

### I — Interface Segregation Principle (ISP)

Don't force classes to implement methods they don't need.  
→ Prefer many small, specific interfaces over one large "fat" interface.

```java
// Bad — forces Robot to implement eat()
interface Worker { void work(); void eat(); }

// Good — separate interfaces
interface Workable { void work(); }
interface Eatable  { void eat(); }

class HumanWorker implements Workable, Eatable { ... }
class RobotWorker  implements Workable          { ... }  // doesn't need eat()
```

### D — Dependency Inversion

High-level modules should depend on abstractions (interfaces), not concrete classes.

```java
// High-level OrderService depends on the Payment interface, not a specific class
class OrderService {
    private Payment payment;  // interface type
    OrderService(Payment payment) { this.payment = payment; }
    void checkout(double amt)     { payment.pay(amt); }
}
```

---

## 13. Real-World Design Patterns Using Interfaces

### Strategy Pattern

```java
interface SortStrategy { void sort(int[] arr); }
class BubbleSort implements SortStrategy { public void sort(int[] arr) { /* ... */ } }
class QuickSort  implements SortStrategy { public void sort(int[] arr) { /* ... */ } }

class Sorter {
    private SortStrategy strategy;
    Sorter(SortStrategy s) { this.strategy = s; }
    void sort(int[] arr) { strategy.sort(arr); }  // swappable at runtime!
}
```

### Observer Pattern

```java
interface Observer  { void update(String event); }
interface Observable {
    void subscribe(Observer o);
    void notifyObservers(String event);
}
```

### Factory Pattern

```java
interface Shape { void draw(); }
class Circle    implements Shape { public void draw() { System.out.println("Circle"); } }
class Rectangle implements Shape { public void draw() { System.out.println("Rectangle"); } }

class ShapeFactory {
    public static Shape create(String type) {
        return switch (type) {
            case "circle"    -> new Circle();
            case "rectangle" -> new Rectangle();
            default          -> throw new IllegalArgumentException("Unknown shape");
        };
    }
}
```

---

## 14. Common Placement Interview Questions

### Q1: Can an interface have a constructor?

**No.** Interfaces cannot be instantiated, so they don't need constructors.

### Q2: What is the difference between interface and abstract class?

See the table in Section 5. Key point: interfaces support multiple inheritance of type.

### Q3: Can an interface extend multiple interfaces?

**Yes.** `interface C extends A, B { }` is valid.

### Q4: Can we have private methods in an interface?

**Yes, from Java 9 onwards.** Private methods can be used as helper methods inside `default` methods.

### Q5: What happens if a class implements two interfaces with the same default method?

The class **must** override the conflicting default method, otherwise it's a compile-time error.

### Q6: What is a functional interface?

An interface with exactly **one abstract method**. Used with lambda expressions. Annotated with `@FunctionalInterface`.

### Q7: Why can't we use `protected` in interface methods?

Interface methods are meant to be part of the **public API** of any implementing class. `protected` would restrict access, defeating the purpose.

### Q8: What is interface segregation principle?

Clients should not be forced to implement interfaces they don't use. Prefer multiple small interfaces over one large interface.

### Q9: Is it possible to instantiate an interface using anonymous class?

**Yes:**

```java
LibraryUser guest = new LibraryUser() {
    public void registerAccount() { System.out.println("Guest register"); }
    public void requestBook()     { System.out.println("Guest request"); }
};
guest.registerAccount();
```

### Q10: What is the difference between `implements` and `extends`?

- `extends`: class-to-class or interface-to-interface inheritance.
- `implements`: class adopts an interface's contract.

---

## 15. Quick Cheat Sheet

```
INTERFACE RULES
───────────────────────────────────────────────────────────
✅  All methods are public abstract by default
✅  All variables are public static final (constants)
✅  A class can implement MULTIPLE interfaces
✅  An interface can extend MULTIPLE interfaces
✅  Default methods (Java 8+) have a body
✅  Static methods (Java 8+) — called via InterfaceName.method()
✅  Private methods (Java 9+) — internal helpers

❌  Cannot have constructors
❌  Cannot have instance variables
❌  Cannot be instantiated directly
❌  Cannot use protected on methods

KEYWORD QUICK REFERENCE
───────────────────────────────────────────────────────────
interface Foo { }              → declare an interface
class Bar implements Foo { }   → implement interface
interface Baz extends Foo { }  → interface inheriting interface
@Override                      → always annotate overridden methods
@FunctionalInterface           → mark single-abstract-method interfaces

WHEN TO USE
───────────────────────────────────────────────────────────
✅  Defining a contract across unrelated classes
✅  Enabling polymorphism and interchangeability
✅  Designing extensible systems (plugin/strategy patterns)
✅  Following SOLID — especially ISP and DIP
```

---