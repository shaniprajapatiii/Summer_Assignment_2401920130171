# Library Management System — Problem Walkthrough Using Interfaces

> **Problem Type:** OOP Interface Design | **Language:** Java

---

## Table of Contents

1. [Problem Statement Summary](#1-problem-statement-summary)
2. [Identifying the Design Need for an Interface](#2-identifying-the-design-need-for-an-interface)
3. [Folder Structure](#3-folder-structure)
4. [Step-by-Step Solution Design](#4-step-by-step-solution-design)
5. [Interface: LibraryUser](#5-interface-libraryuser)
6. [Class: KidUser](#6-class-kiduser)
7. [Class: AdultUser](#7-class-adultuser)
8. [Driver Class: LibraryInterfaceDemo](#8-driver-class-libraryinterfacedemo)
9. [Expected Output](#9-expected-output)
10. [UML Class Diagram](#10-uml-class-diagram)
11. [OOP Concepts Applied](#11-oop-concepts-applied)
12. [Extensibility: Adding Future Roles](#12-extensibility-adding-future-roles)
13. [Key Takeaways for Placements](#13-key-takeaways-for-placements)

---

## 1. Problem Statement Summary

A library needs a system for two user types: **Kids** and **Adults**.

| Rule                  | Kid (< 12 yrs) | Adult (> 12 yrs) |
| --------------------- | -------------- | ---------------- |
| Account Type          | Kids Account   | Adult Account    |
| Allowed Book Category | "Kids" only    | "Fiction" only   |
| Return Period         | 10 days        | 7 days           |

**Future requirement (key constraint):** More user roles may be added with similar patterns. This signals we need an **extensible design** — which interfaces provide perfectly.

---

## 2. Identifying the Design Need for an Interface

Ask yourself: **"What do KidUser and AdultUser have in common?"**

Both:

1. Need to **register an account**
2. Need to **request a book**

But the **logic** for each action differs between the two. This is the classic use-case for an interface:

- Define the **shared contract** (interface) → `LibraryUser`
- Let each class **implement its own logic** → `KidUser`, `AdultUser`

When a new role (e.g., `TeenUser`) is needed in future, just create a new class that implements `LibraryUser`. **Zero changes** to existing code.

---

## 3. Folder Structure

```
java-interface-library/
│
├── src/                          ← All Java source files
│   ├── LibraryUser.java          ← Interface (the contract)
│   ├── KidUser.java              ← Implements LibraryUser (child logic)
│   ├── AdultUser.java            ← Implements LibraryUser (adult logic)
│   └── LibraryInterfaceDemo.java ← Main class (driver/test)
│
└── docs/                         ← Documentation
    ├── 01_INTERFACE_CONCEPTS.md  ← Full theory guide on Java Interfaces
    └── 02_PROBLEM_SOLUTION.md    ← This file — problem walkthrough
```

---

## 4. Step-by-Step Solution Design

```
STEP 1: Identify common behaviour
        → registerAccount() and requestBook() are needed by ALL users

STEP 2: Create the interface
        → LibraryUser declares these two methods (no body)

STEP 3: Create implementing classes
        → KidUser implements LibraryUser with kid-specific logic
        → AdultUser implements LibraryUser with adult-specific logic

STEP 4: Add instance variables
        → age (int) and bookType (String) in both classes

STEP 5: Write the driver class
        → LibraryInterfaceDemo tests all 4 scenarios
```

---

## 5. Interface: LibraryUser

**File:** `src/LibraryUser.java`

```java
public interface LibraryUser {

    void registerAccount();   // How to register — defined by each class

    void requestBook();       // How to borrow — defined by each class
}
```

**What this achieves:**

- Declares a **contract**: any library user type MUST support registering and borrowing.
- Contains **no logic** — just method signatures.
- Is the single point of extensibility: future roles plug into this contract.

---

## 6. Class: KidUser

**File:** `src/KidUser.java`

```java
public class KidUser implements LibraryUser {

    private int age;           // must be < 12 to qualify
    private String bookType;   // must be "Kids" to borrow

    // Setters & Getters
    public void setAge(int age)           { this.age = age; }
    public void setBookType(String bt)    { this.bookType = bt; }
    public int getAge()                   { return age; }
    public String getBookType()           { return bookType; }

    @Override
    public void registerAccount() {
        if (age < 12) {
            System.out.println("You have successfully registered under a Kids Account");
        } else {
            System.out.println("Sorry, Age must be less than 12 to register as a kid");
        }
    }

    @Override
    public void requestBook() {
        if (bookType.equals("Kids")) {
            System.out.println("Book Issued successfully, please return the book within 10 days");
        } else {
            System.out.println("Oops, you are allowed to take only kids books");
        }
    }
}
```

### Logic Flow — KidUser

```
registerAccount()
    │
    ├─ age < 12 ──→ "You have successfully registered under a Kids Account"
    │
    └─ age >= 12 ─→ "Sorry, Age must be less than 12 to register as a kid"

requestBook()
    │
    ├─ bookType == "Kids"    ──→ "Book Issued successfully, please return the book within 10 days"
    │
    └─ bookType != "Kids"    ──→ "Oops, you are allowed to take only kids books"
```

---

## 7. Class: AdultUser

**File:** `src/AdultUser.java`

```java
public class AdultUser implements LibraryUser {

    private int age;           // must be > 12 to qualify
    private String bookType;   // must be "Fiction" to borrow

    // Setters & Getters
    public void setAge(int age)           { this.age = age; }
    public void setBookType(String bt)    { this.bookType = bt; }
    public int getAge()                   { return age; }
    public String getBookType()           { return bookType; }

    @Override
    public void registerAccount() {
        if (age > 12) {
            System.out.println("You have successfully registered under an Adult Account");
        } else {
            System.out.println("Sorry, Age must be greater than 12 to register as an adult");
        }
    }

    @Override
    public void requestBook() {
        if (bookType.equals("Fiction")) {
            System.out.println("Book Issued successfully, please return the book within 7 days");
        } else {
            System.out.println("Oops, you are allowed to take only adult Fiction books");
        }
    }
}
```

### Logic Flow — AdultUser

```
registerAccount()
    │
    ├─ age > 12 ──→ "You have successfully registered under an Adult Account"
    │
    └─ age <= 12 ─→ "Sorry, Age must be greater than 12 to register as an adult"

requestBook()
    │
    ├─ bookType == "Fiction" ──→ "Book Issued successfully, please return the book within 7 days"
    │
    └─ bookType != "Fiction" ──→ "Oops, you are allowed to take only adult Fiction books"
```

---

## 8. Driver Class: LibraryInterfaceDemo

**File:** `src/LibraryInterfaceDemo.java`

```java
public class LibraryInterfaceDemo {

    public static void main(String[] args) {

        // ── Test Case 1: KidUser ──────────────────────────────────────────────
        KidUser kid = new KidUser();

        kid.setAge(10);
        kid.registerAccount();    // Age 10 → valid kid

        kid.setBookType("Kids");
        kid.requestBook();        // "Kids" → success, 10 days

        kid.setAge(18);
        kid.registerAccount();    // Age 18 → invalid for kid

        kid.setBookType("Fiction");
        kid.requestBook();        // "Fiction" → not allowed for kid


        // ── Test Case 2: AdultUser ───────────────────────────────────────────
        AdultUser adult = new AdultUser();

        adult.setAge(5);
        adult.registerAccount();  // Age 5 → invalid for adult

        adult.setBookType("Kids");
        adult.requestBook();      // "Kids" → not allowed for adult

        adult.setAge(23);
        adult.registerAccount();  // Age 23 → valid adult

        adult.setBookType("Fiction");
        adult.requestBook();      // "Fiction" → success, 7 days
    }
}
```

---

## 9. Expected Output

```
========================================
         TEST CASE 1 : KidUser
========================================

[KidUser] Age = 10
You have successfully registered under a Kids Account

[KidUser] BookType = "Kids"
Book Issued successfully, please return the book within 10 days

[KidUser] Age = 18
Sorry, Age must be less than 12 to register as a kid

[KidUser] BookType = "Fiction"
Oops, you are allowed to take only kids books

========================================
         TEST CASE 2 : AdultUser
========================================

[AdultUser] Age = 5
Sorry, Age must be greater than 12 to register as an adult

[AdultUser] BookType = "Kids"
Oops, you are allowed to take only adult Fiction books

[AdultUser] Age = 23
You have successfully registered under an Adult Account

[AdultUser] BookType = "Fiction"
Book Issued successfully, please return the book within 7 days

========================================
           ALL TEST CASES DONE
========================================
```

---

## 10. UML Class Diagram

```
            ┌──────────────────────────────┐
            │       «interface»            │
            │        LibraryUser           │
            ├──────────────────────────────┤
            │ + registerAccount() : void   │
            │ + requestBook() : void       │
            └──────────────────────────────┘
                       ▲           ▲
                       │           │
              implements│           │implements
                       │           │
         ┌─────────────┴───┐   ┌───┴─────────────┐
         │    KidUser       │   │   AdultUser      │
         ├──────────────────┤   ├──────────────────┤
         │ - age: int       │   │ - age: int       │
         │ - bookType:String│   │ - bookType:String│
         ├──────────────────┤   ├──────────────────┤
         │ + setAge()       │   │ + setAge()       │
         │ + setBookType()  │   │ + setBookType()  │
         │ + getAge()       │   │ + getAge()       │
         │ + getBookType()  │   │ + getBookType()  │
         │ + registerAcc.() │   │ + registerAcc.() │
         │ + requestBook()  │   │ + requestBook()  │
         └──────────────────┘   └──────────────────┘
                  ↑                       ↑
                  │                       │
                  └─────────┬─────────────┘
                            │ creates
               ┌────────────┴───────────────┐
               │   LibraryInterfaceDemo      │
               ├─────────────────────────────┤
               │ + main(String[] args): void │
               └─────────────────────────────┘
```

---

## 11. OOP Concepts Applied

### Abstraction

`LibraryUser` interface hides the implementation details. Users of the interface only see _what_ is available (`registerAccount`, `requestBook`), not _how_ it's done.

### Encapsulation

Both `KidUser` and `AdultUser` keep `age` and `bookType` as **private** instance variables, exposing them only through public getters/setters. This protects the data from direct modification.

### Polymorphism

```java
// Both KidUser and AdultUser are of type LibraryUser
LibraryUser u1 = new KidUser();
LibraryUser u2 = new AdultUser();

u1.registerAccount();  // Calls KidUser's version
u2.registerAccount();  // Calls AdultUser's version
```

Same method name → different behaviour based on actual object type at runtime.

### Interface as a Contract

`LibraryUser` is the formal agreement. Both `KidUser` and `AdultUser` are legally bound (by the compiler) to honour it by implementing all declared methods.

---

## 12. Extensibility: Adding Future Roles

The problem mentions: _"In future, more users/roles might be added."_

Thanks to the interface, adding a `TeenUser` requires **zero changes** to existing code:

```java
public class TeenUser implements LibraryUser {

    private int age;           // 12 to 17
    private String bookType;   // e.g., "Young Adult"

    @Override
    public void registerAccount() {
        if (age >= 12 && age < 18) {
            System.out.println("You have successfully registered under a Teen Account");
        } else {
            System.out.println("Sorry, Age must be between 12 and 17 to register as a teen");
        }
    }

    @Override
    public void requestBook() {
        if (bookType.equals("Young Adult")) {
            System.out.println("Book Issued successfully, please return the book within 14 days");
        } else {
            System.out.println("Oops, you are allowed to take only Young Adult books");
        }
    }
}
```

This is the **Open/Closed Principle** in action:

- The `LibraryUser` interface is **closed for modification**.
- The system is **open for extension** via new implementing classes.

---

## 13. Key Takeaways for Placements

| Concept                | How It Appears in This Problem                                   |
| ---------------------- | ---------------------------------------------------------------- |
| Interface declaration  | `LibraryUser` declares `registerAccount()` and `requestBook()`   |
| `implements` keyword   | `KidUser implements LibraryUser`                                 |
| Method overriding      | Both classes override the interface methods with `@Override`     |
| Encapsulation          | `age` and `bookType` are `private` with getters/setters          |
| Polymorphism           | Both classes are assignable to `LibraryUser` reference type      |
| Open/Closed Principle  | Adding `TeenUser` needs no changes to existing files             |
| Separation of Concerns | Each class handles only its own registration and borrowing logic |

### Interview Talking Points

- "I chose an interface over an abstract class because the problem says future roles may be added — an interface lets multiple unrelated classes implement the same contract."
- "The `@Override` annotation ensures at compile time that the method signature matches the interface."
- "Using `LibraryUser` as the reference type instead of `KidUser`/`AdultUser` directly enables polymorphism."

---

## How to Compile & Run

```bash
# Navigate to the src directory
cd OOPs-Interface/src

# Compile all files
javac LibraryUser.java KidUser.java AdultUser.java LibraryInterfaceDemo.java

# Run
java LibraryInterfaceDemo
```

Or compile all at once:

```bash
javac *.java && java LibraryInterfaceDemo
```

---

_This solution demonstrates clean, extensible OOP design using Java Interfaces._
