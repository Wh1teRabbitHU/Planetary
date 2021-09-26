package hu.tamas.ruszka.planetary.gui.component.menu;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.gui.component.menu.project.SetRootFolderMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProjectMenu extends Menu {

	private final SetRootFolderMenuItem setRootFolderMenuItem;

	@PostConstruct
	public void init() {
		MenuItem addSingleModuleMenu = new MenuItem("Add single module");
		MenuItem addModuleRecursivelyMenu = new MenuItem("Add module recursively");
		MenuItem removeNewModuleMenu = new MenuItem("Remove selected module");
		SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
		MenuItem scanModulesMenu = new MenuItem("Scan modules");
		MenuItem runAllMenu = new MenuItem("Run all");

		setText("Project");

		getItems().addAll(setRootFolderMenuItem,
						  addSingleModuleMenu,
						  addModuleRecursivelyMenu,
						  removeNewModuleMenu,
						  separatorMenuItem1,
						  scanModulesMenu,
						  runAllMenu);
	}

}
