package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.sql.Time;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.ietf.jgss.Oid;

import Controller.EuclideController;
import Controller.EuclideControllerKey;
import Model.EuclideModel;

import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JRadioButton;

public class EuclideView extends JFrame {

	private JPanel contentPane;
	private JTextField aInput;
	private JTextField bInput;
	private JTable table;
	private EuclideModel model = new EuclideModel();
	private JLabel bResult;
	private JLabel aResult;
	public JPanel PanelResult_1;
	public JPanel PanelResult_2;
	public ButtonGroup btnGroup;
	private JLabel Notice;
	private JLabel Notice_1;

	/**
	 * Create the frame.
	 */
	public EuclideView() {
		EuclideController model = new EuclideController(this);
		EuclideControllerKey key = new EuclideControllerKey(this);
		setTitle("Euclide mở rộng");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\TTATTT\\Euclide\\icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1034, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton sNguyen = new JRadioButton("Số nguyên");
		sNguyen.setSelected(true);
		sNguyen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		sNguyen.setBounds(301, 9, 112, 23);
		contentPane.add(sNguyen);
		sNguyen.addActionListener(model);

		JRadioButton dThuc = new JRadioButton("Đa thức");
		dThuc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dThuc.setBounds(565, 7, 112, 23);
		contentPane.add(dThuc);
		dThuc.addActionListener(model);

		btnGroup = new ButtonGroup();
		btnGroup.add(sNguyen);
		btnGroup.add(dThuc);

		JLabel aLB = new JLabel("a");
		aLB.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		aLB.setBounds(58, 58, 29, 23);
		contentPane.add(aLB);

		aInput = new JTextField();
		aInput.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		aInput.setBounds(111, 50, 338, 36);
		contentPane.add(aInput);
		aInput.setColumns(10);
		aInput.addKeyListener(key);

		JLabel bLB = new JLabel("b");
		bLB.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		bLB.setBounds(533, 58, 29, 23);
		contentPane.add(bLB);

		bInput = new JTextField();
		bInput.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		bInput.setColumns(10);
		bInput.setBounds(586, 50, 338, 36);
		contentPane.add(bInput);
		bInput.addKeyListener(key);

		Notice = new JLabel("");
		Notice.setHorizontalAlignment(SwingConstants.CENTER);
		Notice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Notice.setBounds(121, 97, 307, 23);
		contentPane.add(Notice);

		Notice_1 = new JLabel("");
		Notice_1.setHorizontalAlignment(SwingConstants.CENTER);
		Notice_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Notice_1.setBounds(596, 97, 307, 23);
		contentPane.add(Notice_1);

		JButton btnNewButton = new JButton("Tính");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnNewButton.setBounds(422, 131, 165, 47);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(model);

		table = new JTable();
		table.setBorder(null);
		table.setToolTipText("");
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "q", "r", "x", "y", "a", "b", "x2", "x1", "y2", "y1" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(39, 189, 952, 276);
		contentPane.add(scrollPane);

		PanelResult_1 = new JPanel();
		PanelResult_1.setBounds(44, 528, 274, 55);
		contentPane.add(PanelResult_1);
		PanelResult_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("-1");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(36, 11, 19, 14);
		PanelResult_1.add(lblNewLabel_1);
		PanelResult_1.setVisible(false);

		JLabel lblNewLabel = new JLabel("a");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(23, 1, 34, 54);
		PanelResult_1.add(lblNewLabel);

		aResult = new JLabel("= ");
		aResult.setFont(new Font("Times New Roman", Font.BOLD, 20));
		aResult.setBounds(62, 11, 106, 44);
		PanelResult_1.add(aResult);

		PanelResult_2 = new JPanel();
		PanelResult_2.setBounds(328, 528, 294, 55);
		contentPane.add(PanelResult_2);
		PanelResult_2.setLayout(null);
		PanelResult_2.setVisible(false);

		JLabel lblB = new JLabel("b");
		lblB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblB.setBounds(25, 0, 34, 54);
		PanelResult_2.add(lblB);

		bResult = new JLabel("= ");
		bResult.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bResult.setBounds(64, 10, 135, 44);
		PanelResult_2.add(bResult);

		JLabel lblNewLabel_1_1 = new JLabel("-1");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(38, 10, 19, 14);
		PanelResult_2.add(lblNewLabel_1_1);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRefresh.setBounds(863, 542, 112, 36);
		contentPane.add(btnRefresh);
		btnRefresh.addActionListener(model);

	}

