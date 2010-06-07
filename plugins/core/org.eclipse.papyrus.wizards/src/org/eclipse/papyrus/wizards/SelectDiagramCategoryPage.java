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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.plugin.AbstractUIPlugin;


/**
 * The Class SelectDiagramCategoryPage.
 */
public class SelectDiagramCategoryPage extends WizardPage {

	/** The my diagram kind buttons. */
	final List<Button> myDiagramKindButtons = new ArrayList<Button>();

	/** The diagram categories. */
	private List<DiagramCategoryDescriptor> diagramCategories;

	/** The Constant CATEGORY_EXTENSION_POINT_NAME. */
	private static final String CATEGORY_EXTENSION_POINT_NAME = "org.eclipse.papyrus.core.papyrusDiagram";

	/** ID of the editor extension (schema filename) */
	public static final String CATEGORY_ELEMENT_NAME = "diagramCategory";

	/** The Constant CATEGORY_ID. */
	private static final String CATEGORY_ID = "id";

	/** The Constant CATEGORY_LABEL. */
	private static final String CATEGORY_LABEL = "label";
	
	/** The Constant CATEGORY_DESCRIPTION. */
	private static final String CATEGORY_DESCRIPTION = "description";

	/** The Constant CATEGORY_ICON. */
	private static final String CATEGORY_ICON = "icon";

	/** The diagram category. */
	private String diagramCategory;


	/**
	 * Instantiates a new select diagram category page.
	 *
	 * @param pageName the page name
	 */
	public SelectDiagramCategoryPage(String pageName) {
		super(pageName);
		setTitle("Initialization information");
		setDescription("Select language of the diagram");
		diagramCategories = buildDiagramCategories();
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
		return diagramCategory;
	}

	/**
	 * Creates the diagram language form.
	 *
	 * @param composite the composite
	 */
	private void createDiagramLanguageForm(Composite composite) {
		Group group = createGroup(composite, "Diagram Language:");

		SelectionListener listener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				for(Button button : myDiagramKindButtons) {
					button.setSelection(false);
				}
				((Button)e.widget).setSelection(true);
				diagramCategory = (String)((Button)e.widget).getData();
				setPageComplete(validatePage());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};

		for(DiagramCategoryDescriptor diagramCategoryDescriptor : getDiagramCategories()) {
			Button button = new Button(group, SWT.CHECK);
			button.addSelectionListener(listener);
			button.setText(diagramCategoryDescriptor.getLabel());
			button.setData(diagramCategoryDescriptor.getId());
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
	 * @param parent the parent
	 * @param name the name
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

	/**
	 * Gets the diagram categories.
	 *
	 * @return the diagram categories
	 */
	private List<DiagramCategoryDescriptor> getDiagramCategories() {
		if(diagramCategories == null) {
			diagramCategories = buildDiagramCategories();
		}
		return diagramCategories;
	}

	/**
	 * Builds the diagram categories.
	 *
	 * @return the hash map
	 */
	private List<DiagramCategoryDescriptor> buildDiagramCategories() {
		List<DiagramCategoryDescriptor> result = new ArrayList<DiagramCategoryDescriptor>();

		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(CATEGORY_EXTENSION_POINT_NAME);
		for(IExtension extension : extensionPoint.getExtensions()) {
			for(IConfigurationElement ele : extension.getConfigurationElements()) {
				if(CATEGORY_ELEMENT_NAME.equals(ele.getName())) {
					DiagramCategoryDescriptor diagramCategoryDescriptor = new DiagramCategoryDescriptor(ele.getAttribute(CATEGORY_ID), ele.getAttribute(CATEGORY_LABEL));
					diagramCategoryDescriptor.setDescription(ele.getAttribute(CATEGORY_DESCRIPTION));
					String iconPath = ele.getAttribute(CATEGORY_ICON);
					if (iconPath != null) {
						diagramCategoryDescriptor.setIcon(AbstractUIPlugin.imageDescriptorFromPlugin(ele.getNamespaceIdentifier(), iconPath));
					}
					result.add(diagramCategoryDescriptor);
				}
			}
		}
		return result;

	}
	
	/**
	 * Validate page.
	 *
	 * @return true, if successful
	 */
	protected boolean validatePage() {
		return diagramCategory != null;
	}
	
	private static class DiagramCategoryDescriptor {
		private String myId;
		private String myLabel;
		private String myDescription;
		private ImageDescriptor myIcon;
		
		public DiagramCategoryDescriptor(String id, String label) {
			myId = id;
			myLabel = label;
		}
		
		public String getId() {
			return myId;
		}
		
		public String getLabel() {
			return myLabel;
		}

		public String getDescription() {
			return myDescription;
		}

		public ImageDescriptor getIcon() {
			return myIcon;
		}
		
		public void setDescription(String description) {
			myDescription = description;
		}
		
		public void setIcon(ImageDescriptor icon) {
			myIcon = icon;
		}
		

	}

}
