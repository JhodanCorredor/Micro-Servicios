package Cars.controller;

import Cars.entity.CarsEntity;
import Cars.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("Cars")
public class CarsController {


    @Autowired
    CarsService carsService;

    @GetMapping
    public ResponseEntity<List<CarsEntity>> getAll() {
        List<CarsEntity> cars = carsService.getAll();
        if (cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("{id}")
    public ResponseEntity<CarsEntity> getById(@PathVariable("idCars") Integer idCars) {
        CarsEntity cars = carsService.getCarrById(idCars);
        if (cars == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity<CarsEntity> save(@RequestBody CarsEntity carsEntity) {
        CarsEntity carsNew = carsService.save(carsEntity);
        return ResponseEntity.ok(carsNew);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<List<CarsEntity>> getByUserId(@PathVariable("idUser") Integer idUser){
        List<CarsEntity> cars = carsService.byUserId(idUser);
        return ResponseEntity.ok(cars);
    }
}
