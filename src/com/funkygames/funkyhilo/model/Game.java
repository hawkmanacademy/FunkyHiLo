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
		int compare = firstCard.compareTo(secondCard);
		Choice gameOutcome = null;
		if (compare == 0){
			gameOutcome = Choice.DRAW;
		}else if (compare > 0) {
			gameOutcome = Choice.HI;
		} else if (compare < 0) {
			gameOutcome = Choice.LO;
		}
		return gameOutcome;
	}
	
}
