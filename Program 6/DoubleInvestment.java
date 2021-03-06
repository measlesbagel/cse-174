public class DoubleInvestment {

  public static void main(String[] args) {
    final double RATE = 5;
    final double INITIAL_BALANCE = 50; 
    final double TARGET = 500;
    double balance = INITIAL_BALANCE; int year = 0;
// Count the years required for the investment to double
    while (balance >= TARGET) {
      year++;
      double interest = balance * RATE / 100; 
      balance = balance + interest;
    }
    System.out.println("The investment doubled after " + year + " years.");
  }

}