package interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class Interfaz1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNumeroGenerado; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz1 frame = new Interfaz1();
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
	public Interfaz1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Generador Números");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("entre 0 y 100");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("entre 100 y 200");
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("entre 200 y 500");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);

		JButton btnNewButton = new JButton("Generar");
		lblNumeroGenerado = new JLabel("Número generado: "); 

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int min = 0, max = 0;
				if (rdbtnNewRadioButton.isSelected()) {
					max = 100;
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					min = 100;
					max = 200;
				} else if (rdbtnNewRadioButton_2.isSelected()) {
					min = 200;
					max = 500;
				}

				Random rand = new Random();
				int numeroGenerado = rand.nextInt(max - min + 1) + min;
				lblNumeroGenerado.setText("Número generado: " + numeroGenerado);  
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnNewRadioButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtnNewRadioButton, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(rdbtnNewRadioButton_2)))
						.addComponent(lblNumeroGenerado, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(136, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnNewRadioButton))
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_1)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_2)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(lblNumeroGenerado)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
