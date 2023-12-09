package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand{
	
	public int getHandValue() {
		int totalValue = 0;
		for (Card card : hand) {
			totalValue = totalValue + card.getValue();
		}
		return totalValue;
	} 
	
	public int getDealerHandValue() {
		if(hand.size() >= 2) {
			hand.get(1).getValue();
			return hand.get(1).getValue();
		} else {
		return 0;
		}
	}
}
