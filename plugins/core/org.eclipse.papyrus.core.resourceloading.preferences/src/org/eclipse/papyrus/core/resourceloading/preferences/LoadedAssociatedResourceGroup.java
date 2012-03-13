package org.eclipse.papyrus.core.resourceloading.preferences;

import org.eclipse.gmf.runtime.common.ui.preferences.CheckBoxFieldEditor;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.papyrus.core.resourceloading.LoadedAssociatedResourceManager;
import org.eclipse.papyrus.core.resourceloading.LoadedAssociatedResourceManager.LoadedAssociatedResource;
import org.eclipse.papyrus.preferences.ui.AbstractGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class LoadedAssociatedResourceGroup extends AbstractGroup {

	public LoadedAssociatedResourceGroup(Composite parent, String key, DialogPage dialogPage) {
		super(parent, key, dialogPage);
		createContent(parent);
	}

	public void createContent(Composite parent) {
		Group group = new Group(parent, SWT.SCROLL_PAGE);
		group.setLayout(new GridLayout());
		group.setText("Automatically load the following associated resources when loading a submodel");

		LoadedAssociatedResourceManager manager = LoadedAssociatedResourceManager.getInstance();
		for (LoadedAssociatedResource loadedAssociatedResource : manager.getLoadedAssociatedResources().values()) {
			CheckBoxFieldEditor fieldEditor = new CheckBoxFieldEditor(
					LoadedAssociatedResourceManager.AUTOLOAD_PREF_PREFIX + loadedAssociatedResource.getFileExtension(),
					loadedAssociatedResource.getDescription(),
					group);
			addFieldEditor(fieldEditor);
		}
	}
}
