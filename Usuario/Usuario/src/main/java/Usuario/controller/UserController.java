package Usuario.controller;

import Usuario.entity.UserEntity;
import Usuario.model.Cars;
import Usuario.model.Bike;
import Usuario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll(){
        List<UserEntity> users = userService.getAll();
        if(users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public  ResponseEntity<UserEntity> getById(@PathVariable("idUser") Integer idUser){
        UserEntity user = userService.getUserById(idUser);
        if (user == null)
            return  ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserEntity> save (@RequestBody UserEntity userEntity){
        UserEntity userNew = userService.save(userEntity);
        return ResponseEntity.ok(userNew);
    }

    @GetMapping("/Cars/{idUser}")
    public ResponseEntity<List<Cars>> getCars(@PathVariable("idUser") Integer idUser){
        UserEntity user = userService.getUserById(idUser);
        if (user == null)
            return ResponseEntity.notFound().build();
        List<Cars> cars = userService.getCars(idUser);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/Moto/{idUser}")
    public ResponseEntity<List<Bike>> getMoto(@PathVariable("idUser") Integer idUser){
        UserEntity user = userService.getUserById(idUser);
        if (user == null)
            return ResponseEntity.notFound().build();
        List<Bike> moto = userService.getMoto(idUser);
        return ResponseEntity.ok(moto);
    }

    @PostMapping("/savecars/{idUser}")
    public ResponseEntity<Cars> saveCars(@PathVariable("idUser") Integer idUser, @RequestBody Cars cars) {
        if (userService.getUserById(idUser) == null)
            return ResponseEntity.notFound().build();
        Cars carsNew = userService.saveCars(idUser , cars);
        return  ResponseEntity.ok(cars);
    }

    @PostMapping("/savebike/{idUser}")
    public ResponseEntity<Bike> saveBike(@PathVariable("idUser") Integer idUser, @RequestBody Bike bike) {
        if (userService.getUserById(idUser) == null)
            return ResponseEntity.notFound().build();
        Bike bikeNew = userService.saveBike(idUser , bike);
        return  ResponseEntity.ok(bike);
    }

    @GetMapping("/getAll/{idUser}")
    public ResponseEntity<Map<String, Object>> getAllVehicles(@PathVariable("idUser") Integer idUser){
        Map<String, Object> result = userService.getUserAndVehicules(idUser);
        return ResponseEntity.ok(result);
    }
}