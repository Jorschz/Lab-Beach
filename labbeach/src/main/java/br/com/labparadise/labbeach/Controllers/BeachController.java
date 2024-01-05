package br.com.labparadise.labbeach.Controllers;

import br.com.labparadise.labbeach.model.Beach;
import br.com.labparadise.labbeach.services.BeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("beach")
public class BeachController {

    @Autowired
    private BeachService beachService;

    //Beach registration
    @PostMapping
    public Long save(
            @RequestParam("name") String name,
            @RequestParam("inclusiveness") Boolean inclusiveness,
            @RequestParam("condition") String condition,
            @RequestParam("neighborhood") Long neighborhoodId){
        return ResponseEntity.ok().body(beachService.save(name, inclusiveness, condition, neighborhoodId)).getBody();
    }

    //Beach Listing
    @GetMapping
    public List<Beach> findAll(){
        List<Beach> beaches = beachService.findAll();
        return ResponseEntity.ok().body(beaches).getBody();
    }

    //Update beach by ID
    @PutMapping
    public ResponseEntity<Beach> update (@RequestBody Beach beach){
        return ResponseEntity.status(HttpStatus.OK).body(beachService.update(beach));
    }

    //Delete beach by ID
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id){
        beachService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //Listing beaches by Condition
    @GetMapping(value = "fcondition")
    public List<Beach>findByCondition(@RequestParam("condition") String condition){
        List<Beach> beaches = beachService.findByCondition(condition);
        return ResponseEntity.ok().body(beaches).getBody();
    }

    //Listing beaches by Inclusiveness
    @GetMapping(value = "finclusiveness")
    public List<Beach>findByInclusiveness(@RequestParam("inclusiveness") Boolean inclusiveness){
        List<Beach> beaches = beachService.findByInclusiveness(inclusiveness);
        return ResponseEntity.ok().body(beaches).getBody();
    }

    //Listing beaches by Neighborhood
    @GetMapping(value = "fvisitors")
    public List<Beach> findByVisitorsQuery(@RequestParam("visitors") Integer visitors){
        List<Beach> beaches = beachService.findByVisitorsQuery(visitors);
        return ResponseEntity.ok().body(beaches).getBody();
    }


}
