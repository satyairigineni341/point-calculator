package service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.OrderDTO;
import model.Order;
import repository.OrderRepository;

@Service
public class OrderServiceImpl {
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRewardServiceImpl customerRewardServiceimpl;
		
	@Transactional
	public void saveOrder(OrderDTO orderDTO) {
		try {
			Order order = convertToOrderModel(orderDTO);
			orderRepository.save(order);
			customerRewardServiceimpl.calculatePointsAndSave(orderDTO);
		} catch(Exception e) {
			System.out.println("Order failed to save");
		}
		
	}
	
	private Order convertToOrderModel(OrderDTO orderDTO) {
		Order order = new Order();
		order.setCustomerId(orderDTO.getCustomerId());
		order.setId(orderDTO.getId());
		order.setItemId(orderDTO.getItemId());
		order.setOrderDescription(orderDTO.getOrderDescription());
		order.setTransactionDate(orderDTO.getTransactionDate());
		order.setItemCost(orderDTO.getItemCost());
		return order;
	}
}
