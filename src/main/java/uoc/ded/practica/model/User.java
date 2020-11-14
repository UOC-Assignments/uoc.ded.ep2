package uoc.ded.practica.model;

public class User {
	
	private String name;
	private String surname;
	
	public User(String name, String surname) {
		setName(surname);
		setSurname(surname);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	private void setSurname(String surname) {
		this.surname = surname;
	}
}