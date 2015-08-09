package com.funkygames.funkyhilo;

import java.util.Scanner;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.constants.Result;
import com.funkygames.funkyhilo.model.Card;
import com.funkygames.funkyhilo.model.Dealer;

public class FunkyHiloGame {

	public static void main(String[] args) {

		// 1 Create Dealer
		Dealer dealer = new Dealer();

		// start game
		Card firstCard = startGame(dealer);

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		System.out.println("user entered: " + input);

		Choice playerChoice = Choice.valueOf(input);

		Card secondCard = dealer.deal();
		
		// end game
		endGame(firstCard,secondCard,playerChoice);

	}

	private static void endGame(Card firstCard,Card secondCard, Choice playerChoice) {
		

		// 4.2 display the second card to the user
		System.out.println("Second Card: " + secondCard);

		// 5. decide the outcome
		// if secondCard.compareTo(firstCard) > 0 then outcome is HI else LO
		Choice gameOutcome = null;
		if (firstCard.compareTo(secondCard) > 0) {
			gameOutcome = Choice.HI;
		} else {
			gameOutcome = Choice.LO;
		}

		Result result = null;
		if (playerChoice == gameOutcome) {
			result = Result.WON;
		} else {
			result = Result.LOST;
		}

		System.out.println("You " + result + "!");
	}

	private static Card startGame(Dealer dealer) {
		// 2. deal the first card
		Card firstCard = dealer.deal();

		// 2.1 display the first card to the user
		System.out.println("First Card: " + firstCard);

		// 3. prompt the player for their choice
		System.out.println("Is the next card Hi or Lo?");

		return firstCard;
	}

}
