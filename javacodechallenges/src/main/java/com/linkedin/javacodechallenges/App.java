package com.linkedin.javacodechallenges;

import java.util.List;

public class App {
    public static double calculateAverageChangeInvested(List<Double> purchases) {
        if (purchases.isEmpty()) {
            return 0;
        }
        
        return purchases.stream()
                .map(purchas -> Math.ceil(purchas) - purchas)
                .reduce(0.0d, (acc, value) -> acc + value) / purchases.size();
    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAverageChangeInvested(purchases));
    }
}
