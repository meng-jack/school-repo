public class Quadrilateral {
 private Point a, Point b, Point c, Point d;
 public Quadrilateral (Point a, Point b, Point c, Point d){
   this.a = a;
   this.b = b;
   this.c = c;
   this.d = d;
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
