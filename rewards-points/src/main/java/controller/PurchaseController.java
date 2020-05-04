package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.OrderDTO;
import service.OrderServiceImpl;

@RequestMapping("api/purchase/")
@RestController
public class PurchaseController {

	@Autowired
	private OrderServiceImpl orderServiceimpl;
	
	@PostMapping(value = "{orderDTO}")
	public void saveOrder(@RequestBody OrderDTO orderDTO) {
		orderServiceimpl.saveOrder(orderDTO);
	}
}
