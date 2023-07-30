import java.util.ArrayList;
import java.util.Scanner;

public class ttt {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Tic Tac Toe.");
		System.out.println("Player 1 will play with X, and Player 2 will play with O.");
		System.out.println("Choose your move by saying the number that corresponds to the appropriate box.");
		
		int moves = 1;
		
		ArrayList<String> usedNumbers = new ArrayList<String>();
		
		String XslashO = "";
		
		String playerNumber = "";
		
		String[] boardNum = new String[9];
		
		for(int i = 0; i < 9; i++) {
			boardNum[i] = " ";
		}
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Here is the tic tac toe board filled out with their corresponding number boxes: ");
		
		String[] demo = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		drawBoard(demo);
		
		while(moves <= 9) {
			if (moves >= 3) {
				if(gameIsFinished(boardNum)) {
					break;
				}
			}
			if(moves % 2 == 1) {
				XslashO = "X";
				playerNumber = "1";
			}
			else {
				XslashO = "O";
				playerNumber = "2";
			}
			System.out.print("Make your move, Player "+playerNumber+": ");
			String boxNumber = scan.nextLine();
			boxNumber = boxNumber.replaceAll("\\D", "");
			if(boxNumber.equals("") || boxNumber.equals(null)) {
				continue;
			}
			if(boxNumber.length() > 1) {	
				System.out.println("Since your input was " + boxNumber.length() + " digits long, we truncated it to the last digit, so in this case your input was understood as " + (boxNumber.substring(boxNumber.length()-1))+ ".");
				boxNumber = boxNumber.substring(boxNumber.length()-1);
			}
			if(!usedNumbers.contains(boxNumber)) {
				drawBoard(turn(Integer.parseInt(boxNumber), XslashO, boardNum));
				usedNumbers.add(boxNumber);
				moves++;
			} else {
				System.out.println("Oops, this spot has already been taken. Try again!");
			}
			
		}
		scan.close();
		if(!gameIsFinished(boardNum) && moves >= 9) {
			System.out.println("Tie!");
		}
		else if(XslashO == "X") {
			System.out.println("Player 1 wins!");
		}
		else if (XslashO == "O") {
			System.out.println("Player 2 wins!");
		}
		
	}
	
	static void drawBoard(String[] boardNum) {
		
		System.out.println(" "+ boardNum[0]+" | "+ boardNum[1]+" | "+ boardNum[2]);
		System.out.println("---|---|---");
		System.out.println(" "+ boardNum[3]+" | "+ boardNum[4]+" | "+ boardNum[5]);
		System.out.println("---|---|---");
		System.out.println(" "+ boardNum[6]+" | "+ boardNum[7]+" | "+ boardNum[8]);
		
	}
	
	static String[] turn(int boxNumber, String XslashO, String[] boardNum) {
		switch(boxNumber) {
		case 1:
			boardNum[0] = XslashO;
			break;
		case 2:
			boardNum[1] = XslashO;
			break;
		case 3:
			boardNum[2] = XslashO;
			break;
		case 4:
			boardNum[3] = XslashO;
			break;
		case 5:
			boardNum[4] = XslashO;
			break;
		case 6:
			boardNum[5] = XslashO;
			break;
		case 7:
			boardNum[6] = XslashO;
			break;
		case 8:
			boardNum[7] = XslashO;
			break;
		case 9:
			boardNum[8] = XslashO;
			break;
		}
		return boardNum;
		
	}
	
	static boolean gameIsFinished(String[] boardNum) {
		if(boardNum[0] == boardNum[1] && boardNum[1] == boardNum[2] && boardNum[1] != " ") {
			return true;
		}
		else if (boardNum[3] == boardNum[4] && boardNum[4] == boardNum[5] && boardNum[4] != " ") {
			return true;
		}
		else if (boardNum[6] == boardNum[7] && boardNum[7] == boardNum[8] && boardNum[7] != " ") {
			return true;
		}
		else if (boardNum[0] == boardNum[3] && boardNum[3] == boardNum[6] && boardNum[3] != " ") {
			return true;
		}
		else if (boardNum[1] == boardNum[4] && boardNum[4] == boardNum[7] && boardNum[4] != " ") {
			return true;
		}
		else if (boardNum[2] == boardNum[5] && boardNum[5] == boardNum[8] && boardNum[5] != " ") {
			return true;
		}
		else if (boardNum[0] == boardNum[4] && boardNum[4] == boardNum[8] && boardNum[4] != " ") {
			return true;
		}
		else if (boardNum[2] == boardNum[4] && boardNum[4] == boardNum[6] && boardNum[4] != " ") {
			return true;
		}
		else {
			return false;
		}
	}

}
