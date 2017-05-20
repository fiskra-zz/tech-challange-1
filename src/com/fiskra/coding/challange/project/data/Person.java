package com.fiskra.coding.challange.project.data;

public final class Person {

	private String firstName;
	private String lastName;
	private Country country;
	private int age;

	public Person() {
		// this constructor is here if you prefer using setters instead of
		// constructor parameters
	}

	public Person(String firstName, String lastName, Country country, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("%s %s (%d / %s)", this.getFirstName(), this.getLastName(), this.getAge(),
				this.getCountry().toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Person))
			return false;
		Person person = (Person) obj;
		return this.firstName.equals(person.firstName) && this.lastName.equals(person.lastName)
				&& this.country.equals(person.country) && this.age == person.age;

	}
}
