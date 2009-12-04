/****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.definition.DirectEditorExtensionPoint;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * The file editors page presents the collection of file names and extensions for which the user has
 * registered editors. It also lets the user add new internal or external (program) editors for a
 * given file name and extension.
 * 
 * The user can add an editor for either a specific file name and extension (e.g. report.doc), or
 * for all file names of a given extension (e.g. *.doc)
 * 
 * The set of registered editors is tracked by the EditorRegistery available from the workbench
 * plugin.
 */
public class PapyrusEmbeddedEditorsPreferencePage extends PreferencePage implements IWorkbenchPreferencePage, Listener {

	protected static final String DEFAULT_EDITOR_LABEL = " (Default Editor)";

	private static final String DATA_EDITOR = "editor"; //$NON-NLS-1$

	protected Table elementTypeTable;

	protected Table editorTable;

	protected Button defaultEditorButton;

	protected Label editorLabel;

	protected IWorkbench workbench;

	protected List<Image> imagesToDispose;

	protected Map<IEditorDescriptor, Image> editorsToImages;

	/**
	 * Creates the page's UI content.
	 */
	@Override
	protected Control createContents(Composite parent) {
		imagesToDispose = new ArrayList<Image>();
		editorsToImages = new HashMap<IEditorDescriptor, Image>(50);

		// define container & its layout
		Composite pageComponent = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		pageComponent.setLayout(layout);
		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		pageComponent.setLayoutData(data);

		// layout the contents

		// layout the top table & its buttons
		Label label = new Label(pageComponent, SWT.LEFT);
		label.setText("Elements to edit");
		data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.horizontalSpan = 2;
		label.setLayoutData(data);

		elementTypeTable = new Table(pageComponent, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		elementTypeTable.addListener(SWT.Selection, this);
		elementTypeTable.addListener(SWT.DefaultSelection, this);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalAlignment = GridData.FILL;
		data.heightHint = elementTypeTable.getItemHeight() * 10; // ten lines
		// shown
		elementTypeTable.setLayoutData(data);

		Composite groupComponent = new Composite(pageComponent, SWT.NULL);
		GridLayout groupLayout = new GridLayout();
		groupLayout.marginWidth = 0;
		groupLayout.marginHeight = 0;
		groupComponent.setLayout(groupLayout);
		data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		groupComponent.setLayoutData(data);

		// Spacer
		label = new Label(pageComponent, SWT.LEFT);
		data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.horizontalSpan = 2;
		label.setLayoutData(data);

		// layout the bottom table & its buttons
		editorLabel = new Label(pageComponent, SWT.LEFT);
		editorLabel.setText("Associated editor");
		data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.horizontalSpan = 2;
		editorLabel.setLayoutData(data);

		editorTable = new Table(pageComponent, SWT.SINGLE | SWT.BORDER);
		editorTable.addListener(SWT.Selection, this);
		editorTable.addListener(SWT.DefaultSelection, this);
		data = new GridData(GridData.FILL_BOTH);
		data.heightHint = editorTable.getItemHeight() * 7;
		editorTable.setLayoutData(data);

		groupComponent = new Composite(pageComponent, SWT.NULL);
		groupLayout = new GridLayout();
		groupLayout.marginWidth = 0;
		groupLayout.marginHeight = 0;
		groupComponent.setLayout(groupLayout);
		data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		groupComponent.setLayoutData(data);

		// upEditorButton = new Button(groupComponent, SWT.PUSH);
		// upEditorButton.setText("Up");
		// upEditorButton.addListener(SWT.Selection, this);
		// upEditorButton.setLayoutData(data);
		// setButtonLayoutData(upEditorButton);
		//
		// downEditorButton = new Button(groupComponent, SWT.PUSH);
		// downEditorButton.setText("Down");
		// downEditorButton.addListener(SWT.Selection, this);
		// setButtonLayoutData(downEditorButton);

		defaultEditorButton = new Button(groupComponent, SWT.PUSH);
		defaultEditorButton.setText("Default");
		defaultEditorButton.addListener(SWT.Selection, this);
		setButtonLayoutData(defaultEditorButton);

		fillResourceTypeTable();
		if(elementTypeTable.getItemCount() > 0) {
			elementTypeTable.setSelection(0);
		}
		fillEditorTable();
		updateEnabledState();

		applyDialogFont(pageComponent);

		return pageComponent;
	}

	/**
	 * The preference page is going to be disposed. So deallocate all allocated SWT resources that
	 * aren't disposed automatically by disposing the page (i.e fonts, cursors, etc). Subclasses
	 * should reimplement this method to release their own allocated SWT resources.
	 */
	@Override
	public void dispose() {
		super.dispose();
		if(imagesToDispose != null) {
			for(Image image2 : imagesToDispose) {
				image2.dispose();
			}
			imagesToDispose = null;
		}
		if(editorsToImages != null) {
			for(Image image2 : editorsToImages.values()) {
				image2.dispose();
			}
			editorsToImages = null;
		}
	}

	/**
	 * Hook method to get a page specific preference store. Reimplement this method if a page don't
	 * want to use its parent's preference store.
	 */
	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	protected void fillEditorTable() {
		editorTable.removeAll();

		String elementType = getSelectedElementType();
		String preferedLanguage = getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + elementType);
		boolean simpleEditorPrefered = IDirectEditorsIds.SIMPLE_DIRECT_EDITOR.equals(preferedLanguage);

		List<DirectEditorExtensionPoint> editors = getAssociatedEditors();
		for(DirectEditorExtensionPoint extensionPoint : editors) {
			TableItem item = new TableItem(editorTable, SWT.NULL);
			item.setData(DATA_EDITOR, extensionPoint);
			// retrieves if this editor is the default one or not.
			String label = getEditorItemName(extensionPoint);
			if(preferedLanguage.equals(extensionPoint.getLanguage())) {
				label += DEFAULT_EDITOR_LABEL;
			}
			item.setText(label);
		}

		// must had basic editor (direct edit)
		TableItem item = new TableItem(editorTable, SWT.NULL);
		item.setData(DATA_EDITOR, null);
		item.setText(simpleEditorPrefered ? getEditorItemName(null) + DEFAULT_EDITOR_LABEL : getEditorItemName(null));
	}

