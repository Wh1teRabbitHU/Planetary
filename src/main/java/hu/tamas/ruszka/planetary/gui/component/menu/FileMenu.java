package hu.tamas.ruszka.planetary.gui.component.menu;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

@Component
public class FileMenu extends Menu {

	@PostConstruct
	public void init() {
		MenuItem newProjectMenu = new MenuItem("New Project");
		MenuItem loadProjectMenu = new MenuItem("Load Project");
		MenuItem saveProjectMenu = new MenuItem("Save Project");
		MenuItem closeProjectMenu = new MenuItem("Close Project");
		SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
		MenuItem exitMenu = new MenuItem("Exit");

		setText("File");

		getItems().addAll(newProjectMenu, loadProjectMenu, saveProjectMenu, closeProjectMenu, separatorMenuItem1,
						  exitMenu);
	}

}
