import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejecucion extends JFrame{

    private JPanel panel1;
    private JTextField fieldNumBloques;
    private JButton empezarJuegoButton;
    private JTextArea areaTorre1;
    private JTextArea areaTorre2;
    private JTextArea areaTorre3;
    private JButton mover21Button;
    private JButton mover31Button;
    private JButton mover12Button;
    private JButton mover13Button;
    private JButton mover23Button;
    private JButton mover32Button;
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

        mover12Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mover("1","2");
            }
        });
        mover13Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mover("1","3");
            }
        });
        mover21Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mover("2","1");
            }
        });
        mover23Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mover("2","3");
            }
        });
        mover31Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mover("3","1");
            }
        });
        mover32Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mover("3","2");
            }
        });
    }

    private void mover(String actual, String destino) {
        try {
            juego.moverBloque(actual, destino);
            actualizar();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void disableMoveButtons() {
        mover12Button.setEnabled(false);
        mover13Button.setEnabled(false);
        mover21Button.setEnabled(false);
        mover23Button.setEnabled(false);
        mover31Button.setEnabled(false);
        mover32Button.setEnabled(false);
    }

    private void inicioJuego() {
        try {
            int numBlocks = Integer.parseInt(fieldNumBloques.getText());
            juego = new Juego(numBlocks);

            fieldNumBloques.setEnabled(false);
            empezarJuegoButton.setEnabled(false);

            actualizar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido de bloques.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizar() {
        areaTorre1.setText("Torre 1:\n");
        for (int i = juego.getTorre("1").getNumBloque() - 1; i >= 0; i--) {
            int tamanio = juego.getTorre("1").getTopBloque().getTamanio();
            for (int j = 0; j < tamanio; j++) {
                areaTorre1.append("#");
            }
            areaTorre1.append("\n");
            juego.getTorre("1").popBloque();
        }

        areaTorre2.setText("Torre 2:\n");
        for (int i = juego.getTorre("2").getNumBloque() - 1; i >= 0; i--) {
            int tamanio = juego.getTorre("2").getTopBloque().getTamanio();
            for (int j = 0; j < tamanio; j++) {
                areaTorre2.append("#");
            }
            areaTorre2.append("\n");
            juego.getTorre("2").popBloque();
        }

        areaTorre3.setText("Torre 3:\n");
        for (int i = juego.getTorre("3").getNumBloque() - 1; i >= 0; i--) {
            int tamanio = juego.getTorre("3").getTopBloque().getTamanio();
            for (int j = 0; j < tamanio; j++) {
                areaTorre3.append("#");
            }
            areaTorre3.append("\n");
            juego.getTorre("3").popBloque();
        }
    }
}