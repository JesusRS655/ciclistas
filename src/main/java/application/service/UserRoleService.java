package application.service;

import application.entity.UserRole;
import application.model.UserRoleModel;

public interface UserRoleService {

	public abstract UserRoleModel addUserRole(UserRoleModel userRoleModel);

	public abstract int removeUserRole(int id);

	public abstract UserRole transform(UserRoleModel userRoleModel);

	public abstract UserRoleModel transform(UserRole userRole);

}
