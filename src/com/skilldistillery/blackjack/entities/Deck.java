package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		cards = makeDeck();
	}

	public List<Card> makeDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCardToHand() {
		return cards.remove(0);
	}

	public void shuffleDeck() {
		Collections.shuffle(cards);
	}

}
