package com.webeco.entity;

public class OrderItem {
	private int orderId;
	private String productId;
	private String username;
	private int quantity;
	private float subtotal;
	public OrderItem(int orderId, String productId, String username, int quantity, float subtotal) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.username = username;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", productId=" + productId + ", username=" + username + ", quantity="
				+ quantity + ", subtotal=" + subtotal + "]";
	}
	}
