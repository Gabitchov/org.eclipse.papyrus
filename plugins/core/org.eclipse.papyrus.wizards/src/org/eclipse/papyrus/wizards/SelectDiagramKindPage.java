/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Tatiana Fesenko(CEA) - improved look&feel
 *******************************************************************************/
package org.eclipse.papyrus.wizards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.core.extension.NotFoundException;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

/**
 * This WizardPage to select the kind of Papyrus Diagram. List all kind of diagrams registered with
 * creationCommand attribute in PapyrusDiagram Eclipse extension.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author Tatiana Fesenko
 */
public class SelectDiagramKindPage extends WizardPage {


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

	final List<Button> myDiagramKindButtons = new ArrayList<Button>();

	/**
	 * @return the new diagram name
	 */
	public String getDiagramName() {
		return nameText.getText();
	}

	/**
	 * @return the creation command
	 */
	public ICreationCommand getCreationCommand() {
		return creationCommand;
	}

	public SelectDiagramKindPage(String pageName) {
		super(pageName);
		setPageComplete(false);
		setTitle("Initialization information");
		setDescription("Select name and kind of the diagram");
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 10;
		plate.setLayout(gridLayout);
		setControl(plate);

		createNameForm(plate);
		createDiagramKindForm(plate);

		//		if(!myDiagramKindButtons.isEmpty()) {
		//			Button defaultKind = myDiagramKindButtons.get(0);
		//			setDefaultDiagramKind((String)defaultKind.getData());
		//		}
		setPageComplete(validatePage());

	}

	private void createDiagramKindForm(Composite composite) {
		Group group = createGroup(composite, "Diagram Kind:");

		SelectionListener listener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				for(Button button : myDiagramKindButtons) {
					button.setSelection(false);
				}
				((Button)e.widget).setSelection(true);
				setDiagramCreationCommand((String)((Button)e.widget).getData());
				setPageComplete(validatePage());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};

		for(CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
			Button button = new Button(group, SWT.RADIO);
			button.addSelectionListener(listener);
			button.setText(desc.getLabel());
			button.setData(desc.getCommandId());
			myDiagramKindButtons.add(button);
		}

	}

	private void setDefaultDiagramKind(String defaultKindCommandId) {
		for(Button button : myDiagramKindButtons) {
			if(defaultKindCommandId != null && defaultKindCommandId.equals(button.getData())) {
				button.setSelection(true);
			} else {
				button.setSelection(false);
			}
		}
		setDiagramCreationCommand(defaultKindCommandId);
	}

	private void setDiagramCreationCommand(String commandId) {
		if(commandId == null) {
			this.creationCommand = null;
			return;
		}
		try {
			this.creationCommand = getCreationCommandRegistry().getCommand(commandId);
		} catch (NotFoundException e) {
			PapyrusTrace.log(e);
		}
	}

	private Group createGroup(Composite parent, String name) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(name);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		group.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		group.setLayoutData(data);
		return group;
	}

	private void createNameForm(Composite composite) {
		Group group = createGroup(composite, "Diagram Name:");

		nameText = new Text(group, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
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

	protected boolean validatePage() {
		return false == "".equals(getDiagramName()) && getCreationCommand() != null;
	}

	public boolean createDiagram(DiResourceSet diResourceSet, EObject root) {
		String diagramName = getDiagramName();
		ICreationCommand creationCommand = getCreationCommand();

		if(creationCommand != null) {
			creationCommand.createDiagram(diResourceSet, root, diagramName);
		} else {
			// Create an empty editor (no diagrams opened)
			// Geting an IPageMngr is enough to initialize the
			// SashSystem.
			EditorUtils.getTransactionalIPageMngr(diResourceSet.getDiResource(), diResourceSet.getTransactionalEditingDomain());
		}
		try {
			diResourceSet.save(new NullProgressMonitor());
		} catch (IOException e) {
			PapyrusTrace.log(e);
			return false;
		}
		return true;
	}

}
