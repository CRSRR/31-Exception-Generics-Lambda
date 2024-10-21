import java.util.InputMismatchException;
import java.util.Scanner;

public class except {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\n===== Exception Handling Menu =====");
            System.out.println("1. Arithmetic Exception (Division by Zero)");
            System.out.println("2. Number Format Exception (Invalid Number Format)");
            System.out.println("3. Array Index Out of Bounds Exception");
            System.out.println("4. Null Pointer Exception");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            try {
                int choice = scanner.nextInt();  // Read user choice

                switch (choice) {
                    case 1:
                        handleArithmeticException(scanner);
                        break;
                    case 2:
                        handleNumberFormatException(scanner);
                        break;
                    case 3:
                        handleArrayIndexOutOfBoundsException(scanner);
                        break;
                    case 4:
                        handleNullPointerException();
                        break;
                    case 5:
                        continueProgram = false;
                        System.out.println("Exiting program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select a valid option (1-5).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();  // Clear the invalid input
            }
        }

        scanner.close();
    }

    // Method to demonstrate ArithmeticException
    private static void handleArithmeticException(Scanner scanner) {
        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();
            int result = numerator / denominator;  // This may cause ArithmeticException if denominator is zero
            System.out.println("Result: " + numerator + " / " + denominator + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed!");
        }
    }

    // Method to demonstrate NumberFormatException
    private static void handleNumberFormatException(Scanner scanner) {
        try {
            System.out.print("Enter a number: ");
            String input = scanner.next();  // This may cause NumberFormatException if input is not a number
            int number = Integer.parseInt(input);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format! Please enter a valid integer.");
        }
    }

    // Method to demonstrate ArrayIndexOutOfBoundsException
    private static void handleArrayIndexOutOfBoundsException(Scanner scanner) {
        try {
            int[] numbers = {1, 2, 3, 4, 5};
            System.out.print("Enter an array index (0-4): ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + numbers[index]);  // This may cause ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index! Index must be between 0 and 4.");
        }
    }

    // Method to demonstrate NullPointerException
    @SuppressWarnings("null")
    private static void handleNullPointerException() {
        try {
            String str = null;
            System.out.println("Length of the string: " + str.length());  // This will cause NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Error: Null pointer exception! You tried to call a method on a null object.");
        }
    }
}
