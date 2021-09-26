package hu.tamas.ruszka.planetary.gui.component.module;

import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.tamas.ruszka.planetary.model.code.ModuleStatus;
import hu.tamas.ruszka.planetary.model.module.ModuleElement;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModuleTreeTableView extends TreeTableView<ModuleElement> {

	@PostConstruct
	public void init() {
		setColumns();
		//		setValues();
	}

	public void replaceValues(ModuleElement rootElement) {
		TreeItem<ModuleElement> rootItem = new TreeItem<>(rootElement);

		fillUpTree(rootItem, rootElement.getChildrens());

		setRoot(rootItem);
	}

	private void setColumns() {
		TreeTableColumn<ModuleElement, String> nameColumn = new TreeTableColumn<>("Name");
		TreeTableColumn<ModuleElement, String> statusColumn = new TreeTableColumn<>("Status");

		nameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
		statusColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("status"));

		getColumns().add(nameColumn);
		getColumns().add(statusColumn);
	}

	private void fillUpTree(TreeItem<ModuleElement> rootItem, List<ModuleElement> childrens) {
		childrens.sort(Comparator.comparing(ModuleElement::getName));

		for (ModuleElement element : childrens) {
			TreeItem<ModuleElement> subItem = new TreeItem<>(element);

			fillUpTree(subItem, element.getChildrens());

			rootItem.getChildren()
					.add(subItem);
		}
	}

	private void setValues() {
		TreeItem<ModuleElement> rootItem = new TreeItem<>();
		ModuleElement rootModule = new ModuleElement();
		rootModule.setName("Root module");

		for (int i = 0; i < 10; i++) {
			TreeItem<ModuleElement> subItem = new TreeItem<>();
			ModuleElement subModule = new ModuleElement();
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
