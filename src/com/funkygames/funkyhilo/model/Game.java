package com.funkygames.funkyhilo.model;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.constants.Result;

public class Game {
	private Card firstCard;
	
	private Card secondCard;

	public Card getFirstCard() {
		return firstCard;
	}

	public void setFirstCard(Card firstCard) {
		this.firstCard = firstCard;
	}

	public Card getSecondCard() {
		return secondCard;
	}

	public void setSecondCard(Card secondCard) {
		this.secondCard = secondCard;
	}
	
	public Choice getOutcome(){
		Choice gameOutcome = null;
		if (firstCard.compareTo(secondCard) > 0) {
			gameOutcome = Choice.HI;
		} else {
			gameOutcome = Choice.LO;
		}
		return gameOutcome;
	}
	
}
