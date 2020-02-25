package application.model;

import java.util.List;

public class TeamModel {

	private String teamname;
	private String director;
	private String picture;
	private List<CyclistModel> cyclistList;

	public TeamModel() {
		super();
	}

	public TeamModel(String teamname, String director, String picture, List<CyclistModel> cyclistList) {
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

	public List<CyclistModel> getCyclistList() {
		return cyclistList;
	}

	public void setCyclistList(List<CyclistModel> cyclistList) {
		this.cyclistList = cyclistList;
	}

}
