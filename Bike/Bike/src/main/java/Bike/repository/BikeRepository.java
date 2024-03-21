package Bike.repository;

import Bike.entity.BikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<BikeEntity, Integer> {

    List<BikeEntity> findByIdUser(Integer idUser);
}