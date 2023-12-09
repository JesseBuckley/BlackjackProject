package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck = new Deck();

	public Deck shuffleDeck() {
		deck.shuffleDeck();
		return deck;
	}

	public Card dealCard() {
		return deck.dealCardToHand();
	}
	
	public int cardsLeft() {
		System.out.println("(Dealer)There are: " + deck.checkDeckSize() + " cards left in my deck.");
		return deck.checkDeckSize();
	}
	// The Dealer decides to Hit or Stand based on the rules of Blackjack:
	// if the Dealer's hand total is below 17, the Dealer must Hit; if the hand
	// total is 17 or above,
	// the Dealer must Stand (the "rule of 17").

	// after the player is done playing his hand whether he bust or stands or blackj
	// the dealer will then know if he has to look at his cards at all or not.

	// method to show or not show dealer cards
}
