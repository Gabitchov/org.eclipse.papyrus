/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.customization.dialog;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.properties.tabbed.customization.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


/**
 * Creates the page for the selection of the xml file to be edited.
 * <p>
 * This page should display three choices:
 * <ul>
 * <li>Create a new one from scratch</li>
 * <li>Create a new one, based on a exiting one</li>
 * <li>Modify an existing one</li>
 * </ul>
 * </p>
 */
public class SelectConfigurationFileWizardPage extends WizardPage {

	/** selection listener for the radio buttons */
	protected SelectionListener selectionListener = new RadioSelectionListener();

	/** map of buttons to know which area should be selected or not */
	protected Map<Button, IConfigurationArea> radioButtonsMapping = new HashMap<Button, IConfigurationArea>();

	/** filter for file selection dialogs */
	protected ViewerFilter fileViewerFilter = new XMLFileViewerFilter();

	/** content area for the create from scratch */
	protected CreateFromScratchArea createFromScratchArea = new CreateFromScratchArea();

	/** content area for the create from exiting configuration */
	protected CreateFromExistingConfigurationArea createFromExistingConfigurationArea = new CreateFromExistingConfigurationArea();

	/** content area for the modify exiting configuration */
	protected ModifyExistingConfigurationArea modifyExistingConfigurationArea = new ModifyExistingConfigurationArea();

	/**
	 * Creates a new SelectConfigurationFileWizardPage.
	 */
	protected SelectConfigurationFileWizardPage() {
		super(Messages.SelectConfigurationFileWizardPage_PageName, Messages.SelectConfigurationFileWizardPage_Title, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridData data = new GridData(SWT.FILL, SWT.TOP, true, true);
		composite.setLayoutData(data);
		GridLayout layout = new GridLayout(2, false);
		// layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		composite.setLayout(layout);
		// sets the new control
		setControl(composite);

		// creates the content
		createContentArea(composite);
	}

	/**
	 * creates the content area for this wizard page
	 * 
	 * @param composite
	 *        the parent composite for the created composites in the content area
	 */
	protected void createContentArea(Composite composite) {

		Group group = new Group(composite, SWT.NONE);
		group.setText("Source");
		GridLayout layout = new GridLayout(1, false);
		group.setLayout(layout);
		GridData groupData = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		group.setLayoutData(groupData);

		// create content for the group
		createFromScratchArea = new CreateFromScratchArea();
		createFromScratchArea.createContent(group);

		createFromExistingConfigurationArea = new CreateFromExistingConfigurationArea();
		createFromExistingConfigurationArea.createContent(group);

		modifyExistingConfigurationArea = new ModifyExistingConfigurationArea();
		modifyExistingConfigurationArea.createContent(group);

		// create a new one by default
		enableConfigurationArea(createFromScratchArea);
	}

	/**
	 * Notifies that one of the radio button has been selected
	 * 
	 * @param e
	 *        selection event that triggers this method
	 */
	protected void notifyButtonChanged(SelectionEvent e) {
		// enable the right one
		if(e.widget != null) {
			IConfigurationArea enabledConfigurationArea = radioButtonsMapping.get(e.widget);
			if(enabledConfigurationArea != null) {
				enableConfigurationArea(enabledConfigurationArea);
			} else {
				Activator.log.warn("impossible to find the area for the widget " + e);
			}
		}
	}

	/**
	 * Enables the specified area
	 * 
	 * @param areaToEnable
	 *        the area to enable
	 */
	protected void enableConfigurationArea(IConfigurationArea areaToEnable) {
		// disable all area, then enables only the right one
		for(IConfigurationArea area : radioButtonsMapping.values()) {
			area.setEnable(false);
		}
		areaToEnable.setEnable(true);
	}

	/**
	 * Checks if the specified control is valid.
	 * 
	 * @param control
	 *        the control to check
	 * @return <code>true</code> if the control is valid, i.e. not <code>null</code> and not disposed.
	 */
	protected boolean isValid(Control control) {
		return (control != null && !control.isDisposed());
	}

	/**
	 * Listener added to the radio buttons.
	 */
	protected class RadioSelectionListener implements SelectionListener {

		/**
		 * {@inheritDoc}
		 */
		public void widgetSelected(SelectionEvent e) {
			// action taken as soon as a button as been pressed
			notifyButtonChanged(e);
		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do here
		}
	}

	/**
	 * Viewer filter for selection dialog, displaying only xml files
	 */
	protected class XMLFileViewerFilter extends ViewerFilter {

		/**
		 * {@inheritDoc}
		 */
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if(element instanceof IFile) {
				IFile file = (IFile)element;
				return "xml".equals(file.getFileExtension());
			}
			return true;
		}
	}

	/**
	 * Interface for all configuration areas
	 */
	protected interface IConfigurationArea {

