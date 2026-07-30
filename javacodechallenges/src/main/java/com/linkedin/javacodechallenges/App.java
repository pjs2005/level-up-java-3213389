package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {
    private static final double CCF = 748;
    private static final double MINI_CHARGE = 18.84;
    private static final double MINI_CCF = 2;
    private static final double ADD_CCF_FEE = 3.90;

    public static double calculateWaterBill(double gallonsUsage) {

        if (checkMinium(gallonsUsage)) {
            return MINI_CHARGE;
        } else {

            double gallons_above = gallonsAbove(gallonsUsage);

            double charableUnits = gallons_above / CCF;
            charableUnits = Math.ceil(charableUnits);

            double additinal = charableUnits * ADD_CCF_FEE;
            return additinal + MINI_CHARGE;
        }
    }

    private static double gallonsAbove(double gallonsUsage) {
        double minimumgallon = CCF * MINI_CCF;
        return gallonsUsage - minimumgallon;
    }

    private static boolean checkMinium(double gallonsUsage) {
        return gallonsAbove(gallonsUsage) <= 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
