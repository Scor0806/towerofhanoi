/**
 * @author Brent Nicholas
 *                                                  Tower of Hanoi
 *                                                      using
 *                                                    Five Pegs
 *    Rules:
 *      In this Tower of Hanoi program the rules are:
 *          Disks can only move one peg forward
 *          V :: node set       E:: edge set
 *          Graph: (V,E) :: V:{Start, Aux1, Aux2, A3, Dest}         E:{(Start, Aux1), (Aux1, Aux2), (Aux2, Aux3),
 *                                                                     (Aux3, Aux1), (Aux3, Dest)}
 *
 */

import java.util.Scanner;

public class FivePegs {
    static int x, moves;
    static int[] hasMoved, toDest;
    public static void main(String [] args){
        int moveMass = 0;
        Scanner in = new Scanner(System.in);
        moves = 1;

        System.out.print("Please input number of Disks:\n");
        int d = in.nextInt();
        hasMoved = new int[12];
        toDest = new int [12];
        for(int j = 0; j < toDest.length; j++){
            toDest[j] = 1;
        }
        for(int i = 1; i <= d; i++){
            toDest[i] = 0;
        }
        x = d;

        move(1, "Start", "Aux1", moves); moves++;
        moves = fivePegZ(d, "Start", "Aux1", "Aux3", "Aux2", "Destination", moves);
        move(1, "Aux3", "Destination", moves);
        in.close();
    }

    public static int fivePegZ(int disks, String start, String source, String dest, String aux, String last, int moves){

        if(disks == 1){
            move(disks, source, aux, moves); moves++;
            move(disks, aux, dest, moves); moves++;
        }
        else if(disks == 2){
            move(disks - 1, source, aux, moves); moves++;
            move(disks - 1, aux, dest, moves); moves++;

            if(moves == 4){
                move(disks, start, source, moves); moves++;
            }
            move(disks, source, aux, moves); moves++;
            move(disks - 1, dest, aux, moves); moves++;
            move(disks - 1, aux, source, moves); moves++;
            move(disks, aux, dest, moves); moves++;
            if(x == 2){
                move(2, dest, last, moves); moves++;
            }
            move(disks - 1, source, aux, moves); moves++;
            move(disks - 1, aux, dest, moves); moves++;
        }
        else{
            moves = fivePegZ(disks-1, start, source, dest, aux, last, moves);
            if(hasMoved[disks] != 1){
                move(disks, start, source, moves); moves++; hasMoved[disks] = 1;
            }
            move(disks, source, aux, moves); moves++;
            moves = fivePegZ(disks - 1, start, dest, source, aux, last, moves);
            move(disks, aux, dest, moves); moves++;
            if(toDest[disks + 1] != 0){
                move(disks, dest, last, moves); moves++; toDest[disks] = 1;
            }
            if(disks == x){
                x--;
                moves = fivePegZ(disks - 1, start, source, dest, aux, last, moves);
            }
        }
        return moves;
    }

    public static void move(int disk, String source, String dest, int moves){
        System.out.println("Move " + moves + ": " + "Disk " + disk + " from " + source + " to " + dest);
    }
}
