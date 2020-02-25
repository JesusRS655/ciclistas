package application.model;

public class UserRoleModel {

	private int id;
	private String role;
	private UserModel userModel;

	public UserRoleModel() {
		super();
	}

	public UserRoleModel(int id, String role, UserModel userModel) {
		super();
		this.id = id;
		this.role = role;
		this.userModel = userModel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

}
