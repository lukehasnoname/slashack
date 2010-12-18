package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class User extends Model {
	
	@Required
	public String username;
	@Required
	public String password;
	@Required
	public String email;
	public Date joindate;
	
	@OneToMany(mappedBy="author", cascade=CascadeType.ALL)
	public List<Post> posts;
	
	public User(String username, String password, String email){
		this.posts = new ArrayList<Post>();
		this.username = username;
		this.password = password;
		this.email = email;
		this.joindate = new Date();
		
	}
}