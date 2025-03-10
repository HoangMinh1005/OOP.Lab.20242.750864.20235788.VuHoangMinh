import javax.swing.JOptionPane;

public class Lab01_bai6 {
	public static void main(String[] args) {
		String strcmd;
		strcmd = JOptionPane.showInputDialog(null, "Chọn loại phương trình bạn muốn giải:\n1. Phương trình bậc nhất (ax + b = 0)\n2. Hệ phương trình 2 ẩn\n3. Phương trình bậc 2 (ax^2 +bx + c = 0)");
		double cmd = Double.parseDouble(strcmd);
		
		if (cmd == 1) {
			String stra, strb;
			
			stra = JOptionPane.showInputDialog(null, "Hệ số a: ");
			strb = JOptionPane.showInputDialog(null, "Hệ số b: ");
			double a = Double.parseDouble(stra);
			double b = Double.parseDouble(strb);
			
			double result = -b/a;
			JOptionPane.showMessageDialog(null, "Nghiệm của phương trình: " + result);
		}
		else if (cmd == 3) {
			String stra, strb, strc;
			
			stra = JOptionPane.showInputDialog(null, "Hệ số a: ");
			strb = JOptionPane.showInputDialog(null, "Hệ số b: ");
			strc = JOptionPane.showInputDialog(null, "Hệ số c: ");
			double a = Double.parseDouble(stra);
			double b = Double.parseDouble(strb);
			double c = Double.parseDouble(strc);
			
			double delta = b*b - 4*a*c;
			if (delta < 0) {
				JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm");
			}
			else if (delta == 0) {
				double n = -b/(2*a);
				JOptionPane.showMessageDialog(null, "Phương trình có 1 ngiệm: " + n);
			}
			else {
				double r1 = (-b + Math.sqrt(delta))/(2*a);
				double r2 = (-b - Math.sqrt(delta))/(2*a);
				JOptionPane.showMessageDialog(null, "Phương trình có 2 nghiệm phân biệt: (n1 = " + r1 + " n2 = " + r2);
			}
		}
		else {
			String stra11, stra12, stra21, stra22, strb1, strb2;
			
			stra11 = JOptionPane.showInputDialog(null, "Hệ số a11: ");
			stra12 = JOptionPane.showInputDialog(null, "Hệ số a12: ");
			strb1 = JOptionPane.showInputDialog(null, "Hệ số b1: ");
			stra21 = JOptionPane.showInputDialog(null, "Hệ số a21: ");
			stra22 = JOptionPane.showInputDialog(null, "Hệ số a22: ");
			strb2 = JOptionPane.showInputDialog(null, "Hệ số b2: ");
			double a11 = Double.parseDouble(stra11);
			double a12 = Double.parseDouble(stra12);
			double a21 = Double.parseDouble(stra21);
			double a22 = Double.parseDouble(stra22);
			double b1 = Double.parseDouble(strb1);
			double b2 = Double.parseDouble(strb2);
			
			double D = a11*a22 - a21* a12;
			double D1 = b1*a22 - b2* a12;
			double D2 = b2*a11 - b1* a21;
			
			if (D == 0) {
				if (D1 == 0 && D2 == 0) {
					JOptionPane.showMessageDialog(null, "Hệ có vô số nghiệm");
				}
				else {
					JOptionPane.showMessageDialog(null, "Hệ vô nghiệm");
				}
			}
			else {
				double n1 = D1/D;
				double n2 = D2/D;
				JOptionPane.showMessageDialog(null, "Hệ có 2 nghiệm x1 = " + n1 + " x2 = " + n2);
			}
		}
	}
}