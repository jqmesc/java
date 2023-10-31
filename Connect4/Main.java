import java.util.*;


public class Main {
  public static void main(String[] args) {
    // Vars
    Scanner obj = new Scanner(System.in);
    Methods methods = new Methods();
    String[][] Game = new String[7][6];
    Boolean running = true;
    int turn = 1;
    int row = 1;


    while (running) {


      System.out.println("\nPlayer " + turn + ", drop your disk at column (0-6):");
      // Display
      methods.Display(Game);


      // Input
      row = obj.nextInt();
     
      // Place
      boolean _placed = false;
      for (int i = Game[row].length - 1; i >= 0; i--) {
        if (!_placed){
          if (Game[row][i] == null) {
            if (turn == 1){
              Game[row][i] = "R";
              _placed = true;
            }
            else{
              Game[row][i] = "Y";
              _placed = true;
            }
          }
        }
      }


      // Check Win
      if (methods.Check(Game)){
        System.out.println();
        methods.Display(Game);
        System.out.println("PLAYER " + turn + " WIN!");
        running = false;
        System.out.println();
      }
     


      // Alternate
      if (turn == 1)
        turn = 2;
      else
        turn = 1;
    }
    obj.close();
  }
}
