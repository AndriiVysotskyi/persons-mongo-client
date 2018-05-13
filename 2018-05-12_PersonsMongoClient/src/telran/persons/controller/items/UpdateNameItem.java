package telran.persons.controller.items;

import telran.persons.controller.PersonsConsoleApp;
import telran.view.Item;

public class UpdateNameItem implements Item {

	@Override
	public String displayedName() {
		return "Update name for person";
	}

	@Override
	public void action() {
		int id = PersonsConsoleApp.inputOutput.getInteger("Eneter id of person you want to change name");
		String newName = PersonsConsoleApp.inputOutput.getString("Enter persons new name");
		PersonsConsoleApp.inputOutput.displayLine(PersonsConsoleApp.persons.updateName(id, newName));

	}

}
