package com.example.AdminDataLab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="find_all_players", query = "select a from Admin a")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String n;
	
	private String pos;
	private String team;
	private String bench;
	private double points;


	public Admin() {
	
	}
	
	public Admin(String n, String pos, String team, String bench, double points) {
		this.n = n;
		this.pos = pos;
		this.team = team;
		this.bench = bench;
		this.points = points;
	}
	
	public Admin(String n, String pos) {
		this.n = n;
		this.pos = pos;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getBench() {
		return bench;
	}

	public void setBench(String bench) {
		this.bench = bench;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "n=" + n + ", pos=" + pos + ", team=" + team + ", bench=" + bench + ", points=" + points;
	}

	
}