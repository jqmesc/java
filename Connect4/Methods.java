public class Methods {
    // Check Win
    public boolean Check(String[][] Game){
        // Horizontal
        for (int i = 0; i < Game[0].length; i++){
            for (int x = 0; x < Game.length-4; x++){
              String _check = "";
              for (int z = x; z < x+4; z++){
                _check += Game[z][i];
              }
              if (_check != ""){
                if (_check.equals("RRRR") || _check.equals("YYYY")){
                  return true;
                }
              }
            }
          }
          // Vertical
          for (int i = 0; i < Game.length; i++){
            for (int x = 0; x < Game[0].length - 3; x++){
              String _check = "";
              for (int z = x; z < x+4; z++){
                _check += Game[i][z];
              }
              //System.out.println("" + x + i);
              if (_check.equals("RRRR") || _check.equals("YYYY")){
                return true;
              }
            }
          }
          // Diagonal
          for (int i = 0; i < Game.length; i++){// Right
            for (int x = 0; x < Game[0].length; x++){
              if (i + 3 < Game.length && x + 3 < Game[0].length){
                String _check = "";
                for (int z = 0; z < 4; z++){
                    _check += Game[i+z][x+z];
                }
                if (_check.equals("RRRR") || _check.equals("YYYY")){
                    return true;
                }
              }
            }
          }
          for (int i = Game.length-1; i >=0; i--){// Left
            for (int x = 0; x < Game[0].length; x++){
              if (i - 3 >= 0 && x + 3 < Game[0].length){
                String _check = "";
                for (int z = 0; z < 4; z++){
                    _check += Game[i-z][x+z];
                }
                if (_check.equals("RRRR") || _check.equals("YYYY")){
                    return true;
                }
              }
            }
        }
        return false;
    }
    // Display
    public void Display(String[][] Game){
        for (int i = 0; i < Game[0].length; i++) {
            for (int x = 0; x < Game.length; x++){
                if (Game[x][i] == null)
                    System.out.print("| ");
                else
                    System.out.print("|" + Game[x][i]);
            }
        System.out.println("|");
        }
        System.out.println("---------------");
    }
}
