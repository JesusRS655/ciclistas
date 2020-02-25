package application.service;

import java.util.List;

import application.entity.User;
import application.model.UserModel;

public interface UserService {

	public abstract List<UserModel> listUsers();

	public abstract UserModel addUser(UserModel userModel);
	
	public abstract void registerUser(UserModel userModel);

	public abstract User transform(UserModel userModel);

	public abstract UserModel transform(User user);

}
