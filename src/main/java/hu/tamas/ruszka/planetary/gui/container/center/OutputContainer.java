package hu.tamas.ruszka.planetary.gui.container.center;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OutputContainer extends VBox {

	@PostConstruct
	public void init() {
		TextArea mainTextArea = new TextArea();
		mainTextArea.setEditable(false);

		getChildren().addAll(mainTextArea);

		setVgrow(mainTextArea, Priority.ALWAYS);
	}

}
