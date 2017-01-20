package net.vergien.boot.plugin.people.view;

import org.vaadin.viritin.fields.TypedSelect;

import net.vergien.boot.plugin.people.entity.Person;

@SuppressWarnings("serial")
public class PersonComboBox extends TypedSelect<Person> {
	public PersonComboBox() {
		super(Person.class);
		asComboBoxType();
		setCaptionGenerator(person -> person.getName());
	}
}
