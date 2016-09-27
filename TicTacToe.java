//package-name

import java.util.Scanner;


public class TicTacToe {

	public static String originalBoard[][];
	private static int countO=0,countX=0;
	private static Scanner scan = new Scanner(System.in);
	private static boolean gameOver = false;
	private static  long input=0;
	private static long mult;

	public static void main(String[] args) {
		System.out.println("please enter size of board greater than equals 2");
		 int n = scan.nextInt();
		 while(n<2){
			 System.out.println("Please enter size of board  greater than equals 2");
			 n = scan.nextInt();
		 }
		mult = n * n;
		originalBoard = new String[n + 1][n + 1];
		showOriginalBoard(n);
		player1Game(n);
	}
	
	private static boolean ifSameRow(int n) {
		boolean sameRow1 = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - 1; j++) {
				if (originalBoard[i][j].equals(originalBoard[i][j + 1])) {
					sameRow1 = true;
				} else {
					sameRow1 = false;
					break;
				}
			}
			if (sameRow1 == true) {
				return true;
			}
		}
		return false;
	}

	private static boolean ifSameCol(int n) {
		boolean sameCol1 = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - 1; j++) {
				if (originalBoard[j][i].equals(originalBoard[j + 1][i])) {
					sameCol1 = true;
				} else {
					sameCol1 = false;
					break;
				}
			}
			if (sameCol1 == true) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean ifSameDiagoal1(int n) {
		boolean sameDiag = false;
		for (int i = 1; i <= n - 1; i++) {
			if (originalBoard[i][i].equals(originalBoard[i + 1][i + 1])) {
				sameDiag = true;
			} else {
				sameDiag = false;
				break;

			}
		}
		if (sameDiag == true) {
			return true;
		}
		return false;
	}
	private static boolean ifSameDiagoal2(int n) {
		boolean sameDiag = false;
		for (int i = n; i <= 2; i--) {
			if (originalBoard[i][i].equals(originalBoard[i - 1][i - 1])) {
				sameDiag = true;
			} else {
				sameDiag = false;
				break;

			}
		}
		if (sameDiag == true) {
			return true;
		}
		return false;
	}
	
	private static void showOriginalBoard(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				originalBoard[i][j] = i + "," + j;
				System.out.print("  " + originalBoard[i][j]);
			}
			System.out.println();
		}
	}

	private static void showBoard(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// originalBoard[i][j]= i +","+ j;
				System.out.print("  " + originalBoard[i][j]);
			}
			System.out.println();
		}
	}


	private static void player1Game(int n) {
		if (input == mult) {
			gameOver = true;
			System.out.println("Match over : Result --- Drawn");
		}
		if (gameOver == false) {
			System.out.println("\n --player 1 ----in action--");
			System.out.println("please select any place on board in order of number on board {x,y} as {X} {y}");
			int player1Row = scan.nextInt();
			int player1col = scan.nextInt();
			if (isSafe(player1Row, player1col, n)) {
				if (!(originalBoard[player1Row][player1col].equals("X  "))
						&& !(originalBoard[player1Row][player1col]
								.equals("O  "))
						&& (countX == countO || (countX == (countO + 1)))) {
					originalBoard[player1Row][player1col] = "X  ";
					countX++;
					input++;
					showBoard(n);
					if ((ifSameRow(n) == true) || ((ifSameCol(n) == true))
							|| (ifSameDiagoal1(n) == true) || (ifSameDiagoal2(n) == true)) {
						System.out.println("Game Over :- result -- Player 1 Won");

					} else {
						player2Game(n);
					}

				} else {
					System.out.println("Wrong Input : move already played by any player");
					showBoard(n);
					player1Game(n);
				}
			} else {
				System.out.println("Wrong Input : Out of bound input");
				showBoard(n);
				player1Game(n);
			}
		}
	}

	private static void player2Game(int n) {
		if (input == mult) {
			gameOver = true;
			System.out.println("Game Over :- result -- Match Drawn");
		}
		if (gameOver == false) {
			System.out.println("\n --player 2 ----in action--");
			System.out.println("please select any place on board in order of number on board {x,y} as {X} {y}");
			int player2Row = scan.nextInt();
			int player2col = scan.nextInt();
			if (isSafe(player2Row, player2col, n)) {
				if (!(originalBoard[player2Row][player2col].equals("X  "))
						&& !(originalBoard[player2Row][player2col]
								.equals("O  "))
						&& (countX == countO || (countX == (countO + 1)))) {
					originalBoard[player2Row][player2col] = "O  ";
					countO++;
					input++;
					showBoard(n);
					if ((ifSameRow(n) == true) || ((ifSameCol(n) == true))
							|| (ifSameDiagoal1(n) == true) || (ifSameDiagoal2(n) == true)) {
						System.out.println("Game Over :- result -- Player 2 Won");

					} else {
						player1Game(n);
					}

				} else {
					System.out.println("Wrong Input : move already played by any player");
					showBoard(n);
					player2Game(n);
				}
			} else {
				System.out.println("Wrong Input : out of bound input");
				showBoard(n);
				player2Game(n);
			}
		}
	}
	
	private static boolean isSafe(int i, int j, int n) {
		return (i >= 1 && i <= n && j >= 1 && j <= n);
	}
}
	
