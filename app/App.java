package app;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Student Database App ===");
            System.out.println("1) Add student");
            System.out.println("2) List students");
            System.out.println("3) Update student");
            System.out.println("4) Delete student");
            System.out.println("0) Exit");
            System.out.print("Select: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Course: ");
                    String course = scanner.nextLine();
                    dao.addStudent(new Student(name, email, course));
                    break;
                case 2:
                    List<Student> students = dao.getAllStudents();
                    System.out.println("ID   | NAME     | EMAIL                    | COURSE");
                    System.out.println("---------------------------------------------------");
                    for (Student s : students) {
                        System.out.printf("%-4d | %-8s | %-24s | %-6s%n", s.getId(), s.getName(), s.getEmail(), s.getCourse());
                    }
                    break;
                case 3:
                    System.out.print("Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("New Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("New Course: ");
                    String newCourse = scanner.nextLine();
                    dao.updateStudent(new Student(updateId, newName, newEmail, newCourse));
                    break;
                case 4:
                    System.out.print("Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    dao.deleteStudent(deleteId);
                    break;
                case 0:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        scanner.close();
    }
}