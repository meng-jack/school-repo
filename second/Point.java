package resource.quadrilateral;
public class Point {

  private double x, y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double distance(Point p) {
    return Math.sqrt(
      Math.pow((p.getX() - this.x), 2) + Math.pow(p.getY() - this.y, 2)
    );
  }

  public Point midpoint(Point p) {
    return new Point((p.getX() - this.x) / 2, (p.getY() - this.y) / 2);
  }

  /*
   * p.x = x2, etc.
   */
  public double slope(Point p) {
    if(p.x <= 0)
      return (p.y - y) / (p.x + x);
    return (p.y - y) / (p.x - x);
  }

  public boolean equals(Point p) {
    return approx(p.getX(), this.x) && approx(p.getY(), this.y) ? true : false;
  }

  public static boolean approx(double a, double b) {
    return (a - b) < 0.000001 ? true : false;
  }

  /* Bonus Methods Start */
  public Point translate(double deltaX, double deltaY) {
    return new Point(x + deltaX, y + deltaY);
  }

  // dilates by given factor, center at origin
  public Point dilate(double factor) {
    return new Point(x * factor, y * factor);
  }

  // reflects across line y = x
  public Point reflectYEqualsX() {
    return new Point(y, x);
  }

  // reflects across line x = xValue
  public Point reflectHorizontal(double xValue) {
    return null;
  }


  /* Bonus Methods End */

  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
