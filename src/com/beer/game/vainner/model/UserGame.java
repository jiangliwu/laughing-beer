package com.beer.game.vainner.model;


import com.beer.user.vainner.model.User;



public  class UserGame implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userGameId;
	private User user;
	private Game game;
	private Integer gameRole;
	private Integer gameHolder;

	// Constructors

	/** default constructor */
	public UserGame() {
	}

	/** full constructor */
	public UserGame(User user, Game game,
			Integer gameRole, Integer gameHolder) {
		this.user = user;
		this.game = game;
		this.gameRole = gameRole;
		this.gameHolder = gameHolder;
	}

	// Property accessors

	public Integer getUserGameId() {
		return this.userGameId;
	}

	public void setUserGameId(Integer userGameId) {
		this.userGameId = userGameId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Integer getGameRole() {
		return this.gameRole;
	}

	public void setGameRole(Integer gameRole) {
		this.gameRole = gameRole;
	}

	public Integer getGameHolder() {
		return this.gameHolder;
	}

	public void setGameHolder(Integer gameHolder) {
		this.gameHolder = gameHolder;
	}

}