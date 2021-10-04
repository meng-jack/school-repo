/**
 * @author Jack Meng
 * Purpose: This is a class that uses the fffffffffffffffffffffffffffffffffffffffffffffffff
 */
public class Quadrilateral {
 private Point p;
 public Quadrilateral (Point a, Point b, Point c, Point d){
   p = new Point[4];
  p[1] = a;
  p[2] = b;
  p[3] = c;
  p[4] = d;
 }
 public boolean isTrapezoid() {
  return a.slope(b) == c.slope(d) ? true : false; 
 }
 public boolean isParallelogram() {
  return a.slope(b) == c.slope(d) && a.slope(d) == c.slope(b) ? true : false; 
 }
 public boolean isSquare() {
  return a.distance(b) == c.distance(d) ? true : false;
 }
 
 public static boolean approx (double a, double b) {
  return (a - b) < 0.000001 ? true : false;
 }
  
}
