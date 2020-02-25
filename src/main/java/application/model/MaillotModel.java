package application.model;

import java.util.List;

public class MaillotModel {

	private String code;
	private String type;
	private String color;
	private float prize;
	private List<CarryModel> carryList;

	public MaillotModel() {
		super();
	}

	public MaillotModel(String code, String type, String color, float prize, List<CarryModel> carryList) {
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

	public List<CarryModel> getCarryList() {
		return carryList;
	}

	public void setCarryList(List<CarryModel> carryList) {
		this.carryList = carryList;
	}

}
