package controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.RewardService;

@RequestMapping("api/rewards/")
@RestController
public class RewardController {
	
	@Autowired
	private RewardService rewardService;
	
	@GetMapping(value = "all/{endDate}")
	public double getTotalPointsAwarded(@PathVariable Date endDate) {
		return rewardService.getAllPointsAwardedByEndDate(endDate);
	}
	
	@GetMapping(value = "{customerId}/{endDate}")
	public double getRewardsEarnedByCustomer(@PathVariable long customerId,@PathVariable Date endDate) {
		return rewardService.getPointsAwardedToCustomer(customerId,endDate);
	}
	
}
