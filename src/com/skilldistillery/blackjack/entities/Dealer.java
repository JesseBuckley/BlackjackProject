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

	public int dealerHandValue() {
		return hand.getDealerHandValue();
	}
	public void dealerHandJustFirstCard() {
		hand.handDetailsOneCardForDealer();
	}
	
	public void showDealerHandDetails() {
		hand.displayHandDetails();
	}
}
