package telran.persons.controller.items;

import java.time.LocalDate;

import telran.persons.controller.PersonsConsoleApp;
import telran.persons.dto.Person;
import telran.view.Item;

public class AddPersonItem implements Item {

	@Override
	public String displayedName() {
		return "Add person";
	}

	@Override
	public void action() {
		Person person = getPerson();
		boolean result = PersonsConsoleApp.persons.addPerson(person);
		PersonsConsoleApp.inputOutput.displayLine(result);

	}

	private Person getPerson() {
		int id = PersonsConsoleApp.inputOutput.getInteger("Enter persons id");
		String name = PersonsConsoleApp.inputOutput.getString("Enter persons name");
		LocalDate birthDate = PersonsConsoleApp.inputOutput.getDate("Enter persons birthdate", "dd/MM/yyyy");
		return new Person(id, name, birthDate);
	}

}
