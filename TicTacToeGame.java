package TicTacToe;
import java.util.Scanner;
public class TicTacToeGame {
	char[] board;
	static char playerCharactor,cpuCharactor;
public void assignBoard() 
	{
		board = new char[10];
		for (int i = 1 ; i < 10 ; i++ ) {
			board[i] = ' ';
		}
	}
	public void userInput() {
			System.out.println("select x or o");
			Scanner input = new Scanner(System.in);
			char userInput = input.next().toUpperCase().charAt(0);
			System.out.println(userInput);
			
			if ( 'X' == userInput) {
				playerCharactor = 'X';
				cpuCharactor = 'O';
			}
			else if ('O' == userInput ) {
				cpuCharactor = 'X';
				playerCharactor = 'O';
			}
			else {
				System.out.println("enter a valid choice");
				userInput();
			}
		}
	public void showBoard(){
			System.out.println("The game Board");
			for (int i = 1 ; i < 10 ; i+=3) {
				System.out.println(board[i]+" | " +board[i+1]+" | "+board[i+2]);
				System.out.println("--+---+--");
			}
			
		} 
			public void userMoveLocation() {
			System.out.println("Enter the index from 1 to 9");
			try {
				Scanner input = new Scanner(System.in);
				int userIndex = input.nextInt();
				if (userIndex >= 10 || userIndex <= 0) {
					System.out.println("Enter a valid index number");
					userMoveLocation();
				}
				else {
					if ( board[userIndex]  != ' ') {
						System.out.println("It is already filled, enter a correct index");
						userMoveLocation();
					}
					else {
						moveLocation(userIndex);
					}
				}
			}
			catch(Exception e){
				System.out.println("Enter a correct option");
				userMoveLocation();
			}
		}
	
		public void moveLocation(int userIndex) {
			board[userIndex]=playerCharactor;
			showBoard();
			for(int i = 1 ; i < 10 ; i++) {
				if ( board[i] == ' ') {
					userMoveLocation();
				}
			}
		}
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe Game");
		TicTacToeGame game = new TicTacToeGame();
		game.assignBoard();
		game.userInput();
		System.out.println("player charater is -" +playerCharactor + 
					" computer character is - "+cpuCharactor);
		game.showBoard();
		game.userMoveLocation();
	}
}
