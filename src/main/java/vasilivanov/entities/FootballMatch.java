package vasilivanov.entities;

import vasilivanov.enums.EventType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "fb_matches")
@NamedQuery(name = "getMatchesWonAtHome", query = "SELECT m FROM FootballMatch m WHERE m.winniingTeam = m.homeTeam")
@NamedQuery(name = "getMatchesWonAway", query = "SELECT m FROM FootballMatch m WHERE m.winniingTeam = m.winniingTeam")
public class FootballMatch extends Event {
  @Column(name = "home_team")
  private String homeTeam;
  @Column(name = "visiting_team")
  private String visitingTeam;
  @Column(name = "winniing_Team")
  private String winniingTeam;
  @Column(name = "home_team_toals")
  private int homeTeamGoals;
  @Column(name = "visiting_team_toals")
  private int visitingTeamGoals;

  public FootballMatch() {
  }

  public FootballMatch(String homeTeam, String visitingTeam, String winniingTeam, int homeTeamGoals, int visitingTeamGoals) {
    this.homeTeam = homeTeam;
    this.visitingTeam = visitingTeam;
    this.winniingTeam = winniingTeam;
    this.homeTeamGoals = homeTeamGoals;
    this.visitingTeamGoals = visitingTeamGoals;
  }

  public FootballMatch(String title, String eventDate, EventType eventType, int maxPartecipants, Location location_id, String homeTeam, String visitingTeam, String winniingTeam, int homeTeamGoals, int visitingTeamGoals) {
    super(title, eventDate, eventType, maxPartecipants, location_id);
    this.homeTeam = homeTeam;
    this.visitingTeam = visitingTeam;
    this.winniingTeam = winniingTeam;
    this.homeTeamGoals = homeTeamGoals;
    this.visitingTeamGoals = visitingTeamGoals;
  }

  public String getHomeTeam() {
    return homeTeam;
  }

  public void setHomeTeam(String homeTeam) {
    this.homeTeam = homeTeam;
  }

  public String getVisitingTeam() {
    return visitingTeam;
  }

  public void setVisitingTeam(String visitingTeam) {
    this.visitingTeam = visitingTeam;
  }

  public String getWinniingTeam() {
    return winniingTeam;
  }

  public void setWinniingTeam(String winniingTeam) {
    this.winniingTeam = winniingTeam;
  }

  public int getHomeTeamGoals() {
    return homeTeamGoals;
  }

  public void setHomeTeamGoals(int homeTeamGoals) {
    this.homeTeamGoals = homeTeamGoals;
  }

  public int getVisitingTeamGoals() {
    return visitingTeamGoals;
  }

  public void setVisitingTeamGoals(int visitingTeamGoals) {
    this.visitingTeamGoals = visitingTeamGoals;
  }

  @Override
  public String toString() {
    return "FootballMatch{" +
            "homeTeam='" + homeTeam + '\'' +
            ", visitingTeam='" + visitingTeam + '\'' +
            ", winniingTeam='" + winniingTeam + '\'' +
            ", homeTeamGoals='" + homeTeamGoals + '\'' +
            ", visitingTeamGoals='" + visitingTeamGoals + '\'' +
            '}';
  }
}
