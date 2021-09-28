package hu.tamas.ruszka.planetary.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import hu.tamas.ruszka.planetary.gui.component.terminal.TerminalOutputTextArea;
import hu.tamas.ruszka.planetary.model.terminal.Terminal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TerminalService {

	private final TerminalOutputTextArea terminalOutputTextArea;

	private String selectedTerminal;
	private Map<String, Terminal> terminals = new HashMap<>();

	public void selectTerminal(String modulePath) {
		if (Objects.equals(selectedTerminal, modulePath)) {
			return;
		}

		log.info("Following module selected: {}", modulePath);

		selectedTerminal = modulePath;

		if (!terminals.containsKey(modulePath)) {
			terminals.put(modulePath, new Terminal(modulePath));
		}

		Terminal terminal = terminals.get(modulePath);
		terminalOutputTextArea.loadTerminal(terminal);
	}

	public void commandEntered(String command) {
		Terminal terminal = getSelectedTerminal();

		if (terminal == null) {
			return;
		}

		String response = exCommand(command);

		terminal.addLine(command);
		terminal.addLine(response);
		terminalOutputTextArea.loadTerminal(terminal);
	}

	private Terminal getSelectedTerminal() {
		if (selectedTerminal == null) {
			return null;
		}

		return terminals.get(selectedTerminal);
	}

	private String exCommand(String command) {
		StringBuilder response = new StringBuilder();
		ProcessBuilder builder = new ProcessBuilder();
		Process pr;

		if (isWindows()) {
			builder.command("cmd.exe", "/c", command);
		} else {
			builder.command("sh", "-c", command);
		}

		builder.directory(new File(selectedTerminal));

		try {
			pr = builder.start();
			pr.waitFor();
		} catch (IOException | InterruptedException ex) {
			log.error(ex.getMessage(), ex);

			return ex.getMessage();
		}

		try (BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()))) {
			String line;

			while ((line = buf.readLine()) != null) {
				response.append(line)
						.append("\n");
			}
		} catch (IOException ex) {
			log.error(ex.getMessage(), ex);

			return ex.getMessage();
		}

		return response.toString();
	}

	private boolean isWindows() {
		return System.getProperty("os.name")
					 .toLowerCase()
					 .startsWith("windows");
	}

}
