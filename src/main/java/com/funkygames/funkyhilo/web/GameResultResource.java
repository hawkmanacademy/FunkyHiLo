package com.funkygames.funkyhilo.web;

import javax.xml.bind.annotation.XmlRootElement;

import com.funkygames.funkyhilo.model.Game;
import com.funkygames.funkyhilo.model.GameResult;

@XmlRootElement(name="funkyhilogame")
public class GameResultResource {
	private  String firstCard;
	private  String secondCard;
	private  String playerChoice;
	private  String result;
	
	public GameResultResource() {
		// TODO Auto-generated constructor stub
	}
	
	public GameResultResource(Game game) {
		this.firstCard = game.getFirstCard().toString();
		this.secondCard = null;
		this.playerChoice = null;
		this.result = null;
	}
	
	public GameResultResource(GameResult gameResult) {
		this.firstCard = gameResult.getFirstCard().toString();
		this.secondCard = gameResult.getSecondCard().toString();
		this.playerChoice = gameResult.getPlayerChoice().name();
		this.result = gameResult.getResult().name();
	}
	
	public String getFirstCard() {
		return firstCard;
	}
	
	public String getSecondCard() {
		return secondCard;
	}
	
	public String getPlayerChoice() {
		return playerChoice;
	}
	
	public String getResult() {
		return result;
	}

	public void setFirstCard(String firstCard) {
		this.firstCard = firstCard;
	}

	public void setSecondCard(String secondCard) {
		this.secondCard = secondCard;
	}

	public void setPlayerChoice(String playerChoice) {
		this.playerChoice = playerChoice;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
