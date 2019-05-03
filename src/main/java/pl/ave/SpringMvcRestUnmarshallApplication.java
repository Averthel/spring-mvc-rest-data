package pl.ave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.ave.controller.CityController;
import pl.ave.model.City;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringMvcRestUnmarshallApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringMvcRestUnmarshallApplication.class, args);

        List<City> cities = new ArrayList<>();
        cities.add(new City("Warszawa", 1500000));
        cities.add(new City("Istambuł", 3500000));
        cities.add(new City("Berlin", 5000000));

        CityController cityController = ctx.getBean(CityController.class);

        cities.forEach(cityController::saveCity);

        cityController.getCities("name").forEach(System.out::println);

    }
}
