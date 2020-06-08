package sebastianrziolkowski.com.github.bestAPI.repo.DeviceRepository;

import org.springframework.data.repository.CrudRepository;
import sebastianrziolkowski.com.github.bestAPI.models.DeviceModels.DeviceRentalHistory;

import java.util.List;

public interface DeviceRentalHistoryRepository extends CrudRepository<DeviceRentalHistory, Long> {
    List<DeviceRentalHistory> findAll();

    long count();
}
