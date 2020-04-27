package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.OrderDTO;
import model.CustomerReward;
import repository.CustomerRewardsRepository;

@Service
public class CustomerRewardServiceImpl {

	@Autowired
	private CustomerRewardsRepository customerRewardsRepository;
	
	public void calculatePointsAndSave(OrderDTO orderDTO) {
		CustomerReward cr = new CustomerReward();
		cr.setCustomerId(orderDTO.getCustomerId());
		cr.setTransactionCost(orderDTO.getItemCost());
		cr.setTransactionDate(orderDTO.getTransactionDate());
		double pointsEarned  = 0,cost = orderDTO.getItemCost(); 
		if(cost>=50 && orderDTO.getItemCost()<=100) {
			pointsEarned = (cost-50);
		}
		else if(orderDTO.getItemCost()>100) {
			pointsEarned = (50)+ (cost-100)*2;
		}
		cr.setPointsEarned(pointsEarned);
		customerRewardsRepository.save(cr);
	}
}
