package application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import application.configuration.ConfigClass;
import application.entity.Carry;
import application.model.CarryModel;
import application.repository.CarryRepository;
import application.service.CarryService;

@Service("carryServiceImpl")
public class CarryServiceImpl implements CarryService {

	@Autowired
	@Qualifier("carryRepository")
	private CarryRepository carryRepository;

	@Autowired
	@Qualifier("configClass")
	private ConfigClass config;

	@Override
	public List<CarryModel> listCarry() {
		List<Carry> cList = carryRepository.findAll();
		List<CarryModel> cModelList = new ArrayList<>();
		for (Carry c : cList) {
			CarryModel cModel = transform(c);
			cModelList.add(cModel);
		}
		return cModelList;
	}

	@Override
	public CarryModel addCarry(CarryModel carryModel) {
		Carry carry = transform(carryModel);
		return transform(carryRepository.save(carry));
	}

	@Override
	public Carry transform(CarryModel carryModel) {
		return config.mapper().map(carryModel, Carry.class);
	}

	@Override
	public CarryModel transform(Carry carry) {
		return config.mapper().map(carry, CarryModel.class);
	}

	@Override
	public boolean checkTable(int cyclistId, String maillotCode, int stagenumber) {
		List<CarryModel> cModelList = listCarry();
		for (CarryModel cModel : cModelList) {
			if (cModel.getStageModel().getStagenumber() == stagenumber && cModel.getCyclistModel().getId() == cyclistId
					&& cModel.getMaillotModel().getCode() == maillotCode) {
				return true;
			}
		}
		return false;
	}

}
