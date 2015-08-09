package com.funkygames.funkyhilo;

import java.util.Scanner;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.constants.Result;
import com.funkygames.funkyhilo.model.Card;
import com.funkygames.funkyhilo.model.Dealer;
import com.funkygames.funkyhilo.model.Game;
import com.funkygames.funkyhilo.model.GameResult;
import com.funkygames.funkyhilo.services.HiLoGameService;

public class FunkyHiloGame {

	public static void main(String[] args) {

		// 1 Create Dealer
		HiLoGameService gameService = new HiLoGameService();
		Game game = gameService.startGame();
		System.out.println("First card is " + game.getFirstCard());
		
		Choice playerChoice = processPlayerChoice();
		
		// determine outcome
		GameResult result = gameService.endGame(game,playerChoice);

		System.out.println("Second Card is " + result.getSecondCard());
		
		System.out.println("You " + result.getResult() + "!");
	}
	
	private static Choice processPlayerChoice() {
		// 3. prompt the player for their choice
		System.out.println("Is the next card Hi or Lo?");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		System.out.println("user entered: " + input);

		Choice playerChoice = Choice.valueOf(input);
		return playerChoice;
	}
}
