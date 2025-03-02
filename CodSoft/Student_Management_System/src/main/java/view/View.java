package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Student;

public class View {
	private ArrayList<Student> students = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	// Method to add a student
	public void addStudent() {

		System.out.println("Enter student's name:");
		String name = scanner.nextLine();

		System.out.println("Enter roll number:");
		int rollNumber = Integer.parseInt(scanner.nextLine());

		System.out.println("Enter grade:");
		String grade = scanner.nextLine();

		students.add(new Student(name, rollNumber, grade));
		System.out.println("Student added successfully!\n");

	}

	// Method to remove a student by roll number
	public void removeStudent() {
		System.out.println("Enter the roll number of the student to remove:");
		int rollNumber = Integer.parseInt(scanner.nextLine());

		boolean found = false;
		for (Student student : students) {
			if (student.getRollNumber() == rollNumber) {
				students.remove(student);
				found = true;
				System.out.println("Student removed successfully!\n");
				break;
			}
		}
		if (!found) {
			System.out.println("Student not found.\n");
		}
	}

	// Method to search for a student by roll number
	public void searchStudent() {
		System.out.println("Enter the roll number of the student to search:");
		int rollNumber = Integer.parseInt(scanner.nextLine());

		for (Student student : students) {
			if (student.getRollNumber() == rollNumber) {
				System.out.println("Student found: " + student + "\n");
				return;
			}
		}
		System.out.println("Student not found.\n");
	}

	// Method to display all students
	public void displayAllStudents() {
		if (students.isEmpty()) {
			System.out.println("No students available.\n");
			return;
		}
		System.out.println("List of all students:");
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println();
	}

	// Method to edit student details by roll number
	public void editStudent() {
		System.out.println("Enter the roll number of the student to edit:");
		int rollNumber = Integer.parseInt(scanner.nextLine());

		for (Student student : students) {
			if (student.getRollNumber() == rollNumber) {
				System.out.println("Enter new name:");
				student.setName(scanner.nextLine());

				System.out.println("Enter new grade:");
				student.setGrade(scanner.nextLine());

				System.out.println("Student updated successfully!\n");
				return;
			}
		}
		System.out.println("Student not found.\n");
	}

	// Method to validate input
	public boolean isValidInput(String input) {
		return input != null && !input.trim().isEmpty();
	}

	// Method to start the system
	public void start() {
		while (true) {
			System.out.println("1. Add Student");
			System.out.println("2. Remove Student");
			System.out.println("3. Search Student");
			System.out.println("4. Display All Students");
			System.out.println("5. Edit Student");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				removeStudent();
				break;
			case 3:
				searchStudent();
				break;
			case 4:
				displayAllStudents();
				break;
			case 5:
				editStudent();
				break;
			case 6:
				System.out.println("Exiting... Goodbye!");
				return;
			default:
				System.out.println("Invalid choice, please try again.\n");
			}
		}
	}

	public static void main(String[] args) {
		View system = new View();
		system.start();
	}

}
