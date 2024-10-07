import java.util.Scanner;
public class Main {

    // Declare arrays to store student information

    //Student name array
    static String[] studentNames = new String[100];
    //Student surname array
    static String[] studentSurnames = new String[100];
    //Student age array
    static int[] studentAges = new int[100];
    //Student grade array
    static String[] studentGrades = new String[100];
    //Student count variable
    static int studentCount = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            //Menu for user input
            System.out.println("\nStudent Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            //Get the user choice which is an int
            choice = scanner.nextInt();
            // Consume the newline
            scanner.nextLine();

            //Switch for selecting functions of the program
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Please select a given option!");
            }
            //Make the user select something and only exit if the exit option is selected
        } while (choice != 4);

        //Close the scanner
        scanner.close();
    }

    //Method to add a new student
    public static void addStudent(Scanner scanner)
    {
        //Check if there are more than 100 students
        if (studentCount < 100)
        {
            //Enter student name
            System.out.print("Enter student name: ");
            studentNames[studentCount] = scanner.nextLine();

            //Enter student surname
            System.out.print("Enter student surname: ");
            studentSurnames[studentCount] = scanner.nextLine();

            //Enter student age
            System.out.print("Enter student age: ");
            studentAges[studentCount] = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            //Enter student grade
            System.out.print("Enter student grade: ");
            studentGrades[studentCount] = scanner.nextLine();

            //Add one to the student count
            studentCount++;
            System.out.println("Student added successfully.");

            //Exit function
            return;
        }

        System.out.println("Cannot add more students. Maximum limit reached.");
    }

    //Method to view all students
    public static void viewStudents()
    {
        //Check if there are students
        if (studentCount == 0)
        {
            System.out.println("No students found.");

            //Exit method
            return;
        }

        System.out.println("\nList of Students:");
        for (int i = 0; i < studentCount; i++)
        {
            //Print the students info
            System.out.println(
                    (i + 1) +
                            ". Name: " + studentNames[i] +
                            ", Age: " + studentAges[i] +
                            ", Surname: " + studentSurnames[i] +
                            ", Grade: " + studentGrades[i]
            );
        }
    }

    //Method to delete a student by index
    public static void deleteStudent(Scanner scanner)
    {
        //Check if there are students
        if (studentCount == 0)
        {
            System.out.println("No students to delete.");
            return;
        }

        System.out.print("Enter the student number to delete: ");
        //User enters the student id. Remove 1, because the arrays index starts from 0 not 1
        int studentIndex = scanner.nextInt() - 1;

        //Check if student index is bigger or the same as 0 and the student count is larger than the index
        //In short, it checks if the user is operating in the bounds of the array
        if (studentIndex >= 0 && studentIndex < studentCount)
        {
            // Shift elements to the left in order to not create ghost records in the array
            for (int i = studentIndex; i < studentCount - 1; i++)
            {
                studentNames[i] = studentNames[i + 1];
                studentAges[i] = studentAges[i + 1];
                studentGrades[i] = studentGrades[i + 1];
            }

            //Remove a student from the counter
            studentCount--;
            System.out.println("Student deleted successfully.");

            //Exit method
            return;
        }

        System.out.println("Invalid student number.");
    }
}