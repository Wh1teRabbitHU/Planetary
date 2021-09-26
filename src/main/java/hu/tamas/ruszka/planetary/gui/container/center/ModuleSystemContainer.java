package hu.tamas.ruszka.planetary.gui.container.center;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.gui.component.module.ModuleTreeTableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModuleSystemContainer extends VBox {

	private final ModuleControlContainer moduleControlContainer;
	private final ModuleTreeTableView moduleTreeTableView;

	@PostConstruct
	public void init() {
		getChildren().addAll(moduleControlContainer, moduleTreeTableView);

		setVgrow(moduleTreeTableView, Priority.ALWAYS);
	}

}
