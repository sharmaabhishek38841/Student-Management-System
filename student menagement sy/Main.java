/**
 * Main.java
 * -------------------------------------------------
 * Entry point of the Student Management System.
 * Displays the main menu in a loop and delegates
 * each operation to the StudentManagementSystem class,
 * until the user chooses to exit.
 * -------------------------------------------------
 */
public class Main {

    public static void main(String[] args) {

        StudentManagementSystem sms = new StudentManagementSystem();
        boolean running = true;

        while (running) {
            sms.displayMenu();
            int choice = sms.getMenuChoice();

            switch (choice) {
                case 1 -> sms.addStudent();
                case 2 -> sms.viewStudents();
                case 3 -> sms.searchStudent();
                case 4 -> sms.updateStudent();
                case 5 -> sms.deleteStudent();
                case 6 -> sms.showBonusMenu();
                case 7 -> {
                    System.out.println("\nThank you for using the Student Management System. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
