package Test;

import java.awt.EventQueue;

import Model.EuclideModel;
import View.EuclideView;

public class test {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EuclideView frame = new EuclideView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
}
