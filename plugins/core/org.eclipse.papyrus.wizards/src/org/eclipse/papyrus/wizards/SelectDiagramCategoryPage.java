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
package org.eclipse.papyrus.wizards;

import static org.eclipse.papyrus.wizards.Activator.log;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.wizards.category.DiagramCategoryRegistry;
import org.eclipse.papyrus.wizards.category.NewPapyrusModelCommand;
import org.eclipse.papyrus.wizards.category.PapyrusModelFromExistingDomainModelCommand;
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
	final List<Button> myDiagramKindButtons = new ArrayList<Button>();


	/** The diagram category. */
	private DiagramCategoryDescriptor mySelectedDiagramCategory;

	/** The Constant PAGE_ID. */
	public static final String PAGE_ID = "SelectDiagramCategory";

	public static final String DEFAULT_EXTENSION = "uml";

	private static final String LAST_SELECTED_CATEGORY = "diagramCategory";

	/**
	 * Instantiates a new select diagram category page.
	 * 
	 * @param pageName
	 *        the page name
	 */
	public SelectDiagramCategoryPage() {
		super(PAGE_ID);
		setTitle("Initialization information");
		setDescription("Select language of the diagram");
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

		createDiagramLanguageForm(plate);

		IDialogSettings settings = getDialogSettings();
		if(settings != null) {
			String category = settings.get(LAST_SELECTED_CATEGORY);
			setDiagramCategory(category);
		}


		setPageComplete(validatePage());
	}

	private void setDiagramCategory(String category) {
		if(category == null) {
			return;
		}
		for(DiagramCategoryDescriptor descriptor : DiagramCategoryRegistry.getInstance().getDiagramCategories()) {
			if(category.equals(descriptor.getId())) {
				mySelectedDiagramCategory = descriptor;
			}
		}

		for(Button button : myDiagramKindButtons) {
			// we take categories from the same registry, so we can use here for performance reasons  "==" instead of "equals" 
			if(mySelectedDiagramCategory == (DiagramCategoryDescriptor)button.getData()) {
				button.setSelection(true);
			}
		}
	}

	/**
	 * Gets the diagram category.
	 * 
	 * @return the diagram category
	 */
	public String getDiagramCategory() {
		return mySelectedDiagramCategory != null ? mySelectedDiagramCategory.getId() : null;
	}

	/**
	 * Initialize model resource.
	 * 
	 * @param diResourceSet
	 *        the di resource set
	 * @param newFile
	 *        the new file
	 * @param root
	 *        the root
	 */
	public void initDomainModel(final DiResourceSet diResourceSet, final IFile newFile, final EObject root) {
		RecordingCommand command = (root != null) ? new PapyrusModelFromExistingDomainModelCommand(diResourceSet, newFile, root) : new NewPapyrusModelCommand(diResourceSet, newFile);
		diResourceSet.getTransactionalEditingDomain().getCommandStack().execute(command);
		if(root == null && !useTemplate()) {
			try {
				mySelectedDiagramCategory.getCommand().createModel(diResourceSet);
			} catch (BackboneException e) {
				log.error(e);
			}
		}
	}

	public void saveSettings(IDialogSettings settings) {
		String category = getDiagramCategory();
		settings.put(LAST_SELECTED_CATEGORY, category);
	}

	/**
	 * Use template.
	 * 
	 * @return true, if successful
	 */
	private boolean useTemplate() {
		IWizardPage nextPage = getNextPage();
		if(nextPage == null || false == nextPage instanceof SelectDiagramKindPage) {
			return false;
		}
		return ((SelectDiagramKindPage)nextPage).useTemplate();
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
			String newExtension = getDiagramFileExtension();
			String currentExtension = newModelFilePage.getFileExtension();
			if(!currentExtension.equals(newExtension)) {

				String oldFileName = newModelFilePage.getFileName();
				String newFileName = NewModelFilePage.getUniqueFileName(newModelFilePage.getContainerFullPath(), newModelFilePage.getFileName(), newExtension);

				newModelFilePage.setFileName(newFileName);
				newModelFilePage.setFileExtension(newExtension);

				String message = String.format("The %s diagram category requires a specific diagram file extension. " + "Thus, the diagram file has been renamed from %s to %s ", mySelectedDiagramCategory.getLabel(), oldFileName, newFileName);
				setMessage(message, IMessageProvider.INFORMATION);

				String errorMessage = newModelFilePage.getErrorMessage();
				if(errorMessage != null) {
					setErrorMessage(errorMessage);
				}
			} else {
				setMessage(null);
			}
		}
		return mySelectedDiagramCategory != null;
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
	 * Gets the diagram file extension.
	 * 
	 * @return the diagram file extension
	 */
	public String getDiagramFileExtension() {
		String extensionPrefix = mySelectedDiagramCategory != null ? mySelectedDiagramCategory.getExtensionPrefix() : null;
		return (extensionPrefix != null) ? extensionPrefix + "." + NewModelFilePage.DEFAULT_DIAGRAM_EXTENSION : NewModelFilePage.DEFAULT_DIAGRAM_EXTENSION;
	}


	/**
	 * Creates the diagram language form.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createDiagramLanguageForm(Composite composite) {
		Group group = createGroup(composite, "Diagram Language:");

		SelectionListener listener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				for(Button button : myDiagramKindButtons) {
					button.setSelection(false);
				}
				((Button)e.widget).setSelection(true);
				mySelectedDiagramCategory = (DiagramCategoryDescriptor)((Button)e.widget).getData();
				setPageComplete(validatePage());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};

		for(DiagramCategoryDescriptor diagramCategoryDescriptor : DiagramCategoryRegistry.getInstance().getDiagramCategories()) {
			Button button = new Button(group, SWT.CHECK);
			button.addSelectionListener(listener);
			button.setText(diagramCategoryDescriptor.getLabel());
			button.setData(diagramCategoryDescriptor);
			Image image = getImage(diagramCategoryDescriptor.getIcon());
			if(image != null) {
				button.setImage(image);
			}
			button.setToolTipText(diagramCategoryDescriptor.getDescription());
			myDiagramKindButtons.add(button);
		}

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
