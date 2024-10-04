package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;
import web.Service.CarServiceImpl;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private CarServiceImpl carDAO;

    @Autowired
    public CarsController(CarServiceImpl carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String getCars(@RequestParam(value = "count", required = false, defaultValue = "5") Integer count, Model model) {
        List<Car> cars = carDAO.getCar(count);
        model.addAttribute("car", cars);
        return "cars";
    }
}
