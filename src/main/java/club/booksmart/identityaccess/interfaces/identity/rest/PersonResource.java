package club.booksmart.identityaccess.interfaces.identity.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import club.booksmart.identityaccess.application.PersonService;
import club.booksmart.identityaccess.domain.model.identity.Person;

@Component
@Path("/person")
public class PersonResource {
	
	@Autowired
	PersonService personService;
	
	@GET
	@Path("random")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Person randomPerson() {
		return personService.getRandom();
	}
	
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Person getById(@PathParam("id") Long id) {
		return personService.getById(id);
	}
	
	
	/**
	 * Saves new person. Spring automatically binds the name
	 * and age parameters in the request to the person argument
	 * @param person
	 * @return String indicating success or failure of save
	 */
	@POST
	@Path("person")
	public String savePerson(Person person) {
		personService.save(person);
		return "Saved person: " + person.toString();
	}

}
