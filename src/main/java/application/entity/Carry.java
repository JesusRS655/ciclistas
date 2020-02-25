package application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "carry")
public class Carry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "cyclist")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cyclist cyclist;

	@ManyToOne
	@JoinColumn(name = "code")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Maillot code;

	@ManyToOne
	@JoinColumn(name = "stagenumber")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Stage stagenumber;

	public Carry() {
		super();
	}

	public Carry(int id, Cyclist cyclist, Maillot code, Stage stagenumber) {
		super();
		this.id = id;
		this.cyclist = cyclist;
		this.code = code;
		this.stagenumber = stagenumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cyclist getCyclist() {
		return cyclist;
	}

	public void setCyclist(Cyclist cyclist) {
		this.cyclist = cyclist;
	}

	public Maillot getCode() {
		return code;
	}

	public void setCode(Maillot code) {
		this.code = code;
	}

	public Stage getStagenumber() {
		return stagenumber;
	}

	public void setStagenumber(Stage stagenumber) {
		this.stagenumber = stagenumber;
	}

}
