package service;

import dto.OrderDTO;
import model.Order;

public interface OrderService {
	public void saveOrder(OrderDTO orderDTO);
	
	public Order convertToOrderModel(OrderDTO orderDTO);

}
