package Bike.controller;

import Bike.entity.BikeEntity;
import Bike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Moto")
public class BikeController {

    @Autowired
    BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<BikeEntity>> getAll() {
        List<BikeEntity> Bike = bikeService.getAll();
        if (Bike.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(Bike);
    }

    @GetMapping("{id}")
    public ResponseEntity<BikeEntity> getById(@PathVariable("idBike") Integer idBike) {
        BikeEntity Bike = bikeService.getMotoById(idBike);
        if (Bike == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(Bike);
    }

    @PostMapping
    public ResponseEntity<BikeEntity> save(@RequestBody BikeEntity BikeEntity) {
        BikeEntity BikeNew = bikeService.save(BikeEntity);
        return ResponseEntity.ok(BikeNew);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<List<BikeEntity>> getByUserId(@PathVariable("idUser") Integer idUser){
        List<BikeEntity> Bike = bikeService.byUserId(idUser);
        return ResponseEntity.ok(Bike);
    }
}
