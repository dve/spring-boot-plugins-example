package net.vergien.boot.plugin.team.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import net.vergien.boot.plugin.people.entity.Person;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	@ManyToOne
	private Person teamLead;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(Person teamLead) {
		this.teamLead = teamLead;
	}

}
