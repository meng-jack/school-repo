package resource.quadrilateral;

import java.util.Scanner;

public class QuadrilateralDriver {
  public static void main(String[] args) throws Exception {
    /**
     * topLeft [0] ----------- topRight [1]
     *  |                           |
     *  |                           |
     *  |                           |
     * botLeft [2] ----------- botRight [3]
     * 
     * 
     */

    /* In the order of Top Left, Top Right, Bottom Left, Bottom Right */
    Point[] pointList = {new Point(1,4), new Point(3,4), new Point(1,2) , new Point(3,2)};
    /*
    Scanner sc = new Scanner(System.in); 
    System.out.println("Enter Top Left Point (1) in the following format:\nx y");
    double x = sc.nextDouble();
    pointList[0] = new Point(x, sc.nextDouble());
    System.out.println("Enter Top Right Point (2) in the following format:\nx y");
    x = sc.nextDouble();
    pointList[1] = new Point(x, sc.nextDouble());
    System.out.println("Enter Bottom Right Point (3) in the following format:\nx y");
    x = sc.nextDouble();
    pointList[2] = new Point(x, sc.nextDouble());
    System.out.println("Enter Bottom Left Point (4) in the following format:\nx y");
    x = sc.nextDouble();
    pointList[3] = new Point(x, sc.nextDouble());
    */
    System.out.println("Printing out everything from Quadrilateral Class(NO USER INPUT)\n");
    Quadrilateral ql = new Quadrilateral(pointList[0], pointList[1], pointList[2], pointList[3]);
    System.out.println("IS TRAPEZOID: " + (ql.isTrapezoid() ? "YES" : "NO"));
    System.out.println("IS PARALLELOGRAM: " + ql.isParallelogram());
    System.out.println("IS SQUARE: " + (ql.isSquare() ? "YES" : "NO"));


    System.out.close();
    //sc.close();
  }
}
