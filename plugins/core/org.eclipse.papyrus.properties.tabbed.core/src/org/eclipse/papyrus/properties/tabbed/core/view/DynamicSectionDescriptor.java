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
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptor;
import org.eclipse.papyrus.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.papyrus.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractSectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.w3c.dom.Node;


/**
 * Descriptor for sections using controllers.
 */
public class DynamicSectionDescriptor extends AbstractSectionDescriptor implements IEnhancedFilter, IConfigurableDescriptor {

	/** semantic resolver */
	public static final String SEMANTIC_RESOLVER = "Semantic";

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

	/** list of fragments to display in the section */
	protected final List<FragmentDescriptor> fragmentDescriptors;

	/** list of views Identifiers */
	protected final List<String> fragmentsId;

	/**
	 * Creates a new DynamicSectionDescriptor.
	 * 
	 * @param fragmentsId
	 *        id of the views to display in the section
	 * 
	 */
	public DynamicSectionDescriptor(String id, String tabId, List<IConstraintDescriptor> constraints, int selectionSize, String adapterID, List<String> replacedSectionIds, List<String> fragmentsId) {
		this.id = id;
		this.tabId = tabId;
		this.constraints = constraints;
		this.selectionSize = selectionSize;
		this.adapterId = adapterID;
		this.replacedSectionIds = replacedSectionIds;
		this.fragmentsId = fragmentsId;
		fragmentDescriptors = new ArrayList<FragmentDescriptor>();
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
		// parses the configuration if required
		if(unparsed) {
			for(String id : fragmentsId) {
				FragmentDescriptor descriptor = PropertyViewService.getInstance().getFragmentDescriptor(id);
				if(descriptor != null) {
					fragmentDescriptors.add(descriptor);
				} else {
					Activator.log.error("impossible to find the fragment descriptor with id: " + id, null);
					parseSectionFailed = true;
				}
			}
			unparsed = false;
		}
		if(!parseSectionFailed) {
			return new DynamicSection(fragmentDescriptors);
		}

		return null;
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
		List<DynamicSectionDescriptor> availableSectionDescriptors = new ArrayList<DynamicSectionDescriptor>();
		List<DynamicSectionDescriptor> filteredDescriptors = new ArrayList<DynamicSectionDescriptor>();

		// retrieve the tab descriptors for the given description.
		// for all section descriptors in the tab descriptor, check if the section should be displayed or not.
		// then, remove from the visible list the elements which are filtered by other sections
		for(List<ITabDescriptor> tabDescriptors : PropertyServiceUtil.getTabDescriptors()) {
			for(ITabDescriptor tabDescriptor : tabDescriptors) {
				for(Object descriptor : tabDescriptor.getSectionDescriptors()) {
					ISectionDescriptor sectionDescriptor = (ISectionDescriptor)descriptor;
					if(sectionDescriptor instanceof DynamicSectionDescriptor) {
						boolean enable = ((DynamicSectionDescriptor)sectionDescriptor).appliesToWithoutSectionInheritance(part, selection);;
						if(enable) {
							availableSectionDescriptors.add((DynamicSectionDescriptor)sectionDescriptor);
						}
					}
				}
			}
		}

		// the list of available descriptors is now available, now remove from the list the section descriptors which are erased by others
		for(DynamicSectionDescriptor currentDescriptor : availableSectionDescriptors) {
			boolean isRemoved = false;
			String currentId = currentDescriptor.getId();
			// is this descriptor removed by another one ?
			for(DynamicSectionDescriptor descriptor : availableSectionDescriptors) {
				if(descriptor.getReplacedSectionIds().contains(currentId)) {
					isRemoved = true;
				}
			}

			if(!isRemoved) {
				filteredDescriptors.add(currentDescriptor);
			}
		}

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
	 * {@inheritDoc}
	 */
	public boolean selectWithoutVisibility(Object objectToTest) {
		// all constraints provided by the section descriptor should be valid.
		List<IConstraintDescriptor> constraintDescriptors = getConstraints();
		if(constraintDescriptors == null || constraintDescriptors.isEmpty()) {
			// something went wrong during definition or parsing, ignore this section
			Activator.log.info("No constraints found for descriptor : " + this);
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
	 * Returns the fragments identifier hold by this section
	 * 
	 * @return the fragments identifier hold by this section
	 */
	public List<String> getFragmentsId() {
		return fragmentsId;
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
		return org.eclipse.papyrus.properties.tabbed.core.Activator.getImage("/icons/Section.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public SectionDescriptorState createState() {
		return new SectionDescriptorState(this);
	}
}
