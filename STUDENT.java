import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class STUDENT {
    private String name;
    private int rollNumber;
    private String grade;

    public STUDENT(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }

    public static void main(String[] args) {
        STUDENTManagementSystem system = new STUDENTManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSTUDENT Management System Menu:");
            System.out.println("1. Add STUDENT");
            System.out.println("2. Remove STUDENT");
            System.out.println("3. Search STUDENT");
            System.out.println("4. Display All STUDENTs");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();

                    STUDENT newSTUDENT = new STUDENT(name, rollNumber, grade);
                    system.addSTUDENT(newSTUDENT);
                    System.out.println("STUDENT added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Roll Number of STUDENT to Remove: ");
                    int rollToRemove = scanner.nextInt();
                    system.removeSTUDENT(rollToRemove);
                    System.out.println("STUDENT removed successfully!");
                    break;
                case 3:
                    System.out.print("Enter Roll Number of STUDENT to Search: ");
                    int rollToSearch = scanner.nextInt();
                    STUDENT foundSTUDENT = system.searchSTUDENT(rollToSearch);
                    if (foundSTUDENT != null) {
                        System.out.println("STUDENT found: " + foundSTUDENT);
                    } else {
                        System.out.println("STUDENT not found.");
                    }
                    break;
                case 4:
                    system.displayAllSTUDENTs();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

class STUDENTManagementSystem {
    private List<STUDENT> STUDENTs;

    public STUDENTManagementSystem() {
        this.STUDENTs = new ArrayList<>();
    }

    public void addSTUDENT(STUDENT STUDENT) {
        STUDENTs.add(STUDENT);
    }

    public void removeSTUDENT(int rollNumber) {
        for (STUDENT STUDENT : STUDENTs) {
            if (STUDENT.getRollNumber() == rollNumber) {
                STUDENTs.remove(STUDENT);
                break;
            }
        }
    }

    public STUDENT searchSTUDENT(int rollNumber) {
        for (STUDENT STUDENT : STUDENTs) {
            if (STUDENT.getRollNumber() == rollNumber) {
                return STUDENT;
            }
        }
        return null;
    }

    public void displayAllSTUDENTs() {
        for (STUDENT STUDENT : STUDENTs) {
            System.out.println(STUDENT);
        }
    }
}
