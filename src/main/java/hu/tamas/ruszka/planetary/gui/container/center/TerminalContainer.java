package hu.tamas.ruszka.planetary.gui.container.center;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.gui.component.terminal.InputTextField;
import hu.tamas.ruszka.planetary.gui.component.terminal.TerminalOutputTextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TerminalContainer extends VBox {

	private final TerminalOutputTextArea terminalOutputTextArea;
	private final InputTextField inputTextField;

	@PostConstruct
	public void init() {
		getChildren().addAll(terminalOutputTextArea, inputTextField);

		setVgrow(terminalOutputTextArea, Priority.ALWAYS);
	}

}
