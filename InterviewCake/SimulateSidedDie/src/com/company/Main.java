package com.company;

// https://rosettacode.org/wiki/Seven-sided_dice_from_five-sided_dice#Java

import java.util.*;

public class Main {

    Random random = new Random();

    public int rand5(){
        int roll = random.nextInt(7);
        return (roll <= 5)? roll : rand5();
    }

    public int seven(){
        int v = 21;
        while(v > 20)
            v = five() * five() * 5 - 6;

        return 1 + v % 7;
    }

    public int five(){
        return 1 + random.nextInt(5);
    }
}
