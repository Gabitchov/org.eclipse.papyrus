/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.core.extension.NotFoundException;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * This WizardPage to select the kind of Papyrus Diagram. List all kind of diagrams registered with
 * creationCommand attribute in PapyrusDiagram Eclipse extension.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class SelectDiagramKindPage extends WizardPage {

	private final static String DIAGRAM_KIND_ID = "diagramKindId";

	/**
	 * The previous page containing the model fileName
	 */
	NewModelFilePage modelFilePage;

	/**
	 * The creation command registry
	 */
	ICreationCommandRegistry creationCommandRegistry;

	/**
	 * The selected creation command
	 */
	private ICreationCommand creationCommand;

	/**
	 * The diagram name text field
	 */
	private Text nameText;

	/**
	 * The list containing all registered diagram kind
	 */
	private CCombo diagramList = null;

	private String modelFileExtension;

	/**
	 * @return the new diagram name
	 */
	protected String getDiagramName() {
		return nameText.getText();
	}

	/**
	 * @return the creation command
	 */
	protected ICreationCommand getCreationCommand() {
		return creationCommand;
	}

	protected SelectDiagramKindPage(String pageName, String modelFileExtension, NewModelFilePage modelFilePage) {
		super(pageName);
		setTitle("Select a new Diagram");
		setDescription("Select a new Diagram");
		this.modelFileExtension = modelFileExtension;
		this.modelFilePage = modelFilePage;
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		root.setLayout(gridLayout);
		Group composite = new Group(root, 0);
		composite.setText("Initialization information");

		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 10;
		composite.setLayout(gridLayout);
		createDialogArea(composite);

		setControl(root);
	}

	private void createDialogArea(Composite composite) {
		createDiagramKindForm(composite);
		createNameForm(composite);
	}

	private void createDiagramKindForm(Composite composite) {
		// create label
		Label label = new Label(composite, SWT.TRAIL);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		label.setLayoutData(data);
		label.setText("Select diagram kind:");

		// create list of diagrams kind
		diagramList = new CCombo(composite, SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		diagramList.setLayoutData(data);
		fillList();
		diagramList.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				handleListSelected();
			}
		});
	}

	private void createNameForm(Composite composite) {
		Label label = new Label(composite, SWT.TRAIL);
		GridData data = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		label.setLayoutData(data);
		label.setText("Diagram Name:");

		nameText = new Text(composite, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		nameText.setLayoutData(data);
		nameText.setText("NewDiagram");
		nameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		dialogChanged();
	}

	/**
	 * Validate the changes on the page.
	 */
	private void dialogChanged() {
		if((nameText.getText() == null) || nameText.getText().length() == 0) {
			updateStatus("The diagram name must entered");
			return;
		}
		updateStatus(null);
	}

	private void fillList() {
		diagramList.add("");
		diagramList.setData(DIAGRAM_KIND_ID + 1, null);
		for(CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
			if(modelFileExtension.equals(desc.getModelFileExtension())) {
				diagramList.add(desc.getLabel());
				diagramList.setData(DIAGRAM_KIND_ID + diagramList.getItemCount(), desc);
			}
		}
		diagramList.select(0);
		handleListSelected();
	}

	private void handleListSelected() {
		int i = diagramList.getSelectionIndex();

		Object obj = diagramList.getData(DIAGRAM_KIND_ID + (i + 1));
		if(obj instanceof CreationCommandDescriptor) {
			CreationCommandDescriptor commandDescriptor = (CreationCommandDescriptor)obj;
			try {
				this.creationCommand = getCreationCommandRegistry().getCommand(commandDescriptor.getCommandId());
			} catch (NotFoundException e) {
				this.creationCommand = null;
				PapyrusTrace.log(e);
			}
		} else {
			this.creationCommand = null;
		}
	}

	private ICreationCommandRegistry getCreationCommandRegistry() {
		if(creationCommandRegistry == null) {
			this.creationCommandRegistry = new CreationCommandRegistry(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
		}
		return creationCommandRegistry;
	}

	/**
	 * Update page status.
	 * 
	 * @param message
	 *        is the error message.
	 */
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

}
