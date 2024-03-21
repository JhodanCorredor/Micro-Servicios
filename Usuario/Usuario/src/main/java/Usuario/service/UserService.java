package Usuario.service;

import Usuario.entity.UserEntity;
import Usuario.feignclients.BikeFeignClient;
import Usuario.feignclients.CarsFeignClient;
import Usuario.model.Cars;
import Usuario.model.Bike;
import Usuario.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CarsFeignClient carsFeignClient;

    @Autowired
    BikeFeignClient bikeFeignClient;

    @Autowired
    RestTemplate restTemplate;

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public UserEntity getUserById(Integer idUser){
        return userRepository.findById(idUser).orElse(null);
    }

    public UserEntity save(UserEntity userEntity){
        UserEntity userNew = userRepository.save(userEntity);
        return  userNew;
    }

    public List<Cars> getCars(Integer idUser){
        List<Cars> cars = restTemplate.getForObject("htttp://localhost:8002/Cars/idUser" + idUser, List.class);
        return cars;
    }

    public List<Bike> getMoto(Integer idUser){
        List<Bike> moto = restTemplate.getForObject("htttp://localhost:8003/Moto/idUser" + idUser, List.class);
        return moto;
    }

    public Cars saveCars(Integer idUser, Cars cars){
        cars.setIdUser(idUser);
        Cars carNew = carsFeignClient.save(cars);
        return carNew;
    }

    public Bike saveBike(Integer idUser, Bike bike){
        bike.setIdUser(idUser);
        Bike bikeNew = bikeFeignClient.save(bike);
        return bikeNew;
    }

    public Map<String, Object> getUserAndVehicules(Integer idUser){
        Map<String, Object> result = new HashMap<>();
        UserEntity user = userRepository.findById(idUser).orElse(null);
        if(user == null){
            result.put("Mensaje", "No existe el usuario");
            return result;
        }
        result.put("User", user);
        List<Cars> cars = carsFeignClient.getCars(idUser);
        if (cars.isEmpty())
            result.put("Cars", "Este usuario no tiene coches");
        else
            result.put("Cars", cars);
        List<Bike> bikes = bikeFeignClient.getBike(idUser);
        if(bikes.isEmpty())
            result.put("Bikes", "Este usuario no tiene motos");
        else
            result.put("Bikes", bikes);
        return result;
    }
}