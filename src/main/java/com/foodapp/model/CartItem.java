package com.foodapp.model;

public class CartItem {
    private Food food;
    private int quantity;
    // getters & setters
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
}
