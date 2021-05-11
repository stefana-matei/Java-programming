package program;

import java.awt.BorderLayout;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TabelJFrame extends JFrame {

	private static final long serialVersionUID = 1847632128655408277L;
	private JPanel contentPane;
	private JTextField txtNumerotare;
	private JTextField txtID;
	private JTextField txtNume;
	private JTextField txtVarsta;
	
	int checkAdaugare = 0;
	int checkEditare = 0;
	
	
	public TabelJFrame(String title) throws SQLException {

		
		super(title);

		String url = "jdbc:mysql://localhost:3306/test";
		Statement sql;
		ResultSet result;
		Connection connection = DriverManager.getConnection(url, "root", "studentupt1998$");
		sql = connection.createStatement();
		sql = connection.prepareStatement("select * from persoane where username=root and password=studentupt1998$", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		result = sql.executeQuery("select * from persoane");
		
		result.first();
		int first = result.getRow();
		
		result.last();
		int size = result.getRow();
		
		result.first();

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		
		txtID = new JTextField();
		txtNume = new JTextField();
		txtVarsta = new JTextField();
		txtNumerotare = new JTextField();
		txtNumerotare.setEditable(false);
		
		
		// buton MovePrevious
		JButton btnMovePrevious = new JButton("");
		btnMovePrevious.setEnabled(false);
		Image imgMovePrevious = new ImageIcon(this.getClass().getResource("/MovePrevious.png")).getImage();
		
		
		// buton MoveFirst
		JButton btnMoveFirst = new JButton("");
		btnMoveFirst.setEnabled(false);
		Image imgMoveFirst = new ImageIcon(this.getClass().getResource("/MoveFirst.png")).getImage();
		
		
		// buton MoveNext
		JButton btnMoveNext = new JButton("");
		Image imgMoveNext = new ImageIcon(this.getClass().getResource("/MoveNext.png")).getImage();
		
		
		// buton MoveLast
		JButton btnMoveLast = new JButton("");
		Image imgMoveLast = new ImageIcon(this.getClass().getResource("/MoveLast.png")).getImage();
		btnMoveLast.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					result.last();
					
					
					btnMoveFirst.setEnabled(true);
					btnMovePrevious.setEnabled(true);
					btnMoveNext.setEnabled(false);
					btnMoveLast.setEnabled(false);
					
					txtID.setText(String.valueOf(result.getInt("id")));
					txtNume.setText(result.getString("nume"));
					txtVarsta.setText(String.valueOf(result.getInt("varsta")));
					txtNumerotare.setText(size + "/" + size);
					
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	
		btnMoveNext.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if(result.next() && result.getRow() != size) {
						
						btnMoveFirst.setEnabled(true);
						btnMovePrevious.setEnabled(true);
						btnMoveNext.setEnabled(true);
						btnMoveLast.setEnabled(true);
						
						txtID.setText(String.valueOf(result.getInt("id")));
						txtNume.setText(result.getString("nume"));
						txtVarsta.setText(String.valueOf(result.getInt("varsta")));
						txtNumerotare.setText(result.getRow() + "/" + size);
						
					}
					else {
						
						result.last();
						
						btnMoveFirst.setEnabled(true);
						btnMovePrevious.setEnabled(true);
						btnMoveNext.setEnabled(false);
						btnMoveLast.setEnabled(false);
						
						txtID.setText(String.valueOf(result.getInt("id")));
						txtNume.setText(result.getString("nume"));
						txtVarsta.setText(String.valueOf(result.getInt("varsta")));
						txtNumerotare.setText(result.getRow() + "/" + size);
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
					
		btnMovePrevious.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if(result.previous() && result.getRow() != 1) {
						
						btnMoveFirst.setEnabled(true);
						btnMovePrevious.setEnabled(true);
						btnMoveNext.setEnabled(true);
						btnMoveLast.setEnabled(true);
						
						txtID.setText(String.valueOf(result.getInt("id")));
						txtNume.setText(result.getString("nume"));
						txtVarsta.setText(String.valueOf(result.getInt("varsta")));
						txtNumerotare.setText(result.getRow() + "/" + size);
						
					}
					else {
						
						result.first();
						
						btnMoveFirst.setEnabled(false);
						btnMovePrevious.setEnabled(false);
						btnMoveNext.setEnabled(true);
						btnMoveLast.setEnabled(true);
						
						txtID.setText(String.valueOf(result.getInt("id")));
						txtNume.setText(result.getString("nume"));
						txtVarsta.setText(String.valueOf(result.getInt("varsta")));
						txtNumerotare.setText(result.getRow() + "/" + size);
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		btnMoveFirst.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				try {

					result.first();

					btnMoveFirst.setEnabled(false);
					btnMovePrevious.setEnabled(false);
					btnMoveNext.setEnabled(true);
					btnMoveLast.setEnabled(true);
					
					
					txtID.setText(String.valueOf(result.getInt("id")));
					txtNume.setText(result.getString("nume"));
					txtVarsta.setText(String.valueOf(result.getInt("varsta")));
					txtNumerotare.setText(first + "/" + size);
					

				} 
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(btnMoveFirst);
		btnMoveFirst.setIcon(new ImageIcon(imgMoveFirst));
		
		
		toolBar.add(btnMovePrevious);
		btnMovePrevious.setIcon(new ImageIcon(imgMovePrevious));

		
		toolBar.add(txtNumerotare);
		txtNumerotare.setText(first + "/" + size);
		txtNumerotare.setColumns(10);

		
		toolBar.add(btnMoveNext);
		btnMoveNext.setIcon(new ImageIcon(imgMoveNext));

		
		toolBar.add(btnMoveLast);
		btnMoveLast.setIcon(new ImageIcon(imgMoveLast));

		
		// buton Add
		JButton btnAdd = new JButton("");
		Image imgAdd = new ImageIcon(this.getClass().getResource("/Add.png")).getImage();
		
		
		// buton Edit
		JButton btnEdit = new JButton("");
		Image imgEdit = new ImageIcon(this.getClass().getResource("/Edit.png")).getImage();
				
				
		// buton Delete
		JButton btnDelete = new JButton("");
		Image imgDelete = new ImageIcon(this.getClass().getResource("/Delete.png")).getImage();
		
		
		// buton Find
		JButton btnFind = new JButton("");
		Image imgFind = new ImageIcon(this.getClass().getResource("/find.JPG")).getImage();
		
		
		// buton Save
		JButton btnSave = new JButton("");
		Image imgSave = new ImageIcon(this.getClass().getResource("/save.JPG")).getImage();
		
		
		// buton Undo
		JButton btnUndo = new JButton("");
		Image imgUndo = new ImageIcon(this.getClass().getResource("/undo.JPG")).getImage();
		btnUndo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(result.getRow() != 1) {
						
						btnMoveFirst.setEnabled(true);
						btnMovePrevious.setEnabled(true);
					}
					else {
					
						btnMoveFirst.setEnabled(false);
						btnMovePrevious.setEnabled(false);
					}
				} 
				catch (SQLException e1) {

					e1.printStackTrace();
				}
				
				
				try {
					
					if(result.getRow() != size) {
						
						btnMoveNext.setEnabled(true);
						btnMoveLast.setEnabled(true);
					}
					else {
						
						btnMoveNext.setEnabled(false);
						btnMoveLast.setEnabled(false);
					}
				}
				catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				btnAdd.setEnabled(true);
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				btnFind.setEnabled(true);
				btnSave.setEnabled(false);
				btnUndo.setEnabled(false);
				
				
				txtID.setEditable(false);
				try {
					
					txtID.setText(String.valueOf(result.getInt("id")));
				} 
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
				txtNume.setEditable(false);
				try {
					
					txtNume.setText(result.getString("nume"));
				} 
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
				txtVarsta.setEditable(false);
				try {
					
					txtVarsta.setText(String.valueOf(result.getInt("varsta")));
				} 
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
				checkAdaugare = 0;
				checkEditare = 0;
			}
		});
		
					
		btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Object[] optiuniDelete = {"Ok", "Cancel"};
				int stergere = JOptionPane.showOptionDialog(null, "Sunteti sigur ca doriti sa stergeti persoana curenta?",
						"Confirmare stergere", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
						optiuniDelete, optiuniDelete[0]);
				
				
				switch(stergere) {
				
				case JOptionPane.YES_OPTION : 
					
					try {
						
						int idCurent = result.getInt("id");
						String url = "jdbc:mysql://localhost:3306/test";
						
						PreparedStatement statement = null;
						Connection connection = null;
						
						
						connection = DriverManager.getConnection(url, "root", "studentupt1998$");
						statement = connection.prepareStatement("delete from persoane where id = ?");
						
						
						int sters = statement.executeUpdate("delete from persoane where ID = '" + idCurent + "'");
						connection.close();
						
						
						if(sters > 0) {
							
							JOptionPane.showMessageDialog(null, "Inregistrarea a fost stearsa!", "Succes",  JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							
							JOptionPane.showMessageDialog(null, "Eroare, nu s-a sters inregistrarea!", "Eroare", JOptionPane.ERROR_MESSAGE);							
						}
						
					}
					catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				break;
				}
			}
		});
				
				
		
		btnFind.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String cautareNume = JOptionPane.showInputDialog(null,"Numele");
				int gasit = 0;
				
				
				try {
					
					int previousPosition = result.getRow();
					result.beforeFirst();
					
					
					do {
						
						result.next();
						
						
						if(result.isAfterLast()) {
							
							JOptionPane.showMessageDialog(null, "Persoana cu numele cautat nu exista in baza de date!",
									"Eroare", JOptionPane.ERROR_MESSAGE);
							result.absolute(previousPosition);
							break;
						}
						
						
						//daca se gaseste numele in baza de date
						if(result.getString("nume").equals(cautareNume)) {
							
							gasit = 1;
							
							
							txtID.setText(String.valueOf(result.getInt("id")));
							txtNume.setText(result.getString("nume"));
							txtVarsta.setText(String.valueOf(result.getInt("varsta")));
							txtNumerotare.setText(result.getRow() + "/" + size);
							
							
							if(result.getRow() == first) {
								
								btnMoveFirst.setEnabled(false);
								btnMovePrevious.setEnabled(false);
								btnMoveNext.setEnabled(true);
								btnMoveLast.setEnabled(true);
							}
							
							
							if(result.getRow() == size) {
								
								btnMoveFirst.setEnabled(true);
								btnMovePrevious.setEnabled(true);
								btnMoveNext.setEnabled(false);
								btnMoveLast.setEnabled(false);
							}
							
							
							if(result.getRow() != first && result.getRow() != size) {
								
								btnMoveFirst.setEnabled(true);
								btnMovePrevious.setEnabled(true);
								btnMoveNext.setEnabled(true);
								btnMoveLast.setEnabled(true);
							}
						}
						
						
					}while(gasit == 0);
					
				} 
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
					
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(checkAdaugare == 1) {
					
					try {
						
						String url = "jdbc:mysql://localhost:3306/test";
						PreparedStatement statement = null;
						Connection connection = null;
						connection = DriverManager.getConnection(url, "root", "studentupt1998$");
						statement = connection.prepareStatement("insert into persoane(id, nume, varsta) values(?, ?, ?)");
						
						
						int savedID = Integer.parseInt(txtID.getText());
						String savedNume = txtNume.getText();
						int savedVarsta = Integer.parseInt(txtVarsta.getText());
						
						
						statement.setInt(1, savedID);
						statement.setString(2, savedNume);
						statement.setInt(3, savedVarsta);
						
						
						int savedSucces = statement.executeUpdate();
						connection.close();
						
						
						if(savedSucces > 0) {
							
							JOptionPane.showMessageDialog(null, "Adaugarea a fost realizata cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							
							JOptionPane.showMessageDialog(null, "Eroare la adaugare!", "Eroare", JOptionPane.ERROR_MESSAGE);
						}
						
						
						btnMoveFirst.setEnabled(true);
						btnMovePrevious.setEnabled(true);
						btnMoveNext.setEnabled(true);
						btnMoveLast.setEnabled(true);
						btnAdd.setEnabled(true);
						btnEdit.setEnabled(true);
						btnDelete.setEnabled(true);
						btnFind.setEnabled(true);
						btnSave.setEnabled(false);
						btnUndo.setEnabled(false);
						
						
						txtID.setEditable(false);
						txtID.setText(String.valueOf(result.getInt("id")));

						
						txtNume.setEditable(false);
						txtNume.setText(result.getString("nume"));
						
						
						txtVarsta.setEditable(false);
						txtVarsta.setText(String.valueOf(result.getInt("varsta")));
						
						
						checkAdaugare = 0;
					} 
					catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
				
				
				if(checkEditare == 1) {
					
					try {
						
						int idCurent = result.getInt("id");
						
						
						String url = "jdbc:mysql://localhost:3306/test";
						PreparedStatement statement = null;
						Connection connection = null;
						connection = DriverManager.getConnection(url, "root", "studentupt1998$");
						statement = connection.prepareStatement("update persoane set id = ?, nume = ?, varsta = ? where id = ?");
						
						
						String editNume = txtNume.getText();
						int editVarsta = Integer.parseInt(txtVarsta.getText());
						

						result.updateInt("id", idCurent);
						result.updateString("nume", editNume);
						result.updateInt("varsta", editVarsta);
						result.updateRow();
						
						
						//numarul de randuri editate
						int editSucces = statement.executeUpdate("update persoane set ID = '" + idCurent + "', Nume = '" + editNume + "', Varsta = '" + editVarsta + "' where ID = '" + idCurent + "'");
						
						
						connection.close();
						
						
						if(editSucces > 0) {
							
							JOptionPane.showMessageDialog(null, "Editarea a fost realizata cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							
							JOptionPane.showMessageDialog(null, "Eroare la editare!", "Eroare", JOptionPane.ERROR_MESSAGE);
						}
						
						
						btnMoveFirst.setEnabled(true);
						btnMovePrevious.setEnabled(true);
						btnMoveNext.setEnabled(true);
						btnMoveLast.setEnabled(true);
						btnAdd.setEnabled(true);
						btnEdit.setEnabled(true);
						btnDelete.setEnabled(true);
						btnFind.setEnabled(true);
						btnSave.setEnabled(false);
						btnUndo.setEnabled(false);
						
						
						txtID.setEditable(false);

						
						txtNume.setEditable(false);
						txtNume.setText(editNume);
						
						
						txtVarsta.setEditable(false);
						txtVarsta.setText(String.valueOf(editVarsta));
						
						
						checkEditare = 0;
					} 
					catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});		
				
		
		btnEdit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				btnMoveFirst.setEnabled(false);
				btnMovePrevious.setEnabled(false);
				btnMoveNext.setEnabled(false);
				btnMoveLast.setEnabled(false);
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				btnFind.setEnabled(false);
				btnSave.setEnabled(true);
				btnUndo.setEnabled(true);
				
				
				txtID.setEditable(false);
				txtNume.setEditable(true);
				txtVarsta.setEditable(true);
				
				
				checkEditare = 1;
			}
		});
		
		
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				btnMoveFirst.setEnabled(false);
				btnMovePrevious.setEnabled(false);
				btnMoveNext.setEnabled(false);
				btnMoveLast.setEnabled(false);
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				btnFind.setEnabled(false);
				btnSave.setEnabled(true);
				btnUndo.setEnabled(true);
				
				
				txtID.setEditable(true);
				txtID.setText("");
				
				
				txtNume.setEditable(true);
				txtNume.setText("");
				
				
				txtVarsta.setEditable(true);
				txtVarsta.setText("");
				
				
				checkAdaugare = 1;
			}
		});
		toolBar.add(btnAdd);
		btnAdd.setIcon(new ImageIcon(imgAdd));

		
		toolBar.add(btnEdit);
		btnEdit.setIcon(new ImageIcon(imgEdit));

		
		toolBar.add(btnDelete);
		btnDelete.setIcon(new ImageIcon(imgDelete));

		
		toolBar.add(btnFind);
		btnFind.setIcon(new ImageIcon(imgFind));

		
		toolBar.add(btnSave);
		btnSave.setIcon(new ImageIcon(imgSave));
		btnSave.setEnabled(false);

		
		toolBar.add(btnUndo);
		btnUndo.setIcon(new ImageIcon(imgUndo));
		btnUndo.setEnabled(false);

		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(87, 45, 55, 43);
		panel.add(lblID);

		
		txtID.setBounds(152, 57, 186, 19);
		panel.add(txtID);
		txtID.setColumns(10);

		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(87, 98, 55, 43);
		panel.add(lblNume);

		
		txtNume.setBounds(152, 110, 186, 19);
		panel.add(txtNume);
		txtNume.setColumns(10);

		
		JLabel lblVarsta = new JLabel("Varsta");
		lblVarsta.setBounds(87, 161, 55, 43);
		panel.add(lblVarsta);

		
		txtVarsta.setBounds(152, 173, 186, 19);
		panel.add(txtVarsta);
		txtVarsta.setColumns(10);
		
	}
}
