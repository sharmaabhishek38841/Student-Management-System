# 🎓 Student Management System (Java)

A **console-based Student Management System** built with **Core Java**, designed as a
beginner-friendly internship project that demonstrates solid **Object-Oriented Programming (OOP)**
principles, clean code structure, and robust input validation.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Console App](https://img.shields.io/badge/Type-Console%20Application-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen?style=for-the-badge)

---

## 📌 Overview

This project allows users to manage student records — adding, viewing, searching, updating,
and deleting students — entirely through a menu-driven console interface. All data is stored
in-memory using an `ArrayList<Student>`, and the codebase follows clean OOP design with
proper encapsulation, validation, and modular methods.

---

## ✨ Features

- ➕ **Add Student** — with duplicate Roll Number prevention
- 📋 **View Students** — displayed in a clean tabular format
- 🔍 **Search Student** — by Roll Number
- ✏️ **Update Student** — modify Name and/or Marks
- ❌ **Delete Student** — by Roll Number
- 📊 **Bonus Features**:
  - Sort students by Marks (descending)
  - Sort students by Name (A–Z)
  - Calculate average marks
  - Display highest & lowest marks
  - Count total students
- 🛡️ **Robust Input Validation** — the app never crashes on invalid input (non-numeric roll numbers, empty names, out-of-range marks, invalid menu choices)

---

## 🗂️ Project Structure

```
StudentManagementSystem/
├── Student.java                    # Entity class (fields, constructors, getters/setters, toString)
├── StudentManagementSystem.java    # Core business logic (CRUD + bonus features)
├── Main.java                       # Entry point with the main menu loop
└── README.md
```

---

## 🧠 OOP Concepts Demonstrated

| Concept | Implementation |
|---|---|
| **Encapsulation** | Private fields in `Student`, accessed only via getters/setters |
| **Abstraction** | `StudentManagementSystem` hides list-handling logic behind simple method calls |
| **Modularity** | Each feature (add, search, update, delete...) is a dedicated method |
| **Constructor Overloading** | Default + parameterized constructors in `Student` |
| **Method Overriding** | Custom `toString()` for clean, formatted output |
| **Composition** | `StudentManagementSystem` "has-a" `ArrayList<Student>` and a `Scanner` |

---

## 🖥️ Sample Run

```
========== Student Management System ==========
1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Bonus Features (Sorting & Statistics)
7. Exit
Enter your choice: 1

--- Add New Student ---
Enter Roll Number: 101
Enter Name: Aditi Sharma
Enter Marks (0-100): 88.5
Student added successfully.
```

---

## ⚙️ How to Run

**Prerequisites:** JDK 8 or higher installed.

```bash
# Clone the repository
git clone https://github.com/<your-username>/StudentManagementSystem.git
cd StudentManagementSystem

# Compile
javac *.java

# Run
java Main
```

---

## ⏱️ Time Complexity

| Operation | Complexity |
|---|---|
| Add Student | O(n) |
| View Students | O(n) |
| Search Student | O(n) |
| Update Student | O(n) |
| Delete Student | O(n) |
| Sort by Marks / Name | O(n log n) |
| Average / Highest / Lowest | O(n) |

*(n = number of students currently stored)*

---

## 🚀 Possible Future Enhancements

- [ ] Persist data to a file (CSV/TXT) or database so records survive restarts
- [ ] Add a GUI version using JavaFX or Swing
- [ ] Add unit tests with JUnit
- [ ] Export student records to PDF/Excel

---

## 📄 License

This project is open-source and available for learning purposes. Feel free to fork and extend it.

---

## 👤 Author

Built as part of an internship project to demonstrate Core Java and OOP fundamentals.
