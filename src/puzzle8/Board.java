package puzzle8;

import edu.princeton.cs.algs4.Stack;

import java.util.Queue;

public class Board {

    public int[][] board;
    private int n, manh, hamm;
    public int blankPosX, blankPosY;
    public Board(int[][] blocks){
         n = blocks.length;
        board = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = blocks[i][j];
                if (board[i][j] == 0){
                    blankPosX = i; blankPosY = j;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (i == blankPosX && j == blankPosY) continue;
                if (board[i][j] != (i * dimension()) + j + 1) hamm++;
            }
        }
        //if (board[n-1][n-1] == 0) hamm--;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int current = board[i][j];
                if (current != 0){
                    int correctX = (current - 1) / n;
                    int correctY = (current - 1) % n;
                    int dx = i - correctX;
                    int dy = j - correctY;
                    manh += (dx + dy);
                }

            }
        }

    }
    public int dimension(){
        return n;
    }
    public int hamming(){return hamm;}

    public int manhattan(){return  manh;}

    public boolean isGoal(){
        /*for(int i = 0; i < n; i++){
            for(int j = 0;j < n - 1;j++){
                if(board[i][j] != (i*n) + j + 1) return false;
            }
        }
        return true;*/ return hamm == 0;
    }
    public Board twin(){
        int xPos, yPos, xPos1, yPos1;
        if (board[0][1] != 0 && board[0][0] != 0){
            xPos = 0; yPos = 1; xPos1 = 0; yPos1 = 0;
        }
        else {
            xPos = 2; yPos = 0; xPos1 = 2; yPos1 = 1;
        }
        int[][] twin = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == xPos && j == yPos){
                    twin[i][j] = this.board[xPos1][yPos1];
                }
                else if (i == xPos1 && j ==yPos1){
                    twin[i][j] = this.board[xPos][yPos];
                }
                else {
                    twin[i][j] = this.board[i][j];
                }
            }
        }
        return new Board(twin);
    }
    public boolean equals(Object y){
        if (this == y) return true;
        if (y == null) return false;
        if (this.getClass() != y.getClass()) return false;
        Board b = (Board) y;
        return this.manh == b.manh && this.hamm == b.hamm && this.blankPosX == b.blankPosX && this.blankPosY == b.blankPosY;
    }
    public Iterable<Board> neighbors(){
        Stack<Board> stek = new Stack<>();

        if (blankPosX > 0){
            int [][] copy = copy(board);
            swap(copy, blankPosX, blankPosY, blankPosX-1, blankPosY);
            stek.push(new Board(copy));
        }
        if (blankPosX < n-1){
            int [][] copy = copy(board);
            swap(copy, blankPosX, blankPosY, blankPosX+1, blankPosY);
            stek.push(new Board(copy));
        }
        if (blankPosY > 0){
            int [][] copy = copy(board);
            swap(copy, blankPosX, blankPosY, blankPosX, blankPosY-1);
            stek.push(new Board(copy));
        }
        if (blankPosY < n-1){
            int [][] copy = copy(board);
            swap(copy, blankPosX, blankPosY, blankPosX, blankPosY+1);
            stek.push(new Board(copy));
        }

        return stek;
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(n + "\n");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                s.append(String.format("%2d ", board[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    /*
     * swaps two elements in 2d array
     */
    private void swap(int[][] array, int row, int col, int row1, int col1){
        int temp = array[row][col];
        array[row][col] = array[row1][col1];
        array[row1][col1] = temp;
    }
/*
* returns copy of array
 */
    private int[][] copy(int[][] array){
        int [][] copy = new int[n][n];
        for(int i =0; i< n; i++)
            for(int j = 0; j < n; j++)
                copy[i][j] = board[i][j];
        return copy;
    }

}
