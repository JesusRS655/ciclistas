package application.service;

import java.util.List;

import application.entity.Cyclist;
import application.model.CyclistModel;

public interface CyclistService {

	public abstract List<CyclistModel> listCyclists();

	public abstract CyclistModel addCyclist(CyclistModel cyclistModel);

	public abstract int removeCyclist(int id);

	public CyclistModel updateCyclist(CyclistModel cyclistModel);

	public abstract Cyclist transform(CyclistModel cyclistModel);

	public abstract CyclistModel transform(Cyclist cyclist);

}
