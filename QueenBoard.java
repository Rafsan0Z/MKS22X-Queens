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

  private void MarkUp(int row, int col){
    board[row][col] += 1;
  }

  private boolean Queen(int r, int c){
    return board[r][c] == -1;
  }

  private boolean addQueen(int r, int c){
    if(r >= size || c >= size || r < 0 || c < 0){
      return false;
    }
    if(board[r][c] == -1){
      return false;
    }
    if(board[r][c] > 0){
      return false;
    }
    board[r][c] = -1;
    for(int i = 0; i < size; i++){
      MarkUp(r+i,c);
      MarkUp(r-i,c);
      MarkUp(r+i,c+i);
      MarkUp(r-i,c+i);
      MarkUp(r,c-i);
    }
    return true;
  }

  private boolean removeQueen(int r, int c){
    if(board[r][c] != -1){
		System.out.println("No Queen Found");
		return false;
	}
  board[r][c] += 1;
   MarkUp(r,c,-1);
   System.out.println("Queen Succesfully removed!");
	 return true;
  }

  public boolean solve(){
    addQueen(0,0);
	  return solveHelper(0,0);
  }

  public void removeAllQueen(){ // removes only the queen not the Marks
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        if(board[i][j] == - 1){board[i][j] = 0;}
      }
    }
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

  public String DebugtoString(){
    String result = "";
    for(int i = 0; i < size; i++){
		for(int j = 0; j < size; j++){
		  result += board[i][j];
			if(j == size - 1){result += '\n';}
			else{result += "__";}
	}
	}
  return result;
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

}
