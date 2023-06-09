package lk.ijse.dep9.app.repository;

import lk.ijse.dep9.app.entity.PaymentInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInfoRepository extends CrudRepository<PaymentInfo, Integer> {
}
