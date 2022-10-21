import java.util.Scanner;

/**
 * Write a description of class UpArrow here. What this code does is it prints
 * out the size of arrows which are odd
 *
 * @author (Tushar Ganta)
 * @version (10/11/21)
 */

public class UpArrow {

  /**
   * this is the main method which will run the program.
   * 
   * @param args from the code
   */
  public static void main(String[] args) {
    arrow(5);
    arrow(7);
    arrow(9);
    arrow(15);
    arrow(31);
  }

  /**
   * This method prints out the head of the arrow. This is an example of head of
   * arrow with size 7 ...*... ..***.. .*****.
   *******
   * @param size the width of the arrow
   */
  public static void arrowHead(int size) {
    for (int i = 1; i <= size; i += 2) {
      for (int dots = size / 2 + 1; dots > (i / 2) + 1; dots--) {
        System.out.print(".");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      for (int dots = size / 2 + 1; dots > (i / 2) + 1; dots--) {
        System.out.print(".");
      }
      System.out.println();
    }
  }

  /**
   * This method prints out the trunk of the arrow. This is an example of trunk of
   * arrow with size 7 ...*... ...*... ...*... ...*... ...*... ...*... ...*...
   * 
   * @param size the width of the arrow
   */

  public static void arrowTrunk(int size) {
    for (int i = 1; i <= size; i++) {
      // dots
      for (int dots = 1; dots <= (size - (size / 4)) / 2; dots++) {
        System.out.print(".");
      }
      // stars
      for (int stars = 1; stars <= size / 4; stars++) {
        System.out.print("*");
      }
      // dots at the end
      for (int dots = 1; dots <= (size - (size / 4)) / 2; dots++) {
        System.out.print(".");
      }
      System.out.println();
    }
  }

  /**
   * This method prints out the whole of the arrow like: This is an example of the
   * arrow with size 7 ...*... ..***.. .*****.
   *******
   * ...*... ...*... ...*... ...*... ...*... ...*... ...*...
   * 
   * @param size the width of the arrow
   */
  public static void arrow(int size) {
    // we can only do odd size arrows
    assert (size % 2 == 1);
    arrowHead(size);
    arrowTrunk(size);
  }

}