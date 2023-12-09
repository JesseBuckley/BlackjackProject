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
	}

	private void mainMenu() {
		System.out.println(
				"Welcome to the casino, would you like to sit down and play Blackjack against the dealer? (Y)or(N)");
		String userInput = sc.nextLine().toUpperCase();

		switch (userInput) {
		case "Y":
			System.out.println("(Dealer) Welcome! Let's play! I am dealing the cards now...\n");
			gameLogic();
			break;
		case "N":
			System.out.println("Maybe later then, good luck!");
			break;

		case "YES":
			System.out.println("(Dealer) Welcome! Let's play! I am dealing the cards now...\n");
			gameLogic();
			break;
		case "NO":
			System.out.println("Maybe later then, good luck!");
			break;

		default:
			System.err.println("Invalid input");
			break;
		}
	}

	public void gameLogic() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		boolean keepPlaying = true;

		do {
			dealer.shuffleDeck();

			dealCards(player, dealer);
			
			System.out.println("\nThe dealer is showing:" + "\n" + dealer.dealerHandValue());
			System.out.println("\nThe player's cards are:");
			player.showPlayerHandDetails();
			System.out.println();
			System.out.println("\nYou have " + player.lookAtHand() + ".");
			if (player.lookAtHand() == 21) {
				System.out.println("\nPlayer Blackjack!! You win!");
				keepPlaying = false;
				break;

			} else if (player.lookAtHand() > 21) {
				System.out.println("Player bust!! You lose!");
				keepPlaying = false;
				break;

			} else if (player.lookAtHand() == 21 && dealer.lookAtHand() == 21) {
				System.out.println("Both player, and dealer have Blackjack!! push!");
				keepPlaying = false;
				break;
			}
			if (dealer.lookAtHand() == 21) {
				System.out.println("\nDealer Blackjack!! You lose!");
				keepPlaying = false;
				break;

			} else if (dealer.lookAtHand() > 21) {
				System.out.println("Dealer bust!! You win!");
				keepPlaying = false;
			}

			while (player.isAbleToHit() && player.isAbleToStand()) {
				System.out.println("\n\n-----Choose between one of the options below-----");
				System.out.println("\n(1) Hit me!");
				System.out.println("(2) Stand");
				int option = sc.nextInt();

				if (option == 1) {
					dealOneCardToPlayer(player, dealer);
					System.out.println("You have " + player.lookAtHand() + ".");
					if (player.lookAtHand() == 21) {
						System.out.println("Player wins, Blackjack!!");
						keepPlaying = false;
						break;

					} else if (player.lookAtHand() > 21) {
						System.out.println("Player loses, bust!!");
						keepPlaying = false;
						break;
					}
				}
				if (option == 2) {
					System.out.println("You decided to stand with an " + player.lookAtHand() + ".");
					System.out.println("\nThe dealer flips his face down card...\n");
					dealer.showDealerHandDetails();
					System.out.println();
					System.out.println("\nThe dealer has: " + dealer.lookAtHand() + ".\n");
					if (dealer.lookAtHand() >= 17 && dealer.lookAtHand() <= 21) {
						System.out.println("The dealer is forced to stand on " + dealer.lookAtHand());
						keepPlaying = false;
					}
					if (dealer.lookAtHand() < 17) {
						System.out.println("Dealer is forced to hit. " + "(" + dealer.lookAtHand() + ")");
						for (int hit = 0; dealer.lookAtHand() < 17; hit++) {
							System.out.println();
							dealOneCardToDealer(dealer);
							System.out.println("The dealer has: " + dealer.lookAtHand() + ".\n");
							dealer.showDealerHandDetails();
						}
						System.out.println();
						if (dealer.lookAtHand() > 21) {
							System.out.println("Dealer forced to hit and went bust on " + dealer.lookAtHand() + ".");
							System.out.println("You win!");
							keepPlaying = false;
							break;
						}
						if (dealer.lookAtHand() < 21 && dealer.lookAtHand() >= 17) {
							System.out.println("Dealer stands at " + dealer.lookAtHand());
						}
					}
					if (player.lookAtHand() > dealer.lookAtHand()) {
						System.out.println("You win");
						keepPlaying = false;
						break;

					} else if (player.lookAtHand() < dealer.lookAtHand()) {
						System.out.println("You lose");
						keepPlaying = false;
						break;
					}
				}
			}
		} while (keepPlaying == true);

	}

	public void dealOneCardToPlayer(Player player, Dealer dealer) {
		for (int p = 0; p < 1; p++) {
			Card playerCards = dealer.dealCard();
			player.addCard(playerCards);
			System.out.println(playerCards + "new card to Player.\n");
		}
	}

	public void dealOneCardToDealer(Dealer dealer) {
		for (int p = 0; p < 1; p++) {
			Card dealerCards = dealer.dealCard();
			dealer.addCard(dealerCards);
			System.out.println(dealerCards + "new card to Dealer.\n");
		}
	}

	public void dealCards(Player player, Dealer dealer) {
		int count = 0;
		do {
		for (int p = 0; p < 1; p++) {

				Card playerCards = dealer.dealCard();
				player.addCard(playerCards);
				System.out.print(playerCards + "(P)\n");
			}
			for (int d = 0; d < 1; d++) {
				if (count == 0) {
					System.out.print("Face down Card (D)\n");
					Card dealerCards = dealer.dealCard();
					dealer.addCard(dealerCards);
				} else if (count == 1) {
					Card dealerCards = dealer.dealCard();
					dealer.addCard(dealerCards);
					System.out.print(dealerCards + "(D)\n");
				}
				count++;
			}
		}while(count <= 1);
	}
}