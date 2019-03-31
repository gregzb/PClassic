import java.util.*;
import java.io.*;
import java.math.*;

public class WaitressDilemma {
    private int[][] map;
    private final int[] moves = new int[] {2,1,2,-1,-2,-1,-2,1,1,2,1,-2,-1,2,-1,-2};
    private ArrayList<Integer> f;

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("WaitressDilemmaIN.txt"));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            int n = Integer.parseInt(br.readLine());
            String[] s1 = br.readLine().split(" ");
            String[] s2 = br.readLine().split(" ");
            System.out.println(minBridges(n,Integer.parseInt(s1[0]),Integer.parseInt(s1[1]),Integer.parseInt(s2[0]),Integer.parseInt(s2[1])));
        }
    }

    public int minBridges(int n, int xs, int ys, int xd, int yd) {
        return 0;
        f = new ArrayList<>();
        map = new int[n][n];
        xs--;
        ys--;
        xd--;
        yd--;
        for (int i = 0; i < moves.length;i+=2) {
            movePiece(xs,xs+moves[i],ys, ys+moves[i+1],xd, yd, 1);
        }
        int fi = 300000000;
        //f.sort(x -> x);
        for (int i = 0; i < f.size(); i++) {
            if (f.get(i) < fi && f.get(i) != -1) {
                fi = f.get(i);
            }
        }
        //return fi-1;

    }

    public void movePiece(int oldx, int oldy, int newxcor, int newycor, int finalx, int finaly, int step) {
        if (newxcor < 0 || newycor < 0 || newxcor >= map.length || newycor >= map.length) {
            return;
        }
        if (map[newxcor][newycor] != 0) {
            return;
        }
        if (newxcor == finalx && newycor == finaly) {
            f.add(step);
        }
        double olddistance = distance(oldx, oldy, finalx, finaly);
        double newdistance = distance(newxcor, newycor, finalx, finaly);
        if (newdistance < Math.sqrt(5) || olddistance <= newdistance) {
            return;
        }
        map[newxcor][newycor] = step;
        for (int i = 0; i < moves.length; i+=2) {
            movePiece(newxcor, newycor, newxcor + moves[i], newycor + moves[i+1], finalx, finaly, step+1);
            }
        map[newxcor][newycor] = 0;
    }

    public double distance(int xs, int ys, int xd, int yd) {
        return Math.sqrt(((xd - xs) ^ 2 + (yd - ys) ^ 2));
    }

//    public int minBridges(int n, int xs, int ys, int xd, int yd) {
//        int[][] board = new int[n][n];
//        System.out.println("hi");
//        ArrayList<Integer> totals = new ArrayList<Integer>();
//        helper(board, xs, ys, xd, yd, 0, totals);
//        int min = totals.get(0);
//        for (int i = 1; i < totals.size(); i++) {
//            if (totals.get(i) < min) {
//                System.out.println("we");
//                min = totals.get(i);
//            }
//        }
//        return min;
//    }
//
//    public void helper(int[][] board, int x, int y, int xd, int yd, int moves, ArrayList<Integer> totals) {
//        //System.out.println(x + ", " + y + ", " + xd + ", " + yd + ", " + moves);
//        if (x < 0 || x >= board.length || y < 0 || y >= board.length) {
//            return;
//        } else if (x == xd && y == yd) {
//            totals.add(moves);
//            return;
//        } else {
//            if (board[x][y] == -1) {
//                return;
//            } else {
//                board[x][y] = -1;
//                helper(board, x - 2, y - 1, xd, yd, moves + 1, totals);
//                helper(board, x - 2, y + 1, xd, yd, moves + 1, totals);
//                helper(board, x - 1, y - 2, xd, yd, moves + 1, totals);
//                helper(board, x - 1, y + 2, xd, yd, moves + 1, totals);
//                helper(board, x + 1, y - 2, xd, yd, moves + 1, totals);
//                helper(board, x + 1, y + 2, xd, yd, moves + 1, totals);
//                helper(board, x + 2, y - 1, xd, yd, moves + 1, totals);
//                helper(board, x + 2, y + 1, xd, yd, moves + 1, totals);
//                board[x][y] = 0;
//            }
//        }
//    }
    
    public static void main (String[] args) throws Exception {
        new WaitressDilemma().run();
    }
}
