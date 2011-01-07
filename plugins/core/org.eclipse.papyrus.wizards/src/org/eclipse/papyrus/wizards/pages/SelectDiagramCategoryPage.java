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

import static org.eclipse.papyrus.wizards.Activator.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
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
		//316943 -  [Wizard] Wrong suffix for file name when creating a profile model
		NewModelFilePage newModelFilePage = getNewModelFilePage();
		if(newModelFilePage != null) {
			String newExtension = ((CreateModelWizard)getWizard()).getDiagramFileExtension();
			String currentExtension = newModelFilePage.getFileExtension();
			if(!currentExtension.equals(newExtension)) {

				String oldFileName = newModelFilePage.getFileName();
				String newFileName = NewModelFilePage.getUniqueFileName(newModelFilePage.getContainerFullPath(), newModelFilePage.getFileName(), newExtension);

				newModelFilePage.setFileName(newFileName);
				newModelFilePage.setFileExtension(newExtension);
				
				DiagramCategoryDescriptor selected = getDiagramCategoryMap().get(mySelectedDiagramCategoryId);
				if (selected == null) {
					log.warn("Could not find DiagramCategory for " + mySelectedDiagramCategoryId);
					return false;
				}
				String categoryLabel = selected.getLabel();
				String message = String.format("The %s diagram category requires a specific diagram file extension. " + "Thus, the diagram file has been renamed from %s to %s ", categoryLabel, oldFileName, newFileName);
				setMessage(message, IMessageProvider.INFORMATION);

				String errorMessage = newModelFilePage.getErrorMessage();
				if(errorMessage != null) {
					setErrorMessage(errorMessage);
				}
			} else {
				setMessage(null);
			}
		}
		return mySelectedDiagramCategoryId != null;
	}
	
	private Map<String, DiagramCategoryDescriptor> getDiagramCategoryMap() {
		return DiagramCategoryRegistry.getInstance().getDiagramCategoryMap();
	}

	private NewModelFilePage getNewModelFilePage() {
		IWizardPage prev = getPreviousPage();
		if(prev instanceof NewModelFilePage) {
			return (NewModelFilePage)prev;
		}
		prev = prev.getPreviousPage();
		if(prev instanceof NewModelFilePage) {
			return (NewModelFilePage)prev;
		}
		return null;
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
