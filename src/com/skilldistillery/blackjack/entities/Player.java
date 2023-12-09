package com.skilldistillery.blackjack.entities;

public class Player {
	protected Hand hand = new BlackjackHand();

	// player at start of game is prompted with a menu to do one of the below
	// methods as menu options.

	public int lookAtHand() {
		return hand.getHandValue();
	}

	public void addCard(Card card) {
		// add card to players hand
		hand.addCard(card);
	}
	
	public boolean isAbleToHit() {
		boolean allowHit = false;
		if (hand.getHandValue() < 21) {
			allowHit = true;
		} else if (hand.getHandValue() == 21) {
			BlackjackHand isBlackJack = new BlackjackHand();
			isBlackJack.isBlackjack();
			allowHit = false;
		}
		return allowHit;
	}

	public boolean isAbleToStand() {
		boolean allowStand = false;
		if (hand.getHandValue() < 21) {
			allowStand = true;
		} else if (hand.getHandValue() > 21) {
			allowStand = false;
		}
		return allowStand;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	// the player shows his cards to the dealer and the dealer doesnt show both
	// until after
	// the player plays the game.
}
