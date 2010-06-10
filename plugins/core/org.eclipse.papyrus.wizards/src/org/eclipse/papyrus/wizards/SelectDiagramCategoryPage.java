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
import org.eclipse.jface.resource.ImageDescriptor;
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


	/**
	 * Instantiates a new select diagram category page.
	 * 
	 * @param pageName
	 *        the page name
	 */
	public SelectDiagramCategoryPage(String pageName) {
		super(pageName);
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

		setPageComplete(validatePage());
	}

	/**
	 * Gets the diagram category.
	 * 
	 * @return the diagram category
	 */
	public String getDiagramCategory() {
		return mySelectedDiagramCategory!= null ? mySelectedDiagramCategory.getId() : null;
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
	 * @param modelContentType
	 *        the model content type
	 * @param modelFileExtension
	 *        the model file extension
	 */
	public void initDomainModel(final DiResourceSet diResourceSet, final IFile newFile, final EObject root, final String modelContentType, final String modelFileExtension) {
		RecordingCommand command = (root != null) ? new PapyrusModelFromExistingDomainModelCommand(diResourceSet, newFile, root) : new NewPapyrusModelCommand(diResourceSet, newFile);
		diResourceSet.getTransactionalEditingDomain().getCommandStack().execute(command);
		if(root == null) {
			try {
				mySelectedDiagramCategory.getCommand().createModel(diResourceSet);
			} catch (BackboneException e) {
				log.error(e);
			}
		}
	}

	/**
	 * Validate page.
	 * 
	 * @return true, if successful
	 */
	private boolean validatePage() {
		return mySelectedDiagramCategory != null;
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
