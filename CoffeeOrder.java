import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Write a description of class CoffeeOrder here. In this project, we are
 * gathering user input for how many coffees, what type of coffee, and what size
 * of coffee and we are calculating the total cost of the order
 *
 * @author (Tushar Ganta)
 * @version (10/4/2021)
 */

public class CoffeeOrder {

  /**
   * You must have this main() to run test cases, so code your functions and call
   * it here For more hints about Input/Output, view :
   * https://canvas.uw.edu/courses/1492302/assignments/6674078
   */

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.println("Welcome to CoffeeOrder 3000");
    System.out.println("How many espresso drinks would you like today (0-3): ");
    int espressoDrinks = console.nextInt();
    double totalCost = 0.0;
    if (espressoDrinks == 0) {
      System.out.println("OK, so you do not want any espressos today!");
    }

    if (espressoDrinks < 0 || espressoDrinks >= 4) {
      throw new java.lang.AssertionError();
    }
    // for all working parameters
    if (espressoDrinks > 0 && espressoDrinks < 4) {
      int i = 1;
      while (i <= espressoDrinks) {
        System.out.println("Getting order for espresso drink #" + i);
        System.out.println("What type (1: Americano, 2: Latte, 3: Mocha): ");
        int typeOfCoffee = console.nextInt();
        if (typeOfCoffee <= 0 || typeOfCoffee > 3) {
          throw new java.lang.AssertionError();
        }
        System.out.println("What size (1: Tall, 2: Grande): ");
        int coffeeSize = console.nextInt();
        if (coffeeSize <= 0 || coffeeSize > 2) {
          throw new java.lang.AssertionError();
        }
        double cost = getPrice(typeOfCoffee, coffeeSize);
        totalCost = totalCost + cost;
        i++;
      }
      // to format the price of the order
      DecimalFormat c = new DecimalFormat("0.00");
      System.out.println("Your total is " + c.format(totalCost));
    }
    System.out.println("Thank you for using CoffeeOrder 3000");
  }

  /**
   * Return the price of a espresso drink based on their coffee type and size.
   * 
   */
  public static double getPrice(int coffeeType, int size) {
    // Tall Americano
    if (coffeeType == 1 && size == 1) {
      return 2.65;
    }
    // Grande Americano
    if (coffeeType == 1 && size == 2) {
      return 2.95;
    }
    // Tall Latte
    if (coffeeType == 2 && size == 1) {
      return 3.35;
    }
    // Grande Latte
    if (coffeeType == 2 && size == 2) {
      return 3.95;
    }
    // Tall Mocha
    if (coffeeType == 3 && size == 1) {
      return 3.85;
    }
    // Grande Mocha
    if (coffeeType == 3 && size == 2) {
      return 4.45;
    }
    return 0.0;
  }
}