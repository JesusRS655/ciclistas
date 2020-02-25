package application.model;

public class PortModel {

	private String portname;
	private float height;
	private String category;
	private float slope;
	private StageModel stageModel;
	private CyclistModel cyclistModel;

	public PortModel() {
		super();
	}

	public PortModel(String portname, float height, String category, float slope, StageModel stageModel,
			CyclistModel cyclistModel) {
		super();
		this.portname = portname;
		this.height = height;
		this.category = category;
		this.slope = slope;
		this.stageModel = stageModel;
		this.cyclistModel = cyclistModel;
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

	public StageModel getStageModel() {
		return stageModel;
	}

	public void setStageModel(StageModel stageModel) {
		this.stageModel = stageModel;
	}

	public CyclistModel getCyclistModel() {
		return cyclistModel;
	}

	public void setCyclistModel(CyclistModel cyclistModel) {
		this.cyclistModel = cyclistModel;
	}

}
