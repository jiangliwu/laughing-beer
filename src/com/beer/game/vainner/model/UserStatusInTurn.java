/**
 * com.beer.game.vainner.model
 * 2013May 14, 2013
 * @author Jiangliwu-Vainner
 */
package com.beer.game.vainner.model;

/**
 * 
 */
public class UserStatusInTurn {
	private String username;
	private long getTime;
	private boolean isDone;
	private boolean isGeted;
	private int order;
	private int receive;
	private int send;
	private int book;
	
	private String op;

	public UserStatusInTurn() {
		this.isGeted = false;
		this.isDone = false;
		this.username = "";
		this.order = 0;
		this.receive = 0;
		this.send = 0;
		this.book = 0;
		this.op = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getGetTime() {
		return getTime;
	}

	public void setGetTime(long getTime) {
		this.getTime = getTime;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public boolean isGeted() {
		return isGeted;
	}

	public void setGeted(boolean isGeted) {
		this.isGeted = isGeted;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getReceive() {
		return receive;
	}

	public void setReceive(int receive) {
		this.receive = receive;
	}

	public int getSend() {
		return send;
	}

	public void setSend(int send) {
		this.send = send;
	}

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}



	public String toString() {
		return this.username + " " + this.order + " " + this.isGeted + " "
				+ this.getTime +" " + this.receive + " " + this.send + " " +this.book +" " + this.op;
	}

}
