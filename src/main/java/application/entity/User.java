package application.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 20)
	private String username;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Column(name = "enabled")
	private boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> roleList = new HashSet<UserRole>();

	public User() {
		super();
	}

	public User(String username, String password, boolean enabled, Set<UserRole> roleList) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roleList = roleList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<UserRole> roleList) {
		this.roleList = roleList;
	}

}