package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.CustomerReward;

@Repository
public interface CustomerRewardsRepository extends JpaRepository<CustomerReward, Long> {
	
	@Query(value = "SELECT * FROM CUSTOMER_REWARD cr where cr.transactionDate between : endDate and MONTH(n.transactionDate) = MONTH(DATEADD(month, - 3, : endDate))", nativeQuery = true)
	List<CustomerReward> getAllTransactionsByEndDate(Date endDate);

	
	@Query(value = "SELECT * FROM CUSTOMER_REWARD cr where cr.customerId=:customerId and cr.transactionDate between : endDate and MONTH(n.transactionDate) = MONTH(DATEADD(month, - 3, : endDate))", nativeQuery = true)
	List<CustomerReward> getAllTransactionsForCustomerByEndDate(long customerId, Date endDate);


}
