package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApplication {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApplication start = new BlackjackApplication();
		start.runGame();
	}

	public void runGame() {
		
		mainMenu();

		// dealer.cardsLeft();
	}

	private void mainMenu() {
		System.out.println(
				"Welcome to the casino, would you like to sit down and play Blackjack against the dealer? (Y)or(N)");
		String userInput = sc.nextLine().toUpperCase();

		switch (userInput) {
		case "Y":
			displayMenu();
			break;
		case "N":
			System.out.println("Maybe later then, good luck!");
			break;

		case "YES":
			displayMenu();
			break;
		case "NO":
			System.out.println("Maybe later then, good luck!");
			break;

		default:
			System.err.println("Invalid input");
			break;
		}
	}

	public void displayMenu() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		dealer.shuffleDeck();
		
		System.out.println("(Dealer) Welcome! Let's play! I am dealing the cards now...\n");
		dealCards(player, dealer);
		
		System.out.println("\n\nThe dealer is showing: " + dealer.dealerHandValue() + "\n\nYou are showing: " + player.lookAtHand());
	}

	public void dealCards(Player player, Dealer dealer) {
		for (int d = 0; d < 2; d++) {

			Card dealerCards = dealer.dealCard();
			dealer.addCard(dealerCards);
			if (d == 0) {
				System.out.println("Dealer's face down card");
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
	public void dealerHandBeforeFlip() {
		
	}
	public void playerDecisions() {
		System.out.println();
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