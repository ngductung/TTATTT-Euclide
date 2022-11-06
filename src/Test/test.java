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
//					frame.processBin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
//		EuclideModel model = new EuclideModel();
//		int a = 1759;
//		int b = 550;
//		String q, r, x, y, x1, x2, y1, y2;
//		q = r = x = y = "-";
//		x1 = y2 = "1";
//		x2 = y1 = "0";
//		String[] arrayStrings = { q, r, x, y, a + "", b + "", x1, x2, y1, y2 };
//		for (String temp : arrayStrings) {
//			System.out.printf("%5s ", temp);
//		}
//		System.out.println();
//		while (b!=0) {
//			arrayStrings = model.resultInt(arrayStrings);
//			for (String temp : arrayStrings) {
//				System.out.printf("%5s ", temp);
//			}
//			System.out.println();
//			b = Integer.parseInt(arrayStrings[5]);
//		}
//		
//		String a1 = "1011";
//		String b1 = "111";
//		String qS, rS, xS, yS, x1S, x2S, y1S, y2S;
//		qS = rS = xS = yS = "-";
//		x1S = y2S = "1";
//		x2S = y1S = "0";
//		String[] arrayStringsS = { qS, rS, xS, yS, a1, b1, x1S, x2S, y1S, y2S };
//		for (String temp : arrayStringsS) {
//			System.out.printf("%20s ", temp);
//		}
//		System.out.println();
//		while (!b1.equals("0")) {
//			arrayStringsS = model.resultBin(arrayStringsS);
//			for (String temp : arrayStringsS) {
//				System.out.printf("%20s ", temp);
//			}
//			System.out.println();
//			b1 = arrayStringsS[5];
//		}
		
	}
}
