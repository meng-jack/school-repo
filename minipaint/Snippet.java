// Snippets

/* Draw Rectangle */
int dim_x = end.x - start.x;
int dim_y = end.y - start.y;


/* Refreshing JPanel with graphics drawings */
Object[] holder...
  
@Override
public void paintComponent(Graphics g) {
  super.paintComponent(g);
  
  askParseDrawings(holder);
  
}

public void askParseDrawings(Object[] f) {
  g = getGraphics();
  for(Object element : f) {
    if(element instanceof Line) {
      g.setColor(currColor);
      g.drawLine(g.startx, g.starty, end.x, end.y);
    } else if (element instance of Rectangle) {
      g.setColor(currColor);
      g.drawRect(start.x, start.y, end.x, end.y);
    }
  }
