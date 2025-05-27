package com.example.camp.model;

import jakarta.persistence.*;


@Entity
@Table(name = "team_scores")
public class TeamScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    // FETCH TYPE MUST BE EAGER  FOR EVERYONE ! Changing to EAGER worked because it fetched the actual data, not a proxy,
    // and Jackson only knows how to serialize real objects — not lazy Hibernate proxies.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column
    private int points;

    public TeamScore(Long id, Game game, Team team, int points) {
        this.id = id;
        this.game = game;
        this.team = team;
        this.points = points;
    }

    public TeamScore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}