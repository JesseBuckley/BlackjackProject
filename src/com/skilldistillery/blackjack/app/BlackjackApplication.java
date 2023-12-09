package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApplication {

	public static void main(String[] args) {
		BlackjackApplication start = new BlackjackApplication();
		start.runGame();
	}

	public void runGame() {
		Player player = new Player();
		Dealer dealer = new Dealer();

		dealer.shuffleDeck();
		dealCards(player, dealer);
		//dealer.cardsLeft();
	}

	public void dealCards(Player player, Dealer dealer) {
		for (int d = 0; d < 2; d++) {

			Card dealerCards = dealer.dealCard();
			dealer.addCard(dealerCards);
			if (d == 0) {
				System.out.println("The dealers first card is turned over");
			} else if (d == 1) {
				System.out.println(dealerCards + " dealer card");
			}
			for (int p = 0; p < 1; p++) {
				Card playerCards = dealer.dealCard();
				player.addCard(playerCards);
				System.out.println(playerCards + " player card");

			}
		}
	}
}
// The Dealer decides to Hit or Stand based on the rules of Blackjack:
// if the Dealer's hand total is below 17, the Dealer must Hit; if the hand
// total is 17 or above,
// the Dealer must Stand (the "rule of 17").

//when player playing his hand is done the dealer shows both cards unless player busted.

// after the player is done playing his hand whether he bust or stands or blackj
// the dealer will then know if he has to look at his cards at all or not.

// method to show or not show dealer cards