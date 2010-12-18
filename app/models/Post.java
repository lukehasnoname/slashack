package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class Post extends Model{
	
	@Required
	@ManyToOne
	public User author;
	@Required
	public String title;
	@Required
	public String url;
	@Lob
	@MaxSize(100000)
	public String content;
	public Date postdate;
	@ManyToOne
	public Post parent;
	@ManyToOne
	public Post root;
	
	public Post(User author, String title, String url, Post parent, Post root){
		this.author = author;
		this.title = title;
		this.url = url;
		this.postdate = new Date();
		this.parent = parent;
		this.root = root;
		//author.posts.add(this);
	}
}
