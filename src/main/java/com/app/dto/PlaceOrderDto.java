package com.app.dto;

import java.util.ArrayList;
import java.util.List;

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
public class PlaceOrderDto {
	private long userId;
	
	private double totalAmount;
	
	private List<ItemDto> Items = new ArrayList<ItemDto>();
}
