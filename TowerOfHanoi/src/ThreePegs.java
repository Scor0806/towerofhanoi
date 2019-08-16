/**
 * @author Brent Nicholas
 *
 *                                                     Tower of Hanoi
 *                                                          using
 *                                                       Three Pegs
 *
 *      This program displays the moves of the popular Tower of Hanoi problem using three Pegs
 *       On start input Number of Disks
 */

import java.util.Scanner;

public class ThreePegs {
    static int moves = 0, disks;
    public static void main(String[] args) {
        // User input
        Scanner in = new Scanner(System.in);
        System.out.print("Please input number of Disks: ");
        disks = in.nextInt();

        // Begins move recursion
        move(disks, "Start", "Aux", "Destination");
    }

    // Recursive function move()
    public static int move(int disks, String start, String aux, String dest){
        // break loop once 1
        if(disks == 1){
            ++moves;
            System.out.println("Move " + moves + ":" + " Disk " + disks + " from " + start + " to " + dest);
        }
        // Descend to 1
        else{
            // Move n-1 disks from start to auxiliary peg
            move(disks-1, start, dest, aux);

            ++moves;    // move counter
            print(disks, start, dest, moves);   // Prints move

            // Move n-1 disks from auxiliary to destination peg
            move(disks-1, aux, start, dest);
        }
        return moves;
    }
    // Prints move message
    public static void print(int disks, String start, String dest, int moves){
        System.out.println("Move " + moves + ": " + "Disk " + disks + " from " + start + " to " + dest);
    }
}
