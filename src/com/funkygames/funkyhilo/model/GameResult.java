package com.funkygames.funkyhilo.model;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.constants.Result;

public class GameResult {
	private Card firstCard;
	
	private Card secondCard;
	
	private Choice playerChoice;
	
	private Choice gameOutcome;
	
	private Result result;

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

	public Choice getPlayerChoice() {
		return playerChoice;
	}

	public void setPlayerChoice(Choice playerChoice) {
		this.playerChoice = playerChoice;
	}

	public Choice getGameOutcome() {
		return gameOutcome;
	}

	public void setGameOutcome(Choice gameOutcome) {
		this.gameOutcome = gameOutcome;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstCard == null) ? 0 : firstCard.hashCode());
		result = prime * result
				+ ((gameOutcome == null) ? 0 : gameOutcome.hashCode());
		result = prime * result
				+ ((playerChoice == null) ? 0 : playerChoice.hashCode());
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result
				+ ((secondCard == null) ? 0 : secondCard.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameResult other = (GameResult) obj;
		if (firstCard == null) {
			if (other.firstCard != null)
				return false;
		} else if (!firstCard.equals(other.firstCard))
			return false;
		if (gameOutcome != other.gameOutcome)
			return false;
		if (playerChoice != other.playerChoice)
			return false;
		if (result != other.result)
			return false;
		if (secondCard == null) {
			if (other.secondCard != null)
				return false;
		} else if (!secondCard.equals(other.secondCard))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GameResult [firstCard=" + firstCard + ", secondCard="
				+ secondCard + ", playerChoice=" + playerChoice
				+ ", gameOutcome=" + gameOutcome + ", result=" + result + "]";
	}
	
}
