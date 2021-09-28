package hu.tamas.ruszka.planetary.model.module;

import java.util.ArrayList;
import java.util.List;

import hu.tamas.ruszka.planetary.model.code.ModuleStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModuleElement {

	private final List<ModuleElement> childrens = new ArrayList<>();

	private String name;
	private String path;
	private ModuleStatus status;

	public ModuleElement(final String name, final String path, final ModuleStatus status) {
		this.name = name;
		this.path = path;
		this.status = status;
	}

}
