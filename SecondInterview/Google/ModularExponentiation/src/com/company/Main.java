package com.company;

// https://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/

public class Main {

    public int modExponent(int x, int y, int p) {

        int res = 1;
        x = x % p;

        while (y > 0) {
            if (y % 2 != 0)
                res = (res * x) % p;

            y = y >> 1;
            x = x * x;
        }
        return res;
    }
}
