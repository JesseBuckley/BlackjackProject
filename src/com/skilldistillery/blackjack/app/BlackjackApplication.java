package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApplication {

	public static void main(String[] args) {
		BlackjackApplication play = new BlackjackApplication();
		play.runGame();
	}

	public void runGame() {
		Player player = new Player();
		Dealer dealer = new Dealer();
	}
}
