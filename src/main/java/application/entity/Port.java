package application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "port")
public class Port {

	@Id
	@Column(name = "portname", length = 40)
	private String portname;

	@Column(name = "height")
	private float height;

	@Column(name = "category", length = 1)
	private String category;

	@Column(name = "slope")
	private float slope;

	@ManyToOne
	@JoinColumn(name = "stagenumber")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Stage stage;

	@ManyToOne
	@JoinColumn(name = "dorsal")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cyclist cyclist;

	public Port() {
		super();
	}

	public Port(String portname, float height, String category, float slope, Stage stage, Cyclist cyclist) {
		super();
		this.portname = portname;
		this.height = height;
		this.category = category;
		this.slope = slope;
		this.stage = stage;
		this.cyclist = cyclist;
	}

	public String getPortname() {
		return portname;
	}

	public void setPortname(String portname) {
		this.portname = portname;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getSlope() {
		return slope;
	}

	public void setSlope(float slope) {
		this.slope = slope;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Cyclist getCyclist() {
		return cyclist;
	}

	public void setCyclist(Cyclist cyclist) {
		this.cyclist = cyclist;
	}

}
