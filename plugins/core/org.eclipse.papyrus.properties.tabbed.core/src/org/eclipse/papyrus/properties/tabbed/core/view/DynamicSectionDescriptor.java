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
import org.eclipse.papyrus.properties.tabbed.core.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.content.ContainerDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.content.ExpandableContainerDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.content.GroupContainerDescriptor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractSectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Descriptor for sections using controllers.
 */
public class DynamicSectionDescriptor extends AbstractSectionDescriptor implements IEnhancedFilter {

	/** SEMANTIC_RESOLVER */
	protected static final String SEMANTIC_RESOLVER = "Semantic";

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

	/** configuration of the content of the section */
	protected SectionConfiguration configuration;

	/** list of constraints on this element. This could be OCL, java constraints for example */
	protected final List<IConstraintDescriptor> constraints;

	/** size of selection */
	protected int selectionSize;

	/** object adapter id */
	protected String adapterId;

	/** list of replaced ids */
	protected final List<String> replacedSectionIds;

	/**
	 * Creates a new DynamicSectionDescriptor.
	 * 
	 */
	public DynamicSectionDescriptor(String id, String tabId, List<IConstraintDescriptor> constraints, int selectionSize, String adapterID, List<String> replacedSectionIds) {
		this.id = id;
		this.tabId = tabId;
		this.constraints = constraints;
		this.selectionSize = selectionSize;
		this.adapterId = adapterID;
		this.replacedSectionIds = replacedSectionIds;
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
	public ISection getSectionClass() {
		// parses the configuration if required
		if(unparsed) {
			try {
				configuration = parseSectionNode(unparsedSectionNode);
			} catch (XMLParseException e) {
				Activator.log.error(e);
				parseSectionFailed = true;
			}
			unparsed = false;
		}

		if(!parseSectionFailed) {
			return new DynamicSection(configuration);
		}

		return null;
	}

	/**
	 * Parses the xml section node to set the content of the section
	 * 
	 * @param unparsedSectionNode
	 *        the node to parse
	 * @return the new configuration for the section
	 */
	protected SectionConfiguration parseSectionNode(Node unparsedSectionNode) throws XMLParseException {
		SectionConfiguration configuration = new SectionConfiguration();
		NodeList children = unparsedSectionNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node containerNode = children.item(i);
			if("container".equals(containerNode.getNodeName())) {
				configuration.getContainers().add(parseContainerNode(containerNode));
			} else if("expandableContainer".equals(containerNode.getNodeName())) {
				configuration.getContainers().add(parseExpandableContainerNode(containerNode));
			} else if("groupContainer".equals(containerNode.getNodeName())) {
				configuration.getContainers().add(parseGroupNode(containerNode));
			}
		}
		return configuration;

	}

	/**
	 * Parses the container XML description and returns the descriptor.
	 * 
	 * @param containerNode
	 *        the node to parse
	 */
	protected ContainerDescriptor parseContainerNode(Node containerNode) throws XMLParseException {
		Layout layout = parseLayout(containerNode);
		return new ContainerDescriptor(layout, containerNode);
	}

	/**
	 * Parses the group container XML description and returns the descriptor.
	 * 
	 * @param containerNode
	 *        the node to parse
	 */
	protected ContainerDescriptor parseGroupNode(Node containerNode) throws XMLParseException {
		Layout layout = parseLayout(containerNode);
		String label = parseLabel(containerNode);
		return new GroupContainerDescriptor(layout, label, containerNode);
	}

	/**
	 * Parses the expandable container XML description and returns the descriptor.
	 * 
	 * @param containerNode
	 *        the node to parse
	 */
	protected ContainerDescriptor parseExpandableContainerNode(Node containerNode) throws XMLParseException {
		Layout layout = parseLayout(containerNode);
		String label = parseLabel(containerNode);
		return new ExpandableContainerDescriptor(layout, label, containerNode);
	}

	/**
	 * Parses the label for the given container
	 * 
	 * @param containerNode
	 *        the container node to parse
	 * @return the label of the container
	 * @throws XMLParseException
	 *         exception thrown when XML file could not be parsed.
	 */
	protected String parseLabel(Node containerNode) throws XMLParseException {
		NamedNodeMap attributes = containerNode.getAttributes();
		if(attributes == null) {
			throw new XMLParseException("Impossible to find attributes for container node " + containerNode);
		}
		// retrieve the name
		Node nameNode = attributes.getNamedItem("label");
		String label = "";
		if(nameNode == null) {
			throw new XMLParseException("Impossible to find layout attribute for container node " + containerNode);
		} else {
			label = nameNode.getNodeValue();
		}
		return label;
	}

	/**
	 * Parses the layout for the container
	 * 
	 * @param containerNode
	 *        the container node which contains layout information
	 * @return the layout for the container
	 */
	protected Layout parseLayout(Node containerNode) throws XMLParseException {
		Layout layout = null;
		// this is a simple container. 
		// Retrieving the layout and generates the composite descriptor
		NamedNodeMap attributes = containerNode.getAttributes();
		if(attributes == null) {
			throw new XMLParseException("Impossible to find attributes for container node " + containerNode);
		}
		Node layoutNode = attributes.getNamedItem("layout");
		if(layoutNode == null) {
			throw new XMLParseException("Impossible to find layout attribute for container node " + containerNode);
		} else if("Grid".equals(layoutNode.getNodeValue())) {
			// retrieve number of columns 
			int columnNu = 1;
			boolean sameSize = false;

			Node columnNuNode = attributes.getNamedItem("columns");
			if(columnNuNode == null) {
				throw new XMLParseException("Impossible to find column number attribute for container node " + containerNode);
			} else {
				columnNu = Integer.parseInt(columnNuNode.getNodeValue());
			}
			Node columnSizeNode = attributes.getNamedItem("sameSize");
			if(columnSizeNode == null) {
				throw new XMLParseException("Impossible to find column size attribute for container node " + containerNode);
			} else {
				sameSize = Boolean.parseBoolean(columnSizeNode.getNodeValue());
			}
			layout = new GridLayout(columnNu, sameSize);
		}
		return layout;
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
		for(List<ITabDescriptor> tabDescriptors : PropertyViewService.getInstance().getTabDescriptors()) {
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

}
