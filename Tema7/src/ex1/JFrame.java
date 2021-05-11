package ex1;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 2577761109480372225L;
	private JPanel contentPane;
	private JTextField txtOperand1;
	private JTextField txtOperand2;

	public JFrame(String str) {

		super(str);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		txtOperand1 = new JTextField();
		txtOperand1.setBounds(159, 15, 164, 19);
		contentPane.add(txtOperand1);
		txtOperand1.setColumns(10);

		
		txtOperand2 = new JTextField();
		txtOperand2.setBounds(159, 53, 164, 19);
		contentPane.add(txtOperand2);
		txtOperand2.setColumns(10);

		
		JLabel lblOperand1 = new JLabel("Operand 1");
		lblOperand1.setBounds(42, 10, 80, 28);
		contentPane.add(lblOperand1);

		
		JLabel lblOperand2 = new JLabel("Operand 2");
		lblOperand2.setBounds(42, 48, 80, 28);
		contentPane.add(lblOperand2);

		
		JLabel lblRezultat = new JLabel("");
		lblRezultat.setForeground(Color.BLACK);
		lblRezultat.setBackground(Color.WHITE);
		lblRezultat.setOpaque(true);
		lblRezultat.setBounds(37, 179, 286, 34);
		contentPane.add(lblRezultat);

		
		JButton btnAdunare = new JButton("Adunare");
		btnAdunare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String a = txtOperand1.getText();
				String b = txtOperand2.getText();

				try {
					CheckHelper.isEmpty(a);
					CheckHelper.isEmpty(b);

					lblRezultat.setText(Double.parseDouble(a) + Double.parseDouble(b) + "");
					
				} catch (NumericException exceptie) {

					System.out.println(exceptie);
					lblRezultat.setText(exceptie.toString());
				}
				
				catch (NumberFormatException exceptie) {

					System.out.println("\nExceptie : nu se introduc cuvinte!Introduceti doar numere\n");
					lblRezultat.setText("Nu se introduc cuvinte!");
				}

			}
		});
		btnAdunare.setBounds(37, 86, 135, 21);
		contentPane.add(btnAdunare);

		
		JButton btnScadere = new JButton("Scadere");
		btnScadere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a = txtOperand1.getText();
				String b = txtOperand2.getText();

				try {
					CheckHelper.isEmpty(a);
					CheckHelper.isEmpty(b);

					lblRezultat.setText(Double.parseDouble(a) - Double.parseDouble(b) + "");
					
				} catch (NumericException exceptie) {

					System.out.println(exceptie);
					lblRezultat.setText(exceptie.toString());

				}
				
				catch (NumberFormatException exceptie) {

					System.out.println("\nExceptie : nu se introduc cuvinte!Introduceti doar numere\n");
					lblRezultat.setText("Nu se introduc cuvinte!");
				}
			}

		});
		btnScadere.setBounds(188, 86, 135, 21);
		contentPane.add(btnScadere);

		
		JButton btnInmultire = new JButton("Inmultire");
		btnInmultire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a = txtOperand1.getText();
				String b = txtOperand2.getText();

				try {
					CheckHelper.isEmpty(a);
					CheckHelper.isEmpty(b);

					lblRezultat.setText(Double.parseDouble(a) * Double.parseDouble(b) + "");
					
				} catch (NumericException exceptie) {

					System.out.println(exceptie);
					lblRezultat.setText(exceptie.toString());
				}
				
				catch (NumberFormatException exceptie) {

					System.out.println("\nExceptie : nu se introduc cuvinte!Introduceti doar numere\n");
					lblRezultat.setText("Nu se introduc cuvinte!");
				}
			}

		});
		btnInmultire.setBounds(37, 129, 135, 21);
		contentPane.add(btnInmultire);

		
		JButton btnImpartire = new JButton("Impartire");
		btnImpartire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a = txtOperand1.getText();
				String b = txtOperand2.getText();
				


				try {
					CheckHelper.isEmpty(a);
					CheckHelper.isEmpty(b);
					
					CheckHelper.checkZero(b);
					
					lblRezultat.setText(Double.parseDouble(a) / Double.parseDouble(b) + "");


				} catch (NumericException exceptie) {

					System.out.println(exceptie);
					
					lblRezultat.setText(exceptie.toString());
				}
				
				catch (NumberFormatException exceptie) {

					System.out.println("\nExceptie : nu se introduc cuvinte!Introduceti doar numere\n");
					lblRezultat.setText("Nu se introduc cuvinte!");
				}
			}

		});
		btnImpartire.setBounds(188, 129, 135, 21);
		contentPane.add(btnImpartire);

		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRezultat.setText("");
			}
		});
		btnClear.setBounds(37, 232, 286, 21);
		contentPane.add(btnClear);
	}
}