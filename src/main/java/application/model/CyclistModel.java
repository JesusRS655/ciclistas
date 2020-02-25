package application.model;

import java.util.List;

public class CyclistModel {

	private int id;
	private String name;
	private int dorsal;
	private int age;
	private String picture;
	private List<PortModel> portList;
	private List<StageModel> stageList;
	private List<CarryModel> carryList;
	private TeamModel team;

	public CyclistModel() {
		super();
	}

	public CyclistModel(int id, String name, int dorsal, int age, String picture, List<PortModel> portList,
			List<StageModel> stageList, List<CarryModel> carryList, TeamModel team) {
		super();
		this.id = id;
		this.name = name;
		this.dorsal = dorsal;
		this.age = age;
		this.picture = picture;
		this.portList = portList;
		this.stageList = stageList;
		this.carryList = carryList;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<PortModel> getPortList() {
		return portList;
	}

	public void setPortList(List<PortModel> portList) {
		this.portList = portList;
	}

	public List<StageModel> getStageList() {
		return stageList;
	}

	public void setStageList(List<StageModel> stageList) {
		this.stageList = stageList;
	}

	public List<CarryModel> getCarryList() {
		return carryList;
	}

	public void setCarryList(List<CarryModel> carryList) {
		this.carryList = carryList;
	}

	public TeamModel getTeam() {
		return team;
	}

	public void setTeam(TeamModel team) {
		this.team = team;
	}

}
