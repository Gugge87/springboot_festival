package at.ingenium.exercise.exercise_3_315_springboot.festivals;

import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
@RequestMapping("/festival")
@Slf4j
public class FestivalController {

    private int counter = 0;
    @Autowired
    private BandService bandService;

    @GetMapping("/bands")
    public ArrayList<Band> bands() {
        log.info("Get /bands was called");
        log.info("Num calls = " + (++counter));

        return bandService.listBands();
    }

    @GetMapping("/bands/{id}")
    public ResponseEntity<Band> read(@PathVariable long id) {
        try {
            return ResponseEntity.ok(bandService.findById(id));
        }catch(NoSuchElementException nsee){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/bands")
    public Band createBand(@RequestBody Band band) {
       return bandService.createBand(band);
    }

    @PutMapping("/bands/{id}")
    public ResponseEntity<Band> updateBand(@RequestBody Band band, @PathVariable long id){

        try {
            bandService.updateBand(id, band);

            return ResponseEntity.ok(band);
        } catch (Exception e) {

            return ResponseEntity.notFound().build();

        }

    }

    @DeleteMapping("/bands/{id}")
    public ResponseEntity<Boolean> deleteBand(@PathVariable long id) {
        try {
            boolean result = bandService.deleteBand(id);
            if (result) {
                return ResponseEntity.ok(result);
            }
            else
                return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            log.error("Band not found with id {}.", id);
            return ResponseEntity.notFound().build();
        }
    }

}
