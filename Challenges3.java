package week4.challenges;

import java.util.ArrayList;

/*Challenge 3 - Integer Array Permutations
Write a program that takes as its input an int[] containing 2 or more values and returning all possible permutations of
the numbers.

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
Note: No two entries in the permutation sequence should be the same. For the purpose of this problem, assume that all
the numbers in the collection are unique. Do not use any library functions for generating permutations.*/
public class Challenges3 {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        result.add(new ArrayList<Integer>());
        for(int i =0; i < A.size(); i++){

            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for(ArrayList<Integer> l : result){

                for(int j =0; j < l.size() + 1; j++){

                    l.add(j, A.get(i));
                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);

                    l.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(current);
        }
        return result;
    }

    public static void main(String[] args){
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);


        System.out.println(new Challenges3().permute(a));
        System.out.println(new Challenges3().permute1(a));

    }

    private boolean [] marked;
    private ArrayList<ArrayList<Integer>> res;
    private ArrayList<Integer> A;
    private int n;

    public ArrayList<ArrayList<Integer>> permute1(ArrayList<Integer> A) {

        n = A.size();
        marked = new boolean[n];
        res = new ArrayList<>();
        this.A = A;

        rec(0, new ArrayList<>());

        return res;

    }

    public void rec(int idx, ArrayList<Integer> temp) {

        if (idx == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                marked[i] = true;
                temp.add(A.get(i));
                rec(idx + 1, temp);
                marked[i] = false;
                temp.remove(temp.size() - 1);
            }
        }


    }


}
