import java.util.Scanner;

/**
 * Here we are going to fetch the amount of letters, in a word.
 *
 * @author (Tushar Ganta)
 * @version (10/18/2021)
 */
public class TextAnalysis {

  /**
   * This is the main method which will call textAnalysis.
   */
  public static void main(String[] args) {
    textAnalysis();
  }

  /**
   * This method calculates the number of times c appears in the message. For
   * example, if message = "abcbcbc", and c = 'b', then the method should return 3
   * If no c character appears in the message, return 0 NOTE: this method is
   * required for testing, you must not delete it
   */
  public static int countChar(String message, char c) {
    int count = 0;
    for (int i = 0; i < message.length(); i++) {
      if (message.charAt(i) == c) {
        count++;
      }
    }
    return count;
  }

  /**
   * This method checks how many times each letter appears in the given message
   * and prints it. For example, if message = "abcbcbc", then the method should
   * print out (output doesn't include "* "): a: 1 b: 3 c: 3 NOTE: this method is
   * required for testing, you must not delete it
   */
  public static void analyzeLine(String message) {
    for (char current = 'a'; current <= 'z'; current++) {
      if (countChar(message, current) > 0) {
        System.out.printf("%c: ", current);
        System.out.println(countChar(message, current));
      }
    }
  }

  /**
   * This methods get inputs from user and calls analyzeLine(). It keeps asking
   * for inputs until user enter "stop" When user enters "stop", the method will
   * end with "All done!" NOTE: this method is required for testing, you must not
   * delete it
   */
  public static void textAnalysis() {
    Scanner console = new Scanner(System.in);
    System.out.print("Enter a line (use stop to end): ");
    String word = console.nextLine();
    while (!word.equalsIgnoreCase("Stop")) {
      analyzeLine(word.toLowerCase());
      System.out.print("Enter a line (use stop to end): ");
      word = console.nextLine();
    }
    System.out.println("All done!");
  }

}