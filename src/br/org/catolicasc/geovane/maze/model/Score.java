package br.org.catolicasc.geovane.maze.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;



@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Score extends Player implements Bean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2333128915780409444L;

	@XmlElementWrapper(name = "games")
	@XmlElement(name = "game")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Game> games;
	
	@ManyToOne
	private Player player;


	public Score() {
		super();
	}


	public Score(List<Game> games, Player player) {
		this();
		this.games = games;
		this.player = player;
	}


	public List<Game> getGames() {
		return games;
	}


	public void setGames(List<Game> games) {
		this.games = games;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}

	
	

}
