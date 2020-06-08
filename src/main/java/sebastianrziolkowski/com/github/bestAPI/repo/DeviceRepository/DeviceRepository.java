package sebastianrziolkowski.com.github.bestAPI.repo.DeviceRepository;

import org.springframework.data.repository.CrudRepository;
import sebastianrziolkowski.com.github.bestAPI.models.DeviceModels.Device;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Long> {
    List<Device> findAll();
    Device findById(long id);
    long count();
}