	/**
	 * Retrieves the {@link TableItem} name
	 * 
	 * @param extensionPoint
	 *        the extension point associated to this item
	 * @return the name of the item
	 */
	public String getEditorItemName(DirectEditorExtensionPoint extensionPoint) {
		if(extensionPoint == null) {
			return IDirectEditorsIds.SIMPLE_DIRECT_EDITOR;
		} else {
			return extensionPoint.getLanguage();
		}
	}

	/**
	 * Place the existing resource types in the table
	 */
	protected void fillResourceTypeTable() {
		Map<String, List<DirectEditorExtensionPoint>> elements = new HashMap<String, List<DirectEditorExtensionPoint>>();

		// Populate the table with the items
		DirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getDirectEditorConfigurations();
		List<DirectEditorExtensionPoint> configurations;
		for(DirectEditorExtensionPoint extensionPoint : extensionPoints) {
			if(!elements.containsKey(extensionPoint.getObjectToEdit())) {
				// no configuration yet for this element.
				configurations = new ArrayList<DirectEditorExtensionPoint>();
			} else {
				configurations = elements.get(extensionPoint.getObjectToEdit());
			}
			configurations.add(extensionPoint);
			// replace configuration list
			elements.put(extensionPoint.getObjectToEdit(), configurations);
		}

		Set<String> keys = elements.keySet();
		int i = 0;
		for(String key : keys) {
			newElementTypeTableItem(elements.get(key), i, false);
			i++;
		}

		// IFileEditorMapping[] array = WorkbenchPlugin.getDefault()
		// .getEditorRegistry().getFileEditorMappings();
		// for (int i = 0; i < array.length; i++) {
		// FileEditorMapping mapping = (FileEditorMapping) array[i];
		// mapping = (FileEditorMapping) mapping.clone(); // want a copy
		// newResourceTableItem(mapping, i, false);
		// }
	}

	/**
	 * Returns the image associated with the given editor.
	 */
	// @unused
	protected Image getImage(IEditorDescriptor editor) {
		Image image = editorsToImages.get(editor);
		if(image == null) {
			image = editor.getImageDescriptor().createImage();
			editorsToImages.put(editor, image);
		}
		return image;
	}

	protected String getSelectedElementType() {
		TableItem[] items = elementTypeTable.getSelection();
		if(items.length > 0) {
			return items[0].getText(); // Table is single select
		}
		return null;
	}

	/**
	 * Returns all {@link DirectEditorExtensionPoint} for the current selected element type
	 * 
	 * @return all {@link DirectEditorExtensionPoint} for the current selected element type or <code>null</code.
	 */
	@SuppressWarnings("unchecked")
	protected List<DirectEditorExtensionPoint> getAssociatedEditors() {
		if(getSelectedElementType() == null) {
			return null;
		}
		TableItem[] items = elementTypeTable.getSelection();
		if(items.length > 0) {
			return (List<DirectEditorExtensionPoint>)items[0].getData();
		}
		return null;
	}

