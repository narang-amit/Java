//SOrry

import java.util.*;
import java.io.*;
public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public static void main(String[] args) {
    try {
      MazeSolver test = new MazeSolver("data2");
      System.out.println(test.maze);
      System.out.println(test.solve(3));
    }
    catch (FileNotFoundException e) {
      System.out.println("Fuck");
      System.exit(1);
    }

  }
  public MazeSolver(String mazeText) throws FileNotFoundException {
    maze = new Maze(mazeText);
    System.out.println("ASTAR does not work");
  }

  //Default to BFS
  public boolean solve(){ return solve(0); }


  public boolean solve(int mode){

    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
    if (mode == 0) {
      frontier = new FrontierQueue();
    }
    else if (mode == 1) {
      frontier = new FrontierStack();
    }
    else if (mode == 2) {
      frontier = new FrontierPriorityQueue();
    }
    else if (mode == 3) {
      frontier = new FrontierPriorityQueue();
      maze.setAStar(true);
    }
    else {
      System.out.println("invalid mode");
      System.exit(1);
    }

    frontier.add(maze.getStart());
    while (frontier.hasNext()) {
      Location temp = frontier.next();
      Location[] listOfNeighbors = maze.getNeighbors(temp);
      for (int i = 0; i < listOfNeighbors.length; i ++) {
        Location val = listOfNeighbors[i];
        if (val != null) {
          if (val.compareTo(maze.getEnd()) == 0) {
            while (temp.compareTo(maze.getStart()) != 0) {
              maze.set(temp.getX(),temp.getY(),'@');
              temp = temp.getPrev();
            }
            return true;
          }
          frontier.add(val);
          maze.set(val.getX(),val.getY(), '?');
        }
      }
    }
  return false;
}

  public String toString(){
    return maze.toString();
  }
}