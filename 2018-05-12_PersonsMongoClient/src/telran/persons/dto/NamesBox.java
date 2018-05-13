package telran.persons.dto;

public class NamesBox {
	int id;
	String newName;

	public NamesBox(int id, String newName) {
		this.id = id;
		this.newName = newName;
	}

	public NamesBox() {
	}

	public int getId() {
		return id;
	}

	public String getNewName() {
		return newName;
	}

}