	public void processInt() {
		String a = aInput.getText().trim();
		String b = bInput.getText().trim();

		try {
			if (checkInput(a, b)) {
				if (Integer.parseInt(a) < Integer.parseInt(b)) {
					String c = a;
					a = b;
					b = c;
					aInput.setText(a);
					bInput.setText(b);
				}
				String q, r, x, y, x1, x2, y1, y2;
				q = r = x = y = "-";
				x1 = y2 = "0";
				x2 = y1 = "1";
				String[] arrayStrings = { q, r, x, y, a, b, x2, x1, y2, y1 };
				do {
					addRow(arrayStrings);
					arrayStrings = model.resultInt(arrayStrings);
					b = arrayStrings[5];

				} while (!b.equalsIgnoreCase("0"));
				addRow(arrayStrings);
				setResultA(arrayStrings[6]);
				setResultB(arrayStrings[8]);
			}
		} catch (Exception e) {
			setOutputNone();
			JOptionPane.showMessageDialog(this, "Lỗi tính toán", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void addRow(String[] stringsAdd) {
		DefaultTableModel tb = (DefaultTableModel) table.getModel();
		tb.addRow(stringsAdd);
		table.setRowHeight(30);
	}

	public void processBin() {
		String a = aInput.getText().trim();
		String b = bInput.getText().trim();

		try {
			if (checkInput(a, b)) {
				if (Integer.parseInt(a, 2) < Integer.parseInt(b, 2)) {
					String c = a;
					a = b;
					b = c;
				}
				String q, r, x, y, x1, x2, y1, y2;
				q = r = x = y = "-";
				x1 = y2 = "0";
				x2 = y1 = "1";
				String[] arrayStrings = { q, r, x, y, a, b, x2, x1, y2, y1 };
				do {
					addRow(arrayStrings);
					arrayStrings = model.resultBin(arrayStrings);
					b = arrayStrings[5];

				} while (!b.equalsIgnoreCase("0"));
				addRow(arrayStrings);
				Font font = new Font("Times New Roman", NORMAL, 14);
				table.setFont(font);
				setResultA(arrayStrings[6]);
				setResultB(arrayStrings[8]);
			}
		} catch (Exception e) {
			setOutputNone();
			JOptionPane.showMessageDialog(this, "Lỗi tính toán", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void formatTable() {
		DefaultTableModel t = (DefaultTableModel) table.getModel();
		t.getDataVector().removeAllElements();
		t.fireTableDataChanged();
	}

	public void setNotice() {
		Notice.setText("Chuyển sang hệ nhị phân trước");
		Notice_1.setText("Chuyển sang hệ nhị phân trước");
	}

	public void noneNotice() {
		Notice.setText("");
		Notice_1.setText("");
	}

	public boolean checkInput(String a, String b) {
		boolean checkA = a.equalsIgnoreCase("");
		boolean checkB = b.equalsIgnoreCase("");
		if (checkA && checkB) {
			setOutputNone();
			JOptionPane.showMessageDialog(this, "Hãy nhập các giá trị", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (checkA) {
			setOutputNone();
			JOptionPane.showMessageDialog(this, "Nhập giá trị a", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (checkB) {
			setOutputNone();
			JOptionPane.showMessageDialog(this, "Nhập giá trị b", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public void refresh() {
		aInput.setText("");
		bInput.setText("");
		formatTable();
		PanelResult_1.setVisible(false);
		PanelResult_2.setVisible(false);
	}

	public void setResultA(String s) {
		PanelResult_1.setVisible(true);
		aResult.setText("= " + s);
	}

	public void setResultB(String s) {
		PanelResult_2.setVisible(true);
		bResult.setText("= " + s);
	}

	public void setOutputInt() {
		formatTable();
		processInt();
	}

	public void setOutputBin() {
		formatTable();
		processBin();
	}
	
	public void setOutputNone() {
		PanelResult_1.setVisible(false);
		PanelResult_2.setVisible(false);
	}
}
