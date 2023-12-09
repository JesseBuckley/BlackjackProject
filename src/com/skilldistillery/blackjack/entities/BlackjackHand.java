package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand{

	public int getHandValue() {
		int totalValue = 0;
		for (Card card : hand) {
			totalValue = totalValue + card.getValue();
		}
		return totalValue;
	} 
	
	
	public boolean isBlackjack() {
		//if player or dealer has exactly 21 after the deal it is blackjack
		//AND if the dealer starts with 21 and you don't have 21 you lose.
		//also if both the dealer and player have 21 the game is a push and nothing happens you just get the menu again.
		return false;
		
	}
	
	public boolean isBust() {
		//if ()
	//if you decide to HIT and go over 21 you bust and you lose. 
		//AND if the dealer has less than 17 he must hit. if that cards puts him at over 21 he busts and you win.
		//AND lastly 
		return false;
	}
}
