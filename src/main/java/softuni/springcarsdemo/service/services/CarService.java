package softuni.springcarsdemo.service.services;

import softuni.springcarsdemo.service.models.CarServiceModel;

import java.util.List;

public interface CarService {

    CarServiceModel save(CarServiceModel model);

    List<CarServiceModel> getCars();
}
