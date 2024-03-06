package com.learning.course.entities.enums;

public enum OrderStatus {
	
	WAINTING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static OrderStatus valueOf(int code) {
		
		for(OrderStatus value : OrderStatus.values()) {
			
			if(code == value.getCode()) {
				return value;
			}
			
		}
		throw new IllegalArgumentException("Invalid OrderStatus Code");
		
	}
	
}
