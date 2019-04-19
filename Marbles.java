package masterMindGame;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public enum Marbles {

	RED(new ImageIcon(Marbles.class.getResource("/images/red.png"))), 
	YELLOW(new ImageIcon(Marbles.class.getResource("/images/yellow.png"))), 
	BLUE(new ImageIcon(Marbles.class.getResource("/images/blue.png"))), 
	GREEN(new ImageIcon(Marbles.class.getResource("/images/green.png"))), 
	WHITE(new ImageIcon(Marbles.class.getResource("/images/white.png"))), 
	BLACK(new ImageIcon(Marbles.class.getResource("/images/black.png")));
	
	private ImageIcon icon;
	private static ArrayList<Marbles> marbles = new ArrayList<>();
	private static final ArrayList<Marbles> mastercode = new ArrayList<Marbles>();
	private static final ArrayList<Marbles> playerGuess = new ArrayList<Marbles>();
			
	private Marbles(ImageIcon icon) {
		this.icon = icon;
	}

	public ImageIcon getMarblesValue() {
		return icon;
	}

	public static Marbles getRandomColor() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}

	public static void setMastercode() {
		for (int i = 0; i < 4; i++) {
			mastercode.add(Marbles.getRandomColor());
		}
	}

	public static ArrayList<Marbles> getMastercode() {
		return mastercode;
	}

	public static void setPlayerGuess() {
		for (int i = 0; i < 4; i++) {
			playerGuess.add(Marbles.getRandomColor());
		}
	}

	public static ArrayList<Marbles> getPlayerGuess() {
		return playerGuess;
	}
}
