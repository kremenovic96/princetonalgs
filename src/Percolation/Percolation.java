package Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/*
*Given a composite systems comprised of randomly distributed insulating and metallic materials:
 *what fraction of the materials need to be metallic so that the composite system is an
  *electrical conductor? Given a porous landscape with water on the surface (or oil below), under
  *what conditions will the water be able to drain through to the bottom (or the oil to gush
  *through to the surface)? Scientists have defined an abstract process known as percolation
  *to model such situations.
 */
public class Percolation {

    private final WeightedQuickUnionUF board;
    private final int n;
    private int[][] system;
    private int numOfOpen;
    private final int up;
    private final int down;

    public Percolation(int n) {
        if(n <= 0){
            throw new IllegalArgumentException();
        }
        board = new WeightedQuickUnionUF((n+1) * (n+1) + 1);
        system = new int[n+1][n+1];
        this.n = n;
        up = 0;
        down = n + 1;
    }

    public void open(int row, int col){
        if(row <= 0 || row > n || col <= 0 || row > n) throw new IllegalArgumentException();
        if(!isOpen(row, col)) {
            system[row][col] = 1;
            numOfOpen++;
            if(row == 1){
                system[row][col] = 1;
                board.union(xyto1D(row, col), up);
            }
            if(row == this.n){
                system[row][col] = 1;
                board.union(xyto1D(row, col), down);
            }
            unionAdjecent(row, col);
        }
    }


    public boolean isOpen(int row, int col){
        if(row <= 0 || row > n || col <= 0 || row > n) throw new IllegalArgumentException();
        return system[row][col] == 1;
    }  // is site (row, col) open?


    public boolean isFull(int row, int col){
        if(row <= 0 || row > n || col <= 0 || row > n) throw new IllegalArgumentException();
        return board.connected(xyto1D(row, col), up);
    }  // is site (row, col) full?

    public int numberOfOpenSites(){
        return numOfOpen;
    }     // number of open sites


    public boolean percolates(){
        return board.connected(up, down);
    }              // does the system percolate?

    public static void main(String[] args){


    }   // test client (optional)


    /*
    *   converts 2d point into 1d
     */
    private int xyto1D(int row, int col){
        return  1+col + row * n;
    }

    /*
     *  union all adjecent opened sites
     *
     */
    private void unionAdjecent(int row, int col){
        if(row > 1) {
            if(isOpen(row-1, col)) board.union(xyto1D(row-1, col), xyto1D(row, col));
        }
        if(col > 1){
            if(isOpen(row, col-1)) board.union(xyto1D(row, col-1), xyto1D(row, col));
        }
        if(col < n){
            if(isOpen(row, col+1)) board.union(xyto1D(row, col+1), xyto1D(row, col));
        }
        if(row < n){
            if(isOpen(row+1, col)) board.union(xyto1D(row+1, col), xyto1D(row, col));
        }

    }

}
