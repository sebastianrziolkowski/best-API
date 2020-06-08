package sebastianrziolkowski.com.github.bestAPI.repo.DeviceRepository;

import org.springframework.data.repository.CrudRepository;
import sebastianrziolkowski.com.github.bestAPI.models.DeviceModels.DeviceRental;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DeviceRentalRepository extends CrudRepository<DeviceRental, Long> {
    List<DeviceRental> findByIdAndUserId(long id, long userId);
}
