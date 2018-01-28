package week4.challenges;
/*Challenge 6 - Number of 1 Bits
Write a function that takes an unsigned integer and returns the number of 1 bits it has.

For example, the 32-bit integer 11 has binary representation:

00000000000000000000000000001011
so the function should return 3.

Note: that since Java does not have unsigned int, use long for Java.*/

public class Challenges6 {
    public int numSetBits(long a) {
        int count = 0;
        while(a > 0){
            if(a % 2 == 1)
                count++;

            a = a/2;
        }
        return count;
    }


    public static void main(String args[]) {
        long a = 11;//00000000000000000000000000001011;

        System.out.println(new Challenges6().numSetBits(a));
        System.out.println(new Challenges6().numSetBits1(a));

    }

    public int numSetBits1(long A) {

        int count = 0;

        while (A > 0) {
            if ( (A & 1) != 0)
                count++;
            A >>= 1;
        }

        return count;

    }
}
