package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;

import View.EuclideView;

public class EuclideControllerKey implements KeyListener {
	private EuclideView view;

	public EuclideControllerKey(EuclideView view) {
		this.view = view;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int command = e.getKeyCode();
		if (command == 10) {
			try {
				if (selection().equalsIgnoreCase("số nguyên")) {
					processInt();
				} else {
					processBin();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} else if(command == 27) {
			this.view.refresh();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public String selection() {
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
	
	public void processInt() {
		this.view.noneNotice();
		this.view.setOutputInt();
	}
	
	public void processBin() {
		this.view.setNotice();
		this.view.setOutputBin();
	}
}
