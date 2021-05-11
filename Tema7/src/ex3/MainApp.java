package ex3;

import java.awt.EventQueue;

public class MainApp {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					MoviesJFrame frame = new MoviesJFrame("Filme");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
