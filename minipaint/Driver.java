import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        // for handling exceptions within the program when thrown during execution
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame jf = new JFrame("Jack Meng - MiniPaint");
            MiniPaintPanel mpp = new MiniPaintPanel();
            jf.add(mpp);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.pack();
            jf.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
