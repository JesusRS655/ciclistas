package application.service;

import java.util.List;

import application.entity.Port;
import application.model.PortModel;

public interface PortService {

	public abstract List<PortModel> listPorts();

	public abstract PortModel addPort(PortModel portModel);

	public abstract int removePort(String portname);

	public PortModel updatePort(PortModel portModel);

	public abstract Port transform(PortModel portModel);

	public abstract PortModel transform(Port port);

}
