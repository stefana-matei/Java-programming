package program;

import java.awt.EventQueue;
import java.sql.*;

public class MainApp {

	public static void main(String[] args) throws SQLException {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {
					TabelJFrame frame = new TabelJFrame("Tabelul MySQL - persoane");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}