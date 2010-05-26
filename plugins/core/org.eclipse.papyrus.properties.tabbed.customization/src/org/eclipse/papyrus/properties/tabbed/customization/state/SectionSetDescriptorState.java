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
package org.eclipse.papyrus.properties.tabbed.customization.state;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.view.constraints.AppliedStereotypeConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.SectionSetDescriptor;


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

	/** label displayed by this section set descriptor */
	private String name;

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
	 */
	public SectionSetDescriptorState(SectionSetDescriptor sectionSetDescriptor) {
		this.sectionSetDescriptor = sectionSetDescriptor;

		// retrieve and build the states for the children sections
		for(DynamicSectionDescriptor abstractSectionDescriptor : sectionSetDescriptor.getSectionDescriptors()) {
			SectionDescriptorState sectionState = new SectionDescriptorState(abstractSectionDescriptor);
			sectionDescriptorStates.add(sectionState);
		}

		// retrieve and build the states for the children sections
		for(IConstraintDescriptor constraintDescriptor : sectionSetDescriptor.getConstraintDescriptors()) {
			ConstraintDescriptorState constraintState = new ConstraintDescriptorState(constraintDescriptor);
			constraintDescriptorStates.add(constraintState);
		}
		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * Returns the label for this section set descriptor state
	 * 
	 * @return the label for this section set descriptor state
	 */
	public String getLabel() {
		if(name == null) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(sectionSetDescriptor.getName());
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
			int selectionSize = getDescriptor().getSelectionSize();
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

			name = buffer.toString();
		}
		return name;
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
}
