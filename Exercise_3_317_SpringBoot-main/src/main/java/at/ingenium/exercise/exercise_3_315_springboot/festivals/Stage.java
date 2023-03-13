package at.ingenium.exercise.exercise_3_315_springboot.festivals;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="stage")
public class Stage {
    @Id
    private String stage_name;
    private int max_visitors;

    public Stage(String stage_name, int max_visitors) {
        this.stage_name = stage_name;
        this.max_visitors = max_visitors;
    }
}
