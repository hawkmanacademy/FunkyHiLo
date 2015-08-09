package com.funkygames.funkyhilo.model;

import com.funkygames.funkyhilo.constants.Rank;
import com.funkygames.funkyhilo.constants.Suit;

public class Card implements Comparable<Card>{
	
	private Rank rank;
	
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}
	
	@Override
	public int compareTo(Card secondCard) {
		//if second card rank - first card (this) rank > 0 the HI else LO
		return secondCard.getRank().getIntValue() - this.rank.getIntValue();
	}
	
}
