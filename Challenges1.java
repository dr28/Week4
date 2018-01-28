package week4.challenges;

/*Challenge 1 - Compute factorial of an integer
The factorial of n is the product of all integers between 1 and n. For example, the factorial of 5 is computed as
follows: 5*4*3*2*1 == 120.

Write a program that takes as its input a java.math.BigInteger and returns a java.math.BigInteger equal to the factorial
of the input.

Hint: this can be implemented using a single static method with only one line of code.*/
public class Challenges1 {

    int computeFactorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * computeFactorial(n - 1);
        }
    }

    public static void main(String args[]) {

        System.out.println(new Challenges1().computeFactorial(5));
    }
}
