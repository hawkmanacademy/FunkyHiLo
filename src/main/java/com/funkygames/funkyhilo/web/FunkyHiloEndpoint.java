package com.funkygames.funkyhilo.web;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.model.Game;
import com.funkygames.funkyhilo.model.GameResult;
import com.funkygames.funkyhilo.services.HiLoGameService;
import com.funkygames.funkyhilo.services.InMemoryMessageService;
import com.funkygames.funkyhilo.services.MessageService;

@Path("/funkyhilo")
public class FunkyHiloEndpoint {
	@Context private HttpServletRequest request;
	
	private MessageService messageService = new InMemoryMessageService();
	private HiLoGameService gameService = new HiLoGameService(messageService);

	public FunkyHiloEndpoint() {
		this.messageService = new InMemoryMessageService();
		this.gameService = new HiLoGameService(messageService);
	}
	
	@GET
    @Produces({MediaType.APPLICATION_JSON })
	public Response playgame(@QueryParam("action") @DefaultValue("start") String action,@QueryParam("choice")  String choice){
	
		Game game = null;
		GameResultResource grr = null;
		switch (action) {
		case "start":
			game = start();
			
			grr = new GameResultResource(game);

			request.getSession().setAttribute("game", game);
			break;
			
		case "choice":
			game = (Game) request.getSession().getAttribute("game");
			// get game from session
			GameResult gameresult = choice( game, choice);
			
			 grr = new GameResultResource(gameresult);
			 break;
		default:
			throw new IllegalArgumentException("invalid action" + action);
		}
		return Response.ok(grr).build();
	}

	private GameResult choice( Game game, String choice)
			 {
		Choice playerChoice = Choice.parse(choice);

		// determine outcome
		GameResult result = gameService.endGame(game, playerChoice);
		
		return result;
		
	}

	private Game start()  {
		Game game = gameService.startGame();
		return game;
	}
}
