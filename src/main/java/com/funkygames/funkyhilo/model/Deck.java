package com.funkygames.funkyhilo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.funkygames.funkyhilo.constants.Rank;
import com.funkygames.funkyhilo.constants.Suit;
import com.funkygames.funkyhilo.exceptions.NoMoreCardsInDeckException;

public class Deck {
	private List<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		//1. for each Suit
		for (Suit suit:Suit.values()){
			//2. for each rank
			for (Rank rank:Rank.values()){
				//3. create a card with the rank and suit passed into the constructor
				Card card = new Card(rank,suit);
				//4. add the newly created card to the cards list
				cards.add(card);
			}
		}
		shuffle();
	}
	
	public Card drawCard() throws NoMoreCardsInDeckException{
		//check if not empty
		if (cards.size() > 0){
			//we remove the topmost card
			Card card = cards.remove(0);
			
			// we return card
			return card;
		}else{
			//if deck is empty throw an exception
			throw new NoMoreCardsInDeckException();
		}
	}
	
	public static void main (String args[]) {
		Deck deck = new Deck();
		Card card = null;
		
		try {
			card = deck.drawCard();
		} catch (NoMoreCardsInDeckException e) {
			System.out.println(e.getMessage());
			System.out.print("creating new deck");
			deck = new Deck();
			try {
				card = deck.drawCard();
			} catch (NoMoreCardsInDeckException e1) {
				//ignore as i know this will work
			}
		}
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
}
