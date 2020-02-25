package application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import application.configuration.ConfigClass;
import application.entity.Port;
import application.model.PortModel;
import application.repository.PortRepository;
import application.service.PortService;

@Service("portServiceImpl")
public class PortServiceImpl implements PortService {
	@Autowired
	@Qualifier("portRepository")
	private PortRepository portRepository;

	@Autowired
	@Qualifier("configClass")
	private ConfigClass config;

	@Override
	public List<PortModel> listPorts() {
		List<Port> pList = portRepository.findAll();
		List<PortModel> pModelList = new ArrayList<>();
		for (Port p : pList) {
			PortModel pModel = transform(p);
			pModelList.add(pModel);
		}
		return pModelList;
	}

	@Override
	public PortModel addPort(PortModel portModel) {
		Port port = transform(portModel);
		return transform(portRepository.save(port));
	}

	@Override
	public int removePort(String portname) {
		portRepository.deleteById(portname);
		return 0;
	}

	@Override
	public PortModel updatePort(PortModel portModel) {
		Port port = transform(portModel);
		return transform(portRepository.save(port));
	}

	@Override
	public Port transform(PortModel portModel) {
		return config.mapper().map(portModel, Port.class);
	}

	@Override
	public PortModel transform(Port port) {
		return config.mapper().map(port, PortModel.class);
	}
}
