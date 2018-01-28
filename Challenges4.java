package week4.challenges;

import java.util.*;

/*Challenge 4 - Compute all substrings
Consider the following interface:

interface SubstringProvider {
  java.util.Collection<String> getSubstrings(String s);
}
Write two implementations of this interface: one using an iterative algorithm and the other using a recursive algorithm.

Example: Given the input string 12345, the output of the program would contain the following strings:
[1, 12, 123, 1234, 12345, 2, 23, 234, 2345, 3, 34, 345, 4, 45, 5]*/

interface SubstringProvider {
    java.util.Collection<String> getSubstrings(String s);
}

public class Challenges4 implements SubstringProvider {

    //Iterative
    public Collection<String> getSubstrings1(String s) {
        List<String> result = new ArrayList<>();

        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            StringBuilder sBuilder = new StringBuilder();
            for (int j = i; j < sLength; j++) {
                sBuilder.append(s.charAt(j));
                result.add(sBuilder.toString());
            }
        }

        return result;
    }

    //Recursive
    public Collection<String> getSubstrings(String s) {
        List<String> result = new ArrayList<>();
        addSubstrings(0, s, result);
        return result;
    }

    public void addSubstrings(int index, String s, List<String> result) {
        if (index < s.length()) {
            StringBuilder sb = new StringBuilder();
            addSubstrings(index, s, sb, result);
            addSubstrings(index + 1, s, result);
        }
    }

    public void addSubstrings(int index, String s, StringBuilder sb, List<String> result) {
        if (index < s.length()) {
            sb.append(s.charAt(index));
            result.add(sb.toString());
            addSubstrings(index + 1, s, sb, result);
        }
    }

    public static void main(String args[]) {
        String a = "12345";
        System.out.println("Iterative "+new Challenges4().getSubstrings1(a));

        System.out.println("Recursive "+new Challenges4().getSubstrings(a));
    }

}