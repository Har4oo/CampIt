package com.example.camp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column
    private String team;

    @Column
    private LocalDate birthDate;

    @Column
    private boolean isMale;

    private String role;

    public Camper(Long id, String firstName, String lastName, String team, LocalDate birthDate, boolean isMale, String role) {
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Transient
    public int getAge() {
        if (birthDate == null) return 0;
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

}
