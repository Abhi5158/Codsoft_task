package Task2;

import java.util.Scanner;

public class StudentGradeCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Taking input for number of subjects
		System.out.print("Enter the number of subjects: ");
		int numSubjects = scanner.nextInt();

		int totalMarks = 0;

		// Taking input for marks in each subject
		for (int i = 1; i <= numSubjects; i++) {
			System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
			int marks = scanner.nextInt();

			if (marks < 0 || marks > 100) {
				System.out.println("Invalid marks! Please enter between 0 and 100.");
				i--;
				continue;
			}
			totalMarks += marks;
		}

		// Calculate average percentage
		double averagePercentage = (double) totalMarks / numSubjects; // type casting

		// grades will be assigned according to the avg marks
		char grade;
		if (averagePercentage >= 90) {
			grade = 'A';
		} else if (averagePercentage >= 80) {
			grade = 'B';
		} else if (averagePercentage >= 70) {
			grade = 'C';
		} else if (averagePercentage >= 60) {
			grade = 'D';
		} else {
			grade = 'F'; // Fail? nope you have a chance to go higher trust yourself and the process.
		}

		// Displaying results
		System.out.println("\n----- Result -----");
		System.out.println("Total Marks: " + totalMarks);
		System.out.println("Average Percentage: " + averagePercentage + "%");
		System.out.println("Grade: " + grade);

		scanner.close();

	}

}
