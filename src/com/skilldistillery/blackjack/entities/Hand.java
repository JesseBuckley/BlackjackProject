package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	protected List<Card> hand = new ArrayList<>();
	
	public Hand() {}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void clear() {
		hand.clear();
	}
	
	public abstract int getHandValue();

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	protected abstract int getDealerHandValue();
	
	protected abstract void displayHandDetails();
	
	protected abstract void handDetailsOneCardForDealer();

}
