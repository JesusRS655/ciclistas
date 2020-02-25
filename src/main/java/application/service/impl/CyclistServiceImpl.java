package application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import application.configuration.ConfigClass;
import application.entity.Cyclist;
import application.model.CyclistModel;
import application.repository.CyclistRepository;
import application.service.CyclistService;

@Service("cyclistServiceImpl")
public class CyclistServiceImpl implements CyclistService {

	@Autowired
	@Qualifier("cyclistRepository")
	private CyclistRepository cyclistRepository;

	@Autowired
	@Qualifier("configClass")
	private ConfigClass config;

	@Override
	public List<CyclistModel> listCyclists() {
		List<Cyclist> cList = cyclistRepository.findAll();
		List<CyclistModel> cModelList = new ArrayList<>();
		for (Cyclist c : cList) {
			CyclistModel cModel = transform(c);
			cModelList.add(cModel);
		}
		return cModelList;
	}

	@Override
	public CyclistModel addCyclist(CyclistModel cyclistModel) {
		Cyclist cyclist = transform(cyclistModel);
		return transform(cyclistRepository.save(cyclist));
	}

	@Override
	public int removeCyclist(int id) {
		cyclistRepository.deleteById(id);
		return 0;
	}

	@Override
	public CyclistModel updateCyclist(CyclistModel cyclistModel) {
		Cyclist cyclist = transform(cyclistModel);
		return transform(cyclistRepository.save(cyclist));
	}

	@Override
	public Cyclist transform(CyclistModel cyclistModel) {
		return config.mapper().map(cyclistModel, Cyclist.class);
	}

	@Override
	public CyclistModel transform(Cyclist cyclist) {
		return config.mapper().map(cyclist, CyclistModel.class);
	}

}
