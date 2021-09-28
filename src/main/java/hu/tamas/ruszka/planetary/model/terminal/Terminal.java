package hu.tamas.ruszka.planetary.model.terminal;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Terminal {

	private String modulePath;
	private List<CommandLine> lines = new ArrayList<>();

	public Terminal(final String modulePath) {
		this.modulePath = modulePath;
	}

	public void addLine(String line) {
		lines.add(new CommandLine(line));
	}

}
