package program;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import javax.swing.JTree;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;


public class XMLJFrame extends JFrame {

	private static final long serialVersionUID = -8849786875917926480L;
	private JPanel contentPane;
	private JLabel lblClock = new JLabel();
	SimpleDateFormat timeFormat;
	static DefaultTreeModel treeModel = new DefaultTreeModel(null);

	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					XMLJFrame frame = new XMLJFrame("Procesare XML");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void recursive(Node child, DefaultMutableTreeNode parent)
	{
		
		if(child.getTextContent().trim().compareTo("") != 0) {
			
			
			//daca e nod de tip element
			if(child.getClass().getSimpleName().compareTo("DeferredElementImpl") == 0) {
				
				Element element = (Element) child;
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(element.getTagName());
				parent.add(node);
				
				
				//daca nodul are descendenti
				if(element.hasChildNodes()) {
					
					NodeList list = element.getChildNodes();
					
					for(int i = 0; i < list.getLength(); i++) {
						
						recursive(list.item(i), node);	
					}	
				}
			}
			//daca e nod de tip text
			else if(child.getClass().getSimpleName().compareTo("DeferredTextImpl") == 0) {
				
				Text text =(Text) child;
				String content = text.getTextContent();
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(content);
				parent.add(node);
			}	
		}	
	}
	
	
	public void xmlBuilt(String root, Element elem)
	{
		
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(root);
		treeModel = new DefaultTreeModel(rootNode);
		
		
		if(elem.hasChildNodes()) {
			
			NodeList list = elem.getChildNodes();
			
			for(int i = 0; i < list.getLength(); i++) {
				
				recursive(list.item(i), rootNode);
			}
		}
	}
	

	public XMLJFrame(String title) 
	{
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
        
		
		JTree treeXML = new JTree();
		
		
		JButton btnOpenXML = new JButton("Open XML");
		btnOpenXML.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				File workingDirectory = new File(System.getProperty("user.dir"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Documents (*.xml)", "xml");
				chooser.setDialogTitle("Open");
				chooser.setCurrentDirectory(workingDirectory);
				chooser.setFileFilter(filter);
				
				
				int returnValue = chooser.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					
					String nameSelectedFile = chooser.getSelectedFile().getName();
					
					
					try {
						
						//construire arbore DOM
						DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
						DocumentBuilder builder = factory.newDocumentBuilder();
						Document document = builder.parse(nameSelectedFile);
						
						
						String name = nameSelectedFile.substring(0, nameSelectedFile.length() - 4);
						Element element = document.getDocumentElement();
						
						
						xmlBuilt(name, element);
						treeXML.setModel(treeModel);
						
						
					} catch (Exception e1) {
						
						System.out.println(e1.toString());
					}
				}
			}
		});
		btnOpenXML.setBounds(30, 24, 105, 26);
		contentPane.add(btnOpenXML);

		
		lblClock.setBounds(433, 24, 87, 26);
		contentPane.add(lblClock);
		setTime();

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 74, 458, 246);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(treeXML);
	}
	
	
	public void setTime() 
	{
		
		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				timeFormat = new SimpleDateFormat("HH:mm:ss");
				String time = timeFormat.format(Calendar.getInstance().getTime());
				lblClock.setText(time);
			}
		});
		timer.start();
	}
}