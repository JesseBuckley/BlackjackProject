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
				"Welcome to the casino, would you like to sit down and play Blackjack with dealer? (Yes) or (No)");
		String userInput = sc.next().toUpperCase().trim().replaceAll("\\s", "");

		switch (userInput) {
		case "Y":
			gameLogic();
			break;
		case "N":
			System.out.println("Maybe later then, good luck!");
			break;

		case "YES":
			gameLogic();
			break;
		case "NO":
			System.out.println("Maybe later then, good luck!");
			break;

		default:
			System.err.println("(Dealer)Come back when you want to play at my table then!");
			break;
		}
	}

	public void gameLogic() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		boolean keepPlaying = true;
		String playAgain;

		do {
			dealer.shuffleDeck();

			System.out.println("(Dealer) Let's play! I am dealing the cards now...\n");

			dealCards(player, dealer);

			System.out.println("\nThe dealer is showing: " + dealer.dealerHandValue() + ".");
			System.out.println("\nThe player's hand is:");
			player.showPlayerHandDetails();
			System.out.println();
			System.out.println("\nYou have " + player.lookAtHand() + ".");

			if (player.lookAtHand() == 21 && dealer.lookAtHand() == 21) {
				System.out.println("\nThe player's hand is:");
				player.showPlayerHandDetails();
				System.out.println();
				System.out.println("\nYou have " + player.lookAtHand() + ".");

				System.out.println("\nThe dealer's hand is:");
				dealer.showDealerHandDetails();
				System.out.println();
				System.out.println("\nThe Dealer has " + dealer.lookAtHand() + ".\n");

				System.out.println("Both player, and dealer have Blackjack!! Push!");

				System.out.println("\n(Dealer) Do you want to play again? (Yes) or (No)");
				playAgain = sc.next().toUpperCase().trim().replaceAll("\\s", "");

				switch (playAgain) {
				case "Y":
					playAgain();
					break;
				case "N":
					System.out.println("(Dealer) It was fun playing with you! Good luck!");
					System.exit(0);
					break;

				case "YES":
					playAgain();
					break;
				case "NO":
					System.out.println("(Dealer) It was fun playing with you! Good luck!");
					System.exit(0);
					break;

				default:
					System.err.println(
							"(Dealer) Look, I get that this is a game... But still... I need to know if I am dealing you cards or not!");
					System.exit(0);
					break;
				}

			} else if (player.lookAtHand() == 21) {
				System.out.println("\nThe player's hand is:");
				player.showPlayerHandDetails();
				System.out.println();
				System.out.println("\nYou have " + player.lookAtHand() + ".");

				System.out.println("\nThe dealer's hand is:");
				dealer.showDealerHandDetails();
				System.out.println();
				System.out.println("\nThe Dealer has " + dealer.lookAtHand() + ".\n");

				System.out.println("\nPlayer Blackjack!! You win!");

				System.out.println("\n(Dealer) Do you want to play again? (Yes) or (No)");
				playAgain = sc.next().toUpperCase().trim().replaceAll("\\s", "");

				switch (playAgain) {
				case "Y":
					playAgain();
					break;
				case "N":
					System.out.println("(Dealer) It was fun playing with you! Good luck!");
					System.exit(0);
					break;

				case "YES":
					playAgain();
					break;
				case "NO":
					System.out.println("(Dealer) It was fun playing with you! Good luck!");
					System.exit(0);
					break;

				default:
					System.err.println(
							"(Dealer) Look, I get that this is a game... But still... I need to know if I am dealing you cards or not!");
					System.exit(0);
					break;
				}

			} else if (dealer.lookAtHand() == 21) {
				System.out.println("\nThe player's hand is:");
				player.showPlayerHandDetails();
				System.out.println();
				System.out.println("\nYou have " + player.lookAtHand() + ".");

				System.out.println("\nThe dealer's hand is:");
				dealer.showDealerHandDetails();
				System.out.println();
				System.out.println("\nThe Dealer has " + dealer.lookAtHand() + ".\n");

				System.out.println("\nDealer Blackjack!! You lose!\n");

				System.out.println("\n\n(Dealer) Do you want to play again? (Yes) or (No)");
				playAgain = sc.next().toUpperCase().trim().replaceAll("\\s", "");

				switch (playAgain) {
				case "Y":
					playAgain();
					break;
				case "N":
					System.out.println("(Dealer) It was fun playing with you! Good luck!");
					System.exit(0);
					break;

				case "YES":
					playAgain();
					break;
				case "NO":
					System.out.println("(Dealer) It was fun playing with you! Good luck!");
					System.exit(0);
					break;

				default:
					System.err.println(
							"(Dealer) Look, I get that this is a game... But still... I need to know if I am dealing you cards or not!");
					System.exit(0);
					break;
				}

			}
			while (player.isAbleToHit() && player.isAbleToStand()) {
				System.out.println("\n\n-----Choose between one of the options below-----");
				System.out.println("\n(1) Hit me!");
				System.out.println("(2) Stand");
				int option = sc.nextInt();

				if (option == 1) {
					dealOneCardToPlayer(player, dealer);
					System.out.println("\nThe player's hand is:");
					player.showPlayerHandDetails();
					System.out.println();
					System.out.println("\nYou have " + player.lookAtHand() + ".");
				}

				if (player.lookAtHand() == 21) {
					System.out.println("\nThe dealer's hand is:");
					dealer.showDealerHandDetails();
					System.out.println();
					System.out.println("\nThe Dealer has " + dealer.lookAtHand() + ".\n");

					System.out.println("Player wins, Blackjack!!");

					System.out.println("\n(Dealer) Do you want to play again? (Yes) or (No)");
					playAgain = sc.next().toUpperCase().trim().replaceAll("\\s", "");

					switch (playAgain) {
					case "Y":
						playAgain();
						break;
					case "N":
						System.out.println("(Dealer) It was fun playing with you! Good luck!");
						System.exit(0);
						break;

					case "YES":
						playAgain();
						break;
					case "NO":
						System.out.println("(Dealer) It was fun playing with you! Good luck!");
						System.exit(0);
						break;

					default:
						System.err.println(
								"(Dealer) Look, I get that this is a game... But still... I need to know if I am dealing you cards or not!");
						System.exit(0);
						break;
					}

				} else if (player.lookAtHand() > 21) {

					System.out.println("\nThe dealer's hand is:");
					dealer.showDealerHandDetails();
					System.out.println();
					System.out.println("\nThe Dealer has " + dealer.lookAtHand() + ".\n");

					System.out.println("Player loses, bust!!");

					System.out.println("\n(Dealer) Do you want to play again? (Yes) or (No)");
					playAgain = sc.next().toUpperCase().trim().replaceAll("\\s", "");

					switch (playAgain) {
					case "Y":
						playAgain();
						break;
					case "N":
						System.out.println("(Dealer) It was fun playing with you! Good luck!");
						System.exit(0);
						break;

					case "YES":
						playAgain();
						break;
					case "NO":
						System.out.println("(Dealer) It was fun playing with you! Good luck!");
						System.exit(0);
						break;

					default:
						System.err.println(
								"(Dealer) Look, I get that this is a game... But still... I need to know if I am dealing you cards or not!");
						System.exit(0);
						break;
					}
				}
				int hitAgain = 2;
				do {
					if (player.isAbleToHit() && option != 2) {
						System.out.println("\n\n-----Hit again, or Stand?-----");
						System.out.println("\n(1) Hit me!!!");
						System.out.println("(2) Stand..");
						hitAgain = sc.nextInt();
						if (hitAgain == 1) {
							dealOneCardToPlayer(player, dealer);
							System.out.println("You have " + player.lookAtHand() + ".");
							System.out.println("\nPlayer hand: ");
							player.showPlayerHandDetails();
							System.out.println();
						}
						if (player.lookAtHand() > 21) {

							System.out.println("\nThe dealer's hand is:");
							dealer.showDealerHandDetails();
							System.out.println();
							System.out.println("\nThe Dealer has " + dealer.lookAtHand() + ".\n");

							System.out.println("Player loses, bust!!");

							System.out.println("\n(Dealer) Do you want to play again? (Yes) or (No)");
							playAgain = sc.next().toUpperCase().trim().replaceAll("\\s", "");

							switch (playAgain) {
							case "Y":
								playAgain();
								break;
							case "N":
								System.out.println("(Dealer) It was fun playing with you! Good luck!");
								System.exit(0);
								break;

							case "YES":
								playAgain();
								break;
							case "NO":
								System.out.println("(Dealer) It was fun playing with you! Good luck!");
								System.exit(0);
								break;

							default:
								System.err.println(
										"(Dealer) Look, I get that this is a game... But still... I need to know if I am dealing you cards or not!");
								System.exit(0);
								break;
							}
						}
					}
					if (player.lookAtHand() == 21) {

						System.out.println("\nThe dealer's hand is:");
						dealer.showDealerHandDetails();
						System.out.println();
						System.out.println("\nThe Dealer has " + dealer.lookAtHand() + ".\n");

						System.out.println("Player wins, Blackjack!!");

						System.out.println("\n(Dealer) Do you want to play again? (Yes) or (No)");
						playAgain = sc.next().toUpperCase().trim().replaceAll("\\s", "");

						switch (playAgain) {
						case "Y":
							playAgain();
							break;
						case "N":
							System.out.println("(Dealer) It was fun playing with you! Good luck!");
							System.exit(0);
							break;

						case "YES":
							playAgain();
							break;
						case "NO":
							System.out.println("(Dealer) It was fun playing with you! Good luck!");
							System.exit(0);
							break;

						default:
							System.err.println(
									"(Dealer) Look, I get that this is a game... But still... I need to know if I am dealing you cards or not!");
							System.exit(0);
							break;
						}
					}
				} while (hitAgain != 2);

				if (hitAgain == 2 || option == 2) {
					System.out.println("You decided to stand with an " + player.lookAtHand() + ".");
					System.out.println("\nThe dealer flips his face down card...");
					System.out.println("\nThe dealer's hand is:");
					dealer.showDealerHandDetails();
					System.out.println();

					if (dealer.lookAtHand() >= 17 && dealer.lookAtHand() <= 21) {
						System.out.println("The dealer is forced to stand on " + "(" + dealer.lookAtHand() + ")");
					}
					if (dealer.lookAtHand() < 17) {
						System.out.println("Dealer is forced to hit. " + "(" + dealer.lookAtHand() + ")");
					}
					for (; dealer.lookAtHand() < 17;) {
						System.out.println();
						dealOneCardToDealer(dealer);
						System.out.println("\nThe dealer's hand is:");
						dealer.showDealerHandDetails();
						System.out.println();
						System.out.println("\nThe Dealer has " + dealer.lookAtHand() + ".\n");
					}

					System.out.println();
					if (dealer.lookAtHand() > 21) {
						System.out.println("Dealer forced to hit and went bust on " + "(" + dealer.lookAtHand() + ")");
						System.out.println("\nThe player's hand is:");
						player.showPlayerHandDetails();
						System.out.println();
						System.out.println("\nYou have " + player.lookAtHand() + ".");

						System.out.println("\nThe dealer's hand is:");
						dealer.showDealerHandDetails();
						System.out.println();
						System.out.println("\nThe Dealer has " + dealer.lookAtHand() + ".\n");

						System.out.println("You won!");
					}
					if (dealer.lookAtHand() < 21 && dealer.lookAtHand() >= 17) {
						System.out.println("Dealer stands at " + dealer.lookAtHand());
					}
					if (dealer.lookAtHand() == 21) {
						System.out.println("\nThe player's hand is:");
						player.showPlayerHandDetails();
						System.out.println();
						System.out.println("\nYou have " + player.lookAtHand() + ".");

						System.out.println("Dealer blackjack!");
						System.out.println("You lost!");
					}
				}
				if (player.lookAtHand() > dealer.lookAtHand()) {
					System.out.println("\nThe player's hand is:");
					player.showPlayerHandDetails();
					System.out.println();
					System.out.println("\nYou have " + player.lookAtHand() + ".");

					System.out.println("\nYou win!");

				} else if (player.lookAtHand() < dealer.lookAtHand() && dealer.lookAtHand() <= 21) {
					System.out.println("\nThe player's hand is:");
					player.showPlayerHandDetails();
					System.out.println();
					System.out.println("\nYou have " + player.lookAtHand() + ".");

					System.out.println("\nYou lose!");

				} else if (player.lookAtHand() == dealer.lookAtHand()) {
					System.out.println("\nThe player's hand is:");
					player.showPlayerHandDetails();
					System.out.println();
					System.out.println("\nYou have " + player.lookAtHand() + ".");

					System.out.println("\nPush!! Neither player or dealer wins!");
				}

				System.out.println("\n(Dealer) Do you want to play again? (Yes) or (No)");
				playAgain = sc.next().toUpperCase().trim().replaceAll("\\s", "");

				switch (playAgain) {
				case "Y":
					playAgain();
					break;
				case "N":
					System.out.println("(Dealer) It was fun playing with you! Good luck!");
					System.exit(0);
					break;

				case "YES":
					playAgain();
					break;
				case "NO":
					System.out.println("(Dealer) It was fun playing with you! Good luck!");
					System.exit(0);
					break;

				default:
					System.err.println(
							"(Dealer) Look, I get that this is a game... But still... I need to know if I am dealing you cards or not!");
					System.exit(0);
					break;
				}
			}
		} while (keepPlaying == true);
	}

	public void playAgain() {
		gameLogic();
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
		} while (count <= 1);
	}
}