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
@Table(name = "stage")
public class Stage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stagenumber")
	private int stagenumber;

	@Column(name = "length")
	private float length;

	@Column(name = "start", length = 40)
	private String start;

	@Column(name = "end")
	private String end;

	@ManyToOne
	@JoinColumn(name = "dorsal")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cyclist cyclist;

	@OneToMany(mappedBy = "portname", cascade = CascadeType.MERGE)
	private List<Port> portList;

	@OneToMany(mappedBy = "id", cascade = CascadeType.MERGE)
	private List<Carry> carryList;

	public Stage() {
		super();
	}

	public Stage(int stagenumber, float length, String start, String end, Cyclist cyclist, List<Port> portList,
			List<Carry> carryList) {
		super();
		this.stagenumber = stagenumber;
		this.length = length;
		this.start = start;
		this.end = end;
		this.cyclist = cyclist;
		this.portList = portList;
		this.carryList = carryList;
	}

	public int getStagenumber() {
		return stagenumber;
	}

	public void setStagenumber(int stagenumber) {
		this.stagenumber = stagenumber;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Cyclist getCyclist() {
		return cyclist;
	}

	public void setCyclist(Cyclist cyclist) {
		this.cyclist = cyclist;
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

}
