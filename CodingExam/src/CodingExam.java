import java.util.*;

class CodingExam {

    @SuppressWarnings("resource")
    public static void main(String args[]) {

        // Initialize or declare local variables
        Scanner userInput = new Scanner(System.in);
        String userChoice = "", inputString = "";
        int executionCounter = 0;

        // Continue to display main menu unless specified to exit
        while (!userChoice.equals("0")) {

            System.out.println("Choose from the following functions to be executed:");
            System.out.println("\n1 - Palindrome Checker");
            System.out.println("2 - Longest Palindrome Substring Checker");
            System.out.println("0 - Exit");
            System.out.print("\nChoice:\t");
            userChoice = userInput.nextLine();

            // Call checkIfPalindrome method
            if (userChoice.equals("1")) {
                System.out.print("\nInput string:\t");
                inputString = userInput.nextLine();
                if (!checkIfPalindrome(inputString)) {
                    System.out.println("The input (" + inputString + ") is not a palindrome.\n");
                }
                else {
                    System.out.println("The input (" + inputString + ") is a palindrome.\n");
                }
            }

            // Call getLongestPalindromeSubstring method
            else if (userChoice.equals("2")) {
                System.out.print("\nInput string:\t");
                inputString = userInput.nextLine();
                System.out.println("The longest palindrome substring in (" + inputString + ") is (" + getLongestPalindromeSubstring(inputString) + ")\n");
            }

            executionCounter++;
            System.out.println(" ----- End of execution no." + executionCounter + " -----\n");

        }

    }

    public static boolean checkIfPalindrome(String inputString) {

        // Initialize or declare local variables
        String reversedString = "";

        // Remove all spaces character for both strings before processing
        inputString = inputString.replaceAll("\\s+", "");

        // Get input length
        int stringLength = inputString.length();

        // Iterate for each character to reverse it manually
        for (int counter = stringLength - 1; counter >= 0; counter--) {
            reversedString += inputString.charAt(counter);
        }

        // Remove all spaces character for both strings before comparing
        reversedString = reversedString.replaceAll("\\s+", "");

        // If inputString is equal to the reversedString return true, else false
        if (inputString.equals(reversedString)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static String getLongestPalindromeSubstring(String inputString) {

        // Initialize or declare local variables
        int leftIndex, rightIndex, maxLength = 1, startIndex = 0, inputStrLength = inputString.length();

        // Remove all spaces character for both strings before processing
        inputString = inputString.replaceAll("\\s+", "");

        // Iterate in each character as the center point of even-length and odd-length palindromes
        for (int counter1 = 1; counter1 < inputStrLength; counter1++) {

            // Find the longest even-length palindrome with center points as counter1-1 and counter1
            leftIndex = counter1 - 1;
            rightIndex = counter1;
            while ((leftIndex >= 0) && (rightIndex < inputStrLength) && (inputString.charAt(leftIndex) == inputString.charAt(rightIndex))) {
                if ((rightIndex - leftIndex) + 1 > maxLength) {
                    startIndex = leftIndex;
                    maxLength = rightIndex - leftIndex + 1;
                }
                leftIndex--;
                rightIndex++;
            }

            // Find the longest odd-length palindrome with center point as counter1 
            leftIndex = counter1 - 1;
            rightIndex = counter1 + 1;
            while ((leftIndex >= 0) && (rightIndex < inputStrLength) && (inputString.charAt(leftIndex) == inputString.charAt(rightIndex))) {
                if ((rightIndex - leftIndex) + 1 > maxLength) {
                    startIndex = leftIndex;
                    maxLength = rightIndex - leftIndex + 1;
                }
                leftIndex--;
                rightIndex++;
            }
        }
        return inputString.substring(startIndex, startIndex + maxLength);
    }
}