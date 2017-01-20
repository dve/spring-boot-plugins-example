package net.vergien.boot.plugin.team.view;

import org.springframework.stereotype.Component;

import net.vergien.boot.plugin.SimpleMenuEntry;

@Component
public class TeamMenuEntry extends SimpleMenuEntry {
	public TeamMenuEntry() {
		super(TeamView.VIEW_NAME, "Teams");
	}
}
