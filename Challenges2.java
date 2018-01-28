package week4.challenges;

/*Compute gcd of two integers
The greatest common divisor (gcd) of two or more non-zero integers is the largest positive integer that divides all the
numbers without a remainder.

Write a program that takes as its input two int values > 0 and returns an int value equal to their gcd.*/
public class Challenges2 {
    public int gcd(int A, int B) {
        if (A < B) {
            return gcd(B, A);
        } else if (B == 0) {
            return A;
        } else {
            return gcd(A % B, B);
        }
    }

    public static void main(String args[]) {
        System.out.println("GCD "+new Challenges2().gcd(9,6));
        System.out.println("GCD "+new Challenges2().gcd1(9,6));

    }

    int gcd1(int A, int B)
    {
        if ( A==0 )
            return B;
        else
            return gcd ( B%A, A );
    }
}
