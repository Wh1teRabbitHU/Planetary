package hu.tamas.ruszka.planetary.model.module;

import hu.tamas.ruszka.planetary.model.code.ModuleStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuleTreeItem {

	private ModuleTreeItem parent;
	private String name;
	private ModuleStatus status;
	private boolean hasTerraformFile;

}
