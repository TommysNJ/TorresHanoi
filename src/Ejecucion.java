import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejecucion extends JFrame{

    private JPanel panel1;
    private JTextField fieldNumBloques;
    private JButton empezarJuegoButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JButton mover21;
    private JButton mover31;
    private JButton mover12;
    private JButton mover13;
    private JButton mover23;
    private JButton mover32;
    private JButton button7;
    private Juego juego;
    private int contador;


    public Ejecucion() {
        setContentPane(panel1);

        empezarJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicioJuego();
            }
        });
    }

    private void mover(String actual, String destino) {
        try {
            juego.moverBloque(actual, destino);
            contador++;
            updateOutput();

            if (juego.finJuego()) {
                JOptionPane.showMessageDialog(this, "¡Has completado el juego en el número mínimo de movimientos!", "Juego completado", JOptionPane.INFORMATION_MESSAGE);
                disableMoveButtons();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void disableMoveButtons() {
        moveABButton.setEnabled(false);
        moveACButton.setEnabled(false);
        moveBAButton.setEnabled(false);
        moveBCButton.setEnabled(false);
        moveCAButton.setEnabled(false);
        moveCBButton.setEnabled(false);
    }

    private void inicioJuego() {
        try {
            int numBlocks = Integer.parseInt(fieldNumBloques.getText());
            juego = new Juego(numBlocks);

            fieldNumBloques.setEnabled(false);
            empezarJuegoButton.setEnabled(false);

            //updateOutput();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido de bloques.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}