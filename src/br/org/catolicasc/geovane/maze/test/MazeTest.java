package br.org.catolicasc.geovane.maze.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.org.catolicasc.geovane.maze.DAO.GameDAO;
import br.org.catolicasc.geovane.maze.model.Game;
import br.org.catolicasc.geovane.maze.model.Player;
import br.org.catolicasc.geovane.maze.model.Score;

public class MazeTest {
	//

	//
	// static {
	//
	////
	// Player player1 = new Player();
	// player1.setNickName("JoazinhoSkate13");
	// player1.setPoint(45);
	//
	// Player player2 = new Player();
	// player2.setNickName("Zé Comeia");
	// player2.setPoint(23);
	//
	//
	////
	//
	// Score score = new Score();
	// score.setPlayers(new ArrayList<Player>());
	// score.getPlayers().add(player1);
	// score.getPlayers().add(player2);
	//
	//
	////
	// Game game = new Game();
	// game.setType(Type.MAZE);
	// game.setName("Runner");
	// game.setScore(new ArrayList<>());
	// game.getScore().add(score);
	////
	// games.add(game);
	//
	//
	//
	//
	// }

	public static void main(String args[]) {

		List<Game> games = new ArrayList<>();

		Player player1 = new Player();
		player1.setNickName("JoazinhoSkate13");
		player1.setPoint(45);

		Player player2 = new Player();
		player2.setNickName("Zé Comeia");
		player2.setPoint(23);

		//

		Score score = new Score();
		score.setPlayers(new ArrayList<Player>());
		score.getPlayers().add(player1);
		score.getPlayers().add(player2);

		//
		Game game = new Game();
		game.setName("Runner");
		game.setScore(new ArrayList<>());
		game.getScore().add(score);
		games.add(game);

	}

}
