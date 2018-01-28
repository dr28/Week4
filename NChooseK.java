package week4.intq;
/*Interview Question 2 - Calculating n choose k
The binomial coefficient, (n)  is often read aloud as "n choose k" and is used to denote the number of different ways to
                           k
choose k elements from a set of n elements without respect to their order.

There are a number of different approaches to calculating this value, including a well-known approach using recursion:

(n) = (n - 1) + (n - 1)  for all integers n,k:1 <= k <= n-1
 k     k - 1       k


Stated another way, the value for (n choose k) is equal to the sum of (n - 1 choose k - 1) and (n - 1 choose k).

Write a program that takes as its input two int values n and k and implements the above algorithm using tail recursion,
returning a long value representing the number of different ways to choose k elements from a set of n elements.

Hint: there two base cases to consider

Bonus 1 - Memoization
The above solution is known to be inefficient due to repeated calculations. Improve the solution using memoization and
explain the improvement in efficiency and the cost at which it is made.*/
import java.util.HashMap;

public class NChooseK {

    public static long nChooseKRecursive(int n, int k) {
        if (k >= n) {
            return 1L;
        } else if (k == 1) {
            return (long) n;
        }
        return nChooseKRecursive(n - 1, k - 1) + nChooseKRecursive(n - 1, k);
    }

    HashMap<String, Long> map1 = new HashMap<>();

    private long nChooseKRecursiveWithMemoization(int n, int k) {
        if (k >= n)
            return 1L;
        else if (k == 1)
            return (long) n;

        String key = n + "" + k;

        if (map1.containsKey(key))
            return map1.get(key);

        long sum = nChooseKRecursiveWithMemoization(n - 1, k - 1) + nChooseKRecursiveWithMemoization(n - 1, k);
        map1.put(key, sum);
        return sum;
    }

    public static void main(String[] args) {

        //{1,2,3,4} n=4 and k =2 {1,2} {1,3} {1,4} {2,3} {2,4} {3,4} == 6
        //{1,2,3,4} n=4 and k =3 {1,2,3} {1, 2, 4} {1,3,4} {2,3,4}  == 4

        System.out.println(nChooseKRecursive(20, 4)); // 4845
        System.out.println(new NChooseK().nChooseKRecursiveWithMemoization(5, 3));

    }

    // From Solution
    public static long nChooseKRecursiveWithMemoization1(int n, int k) {
        HashMap<String, Long> map = new HashMap<>();
        return nChooseKRecursiveWithMemoizationHelper(n, k, map);
    }
    private static long nChooseKRecursiveWithMemoizationHelper(int n, int k, HashMap<String, Long> map) {
        if (k >= n) {
            return 1L;
        } else if (k == 1) {
            return (long) n;
        }

        String key = n + "" + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        long sum = nChooseKRecursive(n - 1, k - 1) + nChooseKRecursive(n - 1, k);
        map.put(key, sum);
        return sum;
    }
}
