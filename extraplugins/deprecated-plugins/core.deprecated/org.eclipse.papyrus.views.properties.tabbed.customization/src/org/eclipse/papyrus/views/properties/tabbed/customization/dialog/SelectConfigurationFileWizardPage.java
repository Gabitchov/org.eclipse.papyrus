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
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.views.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.views.properties.runtime.view.PropertyViewService.ProviderDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.XMLPropertyTabViewProvider;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.views.properties.tabbed.customization.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


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

	/** content area for the modify plugin contribution */
	protected ModifyPluginConfigurationArea modifyPluginConfigurationArea = new ModifyPluginConfigurationArea();

	/** file where to serialize configuration */
	protected File file;

	/** empty string */
	protected static final String EMPTY_STRING = ""; //$NON-NLS-1$

	/** next page to be displayed */
	protected IWizardPage nextPage;

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

		Group userGroup = new Group(composite, SWT.NONE);
		userGroup.setText(Messages.SelectConfigurationFileWizardPage_UserGroup_Label);
		userGroup.setLayout(new GridLayout(1, false));
		userGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		modifyPluginConfigurationArea = new ModifyPluginConfigurationArea();
		modifyPluginConfigurationArea.createContent(userGroup);

		Group devGroup = new Group(composite, SWT.NONE);
		devGroup.setText(Messages.SelectConfigurationFileWizardPage_SourceGroup_Label);
		GridLayout layout = new GridLayout(1, false);
		devGroup.setLayout(layout);
		GridData groupData = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		devGroup.setLayoutData(groupData);

		// create content for the group
		createFromScratchArea = new CreateFromScratchArea();
		createFromScratchArea.createContent(devGroup);

		createFromExistingConfigurationArea = new CreateFromExistingConfigurationArea();
		createFromExistingConfigurationArea.createContent(devGroup);

		modifyExistingConfigurationArea = new ModifyExistingConfigurationArea();
		modifyExistingConfigurationArea.createContent(devGroup);

		// create a new one by default
		enableConfigurationArea(modifyPluginConfigurationArea);
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
				Activator.log.warn(Messages.SelectConfigurationFileWizardPage_Error_NoAreaForWidget + e);
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
		areaToEnable.validatePage();
	}

	/**
	 * Returns the current selected configuration area
	 * 
	 * @return the current selected configuration area
	 */
	protected IConfigurationArea getEnableConfigurationArea() {
		for(Button button : radioButtonsMapping.keySet()) {
			if(button.getSelection()) {
				return radioButtonsMapping.get(button);
			}
		}
		return null;
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
	 * {@inheritDoc}
	 */
	@Override
	public IWizardPage getNextPage() {
		if(getWizard() instanceof CustomizePropertyViewWizard) {

			BusyIndicator.showWhile(getShell().getDisplay(), new Runnable() {

				public void run() {
					CustomizeContentWizardPage newPage = ((CustomizePropertyViewWizard)getWizard()).customizeContentPage;
					// newPage.setInitialContent();
					Document initialDocument = getEnableConfigurationArea().generateInitialContent();
					newPage.setInitialContent(initialDocument);
					file = getEnableConfigurationArea().getNewFile();
					newPage.setNewFile(file);
					setNextPage(newPage);
				}
			});
			return nextPage;
		}
		return null;
	}

	/**
	 * Sets the next page
	 * 
	 * @param page
	 *        the next page to set
	 */
	protected void setNextPage(IWizardPage page) {
		this.nextPage = page;
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

		/** XML file extension */
		protected static final String XML_FILE_EXTENSION = "xml"; //$NON-NLS-1$

		/**
		 * {@inheritDoc}
		 */
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if(element instanceof IFile) {
				IFile file = (IFile)element;
				return XML_FILE_EXTENSION.equals(file.getFileExtension());
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
		 * Indicates if the page is complete and the user can go to the next page
		 */
		public void validatePage();

		/**
		 * Generates the initial content from the given configuration
		 * 
		 * @return the initial content passed to the second page
		 */
		public Document generateInitialContent();

		/**
		 * Creates the content of the area
		 * 
		 * @param parent
		 *        the parent composite where content must be added
		 * @return the composite created
		 */
		public Composite createContent(Composite parent);

		/**
		 * Returns the new file where the content will be serialized
		 * 
		 * @return the new file where the content will be serialized
		 */
		public File getNewFile();

		/**
		 * 
		 */
		public void performPostSerializationAction();
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
			String generatedName = Messages.bind(Messages.SelectConfigurationFileWizardPage_DefaultConfigurationName, System.currentTimeMillis());
			// generate a default name
			Activator.log.warn(Messages.bind(Messages.SelectConfigurationFileWizardPage_ErrorMessage_NoValidTextArea, generatedName));
			return generatedName;
		}

		/**
		 * {@inheritDoc}
		 */
		public void validatePage() {
			if(nameText.getText() == null || nameText.getText().equals(EMPTY_STRING)) {
				setPageComplete(false);
				setMessage(Messages.SelectConfigurationFileWizardPage_ErrorMessage_notValidName, ERROR);
			} else {
				setPageComplete(true);
				setMessage(EMPTY_STRING, NONE);
			}

		}
	}

	/**
	 * Area for the "create a new empty configuration" in the dialog
	 */
	protected class CreateFromScratchArea extends AbstractNameConfigurationArea {

		/** Button used to create an empty configuration */
		protected Button createFromScratchButton;

		/** text used to enter the plugin id required to load classes on runtime */
		protected Text pluginIdText;

		/** text that contais the location of the new file, workspace root-relative */
		protected Text folderText;

		/** button that open a workspce folder selection dialog */
		protected Button folderButton;

		/**
		 * {@inheritDoc}
		 */
		public void setEnable(boolean enable) {
			if(isValid(createFromScratchButton)) {
				createFromScratchButton.setSelection(enable);
				nameText.setEnabled(enable);
				pluginIdText.setEnabled(enable);
				folderButton.setEnabled(enable);
				if(enable) {
					nameText.selectAll();
					nameText.setFocus();
				}
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
			createFromScratchLabel.setText(Messages.SelectConfigurationFileWizardPage_CreateAnEmptyConfig_Label);
			GridData labelData = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);
			createFromScratchLabel.setLayoutData(labelData);

			// second line: name of the new configuration
			Label nameLabel = new Label(createFromScratchComposite, SWT.NONE);
			nameLabel.setText(Messages.SelectConfigurationFileWizardPage_CreateAnEmptyConfigName_Label);
			nameLabel.setToolTipText(Messages.SelectConfigurationFileWizardPage_CreateAnEmptyConfigName_Tooltip);
			labelData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
			nameLabel.setLayoutData(labelData);

			nameText = new Text(createFromScratchComposite, SWT.BORDER);
			nameText.setText(Messages.SelectConfigurationFileWizardPage_CreateAnEmptyConfigName_DefaultValue);
			GridData textData = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
			nameText.setLayoutData(textData);
			nameText.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent e) {
					validatePage();
				}
			});

			// third line: plugin required to load classes
			Label pluginIdLabel = new Label(createFromScratchComposite, SWT.NONE);
			pluginIdLabel.setText(Messages.SelectConfigurationFileWizardPage_CreateAnEmptyConfigPluginId_Label);
			pluginIdLabel.setToolTipText(Messages.SelectConfigurationFileWizardPage_CreateAnEmptyConfigPluginId_Tooltip);
			labelData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
			pluginIdLabel.setLayoutData(labelData);

			pluginIdText = new Text(createFromScratchComposite, SWT.BORDER);
			pluginIdText.setText(Messages.SelectConfigurationFileWizardPage_CreateAnEmptyConfigPluginId_DefaultValue);
			pluginIdText.setLayoutData(textData);
			pluginIdText.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent e) {
					validatePage();
				}
			});

			// 4th line: folder where to create the new file
			Label folderLabel = new Label(createFromScratchComposite, SWT.NONE);
			folderLabel.setText("Folder:");
			folderLabel.setToolTipText("Select the folder where you want to create the new file");
			labelData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
			folderLabel.setLayoutData(labelData);

			folderText = new Text(createFromScratchComposite, SWT.BORDER);
			folderText.setText("");
			folderText.setEditable(false);
			textData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
			folderText.setLayoutData(textData);

			folderButton = new Button(createFromScratchComposite, SWT.NONE);
			folderButton.setText("Select...");
			folderButton.addSelectionListener(new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					ContainerSelectionDialog selectionDialog = new ContainerSelectionDialog(getShell(), null, true, "Select the container where the file will be created");
					if(Dialog.OK == selectionDialog.open()) {
						Object[] result = selectionDialog.getResult();
						if(result.length < 1) {
							Activator.log.error("no container was selected in the dialog", null);
							return;
						}

						Object container = result[0];
						if(container instanceof Path) {
							Path path = (Path)container;
							folderText.setText(path.toString());
						}


						validatePage();
					}
				}

				public void widgetDefaultSelected(SelectionEvent e) {

				}
			});

			return createFromScratchComposite;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getPluginId() {
			if(isValid(pluginIdText)) {
				return pluginIdText.getText();
			}
			Activator.log.error("impossible to read plugin Id from the text area", null);
			return "";
		}

		/**
		 * {@inheritDoc}
		 */
		public File getNewFile() {
			// retrieve the folder where to create the file
			IPath path = new Path(folderText.getText());
			IContainer iContainer = (IContainer)ResourcesPlugin.getWorkspace().getRoot().findMember(path);
			if(iContainer.exists()) {
				IPath location = iContainer.getLocation();
				File file = location.append(Character.toString(IPath.SEPARATOR)).append(nameText.getText()).addFileExtension("xml").toFile();
				return file;
			}
			Activator.log.warn("should never enter here");
			File file = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().append(folderText.getText()).append(Character.toString(IPath.SEPARATOR)).append(nameText.getText()).addFileExtension("xml").toFile();
			return file;
		}

		/**
		 * {@inheritDoc}
		 */
		public Document generateInitialContent() {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			DocumentBuilder documentBuilder;
			try {
				documentBuilder = documentBuilderFactory.newDocumentBuilder();
				Document document = documentBuilder.newDocument();
				Comment comment = document.createComment(Messages.bind(Messages.SelectConfigurationFileWizardPage_EmptyDocument_InitialComment, Calendar.getInstance().getTime()));
				document.appendChild(comment);
				// FIXME change with an interface constant
				Element rootNode = document.createElement("propertyTabView");// $NON-NLS-1$
				rootNode.setAttribute("pluginId", pluginIdText.getText()); // $NON-NLS-1$
				document.appendChild(rootNode);
				document.normalizeDocument();
				return document;
			} catch (ParserConfigurationException e) {
				Activator.log.error(e);
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public void validatePage() {
			if(isValid(nameText)) {
				if(pluginIdText.getText() == null || pluginIdText.getText().equals(EMPTY_STRING)) {
					setPageComplete(false);
					setMessage(Messages.SelectConfigurationFileWizardPage_ErrorMessage_NoValidPluginIdentifier, ERROR);
				} else if(folderText.getText() == null || folderText.getText().equals(EMPTY_STRING)) {
					setPageComplete(false);
					setMessage("Please select a valid folder", ERROR);
				} else {
					super.validatePage();
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void performPostSerializationAction() {
			// nothing here
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

		/** text that contais the location of the new file, workspace root-relative */
		protected Text folderText;

		/** button that open a workspce folder selection dialog */
		protected Button folderButton;

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
			createFromExistingConfigurationExistingLabel.setText(Messages.SelectConfigurationFileWizardPage_CreateFromExistingConfigFile_Label);
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
					IFile[] selectedFiles = WorkspaceResourceDialog.openFileSelection(getShell(), Messages.SelectConfigurationFileWizardPage_CreateFromExistingConfigFile_Dialog_Title, Messages.SelectConfigurationFileWizardPage_CreateFromExistingConfigFile_Dialog_Message, false, new Object[0], Collections.singletonList(fileViewerFilter));
					if(selectedFiles != null && selectedFiles.length == 1) {
						IFile selectedFile = selectedFiles[0];
						createFromExistingConfigurationText.setText(selectedFile.getFullPath().toString());
						validatePage();
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
			nameLabel.setText(Messages.SelectConfigurationFileWizardPage_CreateFromExistingConfigName_Label);
			nameLabel.setToolTipText(Messages.SelectConfigurationFileWizardPage_CreateFromExistingConfigName_Tooltip);
			GridData labelData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
			nameLabel.setLayoutData(labelData);

			nameText = new Text(mainComposite, SWT.BORDER);
			nameText.setText(Messages.SelectConfigurationFileWizardPage_CreateFromExistingConfigName_DefaultValue);
			GridData textData = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
			nameText.setLayoutData(textData);
			nameText.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent e) {
					validatePage();
				}
			});

			// 4th line: folder where to create the new file
			Label folderLabel = new Label(mainComposite, SWT.NONE);
			folderLabel.setText("Folder:");
			folderLabel.setToolTipText("Select the folder where you want to create the new file");
			labelData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
			folderLabel.setLayoutData(labelData);

			folderText = new Text(mainComposite, SWT.BORDER);
			folderText.setText("");
			folderText.setEditable(false);
			textData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
			folderText.setLayoutData(textData);

			folderButton = new Button(mainComposite, SWT.NONE);
			folderButton.setText("Select...");
			folderButton.addSelectionListener(new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					ContainerSelectionDialog selectionDialog = new ContainerSelectionDialog(getShell(), null, true, "Select the container where the file will be created");
					if(Dialog.OK == selectionDialog.open()) {
						Object[] result = selectionDialog.getResult();
						if(result.length < 1) {
							Activator.log.error("no container was selected in the dialog", null);
							return;
						}

						Object container = result[0];
						if(container instanceof Path) {
							Path path = (Path)container;
							folderText.setText(path.toString());
						}
						validatePage();
					}
				}

				public void widgetDefaultSelected(SelectionEvent e) {

				}
			});

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
				folderButton.setEnabled(enable);
				nameText.setEnabled(enable);
				if(enable) {
					nameText.setFocus();
					nameText.selectAll();
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void validatePage() {
			if(isValid(nameText)) {
				if(createFromExistingConfigurationText.getText() == null || createFromExistingConfigurationText.getText().equals(EMPTY_STRING)) {
					setPageComplete(false);
					setMessage(Messages.SelectConfigurationFileWizardPage_ErrorMessage_NoValidExistingConfiguration, ERROR);
				} else if(folderText.getText() == null || folderText.getText().equals(EMPTY_STRING)) {
					setPageComplete(false);
					setMessage("Please select a valid folder", ERROR);
				} else {
					super.validatePage();
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public Document generateInitialContent() {
			// should read the document from the existing file. The result will be put somewhere else.
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			DocumentBuilder documentBuilder;
			try {
				documentBuilder = documentBuilderFactory.newDocumentBuilder();
				IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(createFromExistingConfigurationText.getText()));
				if(iFile.exists()) {
					IPath location = iFile.getLocation();
					if(location != null) {
						final File file = location.toFile();
						Document document = documentBuilder.parse(file);
						return document;
					}
				}
			} catch (ParserConfigurationException e) {
				Activator.log.error(e);
			} catch (SAXException e) {
				Activator.log.error(e);
			} catch (IOException e) {
				Activator.log.error(e);
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public File getNewFile() {
			// retrieve the folder where to create the file
			IPath path = new Path(folderText.getText());
			IContainer iContainer = (IContainer)ResourcesPlugin.getWorkspace().getRoot().findMember(path);
			if(iContainer.exists()) {
				IPath location = iContainer.getLocation();
				File file = location.append(Character.toString(IPath.SEPARATOR)).append(nameText.getText()).addFileExtension("xml").toFile();
				return file;
			}
			Activator.log.warn("should never enter here");
			File file = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().append(folderText.getText()).append(Character.toString(IPath.SEPARATOR)).append(nameText.getText()).addFileExtension("xml").toFile();
			return file;
		}

		/**
		 * {@inheritDoc}
		 */
		public void performPostSerializationAction() {
			// nothing here
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
		public void validatePage() {
			if(isValid(modifyExistingConfigurationText)) {
				if(modifyExistingConfigurationText.getText() == null || modifyExistingConfigurationText.getText().equals(EMPTY_STRING)) {
					setPageComplete(false);
					setMessage(Messages.SelectConfigurationFileWizardPage_ErrorMessage_NoValidExistingConfiguration, ERROR);
				} else {
					setMessage(EMPTY_STRING, NONE);
					setPageComplete(true);
				}
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
					IFile[] selectedFiles = WorkspaceResourceDialog.openFileSelection(getShell(), Messages.SelectConfigurationFileWizardPage_ModifyExistingConfig_Dialog_Title, Messages.SelectConfigurationFileWizardPage_ModifyExistingConfig_Dialog_Message, false, new Object[0], Collections.singletonList(fileViewerFilter));
					if(selectedFiles != null && selectedFiles.length == 1) {
						IFile selectedFile = selectedFiles[0];
						modifyExistingConfigurationText.setText(selectedFile.getFullPath().toString());
						validatePage();
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

		/**
		 * {@inheritDoc}
		 */
		public Document generateInitialContent() {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			DocumentBuilder documentBuilder;
			try {
				documentBuilder = documentBuilderFactory.newDocumentBuilder();
				IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(modifyExistingConfigurationText.getText()));
				if(iFile.exists()) {
					IPath location = iFile.getLocation();
					if(location != null) {
						final File file = location.toFile();
						Document document = documentBuilder.parse(file);
						return document;
					}
				}
			} catch (ParserConfigurationException e) {
				Activator.log.error(e);
			} catch (SAXException e) {
				Activator.log.error(e);
			} catch (IOException e) {
				Activator.log.error(e);
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public File getNewFile() {
			// returns the file itself
			IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(modifyExistingConfigurationText.getText()));
			if(iFile.exists()) {
				IPath location = iFile.getLocation();
				if(location != null) {
					return location.toFile();
				}
			}
			// should never be used
			Activator.log.warn("should not get the file using this method");
			return ResourcesPlugin.getWorkspace().getRoot().getRawLocation().append(modifyExistingConfigurationText.getText()).toFile();
		}

		/**
		 * {@inheritDoc}
		 */
		public void performPostSerializationAction() {
			// nothing here
		}
	}

	/**
	 * Area for the "modify a plugin contribution" in the dialog
	 */
	public class ModifyPluginConfigurationArea implements IConfigurationArea {

		/** text area that display the id of the provider to modify */
		protected Text modifyPluginConfigurationText;

		/** button that opens dialog to select configuration to modify */
		protected Button modifyPluginConfigurationSelectionButton;

		/** Button used to modify an existing configuration */
		protected Button modifyPluginConfigurationButton;

		private File file;

		/**
		 * {@inheritDoc}
		 */
		public void setEnable(boolean enable) {
			if(isValid(modifyPluginConfigurationButton)) {
				modifyPluginConfigurationButton.setSelection(enable);
				modifyPluginConfigurationText.setEnabled(enable);
				modifyPluginConfigurationSelectionButton.setEnabled(enable);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void validatePage() {
			if(isValid(modifyPluginConfigurationText)) {
				if(modifyPluginConfigurationText.getText() == null || modifyPluginConfigurationText.getText().equals(EMPTY_STRING)) {
					setPageComplete(false);
					setMessage(Messages.SelectConfigurationFileWizardPage_ErrorMessage_NoValidExistingConfiguration, ERROR);
				} else {
					setMessage(EMPTY_STRING, NONE);
					setPageComplete(true);
				}
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
			modifyPluginConfigurationButton = new Button(modifyExistingConfigurationComposite, SWT.RADIO);
			modifyPluginConfigurationButton.addSelectionListener(selectionListener);
			radioButtonsMapping.put(modifyPluginConfigurationButton, this);
			Label modifyExistingConfigurationLabel = new Label(modifyExistingConfigurationComposite, SWT.NONE);
			modifyExistingConfigurationLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
			modifyExistingConfigurationLabel.setText("Modify plugin contribution");
			modifyPluginConfigurationText = new Text(modifyExistingConfigurationComposite, SWT.BORDER | SWT.READ_ONLY);
			modifyPluginConfigurationText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
			modifyPluginConfigurationSelectionButton = new Button(modifyExistingConfigurationComposite, SWT.NONE);
			modifyPluginConfigurationSelectionButton.setText(Messages.SelectConfigurationFileWizardPage_ModifyExistingConfigurationSelectionButton_Label);
			modifyPluginConfigurationSelectionButton.addSelectionListener(new SelectionListener() {

				/**
				 * {@inheritDoc}
				 */
				public void widgetSelected(SelectionEvent e) {
					// open a dialog which allows to select a contribution among all available contributions
					List<XMLPropertyTabViewProvider> tabViewProviders = new ArrayList<XMLPropertyTabViewProvider>();
					for(Object provider : PropertyViewService.getInstance().getPropertyViewProviders()) {
						PropertyViewService.ProviderDescriptor descriptor = (PropertyViewService.ProviderDescriptor)provider;
						if(descriptor.getProvider() instanceof XMLPropertyTabViewProvider) {
							tabViewProviders.add((XMLPropertyTabViewProvider)descriptor.getProvider());
						}
					}

					// open a dialog to choose among the provider
					ProviderSelectionDialog dialog = new ProviderSelectionDialog(getShell(), tabViewProviders);
					if(Dialog.OK == dialog.open()) {
						// get the selection of the dialog
						if(dialog.getFirstResult() != null) {
							modifyPluginConfigurationText.setText(((XMLPropertyTabViewProvider)dialog.getFirstResult()).getId());
						}

					}

					validatePage();
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

		/**
		 * {@inheritDoc}
		 */
		public Document generateInitialContent() {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			DocumentBuilder documentBuilder;
			try {
				documentBuilder = documentBuilderFactory.newDocumentBuilder();
				// try to find the file for the given provider...
				XMLPropertyTabViewProvider provider = retrieveProvider();
				if(provider != null) {
					Document document = documentBuilder.parse(provider.getConfigurationContent());
					return document;
				} else {
					Activator.log.error("provider niot found. Impossible to edit", null);
				}
			} catch (ParserConfigurationException e) {
				Activator.log.error(e);
			} catch (SAXException e) {
				Activator.log.error(e);
			} catch (IOException e) {
				Activator.log.error(e);
			}
			return null;
		}

		/**
		 * @return
		 */
		protected XMLPropertyTabViewProvider retrieveProvider() {
			for(ProviderDescriptor descriptor : PropertyViewService.getInstance().getPropertyViewProviders()) {
				IProvider provider = descriptor.getProvider();
				if(provider instanceof XMLPropertyTabViewProvider) {
					//	check this is the one we are looking for.
					String id = ((XMLPropertyTabViewProvider)provider).getId();
					if(id.equals(modifyPluginConfigurationText.getText())) {
						return ((XMLPropertyTabViewProvider)provider);
					}
				}
			}
			return null;
		}

		/**
		 * Retrieves the descriptor of the provider to remove
		 * 
		 * @return the descriptor of the provider to remove
		 */
		protected ProviderDescriptor retrieveProviderDescriptor() {
			for(ProviderDescriptor descriptor : PropertyViewService.getInstance().getPropertyViewProviders()) {
				IProvider provider = descriptor.getProvider();
				if(provider instanceof XMLPropertyTabViewProvider) {
					//	check this is the one we are looking for.
					String id = ((XMLPropertyTabViewProvider)provider).getId();
					if(id.equals(modifyPluginConfigurationText.getText())) {
						return descriptor;
					}
				}
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public File getNewFile() {
			// retrieves the file in the metadata place
			XMLPropertyTabViewProvider provider = retrieveProvider();
			if(provider == null) {
				return null;
			}
			// look if the file was already compute. If not, compute it now
			if(file == null) {
				file = provider.getLocalXmlfile(provider.getId() + "_" + System.currentTimeMillis() + ".xml");
			}
			return file;
		}

		/**
		 * {@inheritDoc}
		 */
		public void performPostSerializationAction() {
			// retrieve provider and updates the preferences to point to the new place
			XMLPropertyTabViewProvider provider = retrieveProvider();
			if(provider == null) {
				Activator.log.error("Impossible to find the provider to customize...", null);
				return;
			}

			// updates the provider
			provider.setConfigurationFile(getNewFile());

			// no need to force update, the properties provider listens for preferences changes
			// PropertyViewService.getInstance().resetTabViewProvider(retrieveProviderDescriptor());
		}
	}

	/**
	 * Returns the new file, where the content of the configuration will be serialized
	 * 
	 * @return the new file, where the content of the configuration will be serialized
	 */
	public File getNewFile() {
		return file;
	}

	/**
	 * selection dialog for tab view provider
	 */
	public class ProviderSelectionDialog extends FilteredItemsSelectionDialog {

		/** list of providers in which the edited provider will be selected */
		private final List<XMLPropertyTabViewProvider> providers;

		/** label provider for the list viewer */
		private ProviderLabelProvider providerLabelProvider;

		/** label provider for the details area */
		private ProviderDetailsLabelProvider providerDetailsLabelProvider;

		/**
		 * Creates a new ProviderSelectionDialog.
		 * 
		 * @param shell
		 *        the shell where to create the dialog
		 */
		public ProviderSelectionDialog(Shell shell, List<XMLPropertyTabViewProvider> providers) {
			super(shell, false);
			this.providers = providers;
			providerLabelProvider = new ProviderLabelProvider();
			providerDetailsLabelProvider = new ProviderDetailsLabelProvider();
			setListLabelProvider(providerLabelProvider);
			setDetailsLabelProvider(providerDetailsLabelProvider);
			setInitialPattern("**");
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected IStatus validateItem(Object item) {
			return Status.OK_STATUS;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Comparator<XMLPropertyTabViewProvider> getItemsComparator() {
			return new Comparator<XMLPropertyTabViewProvider>() {

				public int compare(XMLPropertyTabViewProvider o1, XMLPropertyTabViewProvider o2) {
					return o1.getContributionName().compareTo(o2.getContributionName());
				}

			};
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getElementName(Object item) {
			return providerLabelProvider.getText(item);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected IDialogSettings getDialogSettings() {
			return Activator.getDefault().getDialogSettings();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor) throws CoreException {
			if(progressMonitor != null) {
				progressMonitor.beginTask("Displaying Providers elements", providers.size());
			}
			for(XMLPropertyTabViewProvider provider : providers) {
				contentProvider.add(provider, itemsFilter);
				progressMonitor.worked(1);
			}
			if(progressMonitor != null)
				progressMonitor.done();

		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected ItemsFilter createFilter() {
			return new ItemsFilter() {

				@Override
				public boolean matchItem(Object item) {
					if(!(item instanceof XMLPropertyTabViewProvider)) {
						return false;
					}
					return matches(providerLabelProvider.getText((XMLPropertyTabViewProvider)item));
				}

				@Override
				public boolean isConsistentItem(Object item) {
					if(item instanceof XMLPropertyTabViewProvider) {
						return true;
					}
					return false;
				}

			};
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Control createExtendedContentArea(Composite parent) {
			return null;
		}

		/**
		 * label provider for the list viewer
		 */
		protected class ProviderLabelProvider extends LabelProvider {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public String getText(Object element) {
				if(element instanceof XMLPropertyTabViewProvider) {
					return ((XMLPropertyTabViewProvider)element).getContributionName();
				}
				return super.getText(element);
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Image getImage(Object element) {
				if(element instanceof XMLPropertyTabViewProvider) {
					return Activator.getImage("/icons/plugin_desc.gif");
				}
				return super.getImage(element);
			}
		}

		/**
		 * label provider for the list viewer
		 */
		protected class ProviderDetailsLabelProvider extends ProviderLabelProvider {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public String getText(Object element) {
				if(element instanceof XMLPropertyTabViewProvider) {
					return ((XMLPropertyTabViewProvider)element).getContributionName() + " - " + ((XMLPropertyTabViewProvider)element).getId();
				}
				return super.getText(element);
			}
		}
	}

	/**
	 * Perform actions after file serialization. Hook added to be able to modify preferences when modifying an in-place file
	 */
	public void performPostSerializationAction() {
		getEnableConfigurationArea().performPostSerializationAction();

	};
}
