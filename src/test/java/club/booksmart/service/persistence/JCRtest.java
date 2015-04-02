package club.booksmart.service.persistence;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import javax.jcr.GuestCredentials; 
import javax.jcr.LoginException;
import javax.jcr.Repository; 
import javax.jcr.RepositoryException;
import javax.jcr.Session; 
import org.apache.jackrabbit.commons.JcrUtils; 

public class JCRtest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws LoginException, RepositoryException {
		Repository repository = JcrUtils.getRepository(); 
		Session session = repository.login(new GuestCredentials()); 
		try { 
		String user = session.getUserID(); 
		String name = repository.getDescriptor(Repository.REP_NAME_DESC); 
		System.out.println( 
		"Logged in as " + user + " to a " + name + " repository."); 
		} finally { 
		session.logout(); 
		} 
	}

}
