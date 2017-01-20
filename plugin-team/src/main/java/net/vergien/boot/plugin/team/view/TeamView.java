package net.vergien.boot.plugin.team.view;

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

import net.vergien.boot.plugin.people.repository.PersonRepository;
import net.vergien.boot.plugin.people.view.PersonComboBox;
import net.vergien.boot.plugin.team.entity.Team;
import net.vergien.boot.plugin.team.entity.repository.TeamRepository;

@SuppressWarnings("serial")
@SpringView(name = TeamView.VIEW_NAME)
public class TeamView extends VerticalLayout implements View {
	static final String VIEW_NAME = "teams";

	private MTextField newName = new MTextField("Name").withInputPrompt("Name...");
	private PersonComboBox newLead = new PersonComboBox();
	private MButton newButton = new MButton("Anlegen", event -> onSave());
	private MGrid<Team> teamGrid = new MGrid<>(Team.class).withProperties("id", "name", "teamLead.name");
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private TeamRepository teamRepository;

	@PostConstruct
	void init() {
		addComponent(new Label("This is the default view"));
		addComponent(teamGrid);
		addComponent(new MHorizontalLayout(newName, newLead, newButton));
	}

	private void onSave() {
		Team team = new Team();
		team.setName(newName.getValue());
		team.setTeamLead(newLead.getValue());
		teamRepository.save(team);
		newName.clear();
		newLead.setValue(null);
		enter(null);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		newLead.setBeans(personRepository.findAll());
		teamGrid.setRows(teamRepository.findAll());
	}
}
