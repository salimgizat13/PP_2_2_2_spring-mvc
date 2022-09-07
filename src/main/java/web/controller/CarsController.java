package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;


@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getSomeCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        if (count >= 5) {
            count = 5;
            model.addAttribute("cars", carService.getSomeCars(count));
        }
        model.addAttribute("cars", carService.getSomeCars(count));
        return "car/cars";
    }
}
