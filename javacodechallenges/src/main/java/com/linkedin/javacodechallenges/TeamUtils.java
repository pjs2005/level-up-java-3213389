package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Random;

public class TeamUtils {

  public static void generateTeamsScores(List<Team> teams,
      int numberOfRounds) {
    Random random = new Random();
    teams.forEach(team -> {
      for (int i = 0; i < numberOfRounds; i++) {
        team.getScores().add(random.nextInt(11));
      }
    });
  }

  public static void revealResults(List<Team> teams) {
    teams = teams.stream().sorted((o1, o2) -> {
      if (o1.sumTotalScore() > o2.sumTotalScore()) {
        return -1;
      } else if (o1.sumTotalScore() < o2.sumTotalScore()) {
        return 1;
      } else {
        return 0;
      }
    }).toList();

    Team winner = teams.get(0);
    System.out.println("The Winning team is " + winner.getPlayerNames() + "with the " + winner.sumTotalScore());
    System.out.println("\n\n");

    System.out.println("The overall results are: ");

    teams.forEach(team -> {
      System.out.println(team);
    });
  }
}