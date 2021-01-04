package org.bkb.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hometown")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Hometown {

    @Id
    @Column(name = "ht_id", updatable = false)
    @SequenceGenerator(
            name = "ht_sequence",
            sequenceName = "ht_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ht_sequence"
    )
    private Long hometownId;

    @Column(
            name = "name",
            nullable = false,
            length = 30
    )
    private String name;

    @Column(
            name = "distance",
            nullable = false
    )
    private Long distanceFromEarth;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "alien_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_ht_alien")
    )
    private List<Alien> aliens;

    public Hometown() {}

    public Hometown(String name, Long distanceFromEarth) {
        this.name = name;
        this.distanceFromEarth = distanceFromEarth;
    }

    public Long getHometownId() {
        return hometownId;
    }

    public void setHometownId(Long hometownId) {
        this.hometownId = hometownId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public void setDistanceFromEarth(Long distanceFromEarth) {
        this.distanceFromEarth = distanceFromEarth;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    @Override
    public String toString() {
        return "Hometown{" +
                "hometownId=" + hometownId +
                ", name='" + name + '\'' +
                ", distanceFromEarth=" + distanceFromEarth +
                ", aliens=" + aliens +
                '}';
    }
}
