package com.skilldistillery.blackjack.entities;

public class Player {
	protected Hand hand = new BlackjackHand();

	public int lookAtHand() {
		return hand.getHandValue();
	}

	public void addCard(Card card) {
		hand.addCard(card);
	}
	public void showPlayerHandDetails() {
		hand.displayHandDetails();
	}
	
	public boolean isAbleToHit() {
		boolean allowHit = false;
		if (hand.getHandValue() < 21) {
			allowHit = true;
		} 
		return allowHit;
	}

	public boolean isAbleToStand() {
		boolean allowStand = false;
		if (hand.getHandValue() < 21) {
			allowStand = true;
		} 
		return allowStand;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	@Override
	public String toString() {
		return getHand().toString();
	}
	
}
