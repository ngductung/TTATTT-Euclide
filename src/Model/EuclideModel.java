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
		String qB, rB, xB, yB, aB, bB, x1B, x2B, y1B, y2B;

		qB = rowStrings[0];
		rB = rowStrings[1];
		xB = rowStrings[2];
		yB = rowStrings[3];
		aB = rowStrings[4];
		bB = rowStrings[5];
		x2B = rowStrings[6];
		x1B = rowStrings[7];
		y2B = rowStrings[8];
		y1B = rowStrings[9];

		String[] temp = chiaBin(aB, bB);

		qB = temp[0]; // phan nguyen
		rB = temp[1]; // phan du
		xB = Integer.toBinaryString(Integer.parseInt(x2B, 2) ^ Integer.parseInt(nhanBin(qB, x1B), 2));
		// yb = y1 - qb * y2
		yB = Integer.toBinaryString(Integer.parseInt(y2B, 2) ^ Integer.parseInt(nhanBin(qB, y1B), 2));
		aB = bB;
		bB = rB;
		x2B = x1B;
		x1B = xB;
		y2B = y1B;
		y1B = yB;

		String[] arrayString = { qB, rB, xB, yB, aB, bB, x2B, x1B, y2B, y1B };

		return arrayString;
	}

	public String tinhDu(String a, String b) {
		String result = "";
		int intB = Integer.parseInt(b, 2);
		result = a.substring(0, b.length());
		int aS = Integer.parseInt(result, 2);
		result = Integer.toBinaryString(aS ^ intB);
		return result;
	}

	public String[] chiaBin(String a, String b) {
		String du = tinhDu(a, b);
		a = a.substring(b.length(), a.length());
		String nguyen = "1";
		while (!a.equals("")) {
			if (!du.equals("0")) {
				int thieu = b.length() - du.length();
				if (thieu > a.length()) {
					String bs = a.substring(0, a.length());
					du += bs;
					a = "";
					nguyen += "0";
				} else if (thieu >= b.length() - 1) {
					for (int i = 0; i < thieu-1; i++) {
						nguyen += "0";
					}
					String bs = a.substring(0, thieu);
					du += bs;
					a = a.substring(thieu, a.length());
					du = tinhDu(du, b);
					nguyen += "1";
				} else {
					String bs = a.substring(0, thieu);
					du += bs;
					a = a.substring(thieu, a.length());
					du = tinhDu(du, b);
					nguyen += "1";
				}
			} else {
				break;
			}
		}
		if (du.equals("0") && a.length() > 0) {
			for (int i = 0; i < a.length(); i++) {
				nguyen += "0";
			}
		}
		String[] result = { nguyen, du };
		return result;
	}

	public String nhanBin(String a, String b) {
		String[] binArrays = new String[a.length()];
		for (int i = 0; i < a.length(); i++) {
			String t = "";
			for (int j = 0; j < a.length() - 1 - i; j++) {
				t += "0";
			}
			binArrays[i] = a.substring(i, i + 1) + t;
		}
		String result = b;
		for (int i = 0; i < binArrays.length; i++) {
			String t = "";
			if (Integer.parseInt(binArrays[i], 2) == 0) {

			} else {
				for (int j = 0; j < binArrays[i].length() - 1; j++) {
					t += "0";
				}
				binArrays[i] = b + t;
			}
		}
		result = binArrays[0];
		for (int i = 1; i < binArrays.length; i++) {
			int t1 = Integer.parseInt(result, 2);
			int t2 = Integer.parseInt(binArrays[i], 2);
			result = Integer.toBinaryString(t1 ^ t2);
		}
		return result;
	}
}
