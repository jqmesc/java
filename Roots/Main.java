/* Calculates Roots
   Programmer: James Schultz, Date: 10/21/22 */

public class Main {
  private int a, b, c;
  public Main(){
    a = 1;
    b = 1;
    c = 1;
  }
  public void calculate1(int x, int y, int z){
    double check = Math.sqrt(Math.pow(y, 2) - 4*x*z);
    if (check >= 0)
      System.out.println("First Root: " + ((-1*y)+(Math.sqrt(Math.pow(y,2) - 4*x*z)))/(2*x));
    else
      System.out.println("First Root: Extraneous");
  }
  public void calculate2(int x, int y, int z){
    double check = Math.sqrt(Math.pow(y, 2) - 4*x*z);
    if (check >= 0)
      System.out.println("Second Root: " + ((-1*y)-(Math.sqrt(Math.pow(y,2) - 4*x*z)))/(2*x));
    else
      System.out.println("Second Root: Extraneous");
  }
  public static void main(String[] args) {
    Main q1 = new Main();
    q1.calculate1(1,3,2);
    q1.calculate2(1,3,2);
  }
}
