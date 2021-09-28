package hu.tamas.ruszka.planetary.gui.container;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.gui.container.center.ModuleSystemContainer;
import hu.tamas.ruszka.planetary.gui.container.center.TerminalContainer;
import javafx.scene.control.SplitPane;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainCenterContainer extends SplitPane {

	private final ModuleSystemContainer moduleSystemContainer;
	private final TerminalContainer terminalContainer;

	@PostConstruct
	public void init() {
		getItems().addAll(moduleSystemContainer, terminalContainer);
	}

}
