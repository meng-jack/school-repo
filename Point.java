public class Point {
  private double x, y;
  
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  public double getX() {
    return x == null ? 0.0d : this.x; 
  }
  public double getY() {
    return y == null ? 0.0d : this.x;  
  }
  public double distance (Point p) {
    return Math.sqrt(Math.pow((p.getX() - this.x), 2) + Math.pow(p.getY() - this.y));
  }
  public Point midpoint (Point p) {
    return new Point((p.getX() - this.x) / 2, (p.getY() - this.y) / 2);
  }
  public double slope (Point p) {
    return (p.getY() - this.y) / (p.getX() - this.y); 
  }
  
  public boolean equals (Point p) {
    return approx(p.getX(), this.x) ? true : false;
  }
  
  public static boolean approx (double a, double b) {
    return (a - b) < 0.000001 ? true : false;
  }
   
}
