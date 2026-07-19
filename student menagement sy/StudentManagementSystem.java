import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * StudentManagementSystem.java
 * -------------------------------------------------
 * Core business logic class.
 * Manages an in-memory list (ArrayList) of Student objects
 * and provides all CRUD operations plus bonus statistics
 * features.
 *
 * This class demonstrates:
 * - Abstraction (hides internal list handling from Main)
 * - Modularity (each feature is its own method)
 * - Input validation (never crashes on bad input)
 * -------------------------------------------------
 */
public class StudentManagementSystem {

    // ---------- Fields ----------
    private final ArrayList<Student> students;
    private final Scanner scanner;

    // ---------- Constructor ----------
    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // =====================================================
    //                     MENU DISPLAY
    // =====================================================

    /**
     * Displays the main menu options to the user.
     */
    public void displayMenu() {
        System.out.println("\n========== Student Management System ==========");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Bonus Features (Sorting & Statistics)");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Reads and validates the user's menu choice.
     * Never throws an exception for non-numeric input;
     * instead returns -1 so the caller can handle it gracefully.
     *
     * @return the validated integer choice, or -1 if invalid
     */
    public int getMenuChoice() {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // signals an invalid (non-numeric) choice
        }
    }

    // =====================================================
    //                  CORE CRUD OPERATIONS
    // =====================================================

    /**
     * Adds a new student to the system after validating
     * input and checking for duplicate roll numbers.
     */
    public void addStudent() {
        System.out.println("\n--- Add New Student ---");

        int rollNumber = readIntInput("Enter Roll Number: ");

        // Prevent duplicate roll numbers
        if (findStudentByRoll(rollNumber) != null) {
            System.out.println("Student with this Roll Number already exists.");
            return;
        }

        String name = readNonEmptyString("Enter Name: ");
        double marks = readMarksInput("Enter Marks (0-100): ");

        Student student = new Student(rollNumber, name, marks);
        students.add(student);

        System.out.println("Student added successfully.");
    }

    /**
     * Displays all students currently stored, in a table format.
     */
    public void viewStudents() {
        System.out.println("\n--- Student Records ---");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        printTableHeader();
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------");
        System.out.println("Total Students: " + students.size());
    }

    /**
     * Searches for a student using Roll Number and displays
     * their details if found.
     */
    public void searchStudent() {
        System.out.println("\n--- Search Student ---");
        int rollNumber = readIntInput("Enter Roll Number to search: ");

        Student found = findStudentByRoll(rollNumber);
        if (found == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student Found:");
            printTableHeader();
            System.out.println(found);
        }
    }

    /**
     * Updates the name and/or marks of an existing student,
     * identified by Roll Number.
     */
    public void updateStudent() {
        System.out.println("\n--- Update Student ---");
        int rollNumber = readIntInput("Enter Roll Number to update: ");

        Student student = findStudentByRoll(rollNumber);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String newName = readNonEmptyString("Enter new Name: ");
        double newMarks = readMarksInput("Enter new Marks (0-100): ");

        student.setName(newName);
        student.setMarks(newMarks);

        System.out.println("Student updated successfully.");
    }

    /**
     * Deletes a student from the system using Roll Number.
     */
    public void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        int rollNumber = readIntInput("Enter Roll Number to delete: ");

