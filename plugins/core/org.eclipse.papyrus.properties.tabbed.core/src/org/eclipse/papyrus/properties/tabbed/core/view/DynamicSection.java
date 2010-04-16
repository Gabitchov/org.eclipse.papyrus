/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.properties.tabbed.core.view.content.AbstractContainerDescriptor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;


/**
 * section using controllers for content.
 */
public class DynamicSection extends AbstractPropertySection {

	/** the parent for the created composites in this section */
	protected Composite parent;

	/** Elements being selected */
	protected List<Object> objectsToEdit;

	/** configuration of th econtent of this section */
	protected final SectionConfiguration configuration;

	/** list of controllers created for this section */
	protected final List<PropertyEditorController> controllers;

	/** tabbed property sheet page */
	protected TabbedPropertySheetPage tabbedPropertySheetPage;

	/**
	 * Creates a new DynamicSection.
	 * 
	 * @param configuration
	 *        the graphical configuration of the section
	 * 
	 */
	public DynamicSection(SectionConfiguration configuration) {
		this.configuration = configuration;
		this.controllers = new ArrayList<PropertyEditorController>();
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		this.tabbedPropertySheetPage = tabbedPropertySheetPage;
		// creates a composite that has a grid layout
		this.parent = tabbedPropertySheetPage.getWidgetFactory().createComposite(parent);
		this.parent.setLayout(new GridLayout(1, false));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		for(PropertyEditorController controller : controllers) {
			controller.dispose();
			controller = null;
		}
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if(!(selection instanceof IStructuredSelection) || !((part instanceof IEditingDomainProvider) || part.getAdapter(IEditingDomainProvider.class) != null)) {
			return;
		}

		// retrieve selected elements
		// even if is is a list of objects, each object in it should be an EObject...
		List<Object> newObjects = new ArrayList<Object>();
		Iterator<?> it = ((IStructuredSelection)selection).iterator();
		while(it.hasNext()) {
			EObject newEObject = resolveSemanticObject(it.next());
			if(newEObject != null) {
				newObjects.add(newEObject);
			}
		}

		// the editing domain should not be null.
		// the list should not be empty, and it should not be the same as before. In the latter case, there is no need to update the property section
		if(!newObjects.isEmpty() && !newObjects.equals(objectsToEdit)) {
			objectsToEdit = newObjects;

			for(PropertyEditorController controller : controllers) {
				controller.dispose();
			}
			controllers.clear();

			// generate the content of the section, given the configuration
			for(AbstractContainerDescriptor descriptor : configuration.getContainers()) {
				controllers.addAll(descriptor.createContent(this.parent, this.tabbedPropertySheetPage, objectsToEdit));
			}
		}
		// force the parent to layout
		this.parent.layout(true, true);
	}



	/**
	 * Resolve semantic element
	 * 
	 * @param object
	 *        the object to resolve
	 * @return <code>null</code> or the semantic element associated to the specified object
	 */
	protected EObject resolveSemanticObject(Object object) {
		if(object instanceof EObject) {
			return (EObject)object;
		} else if(object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable)object;
			if(adaptable.getAdapter(EObject.class) != null) {
				return (EObject)adaptable.getAdapter(EObject.class);
			}
		}
		return null;
	}

}
