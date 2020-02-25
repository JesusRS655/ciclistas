package application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import application.configuration.ConfigClass;
import application.entity.UserRole;
import application.model.UserRoleModel;
import application.repository.UserRoleRepository;
import application.service.UserRoleService;

@Service("userRoleServiceImpl")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	@Qualifier("userRoleRepository")
	private UserRoleRepository userRoleRepository;

	@Autowired
	@Qualifier("configClass")
	private ConfigClass config;

	@Override
	public UserRoleModel addUserRole(UserRoleModel userRoleModel) {
		UserRole userRole = transform(userRoleModel);
		return transform(userRoleRepository.save(userRole));
	}

	@Override
	public int removeUserRole(int id) {
		userRoleRepository.deleteById(id);
		return 0;
	}

	@Override
	public UserRole transform(UserRoleModel userRoleModel) {
		return config.mapper().map(userRoleModel, UserRole.class);
	}

	@Override
	public UserRoleModel transform(UserRole userRole) {
		return config.mapper().map(userRole, UserRoleModel.class);
	}

}
