package softuni.springcarsdemo.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.springcarsdemo.service.models.CarServiceModel;
import softuni.springcarsdemo.service.services.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/cars/create");
    }

    @PostMapping("/create")
    public ModelAndView createConfirm(@ModelAttribute CarServiceModel model){
        this.carService.save(model);

        return new ModelAndView("redirect:/all");
    }

    @GetMapping("/all")
    public ModelAndView all(ModelAndView modelAndView){
        List<CarServiceModel> cars = this.carService.getCars();
        modelAndView.addObject("cars",cars);
        modelAndView.setViewName("/cars/all");
        return modelAndView;
    }
}
