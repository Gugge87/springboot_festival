package at.ingenium.exercise.exercise_3_315_springboot.festivals;

import at.ingenium.exercise.exercise_3_315_springboot.db.BandRepository;
import jakarta.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BandService {

    @Autowired
    private BandRepository bandRepository;

    ArrayList<Band> bands = new ArrayList<Band>() {{
        add(new Band(1, "The Offspring", "Rock", 4, 10000));
        add(new Band(2, "Greenday", "Rock", 3, 20000));
    }};

    ArrayList<Stage> stages = new ArrayList<Stage>() {{
        add(new Stage("MainStage", 1000));
        add(new Stage("SecondStage", 500));
    }};

    @PostConstruct
    public void initDB(){

        ArrayList<Song> offspringSetList = new ArrayList<>();
        offspringSetList.add(new Song(1L, "Pretty Fly", Duration.ofSeconds(210)));
        offspringSetList.add(new Song(2L, "Why don't you get a job?", Duration.ofSeconds(192)));

        bands.get(0).setSetList(offspringSetList);
        bands.get(0).setStage(stages.get(1));
        bands.get(1).setStage(stages.get(0));

        bandRepository.saveAll(bands);
    }

    private AtomicLong sequence = new AtomicLong(2);

    public ArrayList<Band> listBands() {
        //return bands;
        ArrayList<Band> allBandsFromDB = new ArrayList<>();

        // same as: bandRepository.findAll().forEach(b -> allBandsFromDB.add(b));
        bandRepository.findAll().forEach(allBandsFromDB::add);

        return allBandsFromDB;
    }

    public Band findById(long id) {
        //return bands.stream().filter(b -> b.getId() == id).findFirst().get();
        return bandRepository.findById(id).get();
    }

    public Band createBand(Band band) {
//        band.setId(sequence.incrementAndGet());
//        bands.add(band);

        band.setId(null);
        band = bandRepository.save(band);

        return band;
    }

    public void updateBand(long id, Band newBand) {
//        Band oldBand = findById(id);
//
//        bands.remove(oldBand);
//
//        newBand.setId(id);
//        bands.add(newBand);
//
//        bands.sort(
//            (a,b) -> Long.compare(a.getId(),b.getId())
//        );

        if( !bandRepository.existsById(id))
            throw new IllegalArgumentException(String.format("Band with ID %d does not exist", id));

        newBand.setId(id);
        bandRepository.save(newBand);

    }

    public boolean deleteBand(long id) {
        //return bands.remove(findById(id));

        if(!bandRepository.existsById(id))
            return false;

        bandRepository.deleteById(id);
        return true;
    }

    public List<Band> getWithSalaryBetween(double low, double high){
        return bandRepository.findBandsBySalaryBetween(low, high);
    }
}
