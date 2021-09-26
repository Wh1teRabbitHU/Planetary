package hu.tamas.ruszka.planetary.gui.component.menu;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

@Component
public class ProjectMenu extends Menu {

	@PostConstruct
	public void init() {
		MenuItem setRootFolderMenu = new MenuItem("Set root folder");
		MenuItem addSingleModuleMenu = new MenuItem("Add single module");
		MenuItem addModuleRecursivelyMenu = new MenuItem("Add module recursively");
		MenuItem removeNewModuleMenu = new MenuItem("Remove selected module");
		SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
		MenuItem scanModulesMenu = new MenuItem("Scan modules");
		MenuItem runAllMenu = new MenuItem("Run all");

		setText("Project");

		getItems().addAll(setRootFolderMenu,
						  addSingleModuleMenu,
						  addModuleRecursivelyMenu,
						  removeNewModuleMenu,
						  separatorMenuItem1,
						  scanModulesMenu,
						  runAllMenu);
	}

}
