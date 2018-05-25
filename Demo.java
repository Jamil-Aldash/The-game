import java.util.Random;
import java.util.Scanner;

public class Demo {
	
				
	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		Card[] hand = new Card[8];
		char r='y';
		Scanner scanner = new Scanner(System.in);
		while(r=='y') {
		for (int x = 0; x < 8; x++) {
			hand[x] = dealer.getCard();
			hand[x].printCard();
		}
		System.out.println("The value of the cards=  " + dealer.convertToValue(dealer.getCard()));
		System.out.println("* If you want a new hand press--y--" + "\n" + "* If you haapy with your cards press-n--");
		r = scanner.next().charAt(0);
		if(r=='n') break;
		 }
		int a[]=dealer.countingSuits(hand);
		System.out.println("The number of Hearts  "+a[0]);
		System.out.println("The number of Spades  "+a[1]);
		System.out.println("The number of Diamonds  "+a[2]);
		System.out.println("The number of Clubs  "+a[3]);
		
		int[]b=dealer.countingSuitsValue(hand, dealer.getCard());
		System.out.println("The value of Hearts  "+b[0]);
		System.out.println("The value of Spades  "+b[1]);
		System.out.println("The value of Diamonds  "+b[2]);
		System.out.println("The value of Clubs  "+b[3]);
		System.out.println("The value of the cards=  " + dealer.convertToValue(dealer.getCard()));
	}
	
}

class Card {

	String suit;
	int value;

	void printCard() {
		String[] valueStrings = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		System.out.println("Card: " + suit + " " + valueStrings[value]);
	}

}

class Dealer {
	String[] suits = { "Clubs", "Diamonds", "Spades", "Hearts" };
	int[] values = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	private int generateRandomNumber() {
		Random random = new Random();
		int generatedNumber = random.nextInt(52);
		return generatedNumber;
	}

	private Card getCardFromNumber(int deckNumber) {
		Card card = new Card();
		card.value = deckNumber % 13;
		card.suit = suits[deckNumber / 13];
		return card;
	}

	Card getCard() {
		return getCardFromNumber(generateRandomNumber());
	}

	int convertToValue(Card c) {
		int x = 0;
		switch (c.suit) {

		case "Hearts":
			x = 1;
			break;
		case "Spades":
			x = 2;
			break;
		case "Diamonds":
			x = 3;
			break;
		case "Clubs":
			x = 4;
			break;
		}
		return (c.value + (x * 13));
	}
	 int[] countingSuits(Card[] hand) {
		int num[]= {0,0,0,0};
		for(int a=0;a<8;a++)
		switch (hand[a].suit) {
		case "Hearts":
			num[0]+= 1;
			break;
		case "Spades":
			num[1]+= 1;
			break;
		case "Diamonds":
			num[2]+= 1;
			break;
		case "Clubs":
			num[3]+= 1;
			break;
		}
		return num;
	 }
	 int[] countingSuitsValue(Card[] hand,Card c) {
			int num[]= {1,2,3,4};
			for(int a=0;a<8;a++)
			switch (hand[a].suit) {
			case "Hearts":
				num[0]+=1*13;
				num[0]=num[0]+c.value;
				break;
			case "Spades":
				num[1]+=1*13;
				num[1]=num[1]+c.value;
				break;
			case "Diamonds":
				num[2]+=1*13;
				num[2]=num[2]+c.value;
				break;
			case "Clubs":
				num[3]+=1*13;
				num[3]=num[3]+c.value;
				break;
			}
			return num;
		 }

	}


