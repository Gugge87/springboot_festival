package at.ingenium.exercise.exercise_3_315_springboot;

import at.ingenium.exercise.exercise_3_315_springboot.festivals.Band;
import at.ingenium.exercise.exercise_3_315_springboot.festivals.BandService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Exercise3315SpringBootApplicationTests {

    @Autowired
    BandService bandService;

    @Test
    void testFilterBySalary() {

        List<Band> bandList = bandService.getWithSalaryBetween(8000.0, 12000.0);

        assertEquals("The Offspring", bandList.get(0).getName());
    }

}
