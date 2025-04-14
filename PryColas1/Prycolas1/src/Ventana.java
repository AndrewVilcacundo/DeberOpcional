import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;

public class Ventana {

    private JComboBox cboMarca;
    private JPanel principal;
    private JTextField txtAnio;
    private JButton btnEncolar;
    private JButton btnDesencolar;
    private JTextArea txtListado;
    private JLabel lblPago;
    private ColaAutos autos = new ColaAutos();

    public Ventana() {
        btnEncolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int anio = Integer.parseInt(txtAnio.getText());
                    if (anio < 1900 || anio > 2025) {
                        JOptionPane.showMessageDialog(null, "El año debe estar entre 1900 y 2025.");
                        return;
                    }
                    String marca = cboMarca.getSelectedItem().toString();
                    autos.encolar(new Auto(marca, anio));
                    txtListado.setText(autos.listarTodos());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingresa un año válido.");
                }
            }
        });

        btnDesencolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Auto atendido = autos.desencolar();
                    int pago = calcularPago(atendido.getAnio());
                    lblPago.setText("Último auto atendido: " + atendido + " | Pago: $" + pago);
                    txtListado.setText(autos.listarTodos());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public int calcularPago(int anioAuto) {
        int anioActual = Year.now().getValue();
        int diferencia = anioActual - anioAuto;
        return (diferencia+1) * 50;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);
        frame.setVisible(true);
    }
}