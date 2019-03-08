import java.util.Scanner;
import java.util.InputMismatchException;
public class QueenBoard{

  private int[][] board;
  private int size;

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
    for(int i = 0; i < size; i++){
      board[r+i][c] += 1;
      board[r-i][c] += 1;
      board[r+i][c+i] += 1;
      board[r-i][c+i] += 1;
      board[r][c-i] += 1;
    }
  }

  private void MarkDown(int row, int col){
    for(int i = 0; i < size; i++){
      board[r+i][c] -= 1;
      board[r-i][c] -= 1;
      board[r+i][c+i] -= 1;
      board[r-i][c+i] -= 1;
      board[r][c-i] -= 1;
    }
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
    MarkUp(r,c);
    return true;
  }

  private boolean removeQueen(int r, int c){
    if(board[r][c] != -1){
		System.out.println("No Queen Found");
		return false;
	}
  board[r][c] += 1;
   MarkDown(r,c);
   System.out.println("Queen Succesfully removed!");
	 return true;
  }

  public boolean solve(){
    addQueen(0,0);
	  return solveHelper(0);
  }

  public void removeAllQueen(){ // removes only the queen not the Marks
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        if(board[i][j] == - 1){board[i][j] = 0;}
      }
    }
  }

  public boolean solveHelper(int r){
    if(row > size - 1){return true;}
    for(int i = 1; i < size; i++){
      boolean check = addQueen(r,i) && solveHelper(r+1);
      if(check){return true;}
      else{removeQueen(r,i);}
    }
    return false;
  }

  public int countSolutions(){
    int count = 0;
    removeAllQueen();
    addQueen(0,0);
    return counterHelper(0,0);
  }

  public int counterHelper(int row, int count){
    if(row > size - 1){return 1;}
    for(int i = 1; i < size; i++){
      boolean check = addQueen(row,i);
      if(check){
        count += counterHelper(row+1,0);
        removeQueen(row,col);
      }
    }
    return count;
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
