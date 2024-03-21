package Cars.repository;

import Cars.entity.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<CarsEntity, Integer> {

    List<CarsEntity> findByIdUser(Integer idUser);
}