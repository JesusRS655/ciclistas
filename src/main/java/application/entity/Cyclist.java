package application.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cyclist")
public class Cyclist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name", length = 60, unique = true)
	private String name;

	@Column(name = "dorsal")
	private int dorsal;

	@Column(name = "age")
	private int age;

	@Column(name = "picture")
	private String picture;

	@OneToMany(mappedBy = "portname", cascade = CascadeType.MERGE)
	private List<Port> portList;

	@OneToMany(mappedBy = "stagenumber", cascade = CascadeType.MERGE)
	private List<Stage> stageList;

	@OneToMany(mappedBy = "id", cascade = CascadeType.MERGE)
	private List<Carry> carryList;

	@ManyToOne
	@JoinColumn(name = "teamname")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team team;

	public Cyclist() {
		super();
	}

	public Cyclist(int id, String name, int dorsal, int age, String picture, List<Stage> stageList, List<Port> portList,
			List<Carry> carryList, Team team) {
		super();
		this.id = id;
		this.name = name;
		this.dorsal = dorsal;
		this.age = age;
		this.picture = picture;
		this.stageList = stageList;
		this.portList = portList;
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

	public List<Stage> getStageList() {
		return stageList;
	}

	public void setStageList(List<Stage> stageList) {
		this.stageList = stageList;
	}

	public List<Port> getPortList() {
		return portList;
	}

	public void setPortList(List<Port> portList) {
		this.portList = portList;
	}

	public List<Carry> getCarryList() {
		return carryList;
	}

	public void setCarryList(List<Carry> carryList) {
		this.carryList = carryList;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
