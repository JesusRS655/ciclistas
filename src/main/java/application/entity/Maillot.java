package application.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "maillot")
public class Maillot {

	@Id
	@Column(name = "code", length = 2)
	private String code;

	@Column(name = "type", length = 10)
	private String type;

	@Column(name = "color", length = 10)
	private String color;

	@Column(name = "prize")
	private float prize;

	@OneToMany(mappedBy = "id", cascade = CascadeType.MERGE)
	private List<Carry> carryList;

	public Maillot() {
		super();
	}

	public Maillot(String code, String type, String color, float prize, List<Carry> carryList) {
		super();
		this.code = code;
		this.type = type;
		this.color = color;
		this.prize = prize;
		this.carryList = carryList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrize() {
		return prize;
	}

	public void setPrize(float prize) {
		this.prize = prize;
	}

	public List<Carry> getCarryList() {
		return carryList;
	}

	public void setCarryList(List<Carry> carryList) {
		this.carryList = carryList;
	}

}
