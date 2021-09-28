package hu.tamas.ruszka.planetary.gui.component.terminal;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.service.TerminalService;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class InputTextField extends TextField {

	private final TerminalService terminalService;

	@PostConstruct
	public void init() {
		setOnKeyPressed(onKeyPressed());
	}

	private EventHandler<KeyEvent> onKeyPressed() {
		return keyEvent -> {
			if (KeyCode.ENTER == keyEvent.getCode()) {
				terminalService.commandEntered(getText());

				clear();
			} else if (KeyCode.UP == keyEvent.getCode()) {
				String prevCommand = terminalService.getPreviousCommand();

				setText(prevCommand);
			} else if (KeyCode.DOWN == keyEvent.getCode()) {
				String nextCommand = terminalService.getNextCommand();

				setText(nextCommand);
			}
		};
	}

}
