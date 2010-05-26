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

import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;


/**
 * State for Constraint Descriptors
 */
public class ConstraintDescriptorState extends AbstractState {

	/** constraint managed by this state */
	protected IConstraintDescriptor constraintDescriptor;

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/**
	 * Creates a new ConstraintDescriptorState.
	 * 
	 * @param constraintDescriptor
	 *        the constraint descriptor managed by this state
	 */
	public ConstraintDescriptorState(IConstraintDescriptor constraintDescriptor) {
		this.constraintDescriptor = constraintDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public IConstraintDescriptor getDescriptor() {
		return constraintDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "ConstraintDescriptorStateDialog";
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
