package hu.tamas.ruszka.planetary.service;

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

		terminal.addLine(command);
		terminalOutputTextArea.loadTerminal(terminal);
	}

	private Terminal getSelectedTerminal() {
		if (selectedTerminal == null) {
			return null;
		}

		return terminals.get(selectedTerminal);
	}

}
