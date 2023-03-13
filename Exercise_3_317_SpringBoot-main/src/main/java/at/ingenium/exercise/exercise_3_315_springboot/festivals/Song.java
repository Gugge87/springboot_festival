package at.ingenium.exercise.exercise_3_315_springboot.festivals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter  // adds at compile time getters for all attributes
@Setter  // adds at compile time setters for all attributes
@AllArgsConstructor  // add a constructor with all attributes
@NoArgsConstructor   // add a constructor with no attributes (default constructor)
public class Song {

  @Id
  @GeneratedValue
  private Long id;
  private String songTitle;
  private Duration songDuration;

}
