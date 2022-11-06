package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import View.EuclideView;

public class EuclideController implements ActionListener {
	private EuclideView view;

	public EuclideController(EuclideView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String in = getSelection();

		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("refresh")) {
			this.view.refresh();
		}

		if (in.equalsIgnoreCase("số nguyên")) {
			view.noneNotice();
			if (command.equalsIgnoreCase("Tính")) {
				view.setOutputInt();
			}

		} else if (in.equalsIgnoreCase("đa thức")) {
			view.setNotice();
			if (command.equalsIgnoreCase("Tính")) {
				view.setOutputBin();
			}
		} else {
			JOptionPane.showMessageDialog(view, "Chọn đa thức hay số nguyên", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public String getSelection() {
		String in = "";
		Enumeration<AbstractButton> btn_in = view.btnGroup.getElements();
		while (btn_in.hasMoreElements()) {
			AbstractButton abstractButton = (AbstractButton) btn_in.nextElement();
			if (abstractButton.isSelected()) {
				in = abstractButton.getText();
			}
		}
		return in;
	}

}
