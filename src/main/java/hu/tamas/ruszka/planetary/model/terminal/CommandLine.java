package hu.tamas.ruszka.planetary.model.terminal;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandLine {

	private LocalDateTime timestamp;
	private String text;

	public CommandLine(final String text) {
		this.timestamp = LocalDateTime.now();
		this.text = text;
	}

}
