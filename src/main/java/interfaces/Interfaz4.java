package interfaces;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Interfaz4 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private ArrayList<String> palabrasList; 
    private JTable table; 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interfaz4 frame = new Interfaz4();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Interfaz4() {
        palabrasList = new ArrayList<>(); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel lblNewLabel = new JLabel("Ingrese Palabra");
        
        textField = new JTextField();
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("Ingresar");
        btnNewButton.addActionListener(e -> ingresarPalabra()); 
        
        JButton btnNewButton_1 = new JButton("Mostrar");
        btnNewButton_1.addActionListener(e -> mostrarPalabras()); 
        
        JScrollPane scrollPane = new JScrollPane();
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Palabras Ingresadas" }
        ));
        scrollPane.setViewportView(table);
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(69)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNewButton))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnNewButton_1)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(158, Short.MAX_VALUE))
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel))
                    .addGap(36)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNewButton)
                        .addComponent(btnNewButton_1))
                    .addGap(18)
                    .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
    
    private void ingresarPalabra() {
        String palabra = textField.getText().trim();
        
        if (palabra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de texto está vacío. Por favor, ingrese una palabra.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (palabra.length() > 10) {
            JOptionPane.showMessageDialog(this, "La palabra no puede tener más de 10 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            palabrasList.add(palabra);
            JOptionPane.showMessageDialog(this, "Palabra ingresada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            textField.setText(""); 
        }
    }
    
    private void mostrarPalabras() {
        if (palabrasList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay palabras ingresadas.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); 
            
            for (String palabra : palabrasList) {
                model.addRow(new Object[] { palabra });
            }
        }
    }
}
