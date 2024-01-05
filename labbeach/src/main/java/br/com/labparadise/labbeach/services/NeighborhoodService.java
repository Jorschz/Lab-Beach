package br.com.labparadise.labbeach.services;

import br.com.labparadise.labbeach.model.Neighborhood;
import br.com.labparadise.labbeach.repositories.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NeighborhoodService {

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    //Neighborhood registration
    public Long save(String name,
                     String description,
                     Integer visitors){
        Neighborhood neighborhood = new Neighborhood();
        neighborhood.setName(name);
        neighborhood.setDescription(description);
        neighborhood.setVisitors(visitors);
        return neighborhoodRepository.save(neighborhood).getId();
    }

    //Neighborhood Listing
    public List<Neighborhood> findAll(){
        return neighborhoodRepository.findAll();
    }

    //Neighborhood Delete
    public void deleteById(Long id){
        neighborhoodRepository.deleteById(id);
    }

    //Neighborhood listing by ID
    public Neighborhood findById(Long id){
        Optional<Neighborhood> neighborhood =  neighborhoodRepository.findById(id);
        return (neighborhood.isPresent() ? neighborhood.get() : null);
    }
}
