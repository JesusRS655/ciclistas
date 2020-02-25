package application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import application.configuration.ConfigClass;
import application.entity.Maillot;
import application.model.MaillotModel;
import application.repository.MaillotRepository;
import application.service.MaillotService;

@Service("maillotServiceImpl")
public class MaillotServiceImpl implements MaillotService {

	@Autowired
	@Qualifier("maillotRepository")
	private MaillotRepository maillotRepository;

	@Autowired
	@Qualifier("configClass")
	private ConfigClass config;

	@Override
	public List<MaillotModel> listMaillots() {
		List<Maillot> mList = maillotRepository.findAll();
		List<MaillotModel> mModelList = new ArrayList<>();
		for (Maillot m : mList) {
			MaillotModel mModel = transform(m);
			mModelList.add(mModel);
		}
		return mModelList;
	}

	@Override
	public MaillotModel addMaillot(MaillotModel maillotModel) {
		Maillot maillot = transform(maillotModel);
		return transform(maillotRepository.save(maillot));
	}

	@Override
	public int removeMaillot(String code) {
		maillotRepository.deleteById(code);
		return 0;
	}

	@Override
	public MaillotModel updateMaillot(MaillotModel maillotModel) {
		Maillot maillot = transform(maillotModel);
		return transform(maillotRepository.save(maillot));
	}

	@Override
	public Maillot transform(MaillotModel maillotModel) {
		return config.mapper().map(maillotModel, Maillot.class);
	}

	@Override
	public MaillotModel transform(Maillot maillot) {
		return config.mapper().map(maillot, MaillotModel.class);
	}

}
