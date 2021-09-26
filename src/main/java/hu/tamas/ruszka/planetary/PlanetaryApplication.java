package hu.tamas.ruszka.planetary;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hu.tamas.ruszka.planetary.configuration.SpringConfiguration;
import hu.tamas.ruszka.planetary.gui.stage.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlanetaryApplication extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		log.info("Starting application!");

		final ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		final MainStage mainStage = ctx.getBean(MainStage.class);

		mainStage.show();
		mainStage.setOnCloseRequest(event -> {
			log.info("Closing application...");
		});
	}

	public static void main(String[] args) {
		launch();
	}

}