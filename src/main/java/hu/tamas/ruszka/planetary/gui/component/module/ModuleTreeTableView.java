package hu.tamas.ruszka.planetary.gui.component.module;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.model.code.ModuleStatus;
import hu.tamas.ruszka.planetary.model.module.ModuleTreeItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModuleTreeTableView extends TreeTableView<ModuleTreeItem> {

	@PostConstruct
	public void init() {
		setColumns();
		setValues();
	}

	private void setColumns() {
		TreeTableColumn<ModuleTreeItem, String> nameColumn = new TreeTableColumn<>("Name");
		TreeTableColumn<ModuleTreeItem, String> statusColumn = new TreeTableColumn<>("Status");

		nameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
		statusColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("status"));

		getColumns().add(nameColumn);
		getColumns().add(statusColumn);
	}

	private void setValues() {
		TreeItem<ModuleTreeItem> rootItem = new TreeItem<>();
		ModuleTreeItem rootModule = new ModuleTreeItem();
		rootModule.setName("Root module");

		for (int i = 0; i < 10; i++) {
			TreeItem<ModuleTreeItem> subItem = new TreeItem<>();
			ModuleTreeItem subModule = new ModuleTreeItem();
			subModule.setName("Sub module" + i);
			subModule.setStatus(ModuleStatus.NEEDS_INIT);
			subItem.setValue(subModule);

			rootItem.getChildren()
					.add(subItem);
		}

		rootItem.setValue(rootModule);

		setRoot(rootItem);
	}

}
