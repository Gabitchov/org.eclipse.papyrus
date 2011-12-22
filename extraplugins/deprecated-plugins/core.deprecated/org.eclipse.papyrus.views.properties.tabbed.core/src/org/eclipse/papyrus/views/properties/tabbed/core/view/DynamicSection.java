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
package org.eclipse.papyrus.views.properties.tabbed.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.views.properties.runtime.view.IFragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.AbstractContainerDescriptor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;


/**
 * Section using controllers for content.
 */
public class DynamicSection extends AbstractPropertySection {

	/** semantic resolver */
	public static final String SEMANTIC_RESOLVER = "Semantic";

	/** id of the graphic resolver */
	public static final String GRAPHIC_RESOLVER = "Graphic";

	/** id of the edit part resolver */
	public static final String EDIT_PART_RESOLVER = "EditPart";

	/** the parent for the created composites in this section */
	protected Composite parent;

	/** Elements being selected */
	protected List<Object> objectsToEdit;

	/** list of controllers created for this section */
	protected final List<AbstractContainerDescriptor> containers;

	/** tabbed property sheet page */
	protected TabbedPropertySheetPage tabbedPropertySheetPage;

	/** list of fragment descriptors that compose the section */
	protected List<IFragmentDescriptor> fragmentDescriptors;

	/** adapter id used to resolve elements */
	protected final String adapterId;

	/**
	 * Creates a new DynamicSection.
	 * 
	 * @param fragmentDescriptors
	 *        list of fragments contained by this section
	 * @param adapterId
	 *        id of the adapter to use to resolvbe objects
	 */
	public DynamicSection(List<IFragmentDescriptor> fragmentDescriptors, String adapterId) {
		this.fragmentDescriptors = fragmentDescriptors;
		this.containers = new ArrayList<AbstractContainerDescriptor>();
		this.adapterId = adapterId;
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		// force new layout to grid layout, not fill layout
		parent.setLayout(new GridLayout(1, true));
		this.tabbedPropertySheetPage = tabbedPropertySheetPage;
		// creates a composite that has a grid layout
		this.parent = tabbedPropertySheetPage.getWidgetFactory().createComposite(parent);
		GridData data = new GridData(GridData.FILL_BOTH);
		this.parent.setLayoutData(data);
		GridLayout layout = new GridLayout(1, true);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		this.parent.setLayout(layout);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		for(AbstractContainerDescriptor container : containers) {
			container.dispose();
			container = null;
		}
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if(!(selection instanceof IStructuredSelection)) {
			return;
		}

		// retrieve selected elements
		// even if is is a list of objects, each object in it should be an EObject...
		List<Object> newObjects = new ArrayList<Object>();
		Iterator<?> it = ((IStructuredSelection)selection).iterator();
		while(it.hasNext()) {
			Object newObject = getAdaptedObject(it.next());
			if(newObject != null) {
				newObjects.add(newObject);
			}
		}

		refreshDisplay(newObjects);

		// force the parent to layout
		parent.layout(false, true);
	}

	/**
	 * Returns the object adapated to the property view (ex: edit part into the underlying model element
	 * 
	 * @param objectToAdapt
	 *        the object to adapt
	 * @return the object adapted to the property view
	 */
	public Object getAdaptedObject(Object objectToAdapt) {
		if(SEMANTIC_RESOLVER.equals(adapterId)) {
			return resolveSemanticElement(objectToAdapt);
		}
		if(GRAPHIC_RESOLVER.equals(adapterId)) {
			return resolveGraphicElement(objectToAdapt);
		}
		if(EDIT_PART_RESOLVER.equals(adapterId)) {
			return resolveEditPart(objectToAdapt);
		}
		return objectToAdapt;
	}

	/**
	 * Resolves the semantic element for the specified object
	 * 
	 * @param objectToAdapt
	 *        the object to retrieve
	 * @return the semantic element for the specified object
	 */
	protected EObject resolveSemanticElement(Object objectToAdapt) {
		if(objectToAdapt instanceof EObject) {
			return (EObject)objectToAdapt;
		} else if(objectToAdapt instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable)objectToAdapt;
			if(adaptable.getAdapter(EObject.class) != null) {
				return (EObject)adaptable.getAdapter(EObject.class);
			}
		}
		return null;
	}

	/**
	 * Resolves the edit part for the specified object
	 * 
	 * @param objectToAdapt
	 *        the object to retrieve
	 * @return the edit part for the specified object
	 */
	protected EditPart resolveEditPart(Object objectToAdapt) {
		if(objectToAdapt instanceof EditPart) {
			return (EditPart)objectToAdapt;
		} else if(objectToAdapt instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable)objectToAdapt;
			if(adaptable.getAdapter(EditPart.class) != null) {
				return (EditPart)adaptable.getAdapter(EditPart.class);
			}
		}
		return null;
	}

	/**
	 * Resolves the semantic element for the specified object
	 * 
	 * @param objectToAdapt
	 *        the object to retrieve
	 * @return the semantic element for the specified object
	 */
	protected View resolveGraphicElement(Object objectToAdapt) {
		if(objectToAdapt instanceof View) {
			return (View)objectToAdapt;
		} else if(objectToAdapt instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable)objectToAdapt;
			if(adaptable.getAdapter(View.class) != null) {
				return (View)adaptable.getAdapter(View.class);
			}
		}
		return null;
	}


	/**
	 * Refreshes the display (if necessary) for the given set of objects
	 * 
	 * @param newObjects
	 *        the list of object to edit
	 */
	protected void refreshDisplay(List<Object> newObjects) {
		// the editing domain should not be null.
		// the list should not be empty, and it should not be the same as before. In the latter case, there is no need to update the property section
		if(!newObjects.isEmpty() && !newObjects.equals(objectsToEdit)) {
			objectsToEdit = newObjects;

			for(AbstractContainerDescriptor container : containers) {
				container.dispose();
			}
			containers.clear();

			// generate the content of the section, given the configuration
			for(IFragmentDescriptor viewDescriptor : fragmentDescriptors) {
				for(AbstractContainerDescriptor descriptor : viewDescriptor.getContainerDescriptors()) {
					descriptor.createContent(this.parent, this.tabbedPropertySheetPage.getWidgetFactory(), objectsToEdit);
					containers.add(descriptor);
				}
			}
		}
	}

	//	/**
	//	 * Resolve semantic element from a given object. The object tries to be adapted into a {@link EObject}, if possible.
	//	 * 
	//	 * @param object
	//	 *        the object to resolve
	//	 * @return <code>null</code> or the semantic element associated to the specified object
	//	 */
	//	protected EObject resolveSemanticObject(Object object) {
	//		if(object instanceof EObject) {
	//			return (EObject)object;
	//		} else if(object instanceof IAdaptable) {
	//			IAdaptable adaptable = (IAdaptable)object;
	//			if(adaptable.getAdapter(EObject.class) != null) {
	//				return (EObject)adaptable.getAdapter(EObject.class);
	//			}
	//		}
	//		return null;
	//	}

}
