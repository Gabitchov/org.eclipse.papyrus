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
package org.eclipse.papyrus.wizards.pages;

import static org.eclipse.papyrus.wizards.Activator.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.wizards.SettingsHelper;
import org.eclipse.papyrus.wizards.kind.DiagramKindContentProvider;
import org.eclipse.papyrus.wizards.kind.DiagramKindLabelProvider;
import org.eclipse.papyrus.wizards.template.ModelTemplateDescription;
import org.eclipse.papyrus.wizards.template.SelectModelTemplateComposite;
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
import org.eclipse.swt.widgets.Table;
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
	 * The diagram name text field
	 */
	private Text nameText;

	private CheckboxTableViewer diagramKindTableViewer;

	private SettingsHelper mySettingsHelper;

	/** The select template composite. */
	private SelectModelTemplateComposite selectTemplateComposite;
	
	private final CategoryProvider myCategoryProvider;

	private Button rememberCurrentSelection;

	private boolean allowTemplates;

	/**
	 * Instantiates a new select diagram kind page.
	 * 
	 */
	public SelectDiagramKindPage(CategoryProvider categoryProvider) {
		this(true, categoryProvider);
	}

	/**
	 * Instantiates a new select diagram kind page.
	 * 
	 */
	public SelectDiagramKindPage(boolean allowTemplates, CategoryProvider categoryProvider) {
		super("Select kind of diagram");
		setTitle("Initialization information");
		setDescription("Select name and kind of the diagram");
		this.allowTemplates = allowTemplates;
		myCategoryProvider = categoryProvider;
	}

	/**
	 * Creates the control.
	 * 
	 * @param parent
	 *        the parent {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 10;
		plate.setLayout(gridLayout);
		setControl(plate);

		String category = getDiagramCategory();

		createNameForm(plate);

		createDiagramKindForm(plate, category);

		createModelTemplateComposite(plate);

		createRememberCurrentSelectionForm(plate);

		fillInTables(category);

	}

	@Override
	public void setWizard(IWizard newWizard) {
		super.setWizard(newWizard);
		setSettingsHelper(new SettingsHelper(getDialogSettings()));
	}

	/**
	 * Sets the settings helper.
	 * 
	 * @param helper
	 *        the new settings helper
	 */
	protected void setSettingsHelper(SettingsHelper helper) {
		mySettingsHelper = helper;
	}

	/**
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 * 
	 * @param visible
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		fillInTables(getDiagramCategory());
		validatePage();
		if(!allowTemplates) {
			selectTemplateComposite.disable();
		}
	}

	private void fillInTables(String category) {
		if(category == null) {
			return;
		}
		diagramKindTableViewer.setInput(category);
		selectTemplateComposite.setInput(category);
		selectDefaultDiagramKinds(category);
		selectDefaultDiagramTemplates(category);
	}

	
	public String getTemplatePath() {
		return selectTemplateComposite.getTemplatePath();
	}

	public String getTemplatePluginId() {
		return selectTemplateComposite.getTemplatePluginId();
	}

	/**
	 * Gets the diagram category.
	 * 
	 * @return the diagram category
	 */
	private String getDiagramCategory() {
		return myCategoryProvider.getCurrentCategory();
	}


	/**
	 * @return the new diagram name
	 */
	public String getDiagramName() {
		return nameText.getText();
	}
	
	public boolean templatesEnabled() {
		return allowTemplates;
	}

	/**
	 * @return the creation command
	 */
	public List<ICreationCommand> getCreationCommands() {
		CreationCommandDescriptor[] selected = getSelectedDiagramKinds();
		List<ICreationCommand> commands = new ArrayList<ICreationCommand>();
		for(int i = 0; i < selected.length; i++) {

			ICreationCommand command;
			try {
				command = (selected[i]).getCommand();
				commands.add(command);
			} catch (Exception e) {
				log.error(e);
			}
		}
		return commands;
	}


	private void createModelTemplateComposite(Composite composite) {
		Group group = createGroup(composite, "You can load a template:");
		selectTemplateComposite = new SelectModelTemplateComposite(group);
	}

	/**
	 * Creates the diagram kind form.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createDiagramKindForm(Composite composite, String category) {
		Group group = createGroup(composite, "Select a Diagram Kind:");
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		group.setData(data);

		final Table diagramKindTable = new Table(group, SWT.NO_BACKGROUND | SWT.CHECK);
		diagramKindTable.setFont(group.getFont());
		diagramKindTable.setBackground(group.getBackground());

		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		diagramKindTable.setLayout(layout);

		GridData data2 = new GridData(SWT.FILL, SWT.FILL, true, true);
		diagramKindTable.setLayoutData(data2);

		diagramKindTable.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				if(e.detail == SWT.CHECK) {
					//					TableItem item = (TableItem)e.item;
					//					for(TableItem next : diagramKindTable.getItems()) {
					//						next.setChecked(false);
					//					}
					//					item.setChecked(true);
					//					setDiagramCreationCommand(((CreationCommandDescriptor)item.getData()).getCommandId());
					validatePage();
				}
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// does nothing
			}
		});
		diagramKindTableViewer = new CheckboxTableViewer(diagramKindTable);
		diagramKindTableViewer.setContentProvider(new DiagramKindContentProvider());
		diagramKindTableViewer.setLabelProvider(new DiagramKindLabelProvider());
		diagramKindTableViewer.setInput(category);
	}


	/**
	 * Creates the group.
	 * 
	 * @param parent
	 *        the parent
	 * @param name
	 *        the name
	 * @return the group
	 */
	private static Group createGroup(Composite parent, String name) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(name);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		group.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		group.setLayoutData(data);
		return group;
	}

	/**
	 * Creates the name form.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createNameForm(Composite composite) {
		Group group = createGroup(composite, "Diagram Name:");

		nameText = new Text(group, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		nameText.setLayoutData(data);
		nameText.setText("NewDiagram");
		nameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				validatePage();
			}
		});
	}

	private void createRememberCurrentSelectionForm(Composite composite) {
		Composite plate = new Composite(composite, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		plate.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		plate.setLayoutData(data);

		rememberCurrentSelection = new Button(plate, SWT.CHECK);
		rememberCurrentSelection.setText("Remember current selection");
		rememberCurrentSelection.setToolTipText("The current selection will be used when you open the wizard next time");

		rememberCurrentSelection.setSelection(mySettingsHelper.rememberCurrentSelection(getDialogSettings()));
	}

	/**
	 * Validate page.
	 * 
	 * @return true, if successful
	 */
	private boolean validatePage() {
		if(getDiagramName() == null || getDiagramName().length() == 0) {
			updateStatus("The diagram name should not be empty.");
			return false;
		}
		//		if(getCreationCommands().isEmpty()) {
		//			updateStatus("At least one diagram kind should be selected.");
		//			return false;
		//		}
		updateStatus(null);
		return true;
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

	public boolean isRememberCurrentSelection() {
		return rememberCurrentSelection.getSelection();
	}

	/**
	 * Gets the selected diagram kinds.
	 * 
	 * @return the selected diagram kinds
	 */
	public CreationCommandDescriptor[] getSelectedDiagramKinds() {
		Object[] checked = diagramKindTableViewer.getCheckedElements();
		// as Object is not a subclass of String we cannot cast Object[] to String[] 
		CreationCommandDescriptor[] result = Arrays.asList(checked).toArray(new CreationCommandDescriptor[checked.length]);
		return result;
	}

	private void selectDefaultDiagramKinds(String category) {
		List<String> kinds = mySettingsHelper.getDefaultDiagramKinds(category);
		List<CreationCommandDescriptor> result = new ArrayList<CreationCommandDescriptor>();
		for(Object next : ((DiagramKindContentProvider)diagramKindTableViewer.getContentProvider()).getElements(category)) {
			CreationCommandDescriptor desc = (CreationCommandDescriptor)next;
			if(kinds.contains(desc.getCommandId())) {
				result.add(desc);
			}
		}

		diagramKindTableViewer.setCheckedElements(result.toArray(new CreationCommandDescriptor[result.size()]));
	}

	private void selectDefaultDiagramTemplates(String category) {
		List<String> templates = mySettingsHelper.getDefaultTemplates(category);
		for(Object next : selectTemplateComposite.getContentProvider().getElements(category)) {
			ModelTemplateDescription desc = (ModelTemplateDescription)next;
			if(templates.contains(desc.getPath())) {
				selectTemplateComposite.selectElement(desc);
				return;
			}
		}
	}
	
	public static interface CategoryProvider{
		String getCurrentCategory();
	}

}
