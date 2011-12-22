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

import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.AppliedStereotypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.Activator;
import org.eclipse.swt.graphics.Image;


/**
 * Descriptor for section set (used mostly for configuration purpose)
 */
public class SectionSetDescriptor implements IConfigurableDescriptor {

	/** list of section descriptors own by this section set */
	private final List<DynamicSectionDescriptor> sectionDescriptors;

	/** list of constraint descriptors placed on this section set */
	private final List<IConstraintDescriptor> constraintDescriptors;

	/** name of this section set, mostly used during configuration or debug time */
	private final String name;

	/** size of the selection */
	private final int selectionSize;

	/**
	 * Creates a new SectionSetDescriptor.
	 * 
	 * @param name
	 *        name of the section state
	 * @param sectionDescriptors
	 *        list of contained section descriptors
	 * @param constraintDescriptors
	 *        list of constraints on the section descriptor
	 * @param selectionSize
	 *        size of the selection
	 * 
	 */
	public SectionSetDescriptor(String name, List<DynamicSectionDescriptor> sectionDescriptors, List<IConstraintDescriptor> constraintDescriptors, int selectionSize) {
		this.name = name;
		this.sectionDescriptors = sectionDescriptors;
		this.constraintDescriptors = constraintDescriptors;
		this.selectionSize = selectionSize;
	}

	/**
	 * Returns the sectionDescriptors owned by the described section set
	 * 
	 * @return the sectionDescriptors owned by the described section set
	 */
	public List<DynamicSectionDescriptor> getSectionDescriptors() {
		return sectionDescriptors;
	}

	/**
	 * Returns the constraintDescriptors placed on the described section set
	 * 
	 * @return the constraintDescriptors placed on the described section set
	 */
	public List<IConstraintDescriptor> getConstraintDescriptors() {
		return constraintDescriptors;
	}

	/**
	 * Returns the size of the selection for this described section set
	 * 
	 * @return the size of the selection for this described section set
	 */
	public int getSelectionSize() {
		return selectionSize;
	}

	/**
	 * Returns the name of this section set descriptor
	 * 
	 * @return the name of this section set descriptor
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(getName());
		buffer.append(": ");
		// retrieve metaclass constraint
		String metaclassName = "";
		for(IConstraintDescriptor constraintDescriptor : getConstraintDescriptors()) {
			if(constraintDescriptor instanceof ObjectTypeConstraintDescriptor) {
				metaclassName = ((ObjectTypeConstraintDescriptor)constraintDescriptor).getElementClass().getCanonicalName();
			}
		}
		buffer.append(metaclassName);

		// now append selection size between '[' and ']'
		int selectionSize = getSelectionSize();
		buffer.append(" [");
		buffer.append((selectionSize >= 0) ? selectionSize : "*");
		buffer.append(']');

		// append stereotype required 
		for(IConstraintDescriptor constraintDescriptor : getConstraintDescriptors()) {
			if(constraintDescriptor instanceof AppliedStereotypeConstraintDescriptor) {
				buffer.append('<');
				buffer.append(((AppliedStereotypeConstraintDescriptor)constraintDescriptor).getStereotypeQualifiedNames());
				buffer.append('>');
			}
		}
		return buffer.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/SectionSet.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public SectionSetDescriptorState createState(boolean readOnly) {
		return new SectionSetDescriptorState(this, readOnly);
	}
}
