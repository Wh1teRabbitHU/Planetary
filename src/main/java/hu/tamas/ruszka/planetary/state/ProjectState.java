package hu.tamas.ruszka.planetary.state;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.model.module.ModuleElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Scope(SCOPE_SINGLETON)
public class ProjectState {

	private String rootFolderPath;
	private ModuleElement rootElement;

}
