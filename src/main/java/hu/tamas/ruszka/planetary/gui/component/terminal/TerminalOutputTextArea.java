package hu.tamas.ruszka.planetary.gui.component.terminal;

import static hu.tamas.ruszka.planetary.util.DateTimeUtil.formatTime;

import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.model.terminal.CommandLine;
import hu.tamas.ruszka.planetary.model.terminal.Terminal;
import javafx.scene.control.TextArea;
import lombok.Getter;
import lombok.Setter;

@Component
public class TerminalOutputTextArea extends TextArea {

	@Getter
	@Setter
	private boolean hasTimestamp = true;

	@PostConstruct
	public void init() {
		setEditable(false);
		setStyle("-fx-font-family: monospace");
	}

	public void clearTerminal() {
		setText("");
	}

	public void loadTerminal(Terminal terminal) {
		String text = terminal.getLines()
							  .stream()
							  .map(mapLines())
							  .reduce(String::concat)
							  .orElse("");

		setText(text);
		selectPositionCaret(getLength());
		deselect();
	}

	private Function<CommandLine, String> mapLines() {
		return line -> {
			String output = "";

			if (hasTimestamp) {
				output += "[";
				output += formatTime(line.getTimestamp());
				output += "] ";
			}

			output += line.getText();

			return output + "\n";
		};
	}

}
