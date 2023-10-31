/* Guessing Game
   Programmer: James Schultz, Date: 11/9/22 */

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner obj = new Scanner(System.in);
    int rng = (int) (Math.random() * 101);
    int guess = -1;
    int tries = 0;
    while (guess != rng) {
      System.out.print("Enter Guess (0-100): ");
      guess = obj.nextInt();
      if (guess - rng > 0)
        System.out.println("Too high");
      if (guess - rng < 0)
        System.out.println("Too low");
      tries++;
    }
    System.out.println("Correct!\n\nAttempts: " + tries);
  }
}
