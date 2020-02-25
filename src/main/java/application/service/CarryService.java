package application.service;

import java.util.List;

import application.entity.Carry;
import application.model.CarryModel;

public interface CarryService {

	public abstract List<CarryModel> listCarry();

	public abstract CarryModel addCarry(CarryModel carryModel);

	public abstract Carry transform(CarryModel carryModel);

	public abstract CarryModel transform(Carry carry);

	public abstract boolean checkTable(int cyclistId, String maillotCode, int stagenumber);

}
