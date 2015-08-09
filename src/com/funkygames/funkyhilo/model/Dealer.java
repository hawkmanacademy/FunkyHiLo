package com.funkygames.funkyhilo.model;

import com.funkygames.funkyhilo.exceptions.NoMoreCardsInDeckException;

public class Dealer {
	//a dealer has a deck of cards
	private Deck deck;
	
	public Dealer() {
		//when a new dealer is created, give them a new deck of cards
		this.deck = new Deck();
	}
	
	public void shuffle(){
		this.deck.shuffle();
	}
	
	public Card deal(){
		//when deal is called, draw a card from the deck
		Card card = null;
		try {
			 card = deck.drawCard();
		} catch (NoMoreCardsInDeckException e) {
			//if the deck is empty, create a new deck and deal again
			deck = new Deck();
			
			try {
				card = deck.drawCard();
			} catch (NoMoreCardsInDeckException e1) {
				throw new IllegalStateException("a new deck should always have at least one card");
			}
			
			System.out.println("run out of cards but recovered by created new deck");
		}
		
		return card;
	}
}
