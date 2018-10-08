package Maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JPanel;

public class MazeGridPanel extends JPanel {
    private int rows;
    private int cols;
    private Cell[][] maze;


    // extra credit
    public void genDFSMaze() {
        boolean[][] visited = new boolean[rows-1][cols-1];
        Stack<Cell> stack = new Stack<Cell>();
        Cell start = maze[0][0];
        stack.push(start);
        //  TODO initialize condition not finished and not empty
        //  TODO initialize current position
        //  TODO initialize case
        //  TODO set condition if can move direction and wall and not visited
        //  TODO move and mark as visited
        //  move on the next case

        while (!stack.isEmpty() || !visited[rows-1][cols-1]) {
            Cell current = stack.peek();
            int max = 4;
            int min = 1;
            int direction = (int)(Math.random() * max) + min ;

            switch (direction) {

                case 1:
                    if (!current.northWall && !visited[current.row-1][current.col]) {
                        stack.push(maze[current.row - 1][current.col]);
                        current.setBackground(Color.GREEN);
                    }

                default:
                    current.setBackground(Color.YELLOW);
                    stack.pop();




            }

        }


    }

    //homework
    public void solveMaze() {
        Stack<Cell> stack = new Stack<Cell>();
        Cell start = maze[0][0];
        start.setBackground(Color.GREEN);
        Cell finish = maze[rows - 1][cols - 1];
        finish.setBackground(Color.RED);
        stack.push(start);

        boolean done = false;


        while (!visited(this.rows-1,this.cols-1) && !(stack.empty())) {

            Cell current = stack.peek();

            //  select last cell to finish
            if(current == finish){
                current.setBackground(Color.BLUE);
                break;
            }
            //  Move North
            if (!(current.northWall) && !(visited(current.row-1, current.col)) ) {
                stack.push(maze[current.row -1][current.col]);
                current.setBackground(Color.BLUE);

            }

            //  Move South
            else if (!(current.southWall) && !(visited(current.row+1, current.col))){
                stack.push(maze[current.row + 1][current.col]);
                current.setBackground(Color.BLUE);
            }

            //  Move East
            else if (!(current.eastWall) && !(visited(current.row, current.col+1))){
                stack.push(maze[current.row][current.col+1]);
                current.setBackground(Color.BLUE);
            }

            //  Move West
            else if (!(current.westWall) && !(visited(current.row, current.col-1))){
                stack.push(maze[current.row][current.col-1]);
                current.setBackground(Color.BLUE);
            }

            //  Dead End
            else {
                current.setBackground(Color.YELLOW);
                stack.pop();
            }
        }

    }




    public boolean visited(int row, int col) {
        Cell c = maze[row][col];
        Color status = c.getBackground();
        if (status.equals(Color.WHITE) || status.equals(Color.RED)) {
            return false;
        }


        return true;


    }


    public void genNWMaze() {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (row == 0 && col == 0) {
                    continue;
                } else if (row == 0) {
                    maze[row][col].westWall = false;
                    maze[row][col - 1].eastWall = false;
                } else if (col == 0) {
                    maze[row][col].northWall = false;
                    maze[row - 1][col].southWall = false;
                } else {
                    boolean north = Math.random() < 0.5;
                    if (north) {
                        maze[row][col].northWall = false;
                        maze[row - 1][col].southWall = false;
                    } else {  // remove west
                        maze[row][col].westWall = false;
                        maze[row][col - 1].eastWall = false;
                    }
                    maze[row][col].repaint();
                }
            }
        }
        this.repaint();

    }

    public MazeGridPanel(int rows, int cols) {
        this.setPreferredSize(new Dimension(800, 800));
        this.rows = rows;
        this.cols = cols;
        this.setLayout(new GridLayout(rows, cols));
        this.maze = new Cell[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                maze[row][col] = new Cell(row, col);

                this.add(maze[row][col]);
            }

        }


        this.genNWMaze();
        //this.solveMaze();
        this.genDFSMaze();
    }


}
