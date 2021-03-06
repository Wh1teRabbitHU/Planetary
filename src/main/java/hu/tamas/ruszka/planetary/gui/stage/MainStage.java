package hu.tamas.ruszka.planetary.gui.stage;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.gui.container.MainContainer;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainStage extends Stage {

	private static final int SCENE_WIDTH = 800;
	private static final int SCENE_HEIGHT = 600;
	private static final String SCENE_TITLE = "Planetary";

	private final MainContainer mainContainer;

	@PostConstruct
	public void init() {
		Scene scene = new Scene(mainContainer, SCENE_WIDTH, SCENE_HEIGHT);

		scene.getStylesheets()
			 .add("dark-theme.css");

		//		this.setMaximized(true);
		this.setScene(scene);
		this.setTitle(SCENE_TITLE);
	}

}
