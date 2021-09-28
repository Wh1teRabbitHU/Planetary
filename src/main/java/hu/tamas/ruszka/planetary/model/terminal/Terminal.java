package hu.tamas.ruszka.planetary.model.terminal;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Terminal {

	private String modulePath;
	private int commandIndex;
	private List<String> commandHistory = new ArrayList<>();
	private List<CommandLine> lines = new ArrayList<>();

	public Terminal(final String modulePath) {
		this.modulePath = modulePath;
	}

	public void addCommand(String command, String response) {
		commandHistory.add(command);
		commandIndex = commandHistory.size();
		lines.add(new CommandLine(command));
		lines.add(new CommandLine(response));
	}

	public String previousCommand() {
		commandIndex--;

		if (commandIndex < 0) {
			commandIndex = 0;
		}

		return commandHistory.get(commandIndex);
	}

	public String nextCommand() {
		commandIndex++;

		if (commandIndex >= commandHistory.size()) {
			commandIndex = commandHistory.size();

			return "";
		}

		return commandHistory.get(commandIndex);
	}

}