        Student student = findStudentByRoll(rollNumber);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        System.out.println("Student deleted successfully.");
    }

    // =====================================================
    //                  BONUS FEATURES
    // =====================================================

    /**
     * Displays the bonus features submenu and routes to the
     * chosen statistic/sort operation.
     */
    public void showBonusMenu() {
        System.out.println("\n--- Bonus Features ---");
        System.out.println("1. Sort by Marks (Descending)");
        System.out.println("2. Sort by Name (Alphabetical)");
        System.out.println("3. Calculate Average Marks");
        System.out.println("4. Display Highest Marks");
        System.out.println("5. Display Lowest Marks");
        System.out.println("6. Count Total Students");
        System.out.println("7. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = getMenuChoice();

        if (students.isEmpty() && choice >= 1 && choice <= 6) {
            System.out.println("No student records found.");
            return;
        }

        switch (choice) {
            case 1 -> sortByMarks();
            case 2 -> sortByName();
            case 3 -> calculateAverageMarks();
            case 4 -> displayHighestMarks();
            case 5 -> displayLowestMarks();
            case 6 -> countTotalStudents();
            case 7 -> System.out.println("Returning to main menu...");
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    /**
     * Sorts and displays students in descending order of marks.
     */
    public void sortByMarks() {
        ArrayList<Student> sorted = new ArrayList<>(students);
        sorted.sort(Comparator.comparingDouble(Student::getMarks).reversed());

        System.out.println("\n--- Students Sorted by Marks (High to Low) ---");
        printTableHeader();
        for (Student s : sorted) {
            System.out.println(s);
        }
    }

    /**
     * Sorts and displays students alphabetically by name.
     */
    public void sortByName() {
        ArrayList<Student> sorted = new ArrayList<>(students);
        sorted.sort(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));

        System.out.println("\n--- Students Sorted by Name (A to Z) ---");
        printTableHeader();
        for (Student s : sorted) {
            System.out.println(s);
        }
    }

    /**
     * Calculates and displays the average marks of all students.
     */
    public void calculateAverageMarks() {
        double total = 0;
        for (Student s : students) {
            total += s.getMarks();
        }
        double average = total / students.size();
        System.out.printf("Average Marks: %.2f%n", average);
    }

    /**
     * Displays the student(s) with the highest marks.
     */
    public void displayHighestMarks() {
        Student topStudent = Collections.max(students, Comparator.comparingDouble(Student::getMarks));
        System.out.println("Highest Marks:");
        printTableHeader();
        System.out.println(topStudent);
    }

    /**
     * Displays the student(s) with the lowest marks.
     */
    public void displayLowestMarks() {
        Student bottomStudent = Collections.min(students, Comparator.comparingDouble(Student::getMarks));
        System.out.println("Lowest Marks:");
        printTableHeader();
        System.out.println(bottomStudent);
    }

    /**
     * Displays the total number of students currently stored.
     */
    public void countTotalStudents() {
        System.out.println("Total Number of Students: " + students.size());
    }

    // =====================================================
    //                  PRIVATE HELPER METHODS
    // =====================================================

    /**
     * Searches the internal list for a student with the given
     * roll number.
     *
     * @param rollNumber the roll number to search for
     * @return the matching Student object, or null if not found
     */
    private Student findStudentByRoll(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                return s;
            }
        }
        return null;
    }

    /**
     * Prints the header row for the student table display.
     */
    private void printTableHeader() {
        System.out.println("-------------------------------------------");
        System.out.printf("%-10s| %-20s| %-6s%n", "Roll No", "Name", "Marks");
        System.out.println("-------------------------------------------");
    }

    /**
     * Repeatedly prompts the user until a valid integer is entered.
     * Prevents the application from crashing on non-numeric input.
     *
     * @param prompt the message to display to the user
     * @return a validated integer
     */
    private int readIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid whole number.");
            }
        }
    }

    /**
     * Repeatedly prompts the user until a valid, non-empty
     * string (name) is entered.
     *
     * @param prompt the message to display to the user
     * @return a validated, non-empty name string
     */
    private String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            } else if (!input.matches("[a-zA-Z ]+")) {
                System.out.println("Name should contain only letters and spaces.");
            } else {
                return input;
            }
        }
    }

    /**
     * Repeatedly prompts the user until a valid marks value
     * (numeric, between 0 and 100) is entered.
     *
     * @param prompt the message to display to the user
     * @return a validated marks value
     */
    private double readMarksInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double marks = Double.parseDouble(input);
                if (marks < 0 || marks > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                } else {
                    return marks;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value for marks.");
            }
        }
    }
}
