package com.beer.game.vainner.model;

public class GameRetailParameter implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Double price;
	private Double delayCost;
	private Double repertoryCost;
	private Double orderCost;
	private Double transportCost;
	private Double discount;
	private Double origin;
	private Double cost;
	private Integer gameId;

	// Constructors

	public GameRetailParameter() {
	}

	public GameRetailParameter(Double price, Double delayCost,
			Double repertoryCost, Double orderCost, Double transportCost,
			Double discount, Double origin, Double cost, Integer gameId) {
		this.price = price;
		this.delayCost = delayCost;
		this.repertoryCost = repertoryCost;
		this.orderCost = orderCost;
		this.transportCost = transportCost;
		this.discount = discount;
		this.origin = origin;
		this.cost = cost;
		this.gameId = gameId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDelayCost() {
		return this.delayCost;
	}

	public void setDelayCost(Double delayCost) {
		this.delayCost = delayCost;
	}

	public Double getRepertoryCost() {
		return this.repertoryCost;
	}

	public void setRepertoryCost(Double repertoryCost) {
		this.repertoryCost = repertoryCost;
	}

	public Double getOrderCost() {
		return this.orderCost;
	}

	public void setOrderCost(Double orderCost) {
		this.orderCost = orderCost;
	}

	public Double getTransportCost() {
		return this.transportCost;
	}

	public void setTransportCost(Double transportCost) {
		this.transportCost = transportCost;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getOrigin() {
		return this.origin;
	}

	public void setOrigin(Double origin) {
		this.origin = origin;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String toString() {
		return "retail config :" + this.price + " " + this.delayCost + " "
				+ this.repertoryCost + " " + this.orderCost + " "
				+ this.transportCost + " " + this.discount + " " + this.origin
				+ " " + this.cost;
	}
}