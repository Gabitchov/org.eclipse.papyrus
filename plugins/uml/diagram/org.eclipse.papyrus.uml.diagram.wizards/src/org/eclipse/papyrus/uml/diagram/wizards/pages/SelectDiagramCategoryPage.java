/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.uml.diagram.wizards.CreateModelWizard;
import org.eclipse.papyrus.uml.diagram.wizards.Messages;
import org.eclipse.papyrus.uml.diagram.wizards.SettingsHelper;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;


/**
 * The Class SelectDiagramCategoryPage.
 */
public class SelectDiagramCategoryPage extends WizardPage {

	/** The my diagram kind buttons. */
	final private List<Button> myDiagramKindButtons = new ArrayList<Button>();

	/** The diagram category. */
	private final List<String> mySelectedDiagramCategoryIds = new LinkedList<String>();

	/** The Constant PAGE_ID. */
	public static final String PAGE_ID = "SelectDiagramCategory"; //$NON-NLS-1$

	/** The Constant DEFAULT_EXTENSION. */
	public static final String DEFAULT_EXTENSION = "uml"; //$NON-NLS-1$

	/** The my allow several categories. */
	private final boolean myAllowSeveralCategories;

	/**
	 * Instantiates a new select diagram category page.
	 * 
	 */
	public SelectDiagramCategoryPage() {
		this(false);
	}

	/**
	 * Instantiates a new select diagram category page.
	 *
	 * @param allowSeveralCategories the allow several categories
	 */
	public SelectDiagramCategoryPage(boolean allowSeveralCategories) {
		super(PAGE_ID);
		myAllowSeveralCategories = allowSeveralCategories;
		setTitle(Messages.SelectDiagramCategoryPage_select_language);
	}

	/**
	 * Sets the wizard.
	 *
	 * @param newWizard the new wizard
	 * @see org.eclipse.jface.wizard.WizardPage#setWizard(org.eclipse.jface.wizard.IWizard)
	 */
	@Override
	public void setWizard(IWizard newWizard) {
		super.setWizard(newWizard);
		SettingsHelper settingsHelper = new SettingsHelper(getDialogSettings());
		String[] defaultDiagramCategory = settingsHelper.getDefaultDiagramCategories();
		if (defaultDiagramCategory != null && defaultDiagramCategory.length > 0) {
			if (myAllowSeveralCategories) {
				setDefaultDiagramCategories(defaultDiagramCategory);
			} else {
				setDefaultDiagramCategories(new String[]{defaultDiagramCategory[0]});
			}
		}
	}

	/**
	 * Creates the control.
	 *
	 * @param parent the parent
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 10;
		plate.setLayout(gridLayout);
		setControl(plate);

		createDiagramCategoryForm(plate);

		setPageComplete(validatePage());
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		
		// re-validate in case the user changed the file name on previous page
		setPageComplete(validatePage());
	}
	
	/**
	 * 
	 * Gets the diagram category.
	 * 
	 * @return the diagram category
     * @deprecated Use getDiagramCategories() instead.
	 */
	public String getDiagramCategory() {
		if(!mySelectedDiagramCategoryIds.isEmpty()) {
			return mySelectedDiagramCategoryIds.get(0);
		}
		return null;
	}

	/**
	 * Gets the diagram categories.
	 *
	 * @return the diagram categories
	 */
	public String[] getDiagramCategories() {
		return mySelectedDiagramCategoryIds.toArray(new String[mySelectedDiagramCategoryIds.size()]);
	}

	/**
	 * Sets the default diagram categories.
	 *
	 * @param categories the new default diagram categories
	 */
	protected final void setDefaultDiagramCategories(String[] categories) {
		mySelectedDiagramCategoryIds.clear();
		mySelectedDiagramCategoryIds.addAll(Arrays.asList(categories));
	}


	/**
	 * Validate page.
	 * 
	 * @return true, if successful
	 */
	protected boolean validatePage() {
		setMessage(null);
		setErrorMessage(null);
		String[] categories = getDiagramCategories();
		if(categories == null || categories.length == 0) {
			setErrorMessage(Messages.SelectDiagramCategoryPage_select_one_category);
			return false;
		}
		for(String newCategory : categories) {
			if(!validateCategoryExists(newCategory)) {
				return false;
			}
		}
		if(!validateFileExtension(categories)) {
			return false;
		}
		return true;
	}

