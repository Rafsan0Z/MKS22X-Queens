public class QueenBoard{

  private int[][] board;
  private int size;

  public QueenBoard(int Size){
    board = new int[Size][Size];
    size = Size;
  }

  public int getSize(){
    return size;
  }

  private boolean inBounds(int r, int c){
    if(r < size && r >= 0 && c < size && c >= 0){
      return true;
    }
    return false;
  }

  private void MarkUp(int r, int c){
    for(int i = 1; i < size; i++){
      if(inBounds(r+i,c)){board[r+i][c] += 1;}
      if(inBounds(r-i,c)){board[r-i][c] += 1;}
      if(inBounds(r+i,c+i)){board[r+i][c+i] += 1;}
      if(inBounds(r-i,c+i)){board[r-i][c+i] += 1;}
//      if(inBounds(r,c-i)){board[r][c-i] += 1;}
      if(inBounds(r,c+i)){board[r][c+i] += 1;}
    }
  }

  private void MarkDown(int r, int c){
    for(int i = 1; i < size; i++){
      if(inBounds(r+i,c)){board[r+i][c] -= 1;}
      if(inBounds(r-i,c)){board[r-i][c] -= 1;}
      if(inBounds(r+i,c+i)){board[r+i][c+i] -= 1;}
      if(inBounds(r-i,c+i)){board[r-i][c+i] -= 1;}
//      if(inBounds(r,c-i)){board[r][c-i] -= 1;}
      if(inBounds(r,c+i)){board[r][c+i] -= 1;}
    }
  }

  private boolean Queen(int r, int c){
    return board[r][c] == -1;
  }

  private boolean addQueen(int r, int c){
    if(!inBounds(r,c)){
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
    if(!inBounds(r,c)){return false;}
    if(board[r][c] != -1){return false;}
    board[r][c] += 1;
    MarkDown(r,c);
	  return true;
  }

  public boolean solve(){
    addQueen(0,0);
	  return solveHelper(1);
  }

  public void removeAllQueen(){ // removes only the queen not the Marks
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        if(board[i][j] == - 1){
          board[i][j] = 0;
          MarkDown(i,j);
        }
      }
    }
  }

  public boolean solveHelper(int c){
    if(c >= size){return true;}
    for(int i = 1; i < size; i++){
      boolean check = addQueen(i,c) && solveHelper(c+1);
      if(check){return true;}
      else{removeQueen(i,c);}
    }
    return false;
  }

  public int countSolutions(){
    int count = 0;
    removeAllQueen();
    return counterHelper(0,count);
  }

  public int counterHelper(int col, int count){
    if(col >= size){return 1;}
    for(int i = 0; i < size; i++){
      boolean check = addQueen(i,col);
      if(check){
        count += counterHelper(col+1,0);
        removeQueen(i,col);
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

  public static void main(String[] args){

    QueenBoard q = new QueenBoard(Integer.parseInt(args[0]));
    q.solve();
    System.out.println(q);
    System.out.println(q.countSolutions());

  }

}
