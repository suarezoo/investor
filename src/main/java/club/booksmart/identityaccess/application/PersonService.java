package club.booksmart.identityaccess.application;

import club.booksmart.identityaccess.domain.model.identity.Person;

public interface PersonService {
	public Person getRandom();
	public Person getById(Long id);
	public void save(Person person);
}