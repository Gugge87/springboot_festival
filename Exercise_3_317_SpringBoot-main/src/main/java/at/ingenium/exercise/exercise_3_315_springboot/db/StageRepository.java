package at.ingenium.exercise.exercise_3_315_springboot.db;

import at.ingenium.exercise.exercise_3_315_springboot.festivals.Stage;
import org.springframework.data.repository.CrudRepository;

public interface StageRepository extends CrudRepository<Stage, String> {

}
