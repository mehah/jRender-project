package modal;

import com.jrender.http.security.UserPrincipal;

import greendb.annotation.Column;
import greendb.annotation.PK;
import greendb.annotation.Table;

@Table("users")
public class User extends UserPrincipal {
	private static final long serialVersionUID = 1L;

	@Column(updatable = false)
	@PK(autoIncrement = true)
	private int id;

	@Column
	private String email;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@Column
	private int admin;

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}	

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin == 1;
	}

	public void setAdmin(boolean admin) {
		if(admin) {
			addRule("RULE_ADMIN");
		}
		
		this.admin = admin ? 1 : 0;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
