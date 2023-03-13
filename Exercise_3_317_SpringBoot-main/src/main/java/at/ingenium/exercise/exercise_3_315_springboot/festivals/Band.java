package at.ingenium.exercise.exercise_3_315_springboot.festivals;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="festival_band")
public class Band{
    @Id
    @GeneratedValue // primary key value is created by database
    private Long id;

    @Column(nullable = false, unique = true, length = 25)
    private String name;

    @Column(name = "band_genre")
    private String genre;
    private int members;
    private double salary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "band_id")
    private List<Song> setList; // Songs einer Band auf einem Festival heißen SetList

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stage_name")
    private Stage stage;

    public Band(){

    }

    public Band(long id, String name, String genre, int members, double salary) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.members = members;
        this.salary = salary;
    }

    public void setSetList(List<Song> setList) {
        this.setList = setList;
    }

    public List<Song> getSetList() {
        return setList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getMembers() {
        return members;
    }

    public double getSalary() {
        return salary;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
}
