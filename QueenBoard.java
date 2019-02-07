import java.util.Scanner;
public class QueenBoard{

  private int[][] board;
  private int size;

  public QueenBoard(int Size){
    board = new int[Size][Size];
    size = Size;
  }

  private boolean addQueen(int r, int c){
    if(board[r][c] == -1){
      System.out.println("Queen already exists!");
      return false;
    }
    board[r][c] = -1;
    for(int i = 0; i < size && i != c; i++){
      board[r][i] += 1;
    }
    for(int j = 0; j < size && j != r; j++){
      board[j][c] += 1;
    }
    return true;
  }

  private boolean removeQueen(int r, int c){
    if(board[r][c] != -1){
		System.out.println("No Queen Found");
		return false;
	}
   for(int i = 0; i < size && i != c; i++){
		 board[r][i] -= 1;
	 }
	 for(int j = 0; j < size && j != r; j++){
		 board[j][c] -= 1;
	 }
	 return true;
  }

  public boolean solve(){
    return true;
  }

  public int countSolutions(){
    return 0;
  }

  public static void main(String[] args){
    Scanner in = Scanner(System.in);
    System.out.println("Input a size: ");
	  int num = in.nextInt();
	  QueenBoard puzzle = new QueenBoard(num);
    System.out.println("Chose one of the following options: ");
	  System.out.println("1. Add a queen");
	  System.out.println("2. Remove a queen");
	  System.out.println("3. Check if board is solvable");
	  System.out.println("4. Find total number of solutions");
	  System.out.println("5. Print the board");
    System.out.println("------------------------");
	  System.out.println("Input a number corresponding to the option");
	  int option = in.nextInt();
    if(option == 1){
		System.out.println("Input a row number: ");
		int row = in.nextInt();
		System.out.println("Input a column number: ");
		int col = in.nextInt();
		puzzle.addQueen(row,col);
	}
	if(option == 2){
		System.out.println("Input a row number: ");
		int row = in.nextInt();
		System.out.println("Input a column number: ");
		int col = in.nextInt();
		puzzle.removeQueen(row,col);
	}
  }

}
