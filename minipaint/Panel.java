import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiniPaintPanel extends JPanel implements MouseListener, ActionListener {
  private class Line {
    private int startx, starty, endx, endy;
    private Color color;

    Line(Point start, Point end, Color cc) {
      startx = start.x;
      starty = start.y;
      endx = end.x;
      endy = end.y;
      color = cc;
    }

    public String toString() {
      return "Line: (" + startx + ", " + starty + ") to (" + endx + ", " + endy + ")\nColor: " + color + "\n";
    }
  }

  private class Rectangle {
    private int startx, starty, endx, endy, width = 0, height = 0;
    private Color color;

    Rectangle(Point start, Point end, Color cc) {
      startx = start.x;
      starty = start.y;
      endx = end.x;
      endy = end.y;
      cc = color;
    }

    public String toString() {
      return "Rectangle: (" + startx + ", " + starty + ") to (" + endx + ", " + endy + ")\nColor: " + color + "\n";
    }
  }

  private JPanel board, menu1;
  private String shape = "line";
  private JButton[] buttons = new JButton[8];
  private JLabel[] labels = new JLabel[2];
  private Color currColor = Color.BLACK;
  private int startx, starty, endx, endy;
  private boolean line = true; // true == line ;; false == rectangle
  private Dynanmic entities = new Dynanmic(500);
  private Graphics g;
  private Dimension windowSize, boardSize;

  MiniPaintPanel() {
    windowSize = new Dimension(800, 500);

    labels[0] = new JLabel("<html>Current Shape: " + shape + "<br>Current Color:<html>");
    labels[0].setForeground(Color.BLACK);
    labels[0].setOpaque(true);
    labels[0].setAlignmentX(Component.LEFT_ALIGNMENT);

    labels[1] = new JLabel("Hello There"); // place holder text
    labels[1].setBackground(currColor);
    labels[1].setForeground(currColor);
    labels[1].setOpaque(true);
    labels[1].setAlignmentX(Component.LEFT_ALIGNMENT);

    buttons[0] = new JButton("     ");
    buttons[0].setBackground(Color.GREEN);

    buttons[1] = new JButton("     ");
    buttons[1].setBackground(Color.BLUE);

    buttons[2] = new JButton("     ");
    buttons[2].setBackground(Color.RED);

    buttons[3] = new JButton("     ");
    buttons[3].setBackground(Color.BLACK);

    buttons[4] = new JButton("     ");
    buttons[4].setBackground(
        new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));

    buttons[5] = new JButton("     ");
    buttons[5].setBackground(Color.ORANGE);

    buttons[6] = new JButton("Change Shape");
    buttons[6].setBackground(Color.BLACK);
    
    buttons[7] = new JButton("Clear Board");
    buttons[7].setBackground(Color.BLACK);

    menu1 = new JPanel();
    menu1.setLayout(new BoxLayout(menu1, BoxLayout.Y_AXIS));
    menu1.setBackground(Color.GRAY);
    menu1.setPreferredSize(new Dimension((int) windowSize.getWidth(),
        (int) windowSize.getHeight() / 3 + (int) windowSize.getHeight() / 4));

    menu1.add(labels[0]);
    menu1.add(labels[1]);

    // for repetitive initialization
    for (JButton jb : buttons) {
      jb.setForeground(Color.WHITE);
      jb.addActionListener(this);
      jb.setAlignmentX(Component.LEFT_ALIGNMENT);
      jb.setAlignmentY(Component.TOP_ALIGNMENT);
      menu1.add(jb);
    }

    board = new JPanel();
    board.addMouseListener(this);
    board.setOpaque(true);
    board.setPreferredSize(new Dimension((int) windowSize.getWidth(), (int) windowSize.getHeight()));

    setLayout(new BorderLayout());
    
    add(board, BorderLayout.NORTH);
    add(menu1, BorderLayout.SOUTH);

  }

  protected void askDraw(Point start, Point end, Color cc, boolean line) {
    g = getGraphics();
    g.setColor(cc);
    if(line) {
      g.drawLine(start.x, start.y, end.x, end.y);
      entities.add(new Line(start, end, cc));
    } else
      System.out.println("NOT YET");
  }

  public void updateText(Color cc) {
    currColor = cc;
    labels[1].setBackground(cc);
    labels[1].setForeground(cc);
    g = getGraphics();
    g.setColor(cc);
  }

  public void storeEntity(Object obj) {
    entities.add(obj);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g = getGraphics();

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == buttons[0])
      updateText(Color.GREEN);
    else if (e.getSource() == buttons[1])
      updateText(Color.BLUE);
    else if (e.getSource() == buttons[2])
      updateText(Color.RED);
    else if (e.getSource() == buttons[3])
      updateText(Color.BLACK);
    else if (e.getSource() == buttons[4]) {
      Color rar = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
      updateText(rar);
      buttons[4].setBackground(rar);
    } else if (e.getSource() == buttons[5])
      updateText(Color.ORANGE);
    else if (e.getSource() == buttons[6]) {
      if (line) {
        shape = "rectangle";
        labels[0].setText("<html>Current Shape: " + shape + "<br>Current Color:<html>");
        line = false;
      } else {
        shape = "line";
        labels[0].setText("<html>Current Shape: " + shape + "<br>Current Color:<html>");
        line = true;
      }
    } else if(e.getSource() == buttons[7]) {
      g = getGraphics();
      g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

  }

  // action listeners (used)
  @Override
  public void mousePressed(MouseEvent e) {
    startx = e.getX();
    starty = e.getY();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    endx = e.getX();
    endy = e.getY();
    askDraw(new Point(startx, starty), new Point(endx, endy), currColor, line);
  }

  // unused methods
  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }
}
