package resource.quadrilateral;

/**
 * @author Jack Meng Purpose: This is a class that uses the Point class to
 *         determine certain properties of said points
 */
public class Quadrilateral {

  private Point[] pointAT = new Point[4];
  
  public Quadrilateral(Point topLeft, Point botLeft, Point topRight, Point botRight) {
    pointAT[0] = topLeft;
    pointAT[1] = botLeft;
    pointAT[2] = topRight;
    pointAT[3] = botRight;
  }

  /**
   * This method only checks if at least two segments are parallel
   * 
   * @return True if the given points are a trapezoid if not return false
   */
  public boolean isTrapezoid() {
    if((pointAT[0].slope(pointAT[1]) == pointAT[3].slope(pointAT[2])) && (pointAT[0].slope(pointAT[3]) != pointAT[1].slope(pointAT[2])))
      return true;
    return false;
  }

  /**
   * This method determines if the said points are in the form of a parallelogram
   * 
   * @return True if the given points are a parallelogram if not return false
   */
  public boolean isParallelogram() {
    return (pointAT[0].slope(pointAT[1]) == pointAT[2].slope(pointAT[3]) && pointAT[2].slope(pointAT[0]) == pointAT[3].slope(pointAT[1])) ? true : false;
  }

  /**
   * This method determines if the said points are in a square meaning they must
   * be a parallelogram and also have the same all around distance between points
   * 
   * @return True if the given points are a square if not return false
   */
  public boolean isSquare() {
    if(isParallelogram()) {
      if(pointAT[0].distance(pointAT[1]) == pointAT[2].distance(pointAT[3]) && (pointAT[0].distance(pointAT[2]) == pointAT[2].distance(pointAT[1])))
        return true;
    }
    return false;
     /*
    return (isParallelogram()
        && (pointAT[0].distance(pointAT[1]) == pointAT[2].distance(pointAT[3]) && (pointAT[0].distance(pointAT[2]) == pointAT[2].distance(pointAT[1])))) ? true : false;
        */
  }

  public boolean isRectangle() {
    if (isParallelogram()) {
      if (pointAT[0].distance(pointAT[1]) == pointAT[2].distance(pointAT[3]) && (pointAT[0].distance(pointAT[2]) == pointAT[1].distance(pointAT[3]))){
        return true;
      }
    }
    return false;
  }

  /*
  public boolean isRhombus() {
    if(isParallelogram()) {
      if(pointAT[0].slope(pointAT[2]))
    }
     return false;
  }
  */
  public static boolean approx(double a, double b) {
    return (a - b) < 0.000001 ? true : false;
  }

  public String toString() {
    return "Point 1: " + pointAT[0].toString() + "\nPoint 2: " + pointAT[1].toString() + "\nPoint 3: " + pointAT[2].toString()
        + "\nPoint 4: " + pointAT[3].toString();
  }
}
