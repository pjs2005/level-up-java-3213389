package com.linkedin.javacodechallenges;

import java.util.*;

public class DoubleOrNothing {
  boolean running = true;

  public void playGame() {

    int points = 10;
    

    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println("You have collected: " + points + " Points");
      System.out.println("To Roll your luck again type roll or to quite type quit");
      String nextAction = scanner.next();

      if (nextAction.equalsIgnoreCase("roll")) {
        if (rollDice()) {
          points = doublePoints(points);
        } else {
          points = 0;
          this.running = false;
        }

      } else if (nextAction.equalsIgnoreCase("quit")) {
        System.out.println("You have collected: " + points + " Points");
        this.running = false;
      }
    } while (this.running);

    System.out.println("The Game has come to an end and you have won " + points + " Points");

  }

  private boolean rollDice() {
    int upper = 100;
    int lower = 1;
    int r = (int) (Math.random() * (upper - lower)) + lower;
    if (r <= 60) {
      return true;
    } else {
      return false;
    }
  }

  private int doublePoints(int points) {
    return points * 2;
  }
}