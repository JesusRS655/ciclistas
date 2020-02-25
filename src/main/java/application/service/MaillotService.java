package application.service;

import java.util.List;

import application.entity.Maillot;
import application.model.MaillotModel;

public interface MaillotService {

	public abstract List<MaillotModel> listMaillots();

	public abstract MaillotModel addMaillot(MaillotModel maillotModel);

	public abstract int removeMaillot(String code);

	public MaillotModel updateMaillot(MaillotModel maillotModel);

	public abstract Maillot transform(MaillotModel maillotModel);

	public abstract MaillotModel transform(Maillot maillot);

}