	public void handleEvent(Event event) {
		/*
		 * if (event.widget == upEditorButton) { promptForEditor(); } else if (event.widget ==
		 * downEditorButton) { removeSelectedEditor(); } else
		 */if(event.widget == defaultEditorButton) {
			setSelectedEditorAsDefault();
		} else if(event.widget == elementTypeTable) {
			fillEditorTable();
		}

		updateEnabledState();

	}

	/**
	 * @see IWorkbenchPreferencePage
	 */
	public void init(IWorkbench aWorkbench) {
		this.workbench = aWorkbench;
		noDefaultAndApplyButton();
	}

	/**
	 * Create a new <code>TableItem</code> to represent the element type supplied.
	 */
	protected TableItem newElementTypeTableItem(List<DirectEditorExtensionPoint> configurations, int index,
			boolean selected) {
		TableItem item = new TableItem(elementTypeTable, SWT.NULL, index);
		item.setText(configurations.get(0).getObjectToEdit());
		item.setData(configurations);
		if(selected) {
			elementTypeTable.setSelection(index);
		}
		return item;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performOk() {
		return super.performOk();

		// TableItem[] items = elementTypeTable.getItems();
		// FileEditorMapping[] resourceTypes = new
		// FileEditorMapping[items.length];
		// for (int i = 0; i < items.length; i++) {
		// resourceTypes[i] = (FileEditorMapping) (items[i].getData());
		// }
		// EditorRegistry registry = (EditorRegistry)
		// WorkbenchPlugin.getDefault()
		// .getEditorRegistry(); // cast to allow save to be called
		// registry.setFileEditorMappings(resourceTypes);
		// registry.saveAssociations();
		//        
		// PrefUtil.savePrefs();
		// return true;
	}

	/**
	 * Add the selected editor to the default list.
	 */
	public void setSelectedEditorAsDefault() {
		TableItem[] items = editorTable.getItems();
		for(TableItem item : items) {
			if(item.getText().endsWith(DEFAULT_EDITOR_LABEL)) {
				DirectEditorExtensionPoint oldExtensionPoint = (DirectEditorExtensionPoint)item.getData(DATA_EDITOR);
				// no configuration associated => standard editor
				item.setText((oldExtensionPoint != null) ? oldExtensionPoint.getLanguage()
						: IDirectEditorsIds.SIMPLE_DIRECT_EDITOR);
			}
		}
		TableItem[] selectedItems = editorTable.getSelection();
		if(selectedItems.length > 0) {
			// First change the label of the old default
			// Now set the new default
			DirectEditorExtensionPoint extensionPoint = (DirectEditorExtensionPoint)selectedItems[0]
					.getData(DATA_EDITOR);
			selectedItems[0].setText(selectedItems[0].getText() + DEFAULT_EDITOR_LABEL);

			// retrieve current object to edit name
			getPreferenceStore().setValue(IDirectEditorsIds.EDITOR_FOR_ELEMENT + getSelectedElementType(),
					(extensionPoint != null) ? extensionPoint.getLanguage() : IDirectEditorsIds.SIMPLE_DIRECT_EDITOR);
		}
	}

	/**
	 * Retrieves the table item that corresponds to the default editor
	 * 
	 * @return the {@link TableItem} that corresponds to the default editor
	 */
	// @unused
	public TableItem getDefaultItem() {
		return null;
	}

	/**
	 * Update the enabled state.
	 */
	public void updateEnabledState() {
		// Update enabled state
		boolean resourceTypeSelected = elementTypeTable.getSelectionIndex() != -1;
		boolean editorSelected = editorTable.getSelectionIndex() != -1;

		editorLabel.setEnabled(resourceTypeSelected);
		// upEditorButton.setEnabled(resourceTypeSelected);
		// downEditorButton.setEnabled(editorSelected);
		defaultEditorButton.setEnabled(editorSelected);
	}

	/**
	 * Update the selected type.
	 */
	// @unused
	public void updateSelectedResourceType() {
		// TableItem item = resourceTypeTable.getSelection()[0]; //Single select
		// Image image =
		// ((IFileEditorMapping)item.getData()).getImageDescriptor().getImage();
		// imagesToDispose.addElement(image);
		// item.setImage(image);
	}
}
