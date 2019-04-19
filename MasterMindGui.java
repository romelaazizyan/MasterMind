package masterMindGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class MasterMindGui extends JFrame {

	// private JPanel contentPane;
	private BoardBackground background;
	private ImageIcon[] btnImage = {
			new ImageIcon(MasterMindGui.class.getResource("/images/red.png")),
			new ImageIcon(MasterMindGui.class.getResource("/images/yellow.png")),
			new ImageIcon(MasterMindGui.class.getResource("/images/green.png")),
			new ImageIcon(MasterMindGui.class.getResource("/images/blue.png")),
			new ImageIcon(MasterMindGui.class.getResource("/images/white.png")),
			new ImageIcon(MasterMindGui.class.getResource("/images/black.png")) };

	private ImageIcon redIcon = Marbles.RED.getMarblesValue(); // .png of a red
																// marble, etc.
	private ImageIcon yellowIcon = Marbles.YELLOW.getMarblesValue();
	private ImageIcon blueIcon = Marbles.BLUE.getMarblesValue();
	private ImageIcon greenIcon = Marbles.GREEN.getMarblesValue();
	private ImageIcon whiteIcon = Marbles.WHITE.getMarblesValue();
	private ImageIcon blackIcon = Marbles.BLACK.getMarblesValue();

	private int btnIndex = 0;
	private int whitePegs = 0;
	private int blackPegs = 0;
	private int[] secretCode;
	private JLabel[] resultsPanel = new JLabel[10];
	private newJbuttonColor[][] btns = new newJbuttonColor[10][4];
	private newJbuttonColor[][] btnPegs = new newJbuttonColor[10][4];
	private newJbuttonColor blankHoles;
	// JPanel mcPanel = createMCPanel();
	private JLabel mc1Label, mc2Label, mc3Label, mc4Label;
	int currentRow = 9;
	private JLabel secret;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterMindGui frame = new MasterMindGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MasterMindGui() {
		secretCode = GeneratedCode.getRandomCode();
		JLabel test1 = new JLabel();
		JLabel test2 = new JLabel();
		JLabel test3 = new JLabel();
		JLabel test4 = new JLabel();
		for (int a : secretCode) {
			// System.out.println(a);
			switch (a) {
			case 0:
				System.out.println(a);
				test1.setIcon(btnImage[0]);
				break;
			case 1:
				System.out.println(a);
				test2.setIcon(btnImage[1]);
				break;
			case 2:
				System.out.println(a);
				test3.setIcon(btnImage[2]);
				break;
			case 3:
				System.out.println(a);
				test4.setIcon(btnImage[3]);
				break;
			case 4:
				System.out.println(a);
				test4.setIcon(btnImage[4]);
				break;
			case 5:
				System.out.println(a);
				test4.setIcon(btnImage[5]);
				break;

			}

		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 500, 730);
		setResizable(false);

		background = new BoardBackground();
		background.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(background);
		background.setLayout(new BorderLayout(10, 10));

		JPanel gamePanel = new JPanel();
		gamePanel.setOpaque(false);
		gamePanel.setBorder(new EmptyBorder(0, 20, 0, 20));
		background.add(gamePanel, BorderLayout.CENTER);
		gamePanel.setLayout(new GridLayout(0, 4, 0, 4));

		gamePanel(gamePanel);

		JPanel pegsPanel = createPegsPanel();
		background.add(pegsPanel, BorderLayout.EAST);

		JPanel secretCode = createSecretPanel();
		background.add(secretCode, BorderLayout.NORTH);

		createButtonPanel();

	}

	private void gamePanel(JPanel gamePanel) {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 4; x++) {
				blankHoles = new newJbuttonColor();
				blankHoles.setText("");
				blankHoles.setColorIndex(-1);
				blankHoles.setIcon(new ImageIcon(MasterMindGui.class
						.getResource("" + "/images/ringSmall.png")));
				blankHoles.setBorder(new EmptyBorder(100, 100, 100, 100));
				blankHoles.setOpaque(false);
				blankHoles.setBackground(new Color(198, 134, 66));
				blankHoles.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						newJbuttonColor btn = ((newJbuttonColor) arg0
								.getSource());
						btn.setColorIndex(btn.getColorIndex() + 1);
						if (btn.getColorIndex() == 6) {
							btn.setColorIndex(0);
						}
						btn.setIcon(btnImage[btn.getColorIndex()]);

					}
				});
				if (y != 9) {
					blankHoles.setEnabled(false);
				}
				btns[y][x] = blankHoles;
				// blankHoles.setBounds(new Rectangle(0, 0, 20, 20));
				gamePanel.add(blankHoles);

			}

		}
	}

	private JPanel createSecretPanel() {
		JPanel secretCodePanel = new JPanel();
		secretCodePanel.setOpaque(false);
		secretCodePanel.setBorder(new EmptyBorder(10, 30, 0, 15));
		secretCode = GeneratedCode.getRandomCode();
		secret = new JLabel("?");
		for (int i = 0; i < 4; i++) {
			secret.setText("?");
			secret.setFont(new Font("Gabriola", Font.BOLD, 40));
			secretCodePanel.add(secret);
		}
		return secretCodePanel;
	}

	private JPanel createPegsPanel() {
		JPanel pegsPanel = new JPanel();
		pegsPanel.setOpaque(false);
		pegsPanel.setBorder(new EmptyBorder(0, 0, 0, 30));
		pegsPanel.setLayout(new GridLayout(0, 1, 0, 0));

		for (int y = 0; y < 10; y++) {
			JLabel pegs = new JLabel("pegs");
			resultsPanel[y] = pegs;
			pegsPanel.add(pegs);
		}
		return pegsPanel;
	}

	private void createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setBorder(new EmptyBorder(10, 30, 10, 30));
		background.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new GridLayout(0, 3, 0, 0));
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				evaluateGuess();
				if (blackPegs == 4) {
					JOptionPane.showMessageDialog(null,
							"Congragulation you win!!");
					// setMastercodeLabels(mcPanel);
					btnSubmit.setEnabled(false);
				} else {
					resultsPanel[currentRow].setText("White Pegs: " + whitePegs
							+ " Black Pegs: " + blackPegs);

				}
				if (currentRow == 0) {
					JOptionPane.showMessageDialog(null,
							"Sorry you lost try again ");
					// setMastercodeLabels(mcPanel);
					btnSubmit.setEnabled(false);
				} else {
					currentRow--;
					for (int i = 0; i < 4; i++) {
						newJbuttonColor button = btns[currentRow][i];
						button.setEnabled(true);
					}
				}

			}

			private void evaluateGuess() {
				whitePegs = 0;
				blackPegs = 0;
				for (int i = 0; i < 4; i++) {
					newJbuttonColor button = btns[currentRow][i];
					int userGuess = button.getColorIndex();
					if (secretCode[i] == userGuess) {
						blackPegs++;
					}
				}
				ArrayList<Integer> alreadyProcessed = new ArrayList<Integer>();
				for (int color : secretCode) {
					for (int j = 0; j < 4; j++) {
						newJbuttonColor btn = btns[currentRow][j];
						int guess = btn.getColorIndex();
						if (color == guess && !alreadyProcessed.contains(j)) {
							alreadyProcessed.add(j);
							whitePegs++;
							break;
						}
					}
				}
				whitePegs -= blackPegs;
			}
		});

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		buttonPanel.add(panel);
		buttonPanel.add(btnSubmit);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		buttonPanel.add(panel_1);
	}
	// private void setMastercodeLabels(JPanel mcPanel) {
	// //JLabel mc1Label = new JLabel();
	// mc1Label.setIcon(new
	// ImageIcon(scaleImage(Marbles.getMastercode().get(0).getMarblesValue())));
	// mcPanel.add(mc1Label);
	//
	// //JLabel mc2Label = new JLabel();
	// mc2Label.setIcon(new ImageIcon
	// (scaleImage(Marbles.getMastercode().get(1).getMarblesValue())));
	// mcPanel.add(mc2Label);
	//
	// //JLabel mc3Label = new JLabel();
	// mc3Label.setIcon(new ImageIcon
	// (scaleImage(Marbles.getMastercode().get(2).getMarblesValue())));
	// mcPanel.add(mc3Label);
	//
	// //JLabel mc4Label = new JLabel();
	// mc4Label.setIcon(new ImageIcon
	// (scaleImage(Marbles.getMastercode().get(3).getMarblesValue())));
	// mcPanel.add(mc4Label);
	// }
	//
	// private JPanel createMCPanel() {
	// JPanel mcPanel = new JPanel();
	// mcPanel.setBorder(new EmptyBorder(30, 30, 0, 30));
	//
	// mc1Label = new JLabel("?");
	// mc2Label = new JLabel("?");
	// mc3Label = new JLabel("?");
	// mc4Label = new JLabel("?");
	//
	// mcPanel.add(mc1Label);
	// mcPanel.add(mc2Label);
	// mcPanel.add(mc3Label);
	// mcPanel.add(mc4Label);
	//
	// return mcPanel;
	// }
	// public Image scaleImage(ImageIcon icon){
	// Image imgX = icon.getImage();
	// Image scaledImage = imgX.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	// return scaledImage;
	// }

}
