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
package org.eclipse.papyrus.properties.runtime.view.constraints;


/**
 * Descriptor for a constraint based on the type of object
 */
public class ObjectTypeConstraintDescriptor implements IConstraintDescriptor {

	/** class of the edited element */
	protected final Class<?> elementClass;

	/**
	 * Creates a new ObjectTypeConstraintDescriptor.
	 * @param elementClass class of the element to edit
	 */
	public ObjectTypeConstraintDescriptor(Class<?> elementClass) {
		this.elementClass = elementClass;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object objectToTest) {
		if(objectToTest == null) {
			return false;
		} else if((elementClass.isAssignableFrom(objectToTest.getClass()))) {
			return true;
		}
		return false;
	}


	/**
	 * Returns the element class for this constraint descriptor, i.e the class that each object in the selection must be compliant (the same or
	 * inherited one)
	 * 
	 * @return the element class for this constraint descriptor
	 */
	public Class<?> getElementClass() {
		return elementClass;
	}



}
