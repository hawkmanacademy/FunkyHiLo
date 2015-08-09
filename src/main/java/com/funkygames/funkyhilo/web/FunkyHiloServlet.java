package com.funkygames.funkyhilo.web;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.model.Game;
import com.funkygames.funkyhilo.model.GameResult;
import com.funkygames.funkyhilo.services.HiLoGameService;
import com.funkygames.funkyhilo.services.InMemoryMessageService;
import com.funkygames.funkyhilo.services.MessageService;

public class FunkyHiloServlet extends HttpServlet {
	private MessageService messageService = new InMemoryMessageService();
	private HiLoGameService gameService = new HiLoGameService(messageService);

	public FunkyHiloServlet() {
		this.messageService = new InMemoryMessageService();
		this.gameService = new HiLoGameService(messageService);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String action = req.getParameter("action");
		String choice = req.getParameter("choice");
		Game game = null;
		switch (action) {
		case "start":
			game = start(resp);

			req.getSession().setAttribute("game", game);
			// store game in session
			
			break;
		case "choice":
			game = (Game) req.getSession().getAttribute("game");
			// get game from session
			choice(resp, game, choice);

			break;

		default:
			throw new IllegalArgumentException("invalid action" + action);
		}
		resp.getWriter().close();
	}

	private void choice(HttpServletResponse resp, Game game, String choice)
			throws IOException {
		Choice playerChoice = Choice.parse(choice);

		// determine outcome
		GameResult result = gameService.endGame(game, playerChoice);

		String secondCardMessage = messageService
				.readMessage(MessageService.SECOND_CARD_MESSAGE_ID);
		resp.getWriter().print(secondCardMessage);

		String gameResultMessage = messageService
				.readMessage(MessageService.GAME_RESULT_MESSAGE_ID);
		resp.getWriter().print(gameResultMessage);
	}

	private Game start(HttpServletResponse resp) throws IOException {
		Game game = gameService.startGame();
		String firstCardMessage = messageService
				.readMessage(MessageService.FIRST_CARD_MESSAGE_ID);
		resp.getWriter().print(firstCardMessage);
		return game;
	}
}
