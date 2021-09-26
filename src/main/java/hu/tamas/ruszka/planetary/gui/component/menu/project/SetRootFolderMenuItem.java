package hu.tamas.ruszka.planetary.gui.component.menu.project;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.gui.stage.SecondaryStage;
import hu.tamas.ruszka.planetary.service.ProjectService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.DirectoryChooser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class SetRootFolderMenuItem extends MenuItem {

	private final SecondaryStage secondaryStage;
	private final ProjectService projectService;

	@PostConstruct
	public void init() {
		setText("Set root folder");
		setOnAction(onAction());
	}

	private EventHandler<ActionEvent> onAction() {
		return actionEvent -> {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			File selectedDirectory = directoryChooser.showDialog(secondaryStage);

			projectService.changeRootFolder(selectedDirectory.getAbsolutePath());
		};
	}

}
