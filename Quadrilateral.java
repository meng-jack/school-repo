public class Quadrilateral {
 private Point a, Point b, Point c, Point d;
 public Quadrilateral (Point a, Point b, Point c, Point d){
   this.a = a;
   this.b = b;
   this.c = c;
   this.d = d;
 }
  
 public static boolean approx (double a, double b) {
  return (a - b) < 0.000001 ? true : false;
 }
  
}
