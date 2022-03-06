import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private char[][] b = new char[NUM_OF_ROW][NUM_OF_COLUMNS];

	
	public Board() {
		reset();
	}



	public void printBoard() {
		for (int i = 0; i < NUM_OF_ROW; i++) {
			System.out.print("|");
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				System.out.print(b[i][j]);
				System.out.print("|");
			}
			System.out.print("\n");
		}
	}
	public void newprintBoard(char[][] bb) {
		for (int i = 0; i < NUM_OF_ROW; i++) {
			System.out.print("|");
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				System.out.print(bb[i][j]);
				System.out.print("|");
			}
			System.out.print("\n");
		}
	}


	public boolean containsWin() {
		for (int row = 0; row < NUM_OF_ROW; row++){
			for (int col = 0; col < NUM_OF_COLUMNS - 3; col++){
				if (b[row][col]==b[row][col+1] &&
						b[row][col+1]==b[row][col+2] &&
						b[row][col+2]==b[row][col+3] &&
						b[row][col]!=' '){
					return true;
				}
			}
		}
		//To horizontally check if someone wins
		for (int row = 0; row < NUM_OF_ROW-3; row++){
			for (int col = 0; col < NUM_OF_COLUMNS; col++){
				if (b[row][col]==b[row+1][col] &&
						b[row+1][col]==b[row+2][col] &&
						b[row+2][col]==b[row+3][col]&&
						b[row][col]!=' '){
					return true;
				}
			}
		}
		//To vertically check if someone wins
		for (int row = 0; row < NUM_OF_ROW-3; row++){
			for (int col = 0; col < NUM_OF_COLUMNS-3; col++){
				if (b[row][col]==b[row+1][col+1] &&
						b[row+1][col+1]==b[row+2][col+2] &&
						b[row+2][col+2]==b[row+3][col+3]&&
						b[row][col]!=' '){
					return true;
				}
			}
		}
		//To diagonally check if someone wins(downward slope)
		for (int row = 0; row < NUM_OF_ROW-3; row++){
			for (int col = 3; col < NUM_OF_COLUMNS; col++){
				if (b[row][col]==b[row+1][col-1] &&
						b[row+1][col-1]==b[row+2][col-2] &&
						b[row+2][col-2]==b[row+3][col-3]&&
						b[row][col]!=' '){
					return true;
				}
			}
		}
		//To diagonally check if someone wins(upward slope)
		return false;
	}


	
	public boolean isTie() {
		for (int i = 0; i < NUM_OF_ROW; i++){
			for (int j = 0; j < NUM_OF_COLUMNS; j++){
				if (b[i][j] == ' ') return false;
			}
		}
		return true;
	}
	
	public void reset() {
		for (int i = 0; i < NUM_OF_ROW; i++){
			for (int j = 0; j < NUM_OF_COLUMNS; j++){
				b[i][j] = ' ';
			}
		}
	}

	public void drop(int col, char symbol) throws Exception {

		for (int i = NUM_OF_ROW-1; i >= 0; i--){
			if (i == 0 && b[i][col-1]!=' ') {
				throw new Exception();//Throw error if there is no vacancy in this column
			}
			if (b[i][col-1]==' '){
				b[i][col-1]=symbol;
				break;
			}
		}
	}



	public boolean droppable(int col, char[][] board){
		if (board[0][col]== ' '){
			return true;
		} else { return false;}
	}

	public char rivalSymbol(char botSymbol){

		for (int i = NUM_OF_ROW-1; i >= 0; i--){
			for (int j = 0; j < NUM_OF_COLUMNS; j++){
				if (b[i][j] != botSymbol && b[i][j] != ' '){
					return b[i][j];
				}
			}
		}
		return'^';//

	}

	/* Like containsWin(), but can be used to verify any 2D char array*/
	public boolean newContainsWin(char[][] board, char symbol) {

		for (int row = 0; row < NUM_OF_ROW; row++){
			for (int col = 0; col < NUM_OF_COLUMNS - 3; col++){
				if (board[row][col]==board[row][col+1] &&
						board[row][col+1]==board[row][col+2] &&
						board[row][col+2]==board[row][col+3] &&
						board[row][col]!=' '&&
						board[row][col]==symbol){

					return true;
				}
			}
		}
		//To horizontally check if someone wins
		for (int row = 0; row < NUM_OF_ROW-3; row++){
			for (int col = 0; col < NUM_OF_COLUMNS; col++){
				if (board[row][col]==board[row+1][col] &&
						board[row+1][col]==board[row+2][col] &&
						board[row+2][col]==board[row+3][col]&&
						board[row][col]!=' '&&
						board[row][col]==symbol){

					return true;
				}
			}
		}
		//To vertically check if someone wins
		for (int row = 0; row < NUM_OF_ROW-3; row++){
			for (int col = 0; col < NUM_OF_COLUMNS-3; col++){
				if (board[row][col]==board[row+1][col+1] &&
						board[row+1][col+1]==board[row+2][col+2] &&
						board[row+2][col+2]==board[row+3][col+3]&&
						board[row][col]!=' '&&
						board[row][col]==symbol){
					return true;
				}
			}
		}
		//To diagonally check if someone wins(downward slope)
		for (int row = 0; row < NUM_OF_ROW-3; row++){
			for (int col = 3; col < NUM_OF_COLUMNS; col++){
				if (board[row][col]==board[row+1][col-1] &&
						board[row+1][col-1]==board[row+2][col-2] &&
						board[row+2][col-2]==board[row+3][col-3]&&
						board[row][col]!=' '&&
						board[row][col]==symbol){
					return true;
				}
			}
		}
		//To diagonally check if someone wins(upward slope)
		return false;

	}


	public int botWin(char botSymbol){
		for (int i=0 ; i < NUM_OF_COLUMNS; i++ ){
			char[][] copiedBoard = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
			for(int a=0; a<b.length; a++)
				for(int j=0; j<b[a].length; j++)
					copiedBoard[a][j]=b[a][j];//make a copy of the board

			if(droppable(i,copiedBoard)){
				for (int k = NUM_OF_ROW-1; k >= 0; k--){
					if (copiedBoard[k][i]==' '){
						copiedBoard[k][i]=botSymbol;//Make sure whether this column is valid, then "drop" it
						if (newContainsWin(copiedBoard,botSymbol)){
							return i+1;//If a move can win the game, return this move, with i+1 specifying which column should the piece be dropped
						}
						break;
					}
				}
			}
		}
		return 999;//If there is no winning move, return 999 to tell the AIPlayer to do something else
	}

	public int rivalWin(char botSymbol){
		char rivalSymbol = rivalSymbol(botSymbol);
		int random = ThreadLocalRandom.current().nextInt(1, 8);
		if (rivalSymbol == '^') {return random;}
		for (int i=0 ; i < NUM_OF_COLUMNS; i++ ){
			char[][] copiedBoard = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
			for(int a=0; a<b.length; a++)
				for(int j=0; j<b[a].length; j++)
					copiedBoard[a][j]=b[a][j];//make a copy of the board

			if(droppable(i,copiedBoard)){
				for (int k = NUM_OF_ROW-1; k >= 0; k--){
					if (copiedBoard[k][i]==' '){
						copiedBoard[k][i]=rivalSymbol;//Make sure whether this column is valid, then "drop" it
						if (newContainsWin(copiedBoard,rivalSymbol)){
							return i+1;//If the rival has a move can win the game, block this move
						}
						break;
					}
				}
			}
		}
		return random;//If there is nothing to block, return a random input
	}
}
