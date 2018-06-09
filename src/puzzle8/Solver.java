package puzzle8;
import edu.princeton.cs.algs4.*;

public class Solver {
    MinPQ<SearchNode> minpq = new MinPQ<>();
    Stack<SearchNode> solution = new Stack<>();
    int mov;
    Board initialBoard;
    private class SearchNode implements Comparable<SearchNode>{
        @Override
        public int compareTo(SearchNode other){
            return Integer.compare(this.b.manhattan() + this.moves, other.b.manhattan() + other.moves);
        }

        public SearchNode(Board board, int m, SearchNode s){
            this.b = board; this.moves = m; this.PredecessorSearchNode = s;
        }
        @Override
        public String toString(){
            return b.toString();
        }
        Board b;
        int moves;
        SearchNode PredecessorSearchNode;
    }

    public Solver(Board initial){
        if (initial == null) throw new IllegalArgumentException();
        initialBoard = initial;
        minpq.insert(new SearchNode(initial, 0, null));
        while(!minpq.min().b.isGoal()){
            SearchNode min = minpq.delMin();
            mov += min.moves;
            solution.push(min);
            for(Board neighbor : min.b.neighbors()){
                SearchNode newNode = new SearchNode(neighbor, min.moves + 1, min);
                if (!newNode.b.equals(min.b))
                    minpq.insert(newNode);
                System.out.println(minpq.size());
            }
        }

    }
    public boolean isSolvable(){
        int[][] init = initialBoard.board;
        int size = initialBoard.dimension();
        int inversion = 0;
        for(int i = 0; i < size; i++)
            for(int j = 0; j<size-1; j++)
                if (init[i][j] > init[i][j+1]) inversion++;
        return inversion % 2 == 0;

    }
    public int moves(){
        if (!isSolvable()) return -1;
        return solution.peek().moves;
    }
    public Iterable<Board> solution(){
        if (!isSolvable()) return null;
        Queue<Board> red = new Queue<>();
        for(SearchNode x : solution) red.enqueue(x.b);
        return red;
    }
    /*public static void main(String[] args){
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }*/

}
