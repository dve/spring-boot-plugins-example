package net.vergien.boot.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.layouts.MHorizontalLayout;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import net.vergien.boot.plugin.MenuEntry;

@Theme("valo")
@SpringUI
@SpringViewDisplay
public class VaadinUI extends UI implements ViewDisplay {

	private Panel springViewDisplay;
	@Autowired
	private Navigator navigator;
	@Autowired
	private List<MenuEntry> menuEntries;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		root.setMargin(true);
		root.setSpacing(true);
		setContent(root);
		MHorizontalLayout horizontalLayout = new MHorizontalLayout();
		for (MenuEntry menuEntry : menuEntries) {
			horizontalLayout.addComponent(new MButton(menuEntry.getName(), event -> {
				navigator.navigateTo(menuEntry.getNavigationTarget());
			}));
		}
		root.addComponent(horizontalLayout);
		springViewDisplay = new Panel();
		springViewDisplay.setSizeFull();
		root.addComponent(springViewDisplay);
		root.setExpandRatio(springViewDisplay, 1.0f);

	}

	@Override
	public void showView(View view) {
		springViewDisplay.setContent((Component) view);
	}
}
