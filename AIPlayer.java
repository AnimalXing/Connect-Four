public class AIPlayer extends Player {


    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }


    public void makeMove(Board board) {
        try {if (board.botWin(this.symbol)!= 999){
            board.drop(board.botWin(this.symbol),this.symbol);//If there is a move that the AI can win, make this move
        } else {board.drop(board.rivalWin(this.symbol),this.symbol);}//Block the rival's winning move or make a random move
        } catch (Exception e){makeMove(board);}







        }
}
