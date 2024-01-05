package br.com.labparadise.labbeach.services;

import br.com.labparadise.labbeach.model.Neighborhood;
import br.com.labparadise.labbeach.model.Beach;
import br.com.labparadise.labbeach.repositories.BeachRepository;
import org.springframework.beans. factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeachService {

    @Autowired
    private BeachRepository beachRepository;
    @Autowired
    private NeighborhoodService neighborhoodService;

    //Beach registration
    public Long save(String name,
                     Boolean inclusiveness,
                     String condition,
                     Long neighborhoodId) {
        Beach beach = new Beach();
        Neighborhood neighborhood = neighborhoodService.findById(neighborhoodId);

        beach.setName(name);
        beach.setInclusiveness(inclusiveness);
        beach.setCondition(condition);
        beach.setNeighborhood(neighborhood);
        return beachRepository.save(beach).getId();
    }

    //Beach Listing
    public List<Beach> findAll() {
        return beachRepository.findAll();
    }

    //Update beach by ID
    public Beach update(Beach beach) {
        return beachRepository.save(beach);
    }

    //Delete beach by ID
    public void deleteById(Long id) {
        beachRepository.deleteById(id);
    }

    //Listing beaches by Condition
    public List<Beach> findByCondition(String condition) {
        return beachRepository.findByCondition(condition);
    }

    //Listing beaches by Inclusiveness
    public List<Beach> findByInclusiveness(Boolean inclusiveness) {
        return beachRepository.findByInclusiveness(inclusiveness);
    }

    //Listing beaches by Neighborhood
    public List<Beach> findByNeighborhood(Long neighborhoodId) {
        Neighborhood neighborhood = neighborhoodService.findById(neighborhoodId);
        return beachRepository.findByNeighborhood(neighborhood);
    }

    //Listing of beaches by visitors in the neighborhood
    public List<Beach> findByVisitorsQuery(Integer visitors){
        return beachRepository.findByVisitorsQuery(visitors);
    }
}
