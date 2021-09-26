package hu.tamas.ruszka.planetary.gui.container.center;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

@Component
public class ModuleControlContainer extends HBox {

	@PostConstruct
	public void init() {
		getChildren().addAll(new Button("Apply"), new Button("Check"), new Button("Remove"));

		setPadding(new Insets(6.0, 6.0, 6.0, 6.0));
	}

}
