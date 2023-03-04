package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ItemDto {
	private int productId;
	
	private int quantity;
	
//	private double unitPrice;
	
//	private double subTotal;
}
