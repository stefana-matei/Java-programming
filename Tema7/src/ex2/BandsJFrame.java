package ex2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class BandsJFrame extends JFrame {


	private static final long serialVersionUID = -5996269975712301203L;
	private JPanel contentPane;
	private JTextField txtInput;

	
	public BandsJFrame(String title) {
		
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		JList<String> listBands = new JList<String>(listModel);
		contentPane.add(listBands, BorderLayout.CENTER);
		
		
		txtInput = new JTextField();
		txtInput.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				
				super.keyPressed(e);
				
				// 10 este enter in cod ASCII
				if (e.getKeyCode() == 10) {
					
					listModel.addElement(txtInput.getText());
					//	resetam caseta de text sa fie goala
					txtInput.setText("");
				}
			}
		});
		contentPane.add(txtInput, BorderLayout.NORTH);
		txtInput.setColumns(10);
		
		
		JButton btnStergere = new JButton("Sterge");
		btnStergere.addActionListener(new ActionListener() {
			
            public void actionPerformed(ActionEvent e) {
            	
                int[] selectedIndices = listBands.getSelectedIndices();
                
                for(int i = selectedIndices.length-1; i >= 0; i--) {
                	
                	listModel.removeElementAt(selectedIndices[i]);
                }
            }
        });
		contentPane.add(btnStergere, BorderLayout.SOUTH);
	}
}