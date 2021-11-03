import javax.swing.*;
import java.awt.Color.*;
import java.awt.*;
import java.awt.event.*;

public class MiniPaintDriver {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Jack Meng - MiniPaint");
        MiniPaintPanel mpp = new MiniPaintPanel();
        jf.add(mpp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
}
