package admission.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="user_seq_gen")
	@SequenceGenerator(name="user_seq_gen", sequenceName="USER_SEQ")
	private Integer id;
	private String nickName;
	private String password;
	private Role role;
	
	
	public User() {
	}


		public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


		public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}




	@Override
	public String toString() {
		return role+" [id=" + id + ", nickName=" + nickName + ", password=" + password  + "]";
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
