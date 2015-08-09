package com.funkygames.funkyhilo.constants;

public enum Choice {
	HI, LO, DRAW;

	public static Choice parse(String choice) {
		Choice playerChoice = null;
		switch (choice.toLowerCase()) {
		case "hi":
		case "h":
		case "high":
			playerChoice = Choice.HI;
			break;
		case "lo":
		case "l":
		case "low":
			playerChoice = Choice.LO;
			break;
		default:
			throw new IllegalArgumentException("invalid choice:" + choice);
		}
		return playerChoice;
	}
}
