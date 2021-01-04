package org.bkb.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "wheel")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Wheel {

    @Id
    @Column(name = "wheel_id", updatable = false)
    @SequenceGenerator(
            name = "wheel_sequence",
            sequenceName = "wheel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wheel_sequence"
    )
    private Long wheelId;

    @Column(
            name = "wheel_def",
            nullable = false,
            length = 30)
    private String wheelDefinition;

    @ManyToOne
    private UFO ufo;

    public Wheel() {}

    public Wheel(String wheelDefinition, UFO ufo) {
        this.wheelDefinition = wheelDefinition;
        this.ufo = ufo;
    }

    public Long getWheelId() {
        return wheelId;
    }

    public void setWheelId(Long wheelId) {
        this.wheelId = wheelId;
    }

    public String getWheelDefinition() {
        return wheelDefinition;
    }

    public void setWheelDefinition(String wheelDefinition) {
        this.wheelDefinition = wheelDefinition;
    }

    public UFO getUfo() {
        return ufo;
    }

    public void setUfo(UFO ufo) {
        this.ufo = ufo;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "wheelId=" + wheelId +
                ", wheelDefinition='" + wheelDefinition + '\'' +
                ", ufo=" + ufo +
                '}';
    }
}
