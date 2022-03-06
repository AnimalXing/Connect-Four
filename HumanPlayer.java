import java.util.Scanner;
import java.util.Set;

public class HumanPlayer extends Player{


    public HumanPlayer (char symbol, Board board, String name){
        super(symbol,board,name);
    }



    public void makeMove(Board board){
        Scanner myObj = new Scanner(System.in);
        System.out.println(this.getName()+", please input your move:");
        int col = myObj.nextInt();//Scan the user input
        try {board.drop(col,this.symbol);
        } catch (Exception e) {
            System.out.println("Invalid input! Try to enter another number!");
            makeMove(board);//If the input is invalid, show an error message and let the user make another move

        }





    }


}
