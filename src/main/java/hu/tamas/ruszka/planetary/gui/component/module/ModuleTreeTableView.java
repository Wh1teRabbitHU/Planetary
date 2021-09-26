package hu.tamas.ruszka.planetary.gui.component.module;

import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

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
		nameColumn.setMinWidth(150.0);
		nameColumn.setPrefWidth(250.0);
		statusColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("status"));
		statusColumn.setMinWidth(100.0);
		statusColumn.setPrefWidth(150.0);

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

}
