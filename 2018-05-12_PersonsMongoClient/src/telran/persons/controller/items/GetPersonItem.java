package telran.persons.controller.items;

import telran.persons.controller.PersonsConsoleApp;
import telran.persons.dto.Person;
import telran.view.Item;

public class GetPersonItem implements Item {

	@Override
	public String displayedName() {
		return "Display persons data";
	}

	@Override
	public void action() {
		int id = PersonsConsoleApp.inputOutput.getInteger("Enter persons id");
		Person person = PersonsConsoleApp.persons.getPerson(id);
		if (person == null) {
			PersonsConsoleApp.inputOutput.displayLine("no person with id " + id);
		} else {
			PersonsConsoleApp.inputOutput.displayLine(person);
		}

	}

}
