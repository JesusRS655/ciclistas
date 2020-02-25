package application.service;

import java.util.List;

import application.entity.Stage;
import application.model.StageModel;

public interface StageService {
	
	public abstract List<StageModel> listStages();

	public abstract StageModel addStage(StageModel stageModel);

	public abstract int removeStage(int stagenumber);

	public StageModel updateStage(StageModel stageModel);

	public abstract Stage transform(StageModel stageModel);

	public abstract StageModel transform(Stage stage);

}
