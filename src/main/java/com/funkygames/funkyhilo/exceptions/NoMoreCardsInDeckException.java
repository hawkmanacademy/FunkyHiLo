package com.funkygames.funkyhilo.exceptions;

public class NoMoreCardsInDeckException extends Exception {
	public NoMoreCardsInDeckException() {
		super("no more cards in deck!");
	}
}
