package br.org.catolicasc.geovane.maze.model;

import java.io.Serializable;
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
public class Score extends Game implements Bean ,Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElementWrapper(name = "players")
	@XmlElement(name = "player")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Player> players;
	
	@ManyToOne
	private Game game;

	public Score() {
		super();
	}

	public Score(List<Player> players, Game game) {
		this();
		this.players = players;
		this.game = game;
	}
	

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}


}
