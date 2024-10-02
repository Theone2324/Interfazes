package interfaces;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;

public class Interfaz2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblImageDisplay;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Interfaz2 frame = new Interfaz2();
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
    public Interfaz2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Elija una opción para ver la imagen");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JRadioButton rdbtnPerro = new JRadioButton("Perro");
        
        JRadioButton rdbtnGato = new JRadioButton("Gato");
        
        JRadioButton rdbtnTigre = new JRadioButton("Tigre");
        
        JRadioButton rdbtnLeon = new JRadioButton("Leon");

        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnPerro);
        group.add(rdbtnGato);
        group.add(rdbtnTigre);
        group.add(rdbtnLeon);

        lblImageDisplay = new JLabel("");
        lblImageDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        lblImageDisplay.setBounds(50, 100, 300, 300);

        rdbtnPerro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblImageDisplay.setIcon(resizeImage("C:\\Users\\NITRO\\Documents\\Proyecto\\EjercicioBasicoJava\\Imagenes\\Perro.jpg"));
            }
        });

        rdbtnGato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblImageDisplay.setIcon(resizeImage("C:\\Users\\NITRO\\Documents\\Proyecto\\EjercicioBasicoJava\\Imagenes\\Gato.jpg"));
            }
        });

        rdbtnTigre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblImageDisplay.setIcon(resizeImage("C:\\Users\\NITRO\\\\Documents\\Proyecto\\EjercicioBasicoJava\\Imagenes\\Tigre.jpg"));
            }
        });

        rdbtnLeon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblImageDisplay.setIcon(resizeImage("C:\\Users\\NITRO\\Documents\\Proyecto\\EjercicioBasicoJava\\Imagenes\\Leon.jpg"));
            }
        });

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] options = { "Claro, que SI!", "Claro, que NO!" };
                int response = JOptionPane.showOptionDialog(null,
                        "¿Desea salir?", 
                        "Confirmación",  
                        JOptionPane.YES_NO_OPTION,  
                        JOptionPane.QUESTION_MESSAGE, 
                        null,  
                        options,  
                        options[0]);  

                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);  
                }
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(118)
                            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(rdbtnPerro, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdbtnGato, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdbtnTigre, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdbtnLeon, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
                            .addGap(18)
                            .addComponent(lblImageDisplay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                    .addComponent(btnSalir)
                    .addGap(18))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblNewLabel)
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(rdbtnPerro)
                            .addGap(18)
                            .addComponent(rdbtnGato)
                            .addGap(18)
                            .addComponent(rdbtnTigre)
                            .addGap(18)
                            .addComponent(rdbtnLeon))
                        .addComponent(lblImageDisplay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(50, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    .addContainerGap(22, Short.MAX_VALUE)
                    .addComponent(btnSalir)
                    .addGap(218))
        );
        contentPane.setLayout(gl_contentPane);
    }

    private ImageIcon resizeImage(String path) {
        ImageIcon imageIcon = new ImageIcon(path); 
        Image image = imageIcon.getImage(); 
        Image newimg = image.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH); 
        return new ImageIcon(newimg);  
    }
}