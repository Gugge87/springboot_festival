package at.ingenium.exercise.exercise_3_315_springboot.db;

import at.ingenium.exercise.exercise_3_315_springboot.festivals.Band;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BandRepository extends CrudRepository<Band, Long> {

  public List<Band> findBandsBySalaryBetween(double low, double high);

}
