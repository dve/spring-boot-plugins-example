package net.vergien.boot.plugin.people.view;

import org.springframework.stereotype.Component;

import net.vergien.boot.plugin.SimpleMenuEntry;

@Component
public class PeopleMenuEntry extends SimpleMenuEntry {
	public PeopleMenuEntry() {
		super(PeopleView.VIEW_NAME, "People");
	}
}
