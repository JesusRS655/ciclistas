package application.model;

public class CarryModel {

	private int id;
	private CyclistModel cyclistModel;
	private MaillotModel maillotModel;
	private StageModel stageModel;

	public CarryModel() {
		super();
	}

	public CarryModel(int id, CyclistModel cyclistModel, MaillotModel maillotModel, StageModel stageModel) {
		super();
		this.id = id;
		this.cyclistModel = cyclistModel;
		this.maillotModel = maillotModel;
		this.stageModel = stageModel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CyclistModel getCyclistModel() {
		return cyclistModel;
	}

	public void setCyclistModel(CyclistModel cyclistModel) {
		this.cyclistModel = cyclistModel;
	}

	public MaillotModel getMaillotModel() {
		return maillotModel;
	}

	public void setMaillotModel(MaillotModel maillotModel) {
		this.maillotModel = maillotModel;
	}

	public StageModel getStageModel() {
		return stageModel;
	}

	public void setStageModel(StageModel stageModel) {
		this.stageModel = stageModel;
	}

}
