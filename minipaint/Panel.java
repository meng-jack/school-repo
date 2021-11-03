import javax.swing.*;
import java.awt.Color.*;
import java.awt.*;
import java.awt.event.*;

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
  }

  private class Oval {
    private int startx, starty, endx, endy;
    private Color color;

    Oval(Point start, Point end, Color cc) {
      startx = start.x;
      starty = start.y;
      endx = end.x;
      endy = end.y;
      cc = color;
    }
  }

  private JPanel board, menu1;
  private JButton[] buttons = new JButton[6];
  private JLabel[] labels = new JLabel[2];
  private Color currColor = Color.BLACK;
  private Line[] lines = new Line[500];
  private int startx, starty, endx, endy;
  private Graphics g;
  private Dimension windowSize;

  MiniPaintPanel() {
    windowSize = new Dimension(800, 500);

    labels[0] = new JLabel("Current Color:");
    labels[0].setForeground(Color.BLACK);
    labels[0].setOpaque(true);
    labels[0].setAlignmentX(Component.CENTER_ALIGNMENT);

    labels[1] = new JLabel("Hello There"); // place holder text
    labels[1].setBackground(currColor);
    labels[1].setForeground(currColor);
    labels[1].setOpaque(true);
    labels[1].setAlignmentX(Component.CENTER_ALIGNMENT);

    buttons[0] = new JButton("                              ");
    buttons[0].setBackground(Color.GREEN);

    buttons[1] = new JButton("                              ");
    buttons[1].setBackground(Color.BLUE);

    buttons[2] = new JButton("                              ");
    buttons[2].setBackground(Color.RED);

    buttons[3] = new JButton("                              ");
    buttons[3].setBackground(Color.BLACK);

    buttons[4] = new JButton("                              ");
    buttons[4].setBackground(
        new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));

    buttons[5] = new JButton("                              ");
    buttons[5].setBackground(Color.ORANGE);

    menu1 = new JPanel();
    menu1.setLayout(new BoxLayout(menu1, BoxLayout.Y_AXIS));
    menu1.setBackground(Color.GRAY);
    menu1.setPreferredSize(new Dimension((int) windowSize.getWidth(),
        (int) windowSize.getHeight() / 4 + (int) windowSize.getHeight() / 3));
    menu1.add(labels[0]);
    menu1.add(labels[1]);

    // for repetitive initialization
    for (JButton jb : buttons) {
      jb.setForeground(Color.WHITE);
      jb.addActionListener(this);
      jb.setPreferredSize(new Dimension(100, 50));
      jb.setAlignmentX(Component.CENTER_ALIGNMENT);
      jb.setAlignmentY(Component.TOP_ALIGNMENT);
      menu1.add(jb);
    }

    board = new JPanel();
    board.addMouseListener(this);
    board.setPreferredSize(new Dimension((int) windowSize.getWidth(),
        (int) windowSize.getHeight() / 3 + (int) windowSize.getHeight() / 3));

    setLayout(new BorderLayout());
    add(board, BorderLayout.NORTH);
    add(menu1, BorderLayout.SOUTH);
  }

  public void updateText(Color cc) {
    currColor = cc;
    labels[1].setBackground(cc);
    labels[1].setForeground(cc);
    g = getGraphics();
    g.setColor(cc);
  }

  public void askSafeDraw() {
    if(lines.length == 500) {
      System.out.println("Overflow. Extending the storage");

    } else if(lines.length < Integer.MAX_VALUE - 1) {
      throw new RuntimeException("Size Limit exceeded.\nOverflow, cannot extend limt beyond Integer.MAX_VALUE");
    } else {
      g = getGraphics();
      g.setColor(currColor);
      g.drawLine(startx, starty, endx, endy);
    }

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

  }

  @Override
  public void mousePressed(MouseEvent e) {
    startx = e.getX();
    starty = e.getY();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    endx = e.getX();
    endy = e.getY();
    askSafeDraw();
  }

  @Override
  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    Graphics rg = (Graphics) gr;

  }

  //unused methods
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
