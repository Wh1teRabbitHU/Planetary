package hu.tamas.ruszka.planetary.gui.container;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.gui.component.menu.FileMenu;
import hu.tamas.ruszka.planetary.gui.component.menu.ProjectMenu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainTopContainer extends VBox {

	private final FileMenu fileMenu;
	private final ProjectMenu projectMenu;

	@PostConstruct
	public void init() {
		MenuBar fileMenuBar = new MenuBar(fileMenu, projectMenu);

		getChildren().add(fileMenuBar);
	}

}
