package com.example.camp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "teams")
@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String teamColour;

    @Column
    private int teamPoints;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamScore> teamScores = new ArrayList<>();

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Camper> campers = new ArrayList<>();

    public Team(Long id, String name, String teamColour, int teamPoints, List<TeamScore> teamScores, List<Camper> campers) {
        this.id = id;
        this.name = name;
        this.teamColour = teamColour;
        this.teamPoints = teamPoints;
        this.teamScores = teamScores;
        this.campers = campers;
    }

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamColour() {
        return teamColour;
    }

    public void setTeamColour(String teamColour) {
        this.teamColour = teamColour;
    }

    public int getTeamPoints() {
        return teamPoints;
    }

    public void setTeamPoints(int teamPoints) {
        this.teamPoints = teamPoints;
    }

    public List<TeamScore> getTeamScores() {
        return teamScores;
    }

    public void setTeamScores(List<TeamScore> teamScores) {
        this.teamScores = teamScores;
    }

    public List<Camper> getCampers() {
        return campers;
    }

    public void setCampers(List<Camper> campers) {
        this.campers = campers;
    }
}
