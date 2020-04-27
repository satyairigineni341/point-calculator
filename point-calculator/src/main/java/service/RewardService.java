package service;

import java.util.Date;

public interface RewardService {
	
	public double getAllPointsAwardedByEndDate(Date endDate);
	
	public double getPointsAwardedToCustomer(long customerId, Date endDate);

}
