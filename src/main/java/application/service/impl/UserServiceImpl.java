package application.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.configuration.ConfigClass;
import application.controller.LoginController;
import application.entity.UserRole;
import application.model.UserModel;
import application.repository.UserRepository;
import application.repository.UserRoleRepository;
import application.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService, UserService {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@Autowired
	@Qualifier("userRoleRepository")
	private UserRoleRepository userRoleRepository;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("configClass")
	private ConfigClass config;

	@Override
	public List<UserModel> listUsers() {
		List<application.entity.User> uList = userRepository.findAll();
		List<UserModel> uModelList = new ArrayList<>();
		for (application.entity.User u : uList) {
			UserModel uModel = transform(u);
			uModelList.add(uModel);
		}
		return uModelList;
	}

	@Override
	public UserModel addUser(UserModel userModel) {
		application.entity.User user = transform(userModel);
		return transform(userRepository.save(user));
	}

	public void registerUser(UserModel userModel) {
		application.entity.User user = new application.entity.User();
		UserRole role = new UserRole();
		user.setUsername(userModel.getUsername());
		user.setPassword(userModel.getPassword());
		user.setRoleList(new HashSet<>(userRoleRepository.findAll()));
		user.setEnabled(true);
		
		role.setRole(userModel.getRole());
		role.setUser(user);
		
		userRepository.save(user);
		userRoleRepository.save(role);

	}

	@Override
	public application.entity.User transform(UserModel userModel) {
		return config.mapper().map(userModel, application.entity.User.class);
	}

	@Override
	public UserModel transform(application.entity.User user) {
		return config.mapper().map(user, UserModel.class);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		application.entity.User user = userRepository.findByUsername(username);
		LOG.info(user);
		List<GrantedAuthority> auths = buildAuthorities(user.getRoleList());
		return buildUser(user, auths);
	}

	private User buildUser(application.entity.User user, List<GrantedAuthority> auths) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, auths);
	}

	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for (UserRole userRole : userRoles)
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		return new ArrayList<GrantedAuthority>(auths);
	}
}
