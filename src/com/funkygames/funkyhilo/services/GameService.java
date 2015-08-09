package com.funkygames.funkyhilo.services;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.model.Game;
import com.funkygames.funkyhilo.model.GameResult;

public interface GameService {
	public Game startGame();
	
	public GameResult endGame(Game game,Choice playerChoice);
}
