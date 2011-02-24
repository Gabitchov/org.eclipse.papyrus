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
package org.eclipse.papyrus.wizards.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.wizards.CreateModelWizard;
import org.eclipse.papyrus.wizards.SettingsHelper;
import org.eclipse.papyrus.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.wizards.category.DiagramCategoryRegistry;
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
	public static final String PAGE_ID = "SelectDiagramCategory";

	/** The Constant DEFAULT_EXTENSION. */
	public static final String DEFAULT_EXTENSION = "uml";

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
	 */
	public SelectDiagramCategoryPage(boolean allowSeveralCategories) {
		super(PAGE_ID);
		myAllowSeveralCategories = allowSeveralCategories;
		setTitle("Select language of the diagram");
	}

	/**
	 * @see org.eclipse.jface.wizard.WizardPage#setWizard(org.eclipse.jface.wizard.IWizard)
	 * 
	 * @param newWizard
	 */
	@Override
	public void setWizard(IWizard newWizard) {
		super.setWizard(newWizard);
		SettingsHelper settingsHelper = new SettingsHelper(getDialogSettings());
		setDefaultDiagramCategories(Collections.singletonList(settingsHelper.getDefaultDiagramCategory()));
	}

	/**
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
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

	/**
	 * Gets the diagram category.
	 * 
	 * @return the diagram category
	 */
	public String getDiagramCategory() {
		if (!mySelectedDiagramCategoryIds.isEmpty()) {
			return mySelectedDiagramCategoryIds.get(0);
		}
		return null;
	}

	public String[] getDiagramCategories() {
		return mySelectedDiagramCategoryIds.toArray(new String[mySelectedDiagramCategoryIds.size()]);
	}
	
	protected final void setDefaultDiagramCategories(Collection<String> categories) {
		mySelectedDiagramCategoryIds.addAll(categories);
	}


	/**
	 * Validate page.
	 * 
	 * @return true, if successful
	 */
	protected boolean validatePage() {
		setMessage(null);
		setErrorMessage(null);
		
		if(getDiagramCategories().length == 0) {
			setErrorMessage("Please select at least one category");
			return false;
		}
		String newCategory = getDiagramCategory();
		if (!validateCategoryExists(newCategory)) {
			return false;
		}
		if (!validateFileExtension(newCategory)) {
			return false;
		}
		return true;
	}
	
	protected boolean validateFileExtension(String newCategory) {
		IStatus status = ((CreateModelWizard)getWizard()).diagramCategoryChanged(newCategory);
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
	protected boolean validateCategoryExists(String newCategory) {
		DiagramCategoryDescriptor selected = getDiagramCategoryMap().get(newCategory);
		if(selected == null) {
			setErrorMessage("Could not find DiagramCategory for " + newCategory);
			return false;
		}
		return true;
	}
	
	private Map<String, DiagramCategoryDescriptor> getDiagramCategoryMap() {
		return DiagramCategoryRegistry.getInstance().getDiagramCategoryMap();
	}

	/**
	 * Creates the diagram language form.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createDiagramCategoryForm(Composite composite) {
		Group group = createGroup(composite, "Diagram Language:");

		SelectionListener listener = new SelectionListener() {
			
			private SelectionEvent prevEvent;

			public void widgetSelected(SelectionEvent e) {
				if (e == prevEvent) {
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

	protected void diagramCategorySelected(String category, boolean checked) {
		if (checked) {
			mySelectedDiagramCategoryIds.add(category);
		} else {
			mySelectedDiagramCategoryIds.remove(category);
		}
	}

	protected void checkDiagramCategoryButtons() {
		checkButtonsFor(mySelectedDiagramCategoryIds.toArray(new String[mySelectedDiagramCategoryIds.size()]));
	}
	
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
