package application.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@Column(name = "teamname", length = 40)
	private String teamname;

	@Column(name = "director", length = 60)
	@NotNull
	private String director;

	@Column(name = "picture")
	private String picture;

	@OneToMany(mappedBy = "id", cascade = CascadeType.MERGE)
	private List<Cyclist> cyclistList;

	public Team() {
		super();
	}

	public Team(String teamname, String director, String picture, List<Cyclist> cyclistList) {
		super();
		this.teamname = teamname;
		this.director = director;
		this.picture = picture;
		this.cyclistList = cyclistList;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<Cyclist> getCyclistList() {
		return cyclistList;
	}

	public void setCyclistList(List<Cyclist> cyclistList) {
		this.cyclistList = cyclistList;
	}

}