		/**
		 * Enables the elements on the area, given the specified enablement state
		 * 
		 * @param enable
		 *        the enablement state for the elements in the composite
		 */
		public void setEnable(boolean enable);

		/**
		 * Creates the content of the area
		 * 
		 * @param parent
		 *        the parent composite where content must be added
		 * @return the composite created
		 */
		public Composite createContent(Composite parent);
	}

	/**
	 * Interface for a configuration area that allows to enter a new name
	 */
	protected interface INameConfigurationArea extends IConfigurationArea {

		/**
		 * Returns the new name for the configuration
		 * 
		 * @return the new name for the configuration
		 */
		public String getNewName();
	}

	/**
	 * abstract implementation for the name configuration area interface
	 */
	protected abstract class AbstractNameConfigurationArea implements INameConfigurationArea {

		/** text area to enter the name of the new configuration */
		protected Text nameText;

		/**
		 * {@inheritDoc}
		 */
		public String getNewName() {
			if(isValid(nameText)) {
				return nameText.getText();
			}
			String generatedName = "Config" + System.currentTimeMillis();
			// generate a default name
			Activator.log.warn("the text area for the new name was disposed or null. A default name has been generated: " + generatedName);
			return generatedName;
		}
	}

	/**
	 * Area for the "create a new empty configuration" in the dialog
	 */
	protected class CreateFromScratchArea extends AbstractNameConfigurationArea {

		/** Button used to create an empty configuration */
		protected Button createFromScratchButton;

		/**
		 * {@inheritDoc}
		 */
		public void setEnable(boolean enable) {
			if(isValid(createFromScratchButton)) {
				createFromScratchButton.setSelection(enable);
				nameText.setEnabled(enable);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public Composite createContent(Composite parent) {
			// main container with a border
			Composite createFromScratchComposite = new Composite(parent, SWT.BORDER);
			createFromScratchComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			createFromScratchComposite.setLayout(new GridLayout(4, false));

			// first line: selection line (radio button + label)
			createFromScratchButton = new Button(createFromScratchComposite, SWT.RADIO);
			createFromScratchButton.addSelectionListener(selectionListener);
			radioButtonsMapping.put(createFromScratchButton, this);
			Label createFromScratchLabel = new Label(createFromScratchComposite, SWT.NONE);
			createFromScratchLabel.setText("Create an empty configuration");
			GridData labelData = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);
			createFromScratchLabel.setLayoutData(labelData);

			// second line: name of the new configuration
			Label nameLabel = new Label(createFromScratchComposite, SWT.NONE);
			nameLabel.setText("Name:");
			nameLabel.setToolTipText("Enter here the name of the new configuration");
			labelData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
			nameLabel.setLayoutData(labelData);

			nameText = new Text(createFromScratchComposite, SWT.BORDER);
			nameText.setText("newConfiguration");
			GridData textData = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
			nameText.setLayoutData(textData);

			return createFromScratchComposite;
		}

	}

	/**
	 * Area for the "create from existing configuration" in the dialog
	 */
	protected class CreateFromExistingConfigurationArea extends AbstractNameConfigurationArea {

		/** Button used to initialize the xml file from an existing one */
		protected Button createFromExistingConfigurationButton;

		/** button that opens dialog to select configuration to copy and modify */
		protected Button createFromExistingConfigurationSelectionButton;

		/** text area that display the name of the configuration file to copy and modify */
		protected Text createFromExistingConfigurationText;

		/**
		 * {@inheritDoc}
		 */
		public Composite createContent(Composite parent) {
			// create from an existing configuration composite
			Composite mainComposite = new Composite(parent, SWT.BORDER);
			mainComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
			mainComposite.setLayout(new GridLayout(4, false));

			// first line: radio button + label
			createFromExistingConfigurationButton = new Button(mainComposite, SWT.RADIO);
			createFromExistingConfigurationButton.addSelectionListener(selectionListener);
			radioButtonsMapping.put(createFromExistingConfigurationButton, this);
			Label createFromExistingConfigurationLabel = new Label(mainComposite, SWT.NONE);
			createFromExistingConfigurationLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
			createFromExistingConfigurationLabel.setText(Messages.SelectConfigurationFileWizardPage_CreateFromExistingConfiguration_Label);

			// second line: browser to select existing configuration
			Label createFromExistingConfigurationExistingLabel = new Label(mainComposite, SWT.NONE);
			createFromExistingConfigurationExistingLabel.setText("File:");
			createFromExistingConfigurationExistingLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
			createFromExistingConfigurationText = new Text(mainComposite, SWT.BORDER | SWT.READ_ONLY);
			createFromExistingConfigurationText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			createFromExistingConfigurationSelectionButton = new Button(mainComposite, SWT.NONE);
			createFromExistingConfigurationSelectionButton.addSelectionListener(new SelectionListener() {

				/**
				 * {@inheritDoc}
				 */
				public void widgetSelected(SelectionEvent e) {
					// open a workspace dialog to choose the exiting configuration to update
					IFile[] selectedFiles = WorkspaceResourceDialog.openFileSelection(getShell(), "Select the current configuration", "Please select an existing property view configuration.", false, new Object[0], Collections.singletonList(fileViewerFilter));
					if(selectedFiles != null && selectedFiles.length == 1) {
						IFile selectedFile = selectedFiles[0];
						createFromExistingConfigurationText.setText(selectedFile.getFullPath().toString());
					}
				}

				/**
				 * {@inheritDoc}
				 */
				public void widgetDefaultSelected(SelectionEvent e) {
					// nothing to do here
				}
			});
			createFromExistingConfigurationSelectionButton.setText(Messages.SelectConfigurationFileWizardPage_CreateFromExistingConfigurationSelectionButton_Label);

			// third line: name of the new configuration
			Label nameLabel = new Label(mainComposite, SWT.NONE);
			nameLabel.setText("Name:");
			nameLabel.setToolTipText("Enter here the name of the new configuration");
			GridData labelData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
			nameLabel.setLayoutData(labelData);

			nameText = new Text(mainComposite, SWT.BORDER);
			nameText.setText("newConfiguration");
			GridData textData = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
			nameText.setLayoutData(textData);
			return mainComposite;
		}

