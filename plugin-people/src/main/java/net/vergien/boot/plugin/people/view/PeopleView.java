package net.vergien.boot.plugin.people.view;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.grid.MGrid;
import org.vaadin.viritin.layouts.MHorizontalLayout;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import net.vergien.boot.plugin.people.entity.Person;
import net.vergien.boot.plugin.people.repository.PersonRepository;

@SuppressWarnings("serial")
@SpringView(name = PeopleView.VIEW_NAME)
public class PeopleView extends VerticalLayout implements View {
	public static final String VIEW_NAME = "people";
	private MTextField newName = new MTextField("Name").withInputPrompt("Name...");
	private MButton newButton = new MButton("Create", event -> onSave());
	private MGrid<Person> peopleGrid = new MGrid<>(Person.class);
	@Autowired
	private PersonRepository personRepository;

	@PostConstruct
	void init() {
		addComponent(new Label("This is the people plugin view"));
		addComponent(peopleGrid);
		addComponent(new MHorizontalLayout(newName, newButton));
	}

	private void onSave() {
		Person person = new Person(newName.getValue());
		personRepository.save(person);

		newName.clear();
		enter(null);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		peopleGrid.setRows(personRepository.findAll());
	}
}