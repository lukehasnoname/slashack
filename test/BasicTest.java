import org.junit.*;
import java.util.*;

import play.db.jpa.GenericModel.JPAQuery;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {
	
	@Before
    public void setup() {
        Fixtures.deleteAll();
    }

    @Test
    public void createUserTest() {
    	User bob = new User("bob", "1234", "bob@gmail.com"); //create a new user in mem
    	bob.save(); //Save it to the database
    	User newBob = User.find("byUsername", "bob").first(); //find it in the database
    	assertEquals("1234", newBob.password); //Assert the correct password is given
    	
    	Post frist = new Post(newBob, "Google!","http://google.com", null, null);
    	frist.save();
    	newBob.posts.add(frist);
    	assertEquals(1, Post.count()); //The post does exist.
    	
    	//Post checkit = newBob.posts.get(0);
    	
    	
    	
    	
    	//assertEquals(workDamnit.title, "Google!");
    	
    	
    }
    
    

}
