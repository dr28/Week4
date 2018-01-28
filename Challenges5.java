package week4.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*Challenge 5 - Single Number
Given an array of integers, every element appears twice except for one. Find that single one.

Input : [1 2 2 3 1]
Output : 3
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
public class Challenges5 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int result = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            result = result ^ A.get(i);
        }
        return result;
    }

    public static void main(String args[]) {
        List a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(1);

        System.out.println(new Challenges5().singleNumber(a));
        System.out.println(new Challenges5().singleNumber1(a));

    }
    // DO NOT MODIFY THE LIST
    public int singleNumber1(final List<Integer> A) {
        int num = 0;

        for (int val : A) {
            num ^= val;
        }

        return num;

    }
}