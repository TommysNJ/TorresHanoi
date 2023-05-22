import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Ejecucion();
                frame.setSize(600, 750);
                frame.setVisible(true);
            }
        });
    }
}