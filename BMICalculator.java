import java.text.DecimalFormat;
import java.util.Scanner;

public class BMICalculator {
    /** Convert english to metric units, perform the BMI Calculation
     * @param inches users height in inches
     * @param pounds users weight in pounds
     * @return User's BMI weight(kg)/height(m)^2: 24.43 kg/m^2
     */
    public static double computeBMI(int inches, int pounds){
        double kgs, meters;
        meters=inches*0.0254;
        kgs=pounds*0.454;
        if(inches<=-0||pounds<=0){
            return 0;
        }
        return kgs/(meters*meters);
    }

    /** Uses a Scanner to prompt the user for info, process the
     * feet/inches conversion, calls the computeBMI method and prints the
     * correct information.
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String userin;
        int inches = 0, pounds = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        while(true) {
            System.out.println("Enter your height in feet and inches (Ex 6'1\") or 0 to quit: ");
            userin=s.nextLine();
            if(userin.equals("0")){
                break;
            }
            inches=Integer.parseInt(userin.substring(0, userin.indexOf("'")))*12;
            inches+=Integer.parseInt((userin.substring(userin.indexOf("'")+1, userin.length()-1)));
            System.out.println("DEBUG: "+inches);
            System.out.println("Enter your weight in pounds: ");
            userin=s.nextLine();
            pounds=Integer.parseInt(userin);
            System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: 24.43 kg/m^2 is: "+computeBMI(inches, pounds));
        }
    }

}
