package application.model;

import java.util.List;

public class StageModel {

	private int stagenumber;
	private float length;
	private String start;
	private String end;
	private CyclistModel cyclist;
	private List<PortModel> portList;
	private List<CarryModel> carryList;

	public StageModel() {
		super();
	}

	public StageModel(int stagenumber, float length, String start, String end, CyclistModel cyclist,
			List<PortModel> portList, List<CarryModel> carryList) {
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

	public CyclistModel getCyclist() {
		return cyclist;
	}

	public void setCyclist(CyclistModel cyclist) {
		this.cyclist = cyclist;
	}

	public List<PortModel> getPortList() {
		return portList;
	}

	public void setPortList(List<PortModel> portList) {
		this.portList = portList;
	}

	public List<CarryModel> getCarryList() {
		return carryList;
	}

	public void setCarryList(List<CarryModel> carryList) {
		this.carryList = carryList;
	}

}
