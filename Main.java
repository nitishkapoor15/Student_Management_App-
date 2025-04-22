package Database;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        int choice;
// menu for user
        do {
            System.out.println("\n===== 🎓 Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline
// depend on choice the program will work 
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // consume
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    dao.addStudent(new Student(name, age, grade));
                    break;

                case 2:
                    dao.getAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to Update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Grade: ");
                    grade = sc.nextLine();
                    dao.updateStudent(new Student(id, name, age, grade));
                    break;

                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int delId = sc.nextInt();
                    dao.deleteStudent(delId);
                    break;

                case 5:
                    System.out.println("👋 Exiting...");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

