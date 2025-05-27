package com.example.camp.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table(name = "campers")
public class Camper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    // FETCH TYPE MUST BE EAGER  FOR EVERYONE ! Changing to EAGER worked because it fetched the actual data, not a proxy,
    // and Jackson only knows how to serialize real objects — not lazy Hibernate proxies.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column
    private LocalDate birthDate;

    @Column
    private Boolean isMale;

    @Column
    private String role;

    public Camper(Long id, String firstName, String lastName, Team team, LocalDate birthDate, Boolean isMale, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.role = role;
    }

    public Camper() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Transient
    public int getAge() {
        if (birthDate == null) return 0;
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

}
