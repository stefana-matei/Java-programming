package ex3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JEditorPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class MoviesJFrame extends JFrame {

	
	private static final long serialVersionUID = -4666176756797810921L;
	private JPanel contentPane;
	private JTextField txtFilm;
	private JTextField txtActori;
	private JLabel lblAnLansare;
	private JTable moviesTable;

	
	public MoviesJFrame(String title) {
		
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(301, 104, 65, 31);
		contentPane.add(spinner);
		SpinnerModel spinnerModel = new SpinnerNumberModel(2020,2015,2020,1);
		spinner.setModel(spinnerModel);
		
		
		JCheckBox ckbComedie = new JCheckBox("comedie");
		ckbComedie.setBounds(151, 162, 73, 21);
		contentPane.add(ckbComedie);
		
		
		JCheckBox ckbDrama = new JCheckBox("drama");
		ckbDrama.setBounds(226, 162, 59, 21);
		contentPane.add(ckbDrama);
		
		
		JCheckBox ckbIstoric = new JCheckBox("istoric");
		ckbIstoric.setBounds(287, 162, 65, 21);
		contentPane.add(ckbIstoric);
		
		
		JCheckBox ckbRomantic = new JCheckBox("romantic");
		ckbRomantic.setBounds(354, 162, 74, 21);
		contentPane.add(ckbRomantic);
		
		
		JCheckBox ckbActiune = new JCheckBox("actiune");
		ckbActiune.setBounds(248, 185, 74, 21);
		contentPane.add(ckbActiune);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 283, 583, 96);
		contentPane.add(scrollPane);
		
		
		moviesTable = new JTable();
		moviesTable.setColumnSelectionAllowed(true);
		moviesTable.setCellSelectionEnabled(true);
		scrollPane.setViewportView(moviesTable);
		String[] coloane = {"Film", "Actori", "An lansare", "Genuri"};
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(coloane);
		moviesTable.setModel(tableModel);

		
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String genuri = "";
				JCheckBox[] checkboxes = {ckbComedie, ckbDrama, ckbIstoric, ckbRomantic, ckbActiune};
				
				for(JCheckBox checkbox : checkboxes) {
					
					if(checkbox.isSelected())	//verificam care sunt bifate si le adaugam intr-un string
						genuri += checkbox.getText() + ", ";
				}
				
				tableModel.addRow(new Object[] {txtFilm.getText(), txtActori.getText(),(Integer)spinner.getValue(), genuri});				
			}
		});
		btnAdauga.setBounds(141, 227, 97, 26);
		contentPane.add(btnAdauga);
		
		
		txtFilm = new JTextField();
		txtFilm.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				
				if(txtFilm.getText().length() > 0 && txtActori.getText().length() > 0)
					btnAdauga.setEnabled(true);
				else
					btnAdauga.setEnabled(false);
			}
		});
		txtFilm.setBounds(196, 16, 240, 26);
		contentPane.add(txtFilm);
		txtFilm.setColumns(10);
		
		
		txtActori = new JTextField();
		txtActori.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				
				if(txtActori.getText().length() > 0 && txtFilm.getText().length() > 0 )
					btnAdauga.setEnabled(true);
				else
					btnAdauga.setEnabled(false);
				
			}
		});
		txtActori.setBounds(196, 58, 240, 26);
		contentPane.add(txtActori);
		txtActori.setColumns(10);
		
		
		JButton btnSterge = new JButton("Sterge");
		btnSterge.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(tableModel.getRowCount() > 0) {
					
					int[] rows = moviesTable.getSelectedRows();
					
					 for(int i = rows.length-1; i >= 0; i--) {
		                	
							tableModel.removeRow(rows[i]);
					 }
				}
			}
		});
		btnSterge.setBounds(339, 227, 97, 26);
		contentPane.add(btnSterge);
		
		

		JLabel lblFilm = new JLabel("Film");
		lblFilm.setBounds(141, 22, 45, 13);
		contentPane.add(lblFilm);
		
		
		JLabel lblActori = new JLabel("Actori");
		lblActori.setBounds(141, 64, 45, 13);
		contentPane.add(lblActori);
		
		
		
		lblAnLansare = new JLabel("An lansare");
		lblAnLansare.setBounds(141, 110, 59, 13);
		contentPane.add(lblAnLansare);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(SystemColor.control);
		editorPane.setForeground(UIManager.getColor("Button.foreground"));
		editorPane.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Genuri", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		editorPane.setBounds(141, 145, 295, 72);
		contentPane.add(editorPane);	
	}
}