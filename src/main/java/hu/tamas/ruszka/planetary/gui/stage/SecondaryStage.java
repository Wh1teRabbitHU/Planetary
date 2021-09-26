package hu.tamas.ruszka.planetary.gui.stage;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

@Component
public class SecondaryStage extends Stage {

	@PostConstruct
	public void init() {
		Scene scene = new Scene(new BorderPane(), 640, 480);

		this.setScene(scene);
		this.setTitle("Planetary");
	}

}