	/**
	 * Validate file extension.
	 *
	 * @param categories the categories
	 * @return true, if successful
	 */
	protected boolean validateFileExtension(String... categories) {
		IStatus status = ((CreateModelWizard)getWizard()).diagramCategoryChanged(categories);
		switch(status.getSeverity()) {
		case Status.ERROR:
			setErrorMessage(status.getMessage());
			return false;
		case Status.WARNING:
			setMessage(status.getMessage(), IMessageProvider.WARNING);
			break;
		case Status.INFO:
			setMessage(status.getMessage(), IMessageProvider.INFORMATION);
			break;
		}
		return true;
	}

	/**
	 * Validate category exists.
	 *
	 * @param newCategory the new category
	 * @return true, if successful
	 */
	protected boolean validateCategoryExists(String newCategory) {
		DiagramCategoryDescriptor selected = getDiagramCategoryMap().get(newCategory);
		if(selected == null) {
			setErrorMessage(Messages.bind(Messages.SelectDiagramCategoryPage_cannot_find_category,newCategory));
			return false;
		}
		return true;
	}

	/**
	 * Gets the diagram category map.
	 *
	 * @return the diagram category map
	 */
	protected Map<String, DiagramCategoryDescriptor> getDiagramCategoryMap() {
		return DiagramCategoryRegistry.getInstance().getDiagramCategoryMap();
	}

	/**
	 * Creates the diagram language form.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createDiagramCategoryForm(Composite composite) {
		Group group = createGroup(composite, Messages.SelectDiagramCategoryPage_diagram_language_group);

		SelectionListener listener = new SelectionListener() {

			private SelectionEvent prevEvent;

			public void widgetSelected(SelectionEvent e) {
				if(e == prevEvent) {
					return;
				}
				Button selected = ((Button)e.widget);
				diagramCategorySelected((String)selected.getData(), selected.getSelection());
				setPageComplete(validatePage());
				prevEvent = e;
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};

		for(DiagramCategoryDescriptor diagramCategoryDescriptor : getDiagramCategoryMap().values()) {
			Button button = createCategoryButton(diagramCategoryDescriptor, group);
			button.addSelectionListener(listener);
			myDiagramKindButtons.add(button);
		}
		checkDiagramCategoryButtons();
	}

	/**
	 * Diagram category selected.
	 *
	 * @param category the category
	 * @param checked the checked
	 */
	protected void diagramCategorySelected(String category, boolean checked) {
		if(checked) {
			if (!mySelectedDiagramCategoryIds.contains(category))
				mySelectedDiagramCategoryIds.add(category);
		} else {
			mySelectedDiagramCategoryIds.remove(category);
		}
	}

	/**
	 * Check diagram category buttons.
	 */
	protected void checkDiagramCategoryButtons() {
		checkButtonsFor(mySelectedDiagramCategoryIds.toArray(new String[mySelectedDiagramCategoryIds.size()]));
	}

	/**
	 * Check buttons for.
	 *
	 * @param diagramCategories the diagram categories
	 */
	protected void checkButtonsFor(String... diagramCategories) {
		for(Button button : myDiagramKindButtons) {
			button.setSelection(false);
		}
		for(Button button : myDiagramKindButtons) {
			for(String diagramCategory : diagramCategories) {
				if(diagramCategory.equals(button.getData())) {
					button.setSelection(true);
				}
			}
		}
	}

	/**
	 * Creates the category button.
	 *
	 * @param diagramCategoryDescriptor the diagram category descriptor
	 * @param group the group
	 * @return the button
	 */
	private Button createCategoryButton(DiagramCategoryDescriptor diagramCategoryDescriptor, Group group) {
		Button button = new Button(group, myAllowSeveralCategories ? SWT.CHECK : SWT.RADIO);
		button.setText(diagramCategoryDescriptor.getLabel());
		button.setData(diagramCategoryDescriptor.getId());
		Image image = getImage(diagramCategoryDescriptor.getIcon());
		if(image != null) {
			button.setImage(image);
		}
		button.setToolTipText(diagramCategoryDescriptor.getDescription());
		return button;
	}

	/**
	 * Gets the image.
	 *
	 * @param imageDescriptor the image descriptor
	 * @return the image
	 */
	private static Image getImage(ImageDescriptor imageDescriptor) {
		if(imageDescriptor != null) {
			return new Image(null, imageDescriptor.getImageData());
		}
		return null;
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
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		group.setLayoutData(data);
		return group;
	}


}
