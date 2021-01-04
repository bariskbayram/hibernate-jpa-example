package org.bkb.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "alien",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique", columnNames = "email")
        },
        indexes = @Index(name = "index_alien_id", columnList = "alien_id")
)
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Alien {

    @Id
    @Column(
            name = "alien_id",
            updatable = false
    )
    @SequenceGenerator(
            name = "alien_sequence",
            sequenceName = "alien_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "alien_sequence"
    )
    private Long alienId;

    @Column(
            name = "first_name",
            nullable = false,
            length = 20
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            length = 20
    )
    private String lastName;

    @Column(
            name = "color",
            nullable = false,
            length = 15
    )
    private String color;

    @Column(
            name = "email",
            nullable = false,
            length = 30
    )
    private String email;

    @Transient()
    private String temp;

    @OneToOne(optional = false)
    @JoinColumn(
            name = "ufo_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_alien_ufo")
    )
    private UFO ufo;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "aliens"
    )
    private List<Hometown> hometowns;

    public Alien(){}

    public Alien(
            String firstName,
            String lastName,
            String color,
            String email,
            String temp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.color = color;
        this.email = email;
        this.temp = temp;
    }

    public Long getAlienId() {
        return alienId;
    }

    public void setAlienId(Long alienId) {
        this.alienId = alienId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public UFO getUfo() {
        return ufo;
    }

    public void setUfo(UFO ufo) {
        this.ufo = ufo;
    }

    public List<Hometown> getHometowns() {
        return hometowns;
    }

    public void setHometowns(List<Hometown> hometowns) {
        this.hometowns = hometowns;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "alienId=" + alienId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", color='" + color + '\'' +
                ", email='" + email + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}
