package com.company;

public class Main {

    // Algorithmic complexity log(money / price)
    static int countCandies(int money, int price, int k) {

        // otherwise it causes an infinite loop
        if (k <= 1) {
            throw new IllegalArgumentException("k must be greater than 1");
        }

        int candies = money / price;
        int wrappers = candies;

        while (wrappers >= k) {
            candies += wrappers / k;
            wrappers = wrappers / k + wrappers % k;
        }

        return candies;
    }

}
