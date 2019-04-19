package masterMindGame;

import java.util.Random;

public class GeneratedCode {
	private static int[] CodeColors = { 0,1,2,3,4,5 };

	public static int[] getCodeColors() {
		return CodeColors;
	}

	public void setCodeColors(int[] codeColors) {
		CodeColors = codeColors;
	}
	
	public static int[] getRandomCode() {
		Random rnd = new Random();
		int intRandomNum = 0;
		int[] randomCode = new int[4];
		for (int i = 0; i < 4; i++) {
			intRandomNum = rnd.nextInt(CodeColors.length);
			randomCode[i] = CodeColors[intRandomNum];

		}
		return randomCode;
	}
}
