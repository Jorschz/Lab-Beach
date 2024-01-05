package br.com.labparadise.labbeach.repositories;

import br.com.labparadise.labbeach.model.Neighborhood;
import br.com.labparadise.labbeach.model.Beach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeachRepository extends JpaRepository<Beach, Long> {

    //Listing of beaches according to their condition.
    public List<Beach> findByCondition(String condition);

    //List of beaches with inclusiveness
    public List<Beach> findByInclusiveness(Boolean inclusiveness);

    //Beach Listing by Neighborhood
    public List<Beach> findByNeighborhood(Neighborhood neighborhood);

    //Beach listing by visitors
    @Query("SELECT p FROM Beach p " +
            "LEFT JOIN Neighborhood b on ( p.neighborhood = b ) " +
            "WHERE b.visitors <= :num")
    public List<Beach> findByVisitorsQuery(@Param("num") Integer visitors);

}
