package week4.intq;
/*Interview Question 1 - Towers of Hanoi
In the classic Towers of Hanoi problem, there are three rods, A, B, and C, and there are n number of discs of different
unique sizes which can slide onto any rod. The puzzle starts with all the discs in a neat stack in ascending order of
size on the rod A, the smallest at the top, thus making a conical shape.

The objective of the puzzle is to move the entire stack to rod C, obeying the following simple rules:

Only one disc can be moved at a time
Only the uppermost disc can be moved
No disc may be placed on top of a smaller disc
Write a program which uses recursion to compute the correct sequence of moves that solve the puzzle, using the following
 interface:

public interface TowersOfHanoiSoln {

    /**
     * All possible moves between rods A, B, and C
     */
/*  public static enum Move {
      AB, AC, BA, BC, CA, CB;
    }

    /**
     * Solve the sequence of correct moves for n discs from rod A to rod C.
     *
     * @param n - number of discs
     * @return the sequence moves
     */
    /*
      Move[] solve(int n);

}
Bonus 1 - Big O analysis
        Identify the time and space complexity of your solution. Can it be improved? If so, how? If not, why?
*/

import java.util.ArrayList;
import java.util.List;

public class TowersOfHanoi {

    static Move[] moves = null;
    static int resultIndex = 0;

    public static Move[] solve(int n) {
        moves = new Move[(1 << n) - 1];
        solve(n,'A', 'B', 'C');
        return moves;
    }

    private static void solve(int n, char src, char aux, char dest) {
        if (n == 0) return;

        solve(n - 1, src, dest, aux);
        System.out.println("Moving disk "+n+" from "+src+" to "+dest);
        System.out.println("moves["+resultIndex+"] "+getMove(src, dest));

        moves[resultIndex] = getMove(src, dest);
        resultIndex = resultIndex + 1;
        solve(n - 1, aux, src, dest);
    }

    private static Move getMove(char src, char dest) {
        if (src == 'A' && dest == 'B') return Move.AB;
        if (src == 'A' && dest == 'C') return Move.AC;
        if (src == 'B' && dest == 'A') return Move.BA;
        if (src == 'B' && dest == 'C') return Move.BC;
        if (src == 'C' && dest == 'A') return Move.CA;
        if (src == 'C' && dest == 'B') return Move.CB;
        return Move.unknown;
    }

    public static enum Move {
        AB, AC, BA, BC, CA, CB, unknown;

        public String toString() {
            switch (this) {
                case AB: return "AB";
                case AC: return "AC";
                case BA: return "BA";
                case BC: return "BC";
                case CA: return "CA";
                case CB: return "CB";
                case unknown: return "?";
                default: break;
            }
            return "?";
        }
    }

    private static void solve2(int n, char src, char aux, char dest, List seq) {
        if (n == 0) return;

        solve2(n - 1, src, dest, aux, seq);
        // System.out.println("Moving disk "+n+" from "+src+" to "+dest);
        //System.out.println("moves["+resultIndex+"] "+getMove(src, dest));
        seq.add(getMove(src, dest));
        //moves[resultIndex] = getMove(src, dest);
        //resultIndex = resultIndex + 1;
        solve2(n - 1, aux, src, dest, seq);
    }


    public static void main(String[] args) {

        System.out.println("-------solve1------------");
        Move[] t = solve(3);
        for(int i = 0; i< t.length; i++) {
             System.out.println("t["+i+"] "+t[i]);

        }

        System.out.println("--------solve2-----------");

        List seq = new ArrayList();
        solve2(3, 'A', 'B', 'C', seq);
        System.out.println("seq "+seq);

        System.out.println("-------solve3------------");
        t = solve3(3);
        for(int i = 0; i< t.length; i++) {
            System.out.println("t["+i+"] "+t[i]);
        }

        System.out.println("--------solveIterative-----------");
        solveIterative(3);

    }

    // From Sol, prints all moves but returned array does not contain all moves
    public static Move[] solve3(int n) {
        Move[] moves = new Move[(1 << n) - 1];
        solve3(n, moves, 0, 'A', 'B', 'C');
        return moves;
    }
    private static void solve3(int n, Move[] moves, int resultIndex, char src, char aux, char dest) {
        if (n == 0) return;

        solve3(n - 1, moves, resultIndex, src, dest, aux);
        System.out.println("Moving disk "+n+" from "+src+" to "+dest);
        System.out.println("moves["+resultIndex+"] "+getMove(src, dest));

        moves[resultIndex] = getMove(src, dest);
        resultIndex = resultIndex + 1;
        solve3(n - 1, moves, resultIndex, aux, src, dest);
    }

    // ---------------------------------------
    // Iterative solution for printing moves
    /* private static void solveIterative(int n, char src, char aux, char dest) {
        if moves == null
            moves = new Move[(1 << n) - 1];

        int totalMoves = (1 << n) - 1;

        if(n%2 == 0 )
            2. If number of disks (i.e. n) is even then interchange destination
                pole and auxiliary pole.
            3. for i = 1 to total number of moves:
                if i%3 == 1:
                    legal movement of top disk between source pole and
                    destination pole
                if i%3 == 2:
                    legal movement top disk between source pole and
                    auxiliary pole
                if i%3 == 0:
                    legal movement top disk between auxiliary pole
                    and destination pole*/

    /* GET NUMBER OF DISKS AS n
     WHILE x BETWEEN 1 INCLUSIVE AND 1 LEFT-SHIFTED BY n BITS
     SUBTRACT 1 FROM n, DIVIDE BY 3 AND TAKE THE REMAINDER AS A
     OR x WITH x-1, ADD 1 TO THAT, DIVIDE BY 3 AND TAKE THE REMAINDER AS B
     PRINT "MOVE FROM TOWER " A " TO TOWER " B
     ADD 1 TO x*/
    private static void solveIterative(int n) {
        char s = 'A', d = 'C', a = 'B';

        // If number of disks is even, then interchange
        // destination pole and auxiliary pole
        if (n % 2 == 0) {
            char temp = d;
            d = a;
            a  = temp;
        }

        for (int i = 1; i< ((1 << n) - 1); i++) {
            if ( i%3 == 1)
                System.out.println("Moving disk "+i+" from "+s+" to "+d);
            else if ( i%3 == 2)
                System.out.println("Moving disk "+i+" from  "+s+" to "+a);
            else if (i%3 == 0)
                System.out.println("Moving disk "+i+" from  "+a+" to "+d);
        }
    }
}




