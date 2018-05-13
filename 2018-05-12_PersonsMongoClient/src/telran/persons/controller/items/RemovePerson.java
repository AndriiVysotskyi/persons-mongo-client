package telran.persons.controller.items;

import telran.persons.controller.PersonsConsoleApp;
import telran.view.Item;

public class RemovePerson implements Item {

	@Override
	public String displayedName() {
		return "Remove person";
	}

	@Override
	public void action() {
		int id = PersonsConsoleApp.inputOutput.getInteger("Eneter id of person you want to delete");
		PersonsConsoleApp.inputOutput.displayLine(PersonsConsoleApp.persons.removePerson(id));
	}

}
