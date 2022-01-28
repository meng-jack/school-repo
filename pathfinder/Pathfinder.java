import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Pathfinder {
  public static final Point start = new Point(1, 0);
  public static final char fin = 'F';
  private static Map<Point, State> maze = new HashMap<>();
  private static int[][] dp;

  public class Point {
    public static int x;
    public static int y;

    public Point(int x, int y) {
      Pathfinder.Point.x = x;
      Pathfinder.Point.y = y;
    }
  }

  public enum State {
    PATH,
    WALL;
  }

  public static Map<Point, State> backTrack(Map<Point, State> mps) {
    for(Point e : mps.keySet()) {
      State ste = mps.get(e);
      dp >>= ste;
      
    }
  }

  public static void main(String... args) {
    try {
      Scanner sc = new Scanner(System.in);
      out.println("Enter File Location OR type 1 to use locale \"maze.txt\":");
      String locale = sc.nextLine();
      sc = new Scanner(new BufferedReader(new FileReader((locale.equals("1") ? "maze.txt" : locale))));
      for(int row = 0; sc.hasNext(); row++) {
        for(int col = 0; sc.hasNext(); col++) {
          int x = sc.nextInt();
          maze.put(new Point(row, col), (x == 1 ? State.WALL : State.PATH));
        }
      }
      dp = new int[maze.size() - 1][maze.size() - 1];
      sc.close();
    } catch (IOException ipoe) {
      ipoe.printStackTrace();
      System.exit(-1);
    }
  }
}