package br.org.catolicasc.geovane.maze.rest;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import br.org.catolicasc.geovane.maze.model.Game;

public class Games {

	private List<Game> games = new ArrayList<>();

	public Games() {
		super();

	}

	public Games(List<Game> games) {
		this();
		this.games = games;
	}

	@XmlTransient
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@XmlElement(name = "link")
	public List<Link> getLinks() {
		List<Link> links = new ArrayList<>();
		for (Game game : getGames()) {

			Link link = Link.fromPath("games/{name}").rel("game").title(game.getName())
					.build(game.getName());

			links.add(link);
		}
		return links;
	}

	public void setLinks(List<Link> links) {

	}
}
