package telran.persons.controller;

import java.util.ArrayList;
import telran.persons.controller.items.AddPersonItem;
import telran.persons.controller.items.GetPersonItem;
import telran.persons.controller.items.RemovePerson;
import telran.persons.controller.items.UpdateNameItem;
import telran.persons.dao.IPersonsDao;
import telran.persons.model.PersonsWebProxy;
import telran.view.ConsoleInputOutput;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;
import telran.view.MenuWithExit;

public class PersonsConsoleApp {
	public static InputOutput inputOutput = new ConsoleInputOutput();
	public static IPersonsDao persons;
	static String HOST_NAME = "http://localhost:8080";

	public static void main(String[] args) {
		String url = args.length == 0 ? HOST_NAME : args[0];
		persons = new PersonsWebProxy(url);
		ArrayList<Item> items = getItemsMain();

		Menu menu = new MenuWithExit(items, inputOutput);
		menu.runMenu();
	}

	private static ArrayList<Item> getItemsMain() {
		ArrayList<Item> res = new ArrayList<>();
		res.add(new AddPersonItem());
		res.add(new GetPersonItem());
		res.add(new RemovePerson());
		res.add(new UpdateNameItem());
		return res;
	}
}
