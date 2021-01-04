package org.bkb.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ufo")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class UFO {

    @Id
    @Column(
            name = "ufo_id",
            updatable = false
    )
    @SequenceGenerator(
            name = "ufo_sequence",
            sequenceName = "ufo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ufo_sequence"
    )
    private Long ufoId;

    @Column(
            name = "name",
            nullable = false,
            length = 20
    )
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(
            name = "produced_date",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Date producedDate;

    @OneToMany(
            mappedBy = "ufo",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Wheel> wheels;

    public UFO() {}

    public UFO(String name) {
        this.name = name;
    }

    public Long getUfoId() {
        return ufoId;
    }

    public void setUfoId(Long ufoId) {
        this.ufoId = ufoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(Date producedDate) {
        this.producedDate = producedDate;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "UFO{" +
                "ufoId=" + ufoId +
                ", name='" + name + '\'' +
                ", wheels=" + wheels +
                '}';
    }
}
