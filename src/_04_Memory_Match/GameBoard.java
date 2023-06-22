package _04_Memory_Match;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	static Card firstSelectedCard = null;
	static Card secondSelectedCard = null;

	// 1. Initialize TOTAL_CARDS to 2;
	static int TOTAL_CARDS = 52;

	ArrayList<Card> cards;

	JPanel panel;
	JLabel timeLabel;
	JButton newGameButton;

	Timer updateTimer;
	Timer gameClock;

	int seconds;

	public void setup() {
		gameClock = new Timer(1000, this);
		updateTimer = new Timer(750, this);

		// Can't play the game if there isn't an even number of cards
		if (TOTAL_CARDS % 2 != 0) {
			System.out.println("ERROR: Odd number of total cards, " + TOTAL_CARDS);
			System.exit(1);
		}

		// 2. Initialize the ArrayList of Cards declared above
		cards = new ArrayList<Card>();

		// 3. Create TOTAL_CARDS number of objects each with a value of 1.
		// Also, add action listeners to each Card object and then add each
		// of the Card objects to the ArrayList of Cards.
		for (int i = 0; i < TOTAL_CARDS; i++) {
			Card card = new Card(1);
			card.addActionListener(this);
			cards.add(card);
		}

		// 4. Use Collections.shuffle() method to randomize the order of
		// the cards in the ArrayList
		Collections.shuffle(cards);
		// 5. Initialize the panel variable declared above
		panel = new JPanel();
		// 6. Add all of the Card objects to the panel
		for (int i = 0; i < cards.size(); i++) {
			panel.add(cards.get(i));
		}
		// 7. Call the setupGui() method to set up the frame
		setupGui(cards);
		// 8. Call the startGame() method to start the game
		startGame();

		int[] rand = new int[52];
		for (int i = 0; i < 52; i++) {
			rand[i] = i;
		}
		randomizeArray(rand);
		for (int i = 0; i < 52; i++) {
			System.out.println(rand[i]);
			cards.get(i).setValue(rand[i]);
		}
	}

	// 9. Fill in the drawCards method to draw all the cards in the ArrayList.
	// Run your code and verify 2 cards are displayed and the game works.

	public void drawCards() {
		int num = 5;
		int num2 = 8;
		int count = 0;
		int faceUp=0;
		Font font = new Font("hi", 5, 30);
		Font Sfont = new Font("h", 5, 20);

		
		
		
			for (int i = 0; i < cards.size(); i++) {
				cards.get(i).setText("");
			}
		

		for (int i = 0; i < cards.size(); i++) {
			// 2
			if (cards.get(i).isFaceUp() == true) {
				if (cards.get(i).getValue() <= 4) {
					cards.get(i).setFont(font);
					cards.get(i).setText("2");
					cards.get(1).setValue(2);
				}

				// 3

				if (cards.get(i).getValue() >= num && cards.get(i).getValue() <= num2) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(font);
					cards.get(i).setText("3");
					cards.get(1).setValue(3);
				}
				count++;
				// 4

				if (cards.get(i).getValue() >= num + (4 * count) && cards.get(i).getValue() <= num2 + (4 * count)) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(font);
					cards.get(i).setText("4");
					cards.get(1).setValue(4);
				}
				count++;
				// 5

				if (cards.get(i).getValue() >= num + (4 * count) && cards.get(i).getValue() <= num2 + (4 * count)) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(font);
					cards.get(i).setText("5");
					cards.get(1).setValue(5);
				}
				count++;
				// 6
				if (cards.get(i).getValue() >= num + (4 * count) && cards.get(i).getValue() <= num2 + (4 * count)) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(font);
					cards.get(i).setText("6");
					cards.get(1).setValue(6);
				}
				count++;
				// 7
				if (cards.get(i).getValue() >= num + (4 * count) && cards.get(i).getValue() <= num2 + (4 * count)) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(font);
					cards.get(i).setText("7");
					cards.get(1).setValue(7);
				}
				count++;
				// 8
				if (cards.get(i).getValue() >= num + (4 * count) && cards.get(i).getValue() <= num2 + (4 * count)) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(font);
					cards.get(i).setText("8");
					cards.get(1).setValue(8);
				}
				count++;
				// 9
				if (cards.get(i).getValue() >= num + (4 * count) && cards.get(i).getValue() <= num2 + (4 * count)) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(font);
					cards.get(i).setText("9");
					cards.get(1).setValue(9);
				}
				count++;
				// 10
				if (cards.get(i).getValue() >= num + (4 * count) && cards.get(i).getValue() <= num2 + (4 * count)) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(font);
					cards.get(i).setText("10");
					cards.get(1).setValue(10);
				}
				count++;
				// Jack
				if (cards.get(i).getValue() >= num + (4 * count) && cards.get(i).getValue() <= num2 + (4 * count)) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(font);
					cards.get(i).setText("Jack");
					cards.get(1).setValue(11);
				}
				count++;
				// Queen
				if (cards.get(i).getValue() >= num + (4 * count) && cards.get(i).getValue() <= num2 + (4 * count)) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(Sfont);
					cards.get(i).setText("Queen");
					cards.get(1).setValue(12);
				}
				count++;
				// King
				if (cards.get(i).getValue() >= num + (4 * count) && cards.get(i).getValue() <= num2 + (4 * count)) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(font);
					cards.get(i).setText("King");
					cards.get(1).setValue(13);
				}
				count++;
				// Ace
				if (cards.get(i).getValue() >= num + (4 * count) && cards.get(i).getValue() <= num2 + (4 * count)) {
					// String r = Integer.toString(cards.get(i).getValue());
					cards.get(i).setFont(font);
					cards.get(i).setText("Ace");
					cards.get(1).setValue(1);
				}
				count++;

			}
		}

	}

	public static int[] randomizeArray(int[] arr) {
		Random rand = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int j = rand.nextInt(i + 1);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}

	// 10.
	// There are 52 cards in a normal sized deck of cards (not counting
	// jokers). There are 4 card suits, each with the numbers 2 to 10 and
	// the Jack, Queen, King, and Ace for a total of 13.

	//
	// Go back and modify the code to have a total of 52 cards and 4 copies
	// of each card, meaning x4 2s, x4 3s, x4 Jacks, ... one of each suit.
	// You can use Jacks=11, Queens=12, Kings=12, Aces=13
	//
	// EXTRA: You can use real card faces images instead of numbers by using
	// the images in the CardImages folder and the setFaceUpIcon() method.
	// Example:
	// card.setFaceUpIcon(Card.cardImagesPath + (i+1) + ".png");

	public void setupGui(ArrayList<Card> cards) {
		setTitle("League Memory Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setPreferredSize(new Dimension(1090, 500));
		add(panel);

		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(this);
		timeLabel = new JLabel("current time: " + (seconds / 60) + ":" + (seconds % 60));

		panel.add(newGameButton);
		panel.add(timeLabel);

		pack();
	}

	public void checkCards() {

		if (firstSelectedCard != null && secondSelectedCard != null) {

			if (firstSelectedCard.isSame(secondSelectedCard)) {
				firstSelectedCard.remove();
				secondSelectedCard.remove();
			} else {
				firstSelectedCard.setFaceUp(false);
				secondSelectedCard.setFaceUp(false);
			}

			firstSelectedCard = null;
			secondSelectedCard = null;
		}
	}

	public void startGame() {
		this.seconds = 0;
		gameClock.start();
		updateTimer.start();
	}

	public void endGame(boolean gameWon) {
		gameClock.stop();
		updateTimer.stop();

		if (gameWon) {
			// Matched all the cards

			int response = JOptionPane.showConfirmDialog(null,
					"You win !! " + "\nPlaying time " + (seconds / 60) + ":" + (seconds % 60) + "\nAgain ?", "You win",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				getContentPane().removeAll();
				this.setup();
				this.startGame();
			} else if (response == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		} else {
			// New game button pressed

			getContentPane().removeAll();
			this.setup();
			this.startGame();
		}
	}

	private boolean allCardsMatched() {
		if (this.cards == null) {
			return false;
		}

		for (Card eachCard : cards) {
			if (!eachCard.isMatched()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.updateTimer) {
			checkCards();
			drawCards();

			if (allCardsMatched()) {
				endGame(true);
			}

		} else if (e.getSource() == this.gameClock) {
			this.seconds++;
			timeLabel.setText("current time: " + (seconds / 60) + ":" + (seconds % 60));
		} else if (e.getSource() == this.newGameButton) {
			endGame(false);
		} else {
			// Card selected

			Card newCard = (Card) e.getSource();

			if (firstSelectedCard == null) {
				// First of 2 cards selected

				firstSelectedCard = newCard;
				firstSelectedCard.setFaceUp(true);
				drawCards();
				updateTimer.stop();
			} else if (secondSelectedCard == null && newCard != firstSelectedCard) {
				// Second of 2 cards selected

				secondSelectedCard = newCard;
				secondSelectedCard.setFaceUp(true);
				drawCards();
				updateTimer.restart();
			}
		}

	}
}
