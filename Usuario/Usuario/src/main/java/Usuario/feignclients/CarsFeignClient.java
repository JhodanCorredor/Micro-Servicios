package Usuario.feignclients;

import Usuario.model.Cars;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "Cars-Service", url = "http://localhost:8002")
public interface CarsFeignClient {

    @PostMapping()
    Cars save(@RequestBody Cars cars);

    @GetMapping("/{idUser}")
    List<Cars> getCars(@PathVariable("idUser") Integer idUser);

}