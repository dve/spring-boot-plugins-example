package net.vergien.boot.plugin;

import org.apache.commons.lang3.Validate;

public class SimpleMenuEntry implements MenuEntry {
	private final String navigationTarget;
	private final String name;

	public SimpleMenuEntry(String navigationTarget, String name) {
		super();
		Validate.notBlank(navigationTarget);
		Validate.notBlank(name);
		this.navigationTarget = navigationTarget;
		this.name = name;
	}

	@Override
	public String getNavigationTarget() {
		return navigationTarget;
	}

	@Override
	public String getName() {
		return name;
	}
}
