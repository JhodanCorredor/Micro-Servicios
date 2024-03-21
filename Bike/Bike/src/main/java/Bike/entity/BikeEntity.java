package Bike.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idBike;
    private String brandBike;
    private String modelBike;
    private Integer idUser;
}