		/**
		 * {@inheritDoc}
		 */
		public void setEnable(boolean enable) {
			if(isValid(createFromExistingConfigurationButton)) {
				createFromExistingConfigurationButton.setSelection(enable);
				createFromExistingConfigurationSelectionButton.setEnabled(enable);
				createFromExistingConfigurationText.setEnabled(enable);
				nameText.setEnabled(enable);
			}
		}

	}

	/**
	 * Area for the "modify an existing configuration" in the dialog
	 */
	public class ModifyExistingConfigurationArea implements IConfigurationArea {

		/** text area that display the name of the configuration file to modify */
		protected Text modifyExistingConfigurationText;

		/** button that opens dialog to select configuration to modify */
		protected Button modifyExistingConfigurationSelectionButton;

		/** Button used to modify an existing configuration */
		protected Button modifyExistingConfigurationButton;

		/**
		 * {@inheritDoc}
		 */
		public void setEnable(boolean enable) {
			if(isValid(modifyExistingConfigurationButton)) {
				modifyExistingConfigurationButton.setSelection(enable);
				modifyExistingConfigurationText.setEnabled(enable);
				modifyExistingConfigurationSelectionButton.setEnabled(enable);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public Composite createContent(Composite parent) {
			// modify an existing configuration composite
			Composite modifyExistingConfigurationComposite = new Composite(parent, SWT.BORDER);
			modifyExistingConfigurationComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
			modifyExistingConfigurationComposite.setLayout(new GridLayout(3, false));
			modifyExistingConfigurationButton = new Button(modifyExistingConfigurationComposite, SWT.RADIO);
			modifyExistingConfigurationButton.addSelectionListener(selectionListener);
			radioButtonsMapping.put(modifyExistingConfigurationButton, this);
			Label modifyExistingConfigurationLabel = new Label(modifyExistingConfigurationComposite, SWT.NONE);
			modifyExistingConfigurationLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
			modifyExistingConfigurationLabel.setText(Messages.SelectConfigurationFileWizardPage_ModifyExistingConfiguration_Label);
			modifyExistingConfigurationText = new Text(modifyExistingConfigurationComposite, SWT.BORDER | SWT.READ_ONLY);
			modifyExistingConfigurationText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
			modifyExistingConfigurationSelectionButton = new Button(modifyExistingConfigurationComposite, SWT.NONE);
			modifyExistingConfigurationSelectionButton.setText(Messages.SelectConfigurationFileWizardPage_ModifyExistingConfigurationSelectionButton_Label);
			modifyExistingConfigurationSelectionButton.addSelectionListener(new SelectionListener() {

				/**
				 * {@inheritDoc}
				 */
				public void widgetSelected(SelectionEvent e) {
					// open a workspace dialog to choose the exiting configuration to update
					IFile[] selectedFiles = WorkspaceResourceDialog.openFileSelection(getShell(), "Select the current configuration", "Please select an existing property view configuration.", false, new Object[0], Collections.singletonList(fileViewerFilter));
					if(selectedFiles != null && selectedFiles.length == 1) {
						IFile selectedFile = selectedFiles[0];
						modifyExistingConfigurationText.setText(selectedFile.getFullPath().toString());
					}
				}

				/**
				 * {@inheritDoc}
				 */
				public void widgetDefaultSelected(SelectionEvent e) {
					// nothing to do here
				}
			});
			return modifyExistingConfigurationComposite;
		}
	}
}
