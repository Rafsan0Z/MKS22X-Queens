import java.util.Scanner;
import java.util.InputMismatchException;
public class QueenBoard{

  private int[][] board;
  private int size;
  private int Solutions;

  public QueenBoard(int Size){
    board = new int[Size][Size];
    size = Size;
    Solutions = 0;
  //  setSolution();
  }

  public int getSize(){
    return size;
  }

  private void MarkUp(){
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){

      }
    }
  }

  private boolean Queen(int r, int c){
    return board[r][c] == -1;
  }

  private void MarkUp(int r, int c, int factor){
    for(int i = 0; i < size && i != c; i++){
      board[r][i] += 1*factor;
    }
    for(int j = 0; j < size && j != r; j++){
      board[j][c] += 1*factor;
    }
    for(int i = r; i < size; i++){
      for(int j = c; j < size; j++){
        if(Queen(i,j)){board[i][j] += 1*factor;}
      }
      for(int k = c; k > 0; k--){
        if(Queen(i,k)){board[i][k] += 1*factor;}
      }
    }
    for(int i = r; i > 0; i--){
      for(int j = c; j < size; j++){
        if(Queen(i,j)){board[i][j] += 1*factor;}
      }
      for(int k = c; k > 0; k--){
        if(Queen(i,k)){board[i][k] += 1*factor;}
      }
    }
  }

  private boolean addQueen(int r, int c){
    if(r >= size || c >= size || r < 0 || c < 0){
      return false;
    }
    if(board[r][c] == -1){
      System.out.println("Queen already exists!");
      return false;
    }
    board[r][c] = -1;
    //MarkUp(r,c,1);
    System.out.println("Queen Succesfully added!");
    return true;
  }

  private boolean removeQueen(int r, int c){
    if(board[r][c] != -1){
		System.out.println("No Queen Found");
		return false;
	}
   MarkUp(r,c,-1);
   System.out.println("Queen Succesfully removed!");
	 return true;
  }

  public boolean solve(){
    addQueen(0,0);
	  return solveHelper(0,0);
  }

  public void removeAllQueen(){

  }

  public boolean solveHelper(int r, int c){
    if(c >= size -1 && r >= size - 1){return true;}
    if(board[r][c+1] == 0){
      addQueen(r,c+1);
    }
    return solveHelper(r+1,c+1);
  }

  public int countSolutions(){
    return Solutions;
  }

  public void clear(){
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        board[i][j] = 0;
      }
    }
  }

  public void setSolution(){
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        if(!Queen(i,j)){
          addQueen(i,j);
          if(i > size-1){Solutions++;}
          removeQueen(i,j);
        }
      }
    }
  }

  public String toString(){
    String result = "";
    for(int i = 0; i < size; i++){
		for(int j = 0; j < size; j++){
			if(board[i][j] == -1){result += "Q";}
			if(j == size - 1){result += '\n';}
			else{result += "__";}
	}
	}
  return result;
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int num = 0;
    boolean taken = true;
    while(taken){
    try{
    System.out.println("Input a size: ");
	  num = in.nextInt();
    taken = false;
  } catch(InputMismatchException e){
    System.out.println("Please input a number!");
    in.next();
  }
}
	  QueenBoard puzzle = new QueenBoard(num);
    System.out.println("Welcome to QueenBoard 1.0!!");
    System.out.println("-------------------------------");
    System.out.println("Chose one of the following options: ");
    System.out.println("0. Exit the Program");
	  System.out.println("1. Add a queen");
	  System.out.println("2. Remove a queen");
	  System.out.println("3. Check if board is solvable");
	  System.out.println("4. Find total number of solutions");
	  System.out.println("5. Print the board");
    System.out.println("6. Clear the board");
    System.out.println("------------------------");
	  System.out.println("Input a number corresponding to the option");
	  int option = in.nextInt();
    boolean running = true;
    while(running){
    try{
    if(option == 1){
		System.out.println("Input a row number: ");
		int row = in.nextInt() - 1;
		System.out.println("Input a column number: ");
		int col = in.nextInt() - 1;
		puzzle.addQueen(row,col);
    System.out.println("Chose another Option: ");
    option = in.nextInt();
	}
	else if(option == 2){
		System.out.println("Input a row number: ");
		int row = in.nextInt() - 1;
		System.out.println("Input a column number: ");
		int col = in.nextInt() - 1;
		puzzle.removeQueen(row,col);
    System.out.println("Chose another Option: ");
    option = in.nextInt();
	}
  else if(option == 3){
		if(puzzle.solve()){
			System.out.println("Yes, the puzzle is solvable");
		}
		else{
			System.out.println("Sorry, the puzzle is not solvable");
		}
    System.out.println("Chose another Option: ");
    option = in.nextInt();
	}
	else if(option == 4){
		int total = puzzle.countSolutions();
		System.out.println("The total number of solutions are: " + total);
    System.out.println("Chose another Option: ");
    option = in.nextInt();
	}
  else if(option == 5){
		String print = puzzle.toString();
		System.out.println(print);
    System.out.println("Chose another Option: ");
    option = in.nextInt();
	}
  else if(option == 6){
    puzzle.clear();
    System.out.println("Chose another Option: ");
    option = in.nextInt();
  }
  else if(option == 0){
    running = false;
  }
	else{
		System.out.println("Invalid Input");
	}
} catch(InputMismatchException e){
  System.out.println("Please input a number!");
  in.next();
}
}
  }

}
