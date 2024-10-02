package interfaces;

import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz3 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private DefaultListModel<String> modeloVocales;
    private DefaultListModel<String> modeloConsonantes;
    private JList<String> listaVocales;
    private JList<String> listaConsonantes;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interfaz3 frame = new Interfaz3();
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
    public Interfaz3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        
        JLabel lblNewLabel = new JLabel("Ingrese Palabra");
        
        textField = new JTextField();
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("INGRESAR");
        
        JLabel lblNewLabel_1 = new JLabel("Comienza con vocal");
        
        JLabel lblNewLabel_2 = new JLabel("Comienza con consonante");
        
        modeloVocales = new DefaultListModel<>();
        modeloConsonantes = new DefaultListModel<>();
        
        listaVocales = new JList<>(modeloVocales);
        listaConsonantes = new JList<>(modeloConsonantes);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String palabra = textField.getText().trim().toLowerCase();
                
                if (!palabra.isEmpty()) {
                    if (esVocal(palabra.charAt(0))) {
                        modeloVocales.addElement(palabra); 
                    } else {
                        modeloConsonantes.addElement(palabra); 
                    }
                    textField.setText("");
                }
            }
        });
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(20)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(41)
        					.addComponent(btnNewButton))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        						.addComponent(listaVocales, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(listaConsonantes, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(268, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnNewButton))
        			.addGap(30)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(listaConsonantes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(listaVocales, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
        			.addContainerGap(45, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

    private boolean esVocal(char letra) {
        return "aeiou".indexOf(letra) != -1;
    }
}
