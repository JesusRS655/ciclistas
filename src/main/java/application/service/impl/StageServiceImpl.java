package application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import application.configuration.ConfigClass;
import application.entity.Stage;
import application.model.StageModel;
import application.repository.StageRepository;
import application.service.StageService;

@Service("stageServiceImpl")
public class StageServiceImpl implements StageService {

	@Autowired
	@Qualifier("stageRepository")
	private StageRepository stageRepository;

	@Autowired
	@Qualifier("configClass")
	private ConfigClass config;

	@Override
	public List<StageModel> listStages() {
		List<Stage> sList = stageRepository.findAll();
		List<StageModel> sModelList = new ArrayList<>();
		for (Stage s : sList) {
			StageModel sModel = transform(s);
			sModelList.add(sModel);
		}
		return sModelList;
	}

	@Override
	public StageModel addStage(StageModel stageModel) {
		Stage stage = transform(stageModel);
		return transform(stageRepository.save(stage));
	}

	@Override
	public int removeStage(int stagenumber) {
		stageRepository.deleteById(stagenumber);
		return 0;
	}

	@Override
	public StageModel updateStage(StageModel stageModel) {
		Stage stage = transform(stageModel);
		return transform(stageRepository.save(stage));
	}

	@Override
	public Stage transform(StageModel stageModel) {
		return config.mapper().map(stageModel, Stage.class);
	}

	@Override
	public StageModel transform(Stage stage) {
		return config.mapper().map(stage, StageModel.class);
	}

}
