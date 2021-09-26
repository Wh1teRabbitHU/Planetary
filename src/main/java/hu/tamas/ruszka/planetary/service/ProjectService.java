package hu.tamas.ruszka.planetary.service;

import static hu.tamas.ruszka.planetary.model.code.ModuleStatus.UNKNOWN;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hu.tamas.ruszka.planetary.gui.component.module.ModuleTreeTableView;
import hu.tamas.ruszka.planetary.model.module.ModuleElement;
import hu.tamas.ruszka.planetary.state.ProjectState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {

	private static final List<String> skippableFolders = Arrays.asList(".terragrunt-cache", ".terraform");
	private static final List<String> moduleFilenames = Arrays.asList("main.tf", "module.hcl");

	private final ProjectState projectState;
	private final ModuleTreeTableView moduleTreeTableView;

	public void changeRootFolder(String rootPath) {
		log.info("Root folder change to: {} ", rootPath);

		projectState.setRootFolderPath(rootPath);

		Set<String> modulePaths = new HashSet<>();
		File rootFolder = new File(rootPath);

		scanForModules(rootFolder, modulePaths);

		if (modulePaths.isEmpty()) {
			log.warn("The given folder has no module files!");

			return;
		}

		modulePaths.forEach(subModule -> log.debug("Module found: {}", subModule));

		ModuleElement rootElement = createModuleTree(rootFolder, modulePaths);

		projectState.setRootElement(rootElement);
		moduleTreeTableView.replaceValues(rootElement);
	}

	private void scanForModules(File file, Set<String> subModules) {
		if (file.isFile()) {
			String fileName = file.getName();
			boolean isModuleFile = moduleFilenames.stream()
												  .anyMatch(name -> name.equals(fileName));

			if (isModuleFile) {
				subModules.add(file.getParentFile()
								   .getAbsolutePath());
			}

			return;
		}

		String folderName = file.getName();
		boolean isSkippable = skippableFolders.stream()
											  .anyMatch(name -> name.equals(folderName));
		File[] subFiles = file.listFiles();

		if (isSkippable || subFiles == null) {
			return;
		}

		for (File children : subFiles) {
			scanForModules(children, subModules);
		}
	}

	private ModuleElement createModuleTree(File rootFolder, Set<String> subModulePaths) {
		boolean isModuleFolder = subModulePaths.stream()
											   .anyMatch(path -> path.equals(rootFolder.getAbsolutePath()));
		ModuleElement moduleElement = new ModuleElement(rootFolder.getName(), isModuleFolder ? UNKNOWN : null);

		File[] subFileArray = rootFolder.listFiles();

		if (subFileArray == null) {
			return moduleElement;
		}

		List<File> subFolders = Arrays.stream(subFileArray)
									  .filter(File::isDirectory)
									  .collect(Collectors.toList());

		for (File subFolder : subFolders) {
			boolean hasModuleFolder = subModulePaths.stream()
													.anyMatch(path -> path.startsWith(subFolder.getAbsolutePath()));

			if (!hasModuleFolder) {
				continue;
			}

			ModuleElement subModuleElement = createModuleTree(subFolder, subModulePaths);

			moduleElement.getChildrens()
						 .add(subModuleElement);
		}

		return moduleElement;
	}

}
