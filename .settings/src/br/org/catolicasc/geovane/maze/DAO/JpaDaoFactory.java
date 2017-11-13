package br.org.catolicasc.geovane.maze.DAO;

public class JpaDaoFactory {

	public static JpaDaoFactory instance = new JpaDaoFactory();
	
	private GameDAO gameDAO;
	

	private JpaDaoFactory() {}
		
	public static JpaDaoFactory getInstance(){
		return instance;
	}
	
	
	public GameDAO getGameDao(){
		if(this.gameDAO == null)
			this.gameDAO = new GameDAO();
		return this.gameDAO;
	}

}
