package Bike.service;

import Bike.entity.BikeEntity;
import Bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    BikeRepository bikeRepository;

    public List<BikeEntity> getAll(){
        return bikeRepository.findAll();
    }

    public BikeEntity getMotoById(Integer idBike){
        return bikeRepository.findById(idBike).orElse(null);
    }

    public BikeEntity save(BikeEntity motoEntity){
        BikeEntity BikeNew = bikeRepository.save(motoEntity);
        return  BikeNew;
    }

    public List<BikeEntity> byUserId(Integer idUser){
        return bikeRepository.findByIdUser(idUser);
    }
}