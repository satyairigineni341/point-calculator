package service;

import dto.OrderDTO;

public interface CustomerRewardService {

	public void calculatePointsAndSave(OrderDTO orderDTO);

}
