/**
 * Student.java
 * -------------------------------------------------
 * Represents a single Student entity.
 * This class follows the Encapsulation principle of OOP:
 * all fields are private and accessed only through
 * public getters and setters.
 * -------------------------------------------------
 */
public class Student {

    // ---------- Private fields (Encapsulation) ----------
    private int rollNumber;
    private String name;
    private double marks;

    // ---------- Constructors ----------

    /**
     * Default constructor.
     */
    public Student() {
    }

    /**
     * Parameterized constructor to create a Student object
     * with all details at once.
     *
     * @param rollNumber unique roll number of the student
     * @param name       name of the student
     * @param marks      marks obtained by the student
     */
    public Student(int rollNumber, String name, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }

    // ---------- Getters and Setters ----------

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    /**
     * Returns a formatted, table-friendly string representation
     * of the student's details.
     */
    @Override
    public String toString() {
        return String.format("%-10d| %-20s| %-6.2f", rollNumber, name, marks);
    }
}
