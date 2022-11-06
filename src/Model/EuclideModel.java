package Model;

import java.time.Year;

public class EuclideModel {
	private String a, b;

	public EuclideModel() {

	}

	public EuclideModel(String a, String b) {

		this.a = a;
		this.b = b;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String[] resultInt(String[] rowStrings) {
		String q, r, x, y, x1, x2, y1, y2;
		this.a = rowStrings[4];
		this.b = rowStrings[5];

		q = (int) Integer.parseInt(a) / Integer.parseInt(b) + "";
		r = Integer.parseInt(a) - Integer.parseInt(b) * Integer.parseInt(q) + "";
		x = Integer.parseInt(rowStrings[6]) - Integer.parseInt(q) * Integer.parseInt(rowStrings[7]) + "";
		y = Integer.parseInt(rowStrings[8]) - Integer.parseInt(q) * Integer.parseInt(rowStrings[9]) + "";
		x2 = Integer.parseInt(rowStrings[7]) + "";
		x1 = x;
		y2 = Integer.parseInt(rowStrings[9]) + "";
		y1 = y;
		a = b;
		b = r;

		String[] arrayString = { q, r, x, y, a, b, x2, x1, y2, y1 };

		return arrayString;
	}

	public String[] resultBin(String[] rowStrings) {
		String qB, rB, xB, yB, a1B, b1B, x1B, x2B, y1B, y2B;

		qB = rowStrings[0];
		rB = rowStrings[1];
		xB = rowStrings[2];
		yB = rowStrings[3];
		a1B = rowStrings[4];
		b1B = rowStrings[5];
		x2B = rowStrings[6];
		x1B = rowStrings[7];
		y2B = rowStrings[8];
		y1B = rowStrings[9];

		int q, r, x, y, a1, b1, x1, x2, y1, y2;
		a1 = Integer.parseInt(a1B, 2);
		b1 = Integer.parseInt(b1B, 2);
		x2 = Integer.parseInt(x1B, 2);
		x1 = Integer.parseInt(x2B, 2);
		y2 = Integer.parseInt(y1B, 2);
		y1 = Integer.parseInt(y2B, 2);

		q = (int) a1 / b1;
		r = Math.abs(a1 - q * b1);
		x = Math.abs(x1 - q * x2);
		y = Math.abs(y1 - q * y2);
		a1 = b1;
		b1 = r;
		x2 = x1;
		x1 = x;
		y2 = y1;
		y1 = y;

		qB = Integer.toBinaryString(q);
		rB = Integer.toBinaryString(r);
		xB = Integer.toBinaryString(x);
		yB = Integer.toBinaryString(y);
		a1B = Integer.toBinaryString(a1);
		b1B = Integer.toBinaryString(b1);
		x2B = Integer.toBinaryString(x2);
		x1B = Integer.toBinaryString(x1);
		y2B = Integer.toBinaryString(y2);
		y1B = Integer.toBinaryString(y1);

		String[] arrayString = { qB, rB, xB, yB, a1B, b1B, x2B, x1B, y2B, y1B };

		return arrayString;
	}
}
