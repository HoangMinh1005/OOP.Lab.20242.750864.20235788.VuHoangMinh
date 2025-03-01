package OOP_Lab;
import javax.swing.JOptionPane;
public class Lab01_bai5 {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "Sum: ";
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        String strSum = String.valueOf(sum);
        strNotification += strSum + "\nDifferent: ";
        double dif = num1 -num2;
        String strDif = String.valueOf(dif);
        strNotification+= strDif +"\nProduct: ";
        double product = num1 *num2;
        String strPro = String.valueOf(product);
        strNotification+= strPro +"\nQuotient: ";
        double quotient = num1/num2;
        String strQuo = String.valueOf(quotient);
        strNotification+= strQuo;
        JOptionPane.showMessageDialog(null, strNotification, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}