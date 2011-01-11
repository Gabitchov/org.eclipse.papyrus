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
	private String mySelectedDiagramCategoryId;
	
	private SettingsHelper mySettingsHelper;

	/** The Constant PAGE_ID. */
	public static final String PAGE_ID = "SelectDiagramCategory";

	/** The Constant DEFAULT_EXTENSION. */
	public static final String DEFAULT_EXTENSION = "uml";

	/**
	 * Instantiates a new select diagram category page.
	 * 
	 */
	public SelectDiagramCategoryPage() {
		super(PAGE_ID);
		setTitle("Initialization information");
		setDescription("Select language of the diagram");
	}

	/**
	 * @see org.eclipse.jface.wizard.WizardPage#setWizard(org.eclipse.jface.wizard.IWizard)
	 * 
	 * @param newWizard
	 */
	@Override
	public void setWizard(IWizard newWizard) {
		super.setWizard(newWizard);
		setSettingsHelper(new SettingsHelper(getDialogSettings()));
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
		return mySelectedDiagramCategoryId;
	}

	/**
	 * Sets the settings helper.
	 *
	 * @param helper the new settings helper
	 */
	protected void setSettingsHelper(SettingsHelper helper) {
		mySettingsHelper = helper;
		initSelectedCategory();
	}

	private void initSelectedCategory() {
		mySelectedDiagramCategoryId = mySettingsHelper.getDefaultDiagramCategory();
	}

	/**
	 * Validate page.
	 * 
	 * @return true, if successful
	 */
	private boolean validatePage() {
		String newCategory = getDiagramCategory();
		if (newCategory == null) {
			setErrorMessage("Please select at least one category");
			return false;
		}
		DiagramCategoryDescriptor selected = getDiagramCategoryMap().get(newCategory);
		if(selected == null) {
			setErrorMessage("Could not find DiagramCategory for " + newCategory);
			return false;
		}
		IStatus status = ((CreateModelWizard)getWizard()).diagramCategoryChanged(getDiagramCategory());
		switch (status.getSeverity()) {
			case Status.ERROR: setErrorMessage(status.getMessage()); return false;
			case Status.WARNING: setMessage(status.getMessage(), IMessageProvider.WARNING);
			case Status.INFO: setMessage(status.getMessage(), IMessageProvider.INFORMATION);
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

			public void widgetSelected(SelectionEvent e) {
				for(Button button : myDiagramKindButtons) {
					button.setSelection(false);
				}
				((Button)e.widget).setSelection(true);
				mySelectedDiagramCategoryId = (String)((Button)e.widget).getData();
				setPageComplete(validatePage());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};

		for(DiagramCategoryDescriptor diagramCategoryDescriptor : getDiagramCategoryMap().values()) {
			Button button = createCategoryButton(diagramCategoryDescriptor, group);
			button.addSelectionListener(listener);
			myDiagramKindButtons.add(button);
			if(mySelectedDiagramCategoryId != null && mySelectedDiagramCategoryId.equals(button.getData())) {
				button.setSelection(true);
			}
		}
	}

	private Button createCategoryButton(DiagramCategoryDescriptor diagramCategoryDescriptor, Group group) {
		Button button = new Button(group, SWT.CHECK);
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
