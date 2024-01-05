package br.com.labparadise.labbeach.Controllers;

import br.com.labparadise.labbeach.model.Neighborhood;
import br.com.labparadise.labbeach.services.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("neighborhood")
public class NeighborhoodController {

    @Autowired
    private NeighborhoodService neighborhoodService;

    //Neighborhood registration
    @PostMapping
    public  Long save(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("visitors") Integer visitors){
        return ResponseEntity.ok().body(neighborhoodService.save(name, description, visitors)).getBody();
    }

    //Neighborhood Listing
    @GetMapping
    public List<Neighborhood> findAll(){
        List<Neighborhood> neighborhoods = neighborhoodService.findAll();
        return ResponseEntity.ok().body(neighborhoods).getBody();
    }

    //Neighborhood Delete
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id){
        neighborhoodService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
