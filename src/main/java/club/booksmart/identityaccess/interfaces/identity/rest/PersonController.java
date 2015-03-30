package club.booksmart.identityaccess.interfaces.identity.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.booksmart.identityaccess.application.PersonService;
import club.booksmart.identityaccess.domain.model.identity.Person;

@Controller
@RequestMapping("api")
public class PersonController {
	
	@Autowired
	PersonService personService;
	

	@RequestMapping(value = "person/random", method = RequestMethod.GET)
	@ResponseBody
	public Person randomPerson() {
		return personService.getRandom();
	}
	
	@RequestMapping("person/{id}")
	@ResponseBody
	public Person getById(@PathVariable Long id) {
		return personService.getById(id);
	}
	
	/* same as above method, but is mapped to
	 * /api/person?id= rather than /api/person/{id}
	 */
	@RequestMapping(value="person", params="id")
	@ResponseBody
	public Person getByIdFromParam(@RequestParam("id") Long id) {
		return personService.getById(id);
	}
	
	/**
	 * Saves new person. Spring automatically binds the name
	 * and age parameters in the request to the person argument
	 * @param person
	 * @return String indicating success or failure of save
	 */
	@RequestMapping(value="person", method=RequestMethod.POST)
	@ResponseBody
	public String savePerson(Person person) {
		personService.save(person);
		return "Saved person: " + person.toString();
	}
}