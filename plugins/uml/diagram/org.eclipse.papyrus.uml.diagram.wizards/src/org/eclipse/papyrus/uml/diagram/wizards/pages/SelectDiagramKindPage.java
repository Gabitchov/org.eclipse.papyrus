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
 *     Saadia Dhouib (CEA LIST) - Implementation of loading diagrams from template files  (.uml, .di , .notation)
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.commands.CreationCommandRegistry;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.infra.viewpoints.configuration.Category;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.uml.diagram.wizards.Messages;
import org.eclipse.papyrus.uml.diagram.wizards.SettingsHelper;
import org.eclipse.papyrus.uml.diagram.wizards.kind.DiagramKindContentProvider;
import org.eclipse.papyrus.uml.diagram.wizards.kind.DiagramKindLabelProvider;
import org.eclipse.papyrus.uml.diagram.wizards.template.ModelTemplateDescription;
import org.eclipse.papyrus.uml.diagram.wizards.template.SelectModelTemplateComposite;
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

	/** The Constant PAGE_ID. */
	public static final String PAGE_ID = "SelectDiagramKind"; //$NON-NLS-1$

	/** The diagram name text field. */
	private Text nameText;

	/** The diagram kind table viewer. */
	private CheckboxTableViewer diagramKindTableViewer;

	/** The my settings helper. */
	private SettingsHelper mySettingsHelper;

	/** The select template composite. */
	private SelectModelTemplateComposite selectTemplateComposite;

	/** The remember current selection. */
	private Button rememberCurrentSelection;

	/** The my category provider. */
	private final CategoryProvider myCategoryProvider;

	/** The allow templates. */
	private final boolean allowTemplates;

	/** The my creation command registry. */
	private final ICreationCommandRegistry myCreationCommandRegistry;

	/** The Constant DEFAULT_CREATION_COMMAND_REGISTRY. */
	public static final ICreationCommandRegistry DEFAULT_CREATION_COMMAND_REGISTRY = CreationCommandRegistry.getInstance(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);

	/**
	 * Instantiates a new select diagram kind page.
	 * 
	 * @param categoryProvider
	 *        the category provider
	 */
	public SelectDiagramKindPage(CategoryProvider categoryProvider) {
		this(true, categoryProvider, DEFAULT_CREATION_COMMAND_REGISTRY);
	}

	/**
	 * Instantiates a new select diagram kind page.
	 * 
	 * @param allowTemplates
	 *        the allow templates
	 * @param categoryProvider
	 *        the category provider
	 * @param creationCommandRegistry
	 *        the creation command registry
	 */
	public SelectDiagramKindPage(boolean allowTemplates, CategoryProvider categoryProvider, ICreationCommandRegistry creationCommandRegistry) {
		super(PAGE_ID);
		setTitle(Messages.SelectDiagramKindPage_page_title);
		setDescription(Messages.SelectDiagramKindPage_page_desc);
		this.allowTemplates = allowTemplates;
		myCategoryProvider = categoryProvider;
		myCreationCommandRegistry = creationCommandRegistry;
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

		String[] categories = getDiagramCategories();

		createNameForm(plate);

		createDiagramKindForm(plate);
		diagramKindTableViewer.setInput(categories);

		createModelTemplateComposite(plate);

		createRememberCurrentSelectionForm(plate);

		fillInTables(categories);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#setWizard(org.eclipse.jface.wizard.IWizard)
	 */
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
	 * Sets the visible.
	 * 
	 * @param visible
	 *        the new visible
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if(visible) {
			fillInTables(getDiagramCategories());
			validatePage();
			if(!allowTemplates) {
				selectTemplateComposite.disable();
			}
		}
	}

	/**
	 * Fill in tables.
	 * 
	 * @param categories
	 *        the categories
	 */
	private void fillInTables(String[] categories) {
		if(categories == null || categories.length == 0) {
			return;
		}
		diagramKindTableViewer.setInput(categories);
		selectTemplateComposite.setInput(categories);
		selectDefaultDiagramKinds(categories);
		selectDefaultDiagramTemplates(categories);
	}


	/**
	 * Gets the uml model template path.
	 * 
	 * @return the template path
	 */
	public String getTemplatePath() {
		return selectTemplateComposite.getTemplatePath();
	}

	/**
	 * Gets the notation model template path.
	 * 
	 * @return the notation template path
	 */
	public String getNotationTemplatePath() {
		return selectTemplateComposite.getNotationTemplatePath();
	}

	/**
	 * Gets the di model template path.
	 * 
	 * @return the di template path
	 */
	public String getDiTemplatePath() {
		return selectTemplateComposite.getDiTemplatePath();
	}

	/**
	 * Gets the template plugin id.
	 * 
	 * @return the template plugin id
	 */
	public String getTemplatePluginId() {
		return selectTemplateComposite.getTemplatePluginId();
	}

	/**
	 * Gets the diagram category.
	 * 
	 * @return the diagram category
	 */
	private String[] getDiagramCategories() {
		return myCategoryProvider.getCurrentCategories();
	}


	/**
	 * Gets the diagram name.
	 * 
	 * @return the new diagram name
	 */
	public String getDiagramName() {
		return nameText.getText();
	}

	/**
	 * Templates enabled.
	 * 
	 * @return true, if successful
	 */
	public boolean templatesEnabled() {
		return allowTemplates;
	}

	/**
	 * Gets the selected command descriptors.
	 * 
	 * @param categoryId
	 *        the category id
	 * @return the selected command descriptors
	 */
	public List<ViewPrototype> getSelectedPrototypes(String categoryId) {
		ViewPrototype[] selected = getSelectedPrototypes();
		List<ViewPrototype> commands = new ArrayList<ViewPrototype>();
		for(int i = 0; i < selected.length; i++) {
			for (Category category : selected[i].getCategories()) {
				if (category.getName().equals(categoryId)) {
					commands.add(selected[i]);
					break;
				}
			}
		}
		return commands;
	}

	/**
	 * Creates the model template composite.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createModelTemplateComposite(Composite composite) {
		Group group = createGroup(composite, Messages.SelectDiagramKindPage_load_template_group);
		selectTemplateComposite = new SelectModelTemplateComposite(group);
	}

	/**
	 * Creates the diagram kind form.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createDiagramKindForm(Composite composite) {
		Group group = createGroup(composite, Messages.SelectDiagramKindPage_select_kind_group);
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
		diagramKindTableViewer.setLabelProvider(createDiagramKindLabelProvider());
	}

	/**
	 * Creates the diagram kind label provider.
	 * 
	 * @return the i base label provider
	 */
	protected IBaseLabelProvider createDiagramKindLabelProvider() {
		return new DiagramKindLabelProvider();
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
		Group group = createGroup(composite, Messages.SelectDiagramKindPage_diagram_name_group);

		nameText = new Text(group, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		nameText.setLayoutData(data);
		nameText.setText(Messages.SelectDiagramKindPage_default_diagram_name);
		nameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				validatePage();
			}
		});
	}

	/**
	 * Creates the remember current selection form.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createRememberCurrentSelectionForm(Composite composite) {
		Composite plate = new Composite(composite, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		plate.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		plate.setLayoutData(data);

		rememberCurrentSelection = new Button(plate, SWT.CHECK);
		rememberCurrentSelection.setText(Messages.SelectDiagramKindPage_remember_current_selection_text);
		rememberCurrentSelection.setToolTipText(Messages.SelectDiagramKindPage_remember_current_selection_tooltip);

		rememberCurrentSelection.setSelection(mySettingsHelper.rememberCurrentSelection(getDialogSettings()));
	}

	/**
	 * Validate page.
	 * 
	 * @return true, if successful
	 */
	private boolean validatePage() {
		if(getDiagramName() == null || getDiagramName().length() == 0) {
			updateStatus(Messages.SelectDiagramKindPage_diagram_name_is_empty);
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

	/**
	 * Checks if is remember current selection.
	 * 
	 * @return true, if is remember current selection
	 */
	public boolean isRememberCurrentSelection() {
		return rememberCurrentSelection.getSelection();
	}

	/**
	 * Gets the selected diagram kinds.
	 * 
	 * @param categoryId
	 *        the category id
	 * @return the selected diagram kinds
	 */
	public String[] getSelectedDiagramKinds(String categoryId) {
		return new String[0];
	}

	/**
	 * Gets the selected diagram kind descriptors.
	 * 
	 * @return the selected diagram kind descriptors
	 */
	protected ViewPrototype[] getSelectedPrototypes() {
		Object[] checked = diagramKindTableViewer.getCheckedElements();
		ViewPrototype[] result = Arrays.asList(checked).toArray(new ViewPrototype[checked.length]);
		return result;
	}

	/**
	 * Select default diagram kinds.
	 * 
	 * @param categories
	 *        the categories
	 */
	private void selectDefaultDiagramKinds(String[] categories) {
		Set<String> kinds = new HashSet<String>();
		for(String category : categories) {
			kinds.addAll(mySettingsHelper.getDefaultDiagramKinds(category));
		}
		CreationCommandDescriptor[] elementsToCheck = findCreationCommandDescriptorsFor(kinds);
		diagramKindTableViewer.setCheckedElements(elementsToCheck);
	}

	/**
	 * Find creation command descriptors for.
	 * 
	 * @param kinds
	 *        the kinds
	 * @return the creation command descriptor[]
	 */
	protected CreationCommandDescriptor[] findCreationCommandDescriptorsFor(Collection<String> kinds) {
		List<CreationCommandDescriptor> result = new ArrayList<CreationCommandDescriptor>();
		Collection<CreationCommandDescriptor> availableDescriptors = getCreationCommandRegistry().getCommandDescriptors();
		for(CreationCommandDescriptor desc : availableDescriptors) {
			if(kinds.contains(desc.getCommandId())) {
				result.add(desc);
			}
		}
		return result.toArray(new CreationCommandDescriptor[result.size()]);
	}

	/**
	 * Select default diagram templates.
	 * 
	 * @param categories
	 *        the categories
	 */
	private void selectDefaultDiagramTemplates(String[] categories) {
		List<String> defaultTemplates = new ArrayList<String>();
		List<Object> availableTemplates = new ArrayList<Object>();
		for(String category : categories) {
			defaultTemplates.addAll(mySettingsHelper.getDefaultTemplates(category));
		}

		availableTemplates.addAll(Arrays.asList(selectTemplateComposite.getContentProvider().getElements(categories)));

		for(Object next : availableTemplates) {
			ModelTemplateDescription desc = (ModelTemplateDescription)next;

			if(defaultTemplates.contains(desc.getUml_path())) {
				selectTemplateComposite.selectElement(desc);
				return;
			}
		}
	}


	/**
	 * Gets the creation command registry.
	 * 
	 * @return the creation command registry
	 */
	protected final ICreationCommandRegistry getCreationCommandRegistry() {
		return myCreationCommandRegistry;
	}

	/**
	 * The Interface CategoryProvider.
	 */
	public static interface CategoryProvider {

		/**
		 * Gets the current categories.
		 * 
		 * @return the current categories
		 */
		String[] getCurrentCategories();
	}

}
