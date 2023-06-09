package lk.ijse.dep9.app.repository;

import lk.ijse.dep9.app.entity.PassengerInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerInfoRepository extends CrudRepository<PassengerInfo, Integer> {
}
