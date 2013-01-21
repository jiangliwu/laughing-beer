package com.beer.game.vainner.model;

import java.sql.Timestamp;




public  class Game implements java.io.Serializable {

	// Fields
	//s
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer gameId;
	private Timestamp startTime;
	private Timestamp endTime;
	private String gameTitle;

	// Constructors

	/** default constructor */
	public Game() {
	}

	/** minimal constructor */
	public Game(Timestamp startTime) {
		this.startTime = startTime;
	}

	/** full constructor */
	public Game(Timestamp startTime, Timestamp endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		
	}

	// Property accessors

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

}