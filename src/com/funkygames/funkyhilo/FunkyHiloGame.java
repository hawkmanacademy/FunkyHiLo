package com.funkygames.funkyhilo;

import java.util.Scanner;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.constants.Result;
import com.funkygames.funkyhilo.model.Card;
import com.funkygames.funkyhilo.model.Dealer;
import com.funkygames.funkyhilo.model.Game;
import com.funkygames.funkyhilo.model.GameResult;
import com.funkygames.funkyhilo.services.HiLoGameService;
import com.funkygames.funkyhilo.services.InMemoryMessageService;
import com.funkygames.funkyhilo.services.MessageService;

public class FunkyHiloGame {
	private MessageService messageService;
	
	public static void main(String[] args) {
		MessageService messageService = new InMemoryMessageService();
		HiLoGameService gameService = new HiLoGameService(messageService);
	
		Scanner scanner = new Scanner(System.in);
		String signal = "";
		
		do{
			playGame(messageService, gameService);
			System.out.println("Do you want to play another game?");
			signal = scanner.nextLine();
		}while(!"n".equalsIgnoreCase(signal));
		scanner.close();
	}

	private static void playGame(MessageService messageService,
			HiLoGameService gameService) {
		Game game = gameService.startGame();
		String firstCardMessage = messageService.readMessage(MessageService.FIRST_CARD_MESSAGE_ID);
		System.out.println(firstCardMessage);
		
		Choice playerChoice = processPlayerChoice();
		
		// determine outcome
		GameResult result = gameService.endGame(game,playerChoice);

		String secondCardMessage = messageService.readMessage(MessageService.SECOND_CARD_MESSAGE_ID);
		System.out.println(secondCardMessage);
		
		String gameResultMessage = messageService.readMessage(MessageService.GAME_RESULT_MESSAGE_ID);
		System.out.println(gameResultMessage);
	}
	
	private static Choice processPlayerChoice() {
		System.out.println("Is the next card Hi or Lo?");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		System.out.println("user entered: " + input);

		Choice playerChoice = Choice.parse(input);
		return playerChoice;
	}
}
