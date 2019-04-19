package masterMindGame;

import java.util.ArrayList;
import java.util.Scanner;

public class MasterMindGame {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String[] secretCode = new String[4];
		String[] userInput = new String[secretCode.length];
		boolean gameFinsished = false;
		int whitePegs = 0;
		int blackPegs = 0;
		Scanner input = new Scanner(System.in);
		//secretCode = GeneratedCode.getRandomCode();
		// for (String string : secretCode) {
		// System.out.println(string);
		// }
		System.out
				.println("Welcome to Mastermind X's mean black pegs and O means white pegs");
		System.out
				.println("Choose 4 colors Green: Red: Yellow: Blue: White: or Black: ");

		System.out.println();
		do {
			whitePegs = 0;
			blackPegs = 0;
			for (int i = 0; i <= 3; i++) {
				System.out.println("Guess Color: ");
				userInput[i] = input.nextLine();
			}
			for (int i = 0; i < 4; i++)
			if (secretCode[i].equals(userInput[i])){
			blackPegs++;
			}
			ArrayList<Integer> alreadyProcessed = new ArrayList<Integer>();
			for (String color : secretCode)
			for (int j = 0; j < 4; j++)
			if (color.equals(userInput[j]) && !alreadyProcessed.contains(j))
			{
			alreadyProcessed.add(j);
			whitePegs++;
			break;
			}
			whitePegs -= blackPegs;
			if (blackPegs == 4){ // got right combination
			System.out.println("Correct");
			}

			System.out.println("White Pegs " + whitePegs);
			// whitePegs = whitePegs - blackPegs;
			System.out.println("White Pegs " + whitePegs);
			System.out.println("Black Pegs " + blackPegs);

			switch (blackPegs) {
			case 0:
				if (whitePegs <= 0) {
					System.out.println("[][][][]");
				} else if (whitePegs == 1) {
					System.out.println("[][O][][]");
				} else if (whitePegs == 2) {
					System.out.println("[][O][O][]");
				} else if (whitePegs == 3) {
					System.out.println("[][O][O][O]");
				} else if (whitePegs == 4) {
					System.out.println("[O][O][O][O]");
				}
				break;
			case 1:
				if (whitePegs <= 0) {
					System.out.println("[X][][][]");
				} else if (whitePegs == 1) {
					System.out.println("[X][O][][]");
				} else if (whitePegs == 2) {
					System.out.println("[X][O][O][]");
				} else if (whitePegs == 3) {
					System.out.println("[X][O][O][O]");
				}
				break;
			case 2:
				if (whitePegs <= 0) {
					System.out.println("[X][X][][]");
				} else if (whitePegs == 1) {
					System.out.println("[X][X][O][]");
				} else if (whitePegs == 2) {
					System.out.println("[X][X][O][O]");
				}
				break;
			case 3:
				if (whitePegs <= 0) {
					System.out.println("[X][X][X][]");
				} else if (whitePegs == 1) {
					System.out.println("[X][X][X][O]");
				}
				break;
			case 4:
				System.out.println("[X][X][X][X]");
				System.out.println("YOU WIN CONGRATS ");
				gameFinsished = true;
				break;
			default:
				System.out.println("[][][][]");
				break;
			}
		} while (gameFinsished == false);
	}
}
