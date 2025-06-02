
public class Board {
	private char board[][];
	private int rows;
	private int columns;
	
	public Board(int rows ,int columns) {
		 board = new char [rows][columns];
	
		 for(int i=0; i < rows; i++) {
			 for(int j=0; j<columns; j++){
				 board[i][j] = '-';
			
			 }
		 }

	}
	
	public void printBoard() {
		System.out.print("  "); 
        for (int j = 0; j < board[0].length; j++) {
            System.out.print(j + " "); 
        }
        System.out.println(); 
        
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " "); // 
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " "); 
            }
            System.out.println(); 
        }
	}

	public char[][] getBoard() {
		return board;
	}
	
	public boolean Move(int column,char currentSymbol) {
		if(column < 0 || column >= board[0].length){
			System.out.println("Incorrect move.Try again");
			return false;
		}
		for(int i= board.length - 1; i>=0; i--) {
			if(board[i][column] == '-') {
				board[i][column] = currentSymbol;
				return true;
			}
		}
				
				System.out.println("Column is Full!");
				return false;
				
		}
	
	public boolean checkWinner(char symbol) {
		return checkHorizontalWinner(symbol) || checkVerticalWinner(symbol) || checkDiagonialWinner(symbol);
	}
	
	private boolean checkHorizontalWinner(char symbol) {
		for(int i=0; i< board.length; i++) {
			for(int j=0; j< board[0].length-3; j++) {
				if(board[i][j] == symbol && board[i][j+1] == symbol && board[i][j+2] == symbol && board[i][j+3] == symbol) {
					return true;
				}
				
			}
		}
		return false;
		
	}
	private boolean checkVerticalWinner(char symbol) {
		for(int i=0; i< board.length-3; i++) {
			for(int j=0; j< board[0].length; j++) {
				if(board[i][j] == symbol && board[i+1][j] == symbol && board[i+2][j] == symbol && board[i+3][j] == symbol) {
					return true;
				}
				
			}
		}
		return false;
	
	
	}
	//Aπο πανω αριστερα προς κατω δεξια 
	private boolean checkDiagonialWinner(char symbol) {
		for(int i=0; i< board.length -3; i++) {
			for(int j=0; j< board[0].length -3; j++) {
				if(board[i][j] == symbol && board[i+1][j+1] == symbol && board[i+2][j+2] == symbol && board[i+3][j+3] == symbol) {
					return true;
				}
				
			}
		}
		
	//Απο κατω αρσιτερα προς πανω δεξια
		for(int i=3; i<board.length; i++) {
			for(int j=0; j<board[0].length- 3; j++) {
				if(board[i][j] == symbol && board[i-1][j+1] == symbol && board[i-2][j+2] == symbol && board[i-3][j+3] == symbol) {
					return true;
				}
			}
				
			}
		return false;
		}
	public boolean boardFull() {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length;j++) {
				if(board[i][j]== '-') {
					return false;
				}
			}
		}
		return true;
	}
		
	
	
	
}
