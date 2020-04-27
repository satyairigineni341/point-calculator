package dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {
	
	private long id;
	
	private long customerId;
	
	private long itemId;
	
	private double itemCost;
	
	private String orderDescription;
	
	private Date transactionDate;
	
}
