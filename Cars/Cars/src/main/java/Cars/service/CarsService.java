package Cars.service;

import Cars.entity.CarsEntity;
import Cars.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    @Autowired
    CarsRepository carsRepository;

    public List<CarsEntity> getAll(){
        return carsRepository.findAll();
    }

    public CarsEntity getCarrById(Integer idCars){
        return carsRepository.findById(idCars).orElse(null);
    }

    public CarsEntity save(CarsEntity userEntity){
        CarsEntity carsNew = carsRepository.save(userEntity);
        return  carsNew;
    }

    public List<CarsEntity> byUserId(Integer idUser){
        return carsRepository.findByIdUser(idUser);
    }
}