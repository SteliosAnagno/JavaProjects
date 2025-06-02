import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int rows;
		int columns;
		
		
		System.out.println("This Is Score 4!");
		System.out.println("Please enter the name of the 1st player:");
		Players p1 = new Players(scanner.nextLine());
		System.out.println("Please enter the name of the 2nd player:");
		Players p2 = new Players(scanner.nextLine());
		
		
		System.out.println(p1.getName() + ", please select your chip:");
		String p1Symbol = new String(scanner.nextLine().toUpperCase());
		if(p1Symbol.equals("X") || p1Symbol.equals("O")){
			p1.setSymbol(p1Symbol);
		}
		String p2Symbol = p1.getSymbol().equals("X")? "O" : "X";
		p2.setSymbol(p2Symbol);
			
		
		System.out.println(p2.getName() + ", your chip is :" + p2.getSymbol());
		while(true) {
		System.out.println("Please enter the number of rows:");
		rows = scanner.nextInt();
		if(rows >= 4 && rows <= 15) {
			break;
		}else {
			System.out.println("Incorrect Input.Please enter the number of rows(4-15)");
		}
		}
		while(true) {
			System.out.println("Please enter the number of columns:");
			columns = scanner.nextInt();
			if(columns >= 4 && columns <= 15) {
				break;
			}else {
				System.out.println("Incorrect Input.Please enter the number of columns(4-15)");
			}
		}
		
		Board board = new Board(rows,columns);
		board.printBoard();
		
		Players currentPlayer = random.nextInt(2) == 0 ? p1 : p2;
		System.out.println(currentPlayer.getName() +" Starts!");
		
		while(true) {
			board.printBoard();
			System.out.println(currentPlayer.getName()+ ", your turn.Select column:");
			boolean validMove = false;
			while(!validMove) {
			int column = scanner.nextInt();
			validMove = board.Move(column, currentPlayer.getSymbol().charAt(0));
			
			}
			if(board.checkWinner(currentPlayer.getSymbol().charAt(0))) {
				board.printBoard();
				System.out.println("GAME OVER THE WINNER IS : "+ currentPlayer.getName());
				break;
			}else if(board.boardFull()) {
				board.printBoard();
				System.out.println("GAME OVER WE HAVE A DRAW.");
				break;
			}
			//Allazoun oi paixtes edw
			currentPlayer = Players.SwitchPlayer(currentPlayer, p1, p2);
		
		
			
	}
}
}

		
		
		
		
		
		
		
		
		
		
	
