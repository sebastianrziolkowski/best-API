package sebastianrziolkowski.com.github.bestAPI.controller.deviceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sebastianrziolkowski.com.github.bestAPI.models.DeviceModels.DeviceRental;
import sebastianrziolkowski.com.github.bestAPI.models.User;
import sebastianrziolkowski.com.github.bestAPI.repo.DeviceRepository.DeviceRentalRepository;
import sebastianrziolkowski.com.github.bestAPI.staticClass.mappingPath;

import javax.validation.Valid;
import java.util.Date;
import java.util.Map;


@RestController
public class DeviceRentalController {

    @Autowired
    private DeviceRentalRepository deviceRentalRepository;


    @PostMapping(mappingPath.ADD_DEVICE_RENTAL)
    public void addRentalDevice(@Valid @RequestBody DeviceRental deviceRental) {
        deviceRental.setRentStartDate(new Date());
        deviceRentalRepository.save(deviceRental);
    }


}
