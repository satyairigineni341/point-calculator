package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.CustomerReward;
import repository.CustomerRewardsRepository;

@Service
public class RewardServiceImpl {
	@Autowired
	private CustomerRewardsRepository customerRewardsRepository;
	
	@Transactional
	public double getAllPointsAwardedByEndDate(Date endDate) {
		List<CustomerReward> result = new ArrayList<>();
		double totalPointsAwarded = 0;
		result = customerRewardsRepository.getAllTransactionsByEndDate(endDate);
		for(CustomerReward cr : result) totalPointsAwarded+= cr.getPointsEarned();
		return totalPointsAwarded;
	}

	@Transactional
	public double getPointsAwardedToCustomer(long customerId, Date endDate) {
		List<CustomerReward> result = new ArrayList<>();
		double totalPointsEarnedByCustomer = 0;
		result = customerRewardsRepository.getAllTransactionsForCustomerByEndDate(customerId, endDate);
		for(CustomerReward cr : result) totalPointsEarnedByCustomer+= cr.getPointsEarned();
		return totalPointsEarnedByCustomer;
	}

}
