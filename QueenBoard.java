public class QueenBoard{

  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
    if(int[r][c] == -1){
      System.out.println("Queen already exists!");
      return false;
    }
    int[r][c] = -1;
    for(int i = 0; i < size && i != c; i++){
      int[r][i] += 1;
    }
    for(int j = 0; j < size && j != r; j++){
      int[j][c] += 1;
    }
  }

  private boolean removeQueen(int r, int c){
    return true;
  }

  public static void main(String[] args){

  }

}
