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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.AppliedStereotypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ConstraintDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * State for section set descriptors
 */
public class SectionSetDescriptorState extends AbstractState {

	/** list of sections for this section set */
	protected final List<SectionDescriptorState> sectionDescriptorStates = new ArrayList<SectionDescriptorState>();

	/** list of constraints for this section set */
	protected final List<ConstraintDescriptorState> constraintDescriptorStates = new ArrayList<ConstraintDescriptorState>();

	/** descriptor for section sets */
	protected final SectionSetDescriptor sectionSetDescriptor;

	/** name of the section set descriptor */
	private String name;

	/** selection size */
	private int selectionSize;

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/**
	 * Returns the sectionSetDescriptor managed by this state
	 * 
	 * @return the sectionSetDescriptor managed by this state
	 */
	public SectionSetDescriptor getDescriptor() {
		return sectionSetDescriptor;
	}

	/**
	 * Creates a new SectionSetDescriptorState.
	 * 
	 * @param sectionSetDescriptor
	 *        descriptor for section sets
	 * @param readOnly
	 *        read only mode of the state
	 */
	public SectionSetDescriptorState(SectionSetDescriptor sectionSetDescriptor, boolean readOnly) {
		super(readOnly);
		this.sectionSetDescriptor = sectionSetDescriptor;
		this.name = sectionSetDescriptor.getName();
		this.selectionSize = sectionSetDescriptor.getSelectionSize();

		// retrieve and build the states for the children sections
		for(DynamicSectionDescriptor abstractSectionDescriptor : sectionSetDescriptor.getSectionDescriptors()) {
			SectionDescriptorState sectionState = abstractSectionDescriptor.createState(readOnly);
			sectionDescriptorStates.add(sectionState);
		}

		// retrieve and build the states for the children sections
		for(IConstraintDescriptor constraintDescriptor : sectionSetDescriptor.getConstraintDescriptors()) {
			ConstraintDescriptorState constraintState = constraintDescriptor.createState(readOnly);
			constraintDescriptorStates.add(constraintState);
		}
		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * Sets the name
	 * 
	 * @param name
	 *        the name to set
	 */
	public void setName(String name) {
		changeSupport.firePropertyChange("name", this.name, this.name = name);
	}

	/**
	 * Returns the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the selectionSize
	 * 
	 * @param selectionSize
	 *        the selectionSize to set
	 */
	public void setSelectionSize(int selectionSize) {
		changeSupport.firePropertyChange("selectionSize", this.selectionSize, this.selectionSize = selectionSize);
	}

	/**
	 * Returns the selectionSize
	 * 
	 * @return the selectionSize
	 */
	public int getSelectionSize() {
		return selectionSize;
	}

	/**
	 * Returns the label for this section set descriptor state
	 * 
	 * @return the label for this section set descriptor state
	 */
	public String getLabel() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(name);
		buffer.append(": ");
		// retrieve metaclass constraint
		String metaclassName = "";
		for(IConstraintDescriptor constraintDescriptor : getDescriptor().getConstraintDescriptors()) {
			if(constraintDescriptor instanceof ObjectTypeConstraintDescriptor) {
				metaclassName = ((ObjectTypeConstraintDescriptor)constraintDescriptor).getElementClass().getCanonicalName();
			}
		}
		buffer.append(metaclassName);

		// now append selection size between '[' and ']'
		buffer.append(" [");
		buffer.append((selectionSize >= 0) ? selectionSize : "*");
		buffer.append(']');

		// append stereotype required 
		for(IConstraintDescriptor constraintDescriptor : getDescriptor().getConstraintDescriptors()) {
			if(constraintDescriptor instanceof AppliedStereotypeConstraintDescriptor) {
				buffer.append('<');
				buffer.append(((AppliedStereotypeConstraintDescriptor)constraintDescriptor).getStereotypeQualifiedNames());
				buffer.append('>');
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns the constraintDescriptor States for this section set
	 * 
	 * @return the constraintDescriptor States for this section set
	 */
	public List<ConstraintDescriptorState> getConstraintDescriptorStates() {
		return constraintDescriptorStates;
	}

	/**
	 * Returns the sectionDescriptor States for this section set
	 * 
	 * @return the sectionDescriptor States for this section set
	 */
	public List<SectionDescriptorState> getSectionDescriptorStates() {
		return sectionDescriptorStates;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "SectionSetDescriptorStateDialog";
	}

	/**
	 * Adds a property change listener to this class
	 * 
	 * @param listener
	 *        the listener to add
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * Removes a property change listener from this class
	 * 
	 * @param listener
	 *        the listener to remove
	 */
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		List<ITraversableModelElement> children = new ArrayList<ITraversableModelElement>();
		children.addAll(getConstraintDescriptorStates());
		children.addAll(getSectionDescriptorStates());
		return children;
	}

	/**
	 * adds a section descriptor state and fire a add event
	 * 
	 * @param state
	 *        the state to add
	 */
	public void addSectionDescriptorState(SectionDescriptorState state) {
		sectionDescriptorStates.add(state);
		changeSupport.firePropertyChange(PROPERTY_ADD_CHILD, null, sectionDescriptorStates);
	}

	/**
	 * adds a section descriptor state and fire a add event
	 * 
	 * @param state
	 *        the state to add
	 */
	public void removeSectionDescriptorState(SectionDescriptorState state) {
		sectionDescriptorStates.remove(state);
		changeSupport.firePropertyChange(PROPERTY_REMOVE_CHILD, null, sectionDescriptorStates);
	}

	/**
	 * Serializes this section set descriptor state
	 * 
	 * @param document
	 *        document used to create XML nodes
	 * 
	 * @return the node result of the parsing of this state
	 */
	public Node generateNode(Document document) {
		Element sectionSetDescriptorNode = document.createElement("sectionSet");
		sectionSetDescriptorNode.setAttribute("name", name);

		// create the context
		Element contextNode = document.createElement("context");
		contextNode.setAttribute("enablesFor", "" + selectionSize);
		// generate for each constraint
		for(ConstraintDescriptorState constraintState : getConstraintDescriptorStates()) {
			Node node = constraintState.generateNode(document);
			contextNode.appendChild(node);
		}
		sectionSetDescriptorNode.appendChild(contextNode);

		// generate for section
		for(SectionDescriptorState sectionState : getSectionDescriptorStates()) {
			Node node = sectionState.generateNode(document);
			sectionSetDescriptorNode.appendChild(node);
		}
		return sectionSetDescriptorNode;
	}
}
