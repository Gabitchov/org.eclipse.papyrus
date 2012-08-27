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

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.IFragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractSectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.w3c.dom.Node;


/**
 * Descriptor for sections using controllers.
 */
public class DynamicSectionDescriptor extends AbstractSectionDescriptor implements IEnhancedFilter, IConfigurableDescriptor {

	/** semantic resolver */
	public static final String SEMANTIC_RESOLVER = "Semantic";

	/** id of the graphic resolver */
	public static final String GRAPHIC_RESOLVER = "Graphic";

	/** id of the edit part resolver */
	public static final String EDIT_PART_RESOLVER = "EditPart";

	/** section class managing the content */
	protected ISection section;

	/** id of the section */
	protected final String id;

	/** id of the tab contributed */
	protected final String tabId;

	/** stores the unparsed configuration, waiting for the section to be used */
	protected Node unparsedSectionNode;

	/** indicates if the section has already been parsed */
	protected boolean unparsed = true;

	/** indicates if the parse was correct */
	protected boolean parseSectionFailed = false;

	/** list of constraints on this element. This could be OCL, java constraints for example */
	protected final List<IConstraintDescriptor> constraints;

	/** size of selection */
	protected final int selectionSize;

	/** object adapter id */
	protected final String adapterId;

	/** list of replaced ids */
	protected final List<String> replacedSectionIds;

	/** section which should be before this one */
	protected final String afterSectionId;

	/** list of fragments to display in the section */
	protected final List<IFragmentDescriptor> fragmentDescriptors;



	/**
	 * Creates a new DynamicSectionDescriptor.
	 * 
	 * @param id
	 *        unique identifier of this section descriptor
	 * @param tabId
	 *        id of the tab where this section should be added
	 * @param constraints
	 *        the constraints placed on this section, so it should be displayed or not
	 * @param selectionSize
	 *        size of the selection
	 * @param adapterID
	 *        name of the adapter
	 * @param replacedSectionIds
	 *        id of the section replaced by this one
	 * @param afterSectionId
	 *        identifier of the section which should be placed before this one
	 * @param fragmentDescriptors
	 *        fragments to display in the section
	 */
	public DynamicSectionDescriptor(String id, String tabId, List<IConstraintDescriptor> constraints, int selectionSize, String adapterID, List<String> replacedSectionIds, String afterSectionId, List<IFragmentDescriptor> fragmentDescriptors) {
		this.id = id;
		this.tabId = tabId;
		this.constraints = constraints;
		this.selectionSize = selectionSize;
		this.adapterId = adapterID;
		this.replacedSectionIds = replacedSectionIds;
		this.afterSectionId = afterSectionId;
		this.fragmentDescriptors = fragmentDescriptors;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getEnablesFor() {
		return selectionSize;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAfterSection() {
		if(afterSectionId == null) {
			return super.getAfterSection();
		}
		return afterSectionId;
	}

	/**
	 * Returns the adapterId for this section descriptor
	 * 
	 * @return the adapterId for this section descriptor
	 */
	public String getAdapterId() {
		return adapterId;
	}

	/**
	 * {@inheritDoc}
	 */
	public ISection getSectionClass() {
		return new DynamicSection(fragmentDescriptors, getAdapterId());
	}


	/**
	 * {@inheritDoc}
	 */
	public String getTargetTab() {
		return tabId;
	}

	/**
	 * Sets the unparsed content for the descriptor.
	 * 
	 * @param sectionNode
	 *        the node configuring the described section.
	 */
	public void setUnparsedContent(Node sectionNode) {
		this.unparsedSectionNode = sectionNode;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEnhancedFilter getFilter() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object toTest) {
		return SectionDispatcher.getInstance().isSectionDisplayed(this, toTest);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean appliesTo(IWorkbenchPart part, ISelection selection) {
		// check all 
		List<DynamicSectionDescriptor> filteredDescriptors = SectionDispatcher.getInstance().getDisplayedSections(part, selection);

		// now, compare the current descriptor. Is it in the list of filtered descriptors ?
		return filteredDescriptors.contains(this);
	}

	/**
	 * Determines if this section applies to the selection, without inheritance issue. The section, even if overriden by another visible section, will
	 * return <code>true</code>
	 * 
	 * @param part
	 *        the current workbench part.
	 * @param selection
	 *        the selection.
	 * @return <code>true</code> if this section applies to the current
	 *         selection.
	 */
	public boolean appliesToWithoutSectionInheritance(IWorkbenchPart part, ISelection selection) {
		return super.appliesTo(part, selection);
	}

	/**
	 * Returns the constraints
	 * 
	 * @return the constraints
	 */
	public List<IConstraintDescriptor> getConstraints() {
		return constraints;
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
	 * {@inheritDoc}
	 */
	public boolean selectWithoutVisibility(Object objectToTest) {
		// all constraints provided by the section descriptor should be valid.
		List<IConstraintDescriptor> constraintDescriptors = getConstraints();
		if(constraintDescriptors == null || constraintDescriptors.isEmpty()) {
			// something went wrong during definition or parsing, ignore this section
			Activator.log.warn("No constraints found for descriptor : " + this.getText());
			return false;
		}

		// adapt the selection using adapters provided by the section descriptor
		Object adaptedObject = getAdaptedObject(objectToTest);

		for(IConstraintDescriptor constraintDescriptor : constraintDescriptors) {
			if(!constraintDescriptor.select(adaptedObject)) {
				return false;
			}
		}

		// then, is this section in the hidden views (preferences ?)for this kind of object ?
		return true;
	}


	/**
	 * Returns the replacedSectionIds
	 * 
	 * @return the replacedSectionIds
	 */
	public List<String> getReplacedSectionIds() {
		return replacedSectionIds;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "Section: " + getId() + " in tab: " + getTargetTab();
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return org.eclipse.papyrus.views.properties.tabbed.core.Activator.getImage("/icons/Section.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public SectionDescriptorState createState(boolean readOnly) {
		return new SectionDescriptorState(this, readOnly);
	}

	/**
	 * Returns the list of fragment descriptors for this section
	 * 
	 * @return the list of fragment descriptors for this section
	 */
	public List<IFragmentDescriptor> getFragmentDescriptors() {
		return fragmentDescriptors;
	}
}
