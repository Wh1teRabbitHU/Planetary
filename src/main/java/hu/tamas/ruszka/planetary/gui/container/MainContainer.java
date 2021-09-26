package hu.tamas.ruszka.planetary.gui.container;


import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.scene.layout.BorderPane;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainContainer extends BorderPane {

	private final MainTopContainer mainTopContainer;
	private final MainCenterContainer mainCenterContainer;

	@PostConstruct
	public void init() {
		setTop(mainTopContainer);
		setCenter(mainCenterContainer);
	}

}
